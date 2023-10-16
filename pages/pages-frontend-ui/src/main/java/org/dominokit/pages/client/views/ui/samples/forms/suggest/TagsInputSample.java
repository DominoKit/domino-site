package org.dominokit.pages.client.views.ui.samples.forms.suggest;

import elemental2.core.JsRegExp;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.suggest.OrderedSuggestionsStore;
import org.dominokit.domino.ui.forms.suggest.TagBox;
import org.dominokit.domino.ui.forms.suggest.TagOption;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TagsInputSample extends BaseDominoElement<HTMLDivElement, TagsInputSample> {

    private static final String IP_ADDRESS_REGEX = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private DivElement element;

    public static TagsInputSample create() {
        return new TagsInputSample();
    }

    public TagsInputSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("FREE TEXT TAGS", "Free text tags accept any text value"))
                .appendChild(Row.create()
                        .span6(TagBox.create("Tag input", token -> token)
                                .setPlaceholder("Type anything...")
                                .setRemovable(true)
                                .withValue(Arrays.asList("Tag A", "Tag B"))
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                        .span6(TagBox.create("Tag input", token -> {
                                            try {
                                                return Integer.parseInt(token);
                                            } catch (Exception e) {
                                                return null;
                                            }
                                        })
                                        .setPlaceholder("Type numbers...")
                                        .setRemovable(true)
                                        .withValue(Arrays.asList(1, 20))
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                        })
                        )
                )
        ;

        Person schroederColeman = new Person("Schroeder Coleman");
        OrderedSuggestionsStore<Person, Chip, TagOption<Person>> personsStore = OrderedSuggestionsStore.<Person, Chip, TagOption<Person>>create(person ->
                        Optional.of(TagOption.create(person.name, person, person.name))
                )
                .setMissingEntryProvider(inputValue -> Optional.of(TagOption.create(inputValue, new Person(inputValue), inputValue)))
                .setMissingValueProvider(person -> Optional.of(TagOption.create(person.name, person, person.name)))
                .addItem(schroederColeman)
                .addItem(new Person("Renee Mcintyre"))
                .addItem(new Person("Casey Garza"))
                .addItem(new Person("Ahmad Bawaneh"))
                .addItem(new Person("Ahmad Ali"))
                .addItem(new Person("Ali Naser"))
                .addItem(new Person("Sam Sam"))
                .addItem(new Person("Sir Sam"))
                .setSuggestionFilter((searchValue, suggestItem) -> suggestItem.getValue().getName().toLowerCase().contains(searchValue.toLowerCase()));

        this.element
                .appendChild(BlockHeader.create("SELECT TAGS", "Select tags have store of objects to be selected"))
                .appendChild(Row.create()
                        .span6(TagBox.create("Friends", personsStore)
                                .withValue(Collections.singletonList(schroederColeman))
                                .setPlaceholder("Friend's name...")
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                        .span6(TagBox.create("IP addresses", token -> token)
                                .setHelperText("Pattern: 000.000.000.000")
                                .setRemovable(true)
                                .addValidator((tagBox) -> {
                                    List<TagOption<String>> selectedOptions = tagBox.getSelectedOptions();
                                    for (TagOption<String> v : selectedOptions) {
                                        if (!new JsRegExp(IP_ADDRESS_REGEX).test(v.getValue())) {
                                            v.getComponent().addCss(dui_border, dui_border_red, dui_border_solid);
                                            return ValidationResult.invalid("Invalid IP address [ " + v + " ]");
                                        }
                                    }
                                    return ValidationResult.valid();
                                })
                                .withValue(Collections.singletonList("127.0.0.1"))
                                .setPlaceholder("Type invalid address...")
                                .setAutoValidation(true)
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                )
                .appendChild(BlockHeader.create("READONLY & DISABLED"))
                .appendChild(Row.create()
                        .span6(TagBox.create("Tag input: Readonly", token -> token)
                                .setPlaceholder("Type anything...")
                                .setRemovable(true)
                                .withValue(Arrays.asList("Tag A", "Tag B"))
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                                .setReadOnly(true)
                        )
                        .span6(TagBox.create("Tag input: Disabled", token -> token)
                                .setPlaceholder("Type anything...")
                                .setRemovable(true)
                                .withValue(Arrays.asList("Tag A", "Tag B"))
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                                .setDisabled(true)
                        )
                )
                .appendChild(BlockHeader.create("DIFFERENT COLORS"))
                .appendChild(Row.create()
                        .span6(TagBox.create("Tag input", token -> token)
                                .addCss(dui_accent_pink)
                                .setPlaceholder("Type anything...")
                                .setRemovable(true)
                                .withValue(Arrays.asList("Tag A", "Tag B"))
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                        .span6(TagBox.create("Tag input", token -> token)
                                .addCss(dui_accent_blue)
                                .setPlaceholder("Type anything...")
                                .setRemovable(true)
                                .withValue(Arrays.asList("Tag A", "Tag B"))
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

    public static class Person {

        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Person(String name) {
            this.id = 0;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
