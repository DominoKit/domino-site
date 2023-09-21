package org.dominokit.pages.client.views.ui.samples.icons;

import elemental2.dom.*;
import elemental2.dom.EventListener;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.LabeledIcon;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.icons.lib.MdiByTagFactory;
import org.dominokit.domino.ui.icons.lib.MdiTags;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.style.DisplayCss;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.DominoDom;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.view.BaseElementView;
import org.dominokit.pages.client.presenters.samples.components.AlertsProxy;
import org.dominokit.pages.client.presenters.samples.icons.IconsProxy;
import org.dominokit.pages.client.views.IconsView;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.alerts.BasicAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.ContextAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.DismissibleAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.LinksAlertsSample;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.style.DisplayCss.dui_elevation_0;

@UiView(presentable = IconsProxy.class)
public class IconsViewImpl extends BaseElementView<HTMLDivElement> implements IconsView {

    public static final Set<String> RESERVED_KEYWORDS = new HashSet<>(Arrays.asList("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"));
    private IconsUiHandlers uiHandlers;

    private DivElement element;
    private DivElement byTagsContainer;
    private HTMLInputElement copyInput = input("textarea").style("visibility:hidden; width: 0px; height: 0px;").element();

    private Map<String, Card> icons_cards = new HashMap<>();
    private String tag;

    @Override
    protected HTMLDivElement init() {
        element = div();
        element.appendChild(copyInput);

        element.appendChild(SearchBox.create()
                .addCss(dui_m_b_4, dui_rounded_md, dui_border, dui_border_teal, dui_border_solid)
                .setAutoSearch(true)
                .setAutoSearchDelay(1000)
                .withTextBox((parent, textBox) -> textBox
                        .appendChild(PostfixAddOn.of(ToggleMdiIcon.create(Icons.arrow_collapse_vertical(), Icons.arrow_expand_vertical())
                                        .clickable()
                                        .apply(self -> {
                                            self.addClickListener(evt -> {
                                                self.toggle();
                                                icons_cards.forEach((s, card) -> card.toggleCollapse());
                                            });
                                        })
                                )
                        )
                )
                .addSearchListener(token -> {
                    byTagsContainer.clearElement();
                    icons_cards.clear();
                    if (token.isEmpty()) {
                        setTag(this.tag);
                    } else {
                        if (isNull(tag) || "all".equals(tag)) {
                            MdiTags.TAGS.forEach(tag -> findForTag(token, tag));
                        } else {
                            findForTag(token, this.tag);
                        }
                    }
                })
        );
        element.appendChild(byTagsContainer = div());
        mdiEffects();
        return element.element();
    }

    @Override
    public void setTag(String tag) {
        this.tag = tag.replace("_", " / ");
        byTagsContainer.clearElement();
        icons_cards.clear();
        if ("all".equals(this.tag)) {
            MdiTags.TAGS.forEach(iconsTag -> {
                icons_cards.put(iconsTag, createCategoryCard(iconsTag));
            });
        } else {
            icons_cards.put(this.tag, createCategoryCard(this.tag));
        }
    }


    private void findForTag(String token, String tag) {
        List<Supplier<MdiIcon>> foundForTag = MdiByTagFactory.get(Arrays.asList("Untagged", "").contains(tag) ? MdiTags.UNTAGGED : tag).stream().filter(supplier -> {
                    MdiIcon mdiIcon = supplier.get();
                    return mdiIcon.getMetaInfo()
                            .getAliases()
                            .stream()
                            .anyMatch(alias -> alias.toLowerCase().contains(token.toLowerCase())) ||
                            mdiIcon.getMetaInfo().getName().contains(token.toLowerCase()) ||
                            mdiIcon.getMetaInfo().getTags()
                                    .stream().anyMatch(iconTag -> iconTag.toLowerCase().contains(token.toLowerCase()))
                            ;
                })
                .collect(Collectors.toList());

        if (!foundForTag.isEmpty()) {
            icons_cards.put(tag, createCategoryCard(tag, foundForTag));
        }
    }

    private Card createCategoryCard(String tag, List<Supplier<MdiIcon>> iconsSuppliers) {
        Card card = Card.create(tag)
                .addCss(dui_elevation_0)
                .setCollapsible(true);
        card.appendChild(PostfixAddOn.of(Badge.create(iconsSuppliers.size() + "").addCss(dui_rounded_full)));
        byTagsContainer.appendChild(card.element());
        int rows = (iconsSuppliers.size() / 4) + ((iconsSuppliers.size() % 4) > 0 ? 1 : 0);
        for (int i = 0; i < rows; i++) {
            Row row = Row.create().addCss(dui_m_y_4);
            card.appendChild(row);
            for (int j = i * 4; j < (i * 4 + 4) && j < iconsSuppliers.size(); j++) {
                row.appendChild(Column.span3().appendChild(createDemoIcon(iconsSuppliers.get(j).get())));
            }
        }
        return card;
    }

    private IsElement<HTMLElement> createDemoIcon(Icon<?> icon) {
        return LabeledIcon.create(icon, icon.getName())
                .addCss(dui_clickable)
                .addClickListener(evt -> {
                    String name = (icon.getName().replace("mdi-", "").replace("-", "_"));
                    copyInput.value = "Icons." + unreservedKeywordName(name) + "()";
                    copyInput.select();
                    EventListener copyListener = e -> {
                        ClipboardEvent clipboardEvent = Js.uncheckedCast(e);
                        clipboardEvent.clipboardData.setData("text/plain", copyInput.value);
                        e.preventDefault();
                    };
                    DomGlobal.document.addEventListener("copy", copyListener);
                    DominoDom.document.execCommand("copy");
                    DomGlobal.document.removeEventListener("copy", copyListener);
                    Notification.create("Copied to clipboard").addCss(dui_info).show();
                });

    }

    private String unreservedKeywordName(String str) {
        if (RESERVED_KEYWORDS.contains(str)) {
            return str + "_";
        }
        return str;
    }

    private Card createCategoryCard(String tag) {
        return createCategoryCard(tag, MdiByTagFactory.get(Arrays.asList("Untagged", "").contains(tag) ? MdiTags.UNTAGGED : tag));
    }

    private void mdiEffects() {
        element.appendChild(Card.create("Icons advanced features")
                .addCss(dui_elevation_0)
                .appendChild(BlockHeader.create("Sizes"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Size 18px"))
                                .appendChild(Icons.account().addCss(dui_font_size_4)))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Size 24px"))
                                .appendChild(Icons.account().addCss(dui_font_size_6)))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Size 36px"))
                                .appendChild(Icons.account().addCss(dui_font_size_10)))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Size 48px"))
                                .appendChild(Icons.account().addCss(dui_font_size_14)))
                )
                .appendChild(BlockHeader.create("Rotate"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("No rotate"))
                                .appendChild(Icons.account()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 45"))
                                .appendChild(Icons.account().rotate45()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 90"))
                                .appendChild(Icons.account().rotate90()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 135"))
                                .appendChild(Icons.account().rotate135()))
                )
                .appendChild(Row.create()

                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 180"))
                                .appendChild(Icons.account().rotate180()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 255"))
                                .appendChild(Icons.account().rotate225()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 270"))
                                .appendChild(Icons.account().rotate270()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 315"))
                                .appendChild(Icons.account().rotate315()))
                )
                .appendChild(BlockHeader.create("Flip"))
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(h(6).textContent("No flip"))
                                .appendChild(Icons.account_alert()))
                        .appendChild(Column.span4()
                                .appendChild(h(6).textContent("Flip horizontal"))
                                .appendChild(Icons.account_alert().flipH()))
                        .appendChild(Column.span4()
                                .appendChild(h(6).textContent("Flip vertical"))
                                .appendChild(Icons.account_alert().flipV()))
                )
                .appendChild(BlockHeader.create("Spin"))
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(Icons.loading().spin()))
                        .appendChild(Column.span6()
                                .appendChild(Icons.star().spin()))
                )
                .appendChild(BlockHeader.create("Contrast"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Light"))
                                .appendChild(div().style("width: 40px; height:40px")
                                        .addCss(dui_black, dui_font_size_10)
                                        .appendChild(Icons.account()
                                                .light())))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Light inactive"))
                                .appendChild(div().style("width: 40px; height:40px")
                                        .addCss(dui_black, dui_font_size_10)
                                        .appendChild(Icons.account()
                                                .light()
                                                .inactive())))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Dark"))
                                .appendChild(Icons.account()
                                        .dark()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Dark inactive"))
                                .appendChild(Icons.account()
                                        .dark()
                                        .inactive()))
                )
                .setCollapsible(true)
        );
    }

    @Override
    public void setUiHandlers(IconsUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }

}