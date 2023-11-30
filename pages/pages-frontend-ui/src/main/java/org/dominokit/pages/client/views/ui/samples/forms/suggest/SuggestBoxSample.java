package org.dominokit.pages.client.views.ui.samples.forms.suggest;

import elemental2.core.Global;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Response;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.suggest.*;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.dominokit.domino.ui.utils.Domino.*;

public class SuggestBoxSample extends BaseDominoElement<HTMLDivElement, SuggestBoxSample> {

    private DivElement element;

    public static SuggestBoxSample create() {
        return new SuggestBoxSample();
    }

    public SuggestBoxSample() {
        this.element = div().addCss(dui_p_2);
        LocalSuggestionsStore<String, SpanElement, SuggestOption<String>> localStore = LocalSuggestionsStore.<String, SpanElement, SuggestOption<String>>create()
                .addSuggestion(SuggestOption.create("Ahmad bawaneh"))
                .addSuggestion(SuggestOption.create("Ahmad Ali"))
                .addSuggestion(SuggestOption.create("Ali omar"))
                .addSuggestion(SuggestOption.create("Ali hasan"))
                .addSuggestion(SuggestOption.create("Schroeder Coleman"))
                .addSuggestion(SuggestOption.create("Renee Mcintyre"))
                .addSuggestion(SuggestOption.create("Casey Garza"))
                .setMissingEntryProvider(inputValue -> Optional.of(SuggestOption.create(inputValue)))
                .setMissingValueProvider(missingValue -> Optional.of(SuggestOption.create(missingValue)));

        TextBox friendNameBox = TextBox.create("Your friend name")
                .setHelperText("Add friend name as suggestion")
                .withInputElement((parent, input) -> {
                    input.onKeyDown(keyEvents -> {
                        keyEvents.onEnter(evt -> {
                            localStore.addSuggestion(SuggestOption.create(parent.getValue()));
                            parent.clear();
                        });
                    });
                })
                .apply(textBox -> {
                    textBox.appendChild(PostfixAddOn.of(Button.create("ADD FRIEND")
                            .addCss(dui_primary, dui_h_8, dui_leading_5)
                            .addClickListener(evt -> {
                                localStore.addSuggestion(SuggestOption.create(textBox.getValue()));
                                textBox.clear();
                            }))
                    );
                });


        this.element
                .appendChild(BlockHeader.create("Local suggestions"))
                .appendChild(Row.create()
                        .span6(friendNameBox)
                        .span6(SuggestBox.create(localStore)
                                .setLabel("Suggested friend")
                                .setHelperText("Type to see suggestions")
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                )
        ;

        SuggestionsStore<String, SpanElement, SuggestOption<String>> dynamicStore = new SuggestionsStore<String, SpanElement, SuggestOption<String>>() {

            @Override
            public void filter(String searchValue, SuggestionsHandler<String, SpanElement, SuggestOption<String>> suggestionsHandler) {
                DomGlobal.fetch("https://restcountries.com/v2/all?fields=name")
                        .then(Response::text)
                        .then(json -> {
                            List<SuggestOption<String>> suggestItems = new ArrayList<>();
                            JsArray<JsPropertyMap<String>> randomNames = Js.cast(Global.JSON.parse(json));
                            for (int i = 0; i < randomNames.length; i++) {
                                JsPropertyMap<String> nameProperties = randomNames.getAt(i);
                                if (nameProperties.get("name").toLowerCase().contains(searchValue.toLowerCase())) {
                                    SuggestOption<String> suggestItem = SuggestOption.create(nameProperties.get("name"));
                                    suggestItems.add(suggestItem);
                                }
                            }
                            suggestionsHandler.onSuggestionsReady(suggestItems);
                            return null;
                        });
            }

            @Override
            public void find(String searchValue, Consumer<SuggestOption<String>> handler) {
                DomGlobal.fetch("https://restcountries.com/v2/all?fields=name")
                        .then(Response::text)
                        .then(json -> {
                            JsArray<JsPropertyMap<String>> randomNames = Js.cast(Global.JSON.parse(json));
                            for (int i = 0; i < randomNames.length; i++) {
                                JsPropertyMap<String> nameProperties = randomNames.getAt(i);
                                if (nameProperties.get("name").equals(searchValue)) {
                                    SuggestOption<String> suggestItem = SuggestOption.create(nameProperties.get("name"));
                                    handler.accept(suggestItem);
                                    return null;
                                }
                            }
                            return null;
                        });
            }
        };

        this.element
                .appendChild(BlockHeader.create("Dynamic suggestions"))
                .appendChild(Row.create()
                        .span6(SuggestBox.create(dynamicStore)
                                .setLabel("Suggested country")
                                .setHelperText("Type to see suggestions")
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                        .span6(MultiSuggestBox.create(dynamicStore)
                                .setLabel("Suggested countries")
                                .setHelperText("Type to see suggestions")
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                );


        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
