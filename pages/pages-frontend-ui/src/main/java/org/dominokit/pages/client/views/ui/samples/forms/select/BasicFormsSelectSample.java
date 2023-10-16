package org.dominokit.pages.client.views.ui.samples.forms.select;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.suggest.MultiSelect;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.LabeledIcon;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.icons.lib.IconsMeta;
import org.dominokit.domino.ui.menu.CustomMenuItem;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import java.util.Arrays;

public class BasicFormsSelectSample extends BaseDominoElement<HTMLDivElement, BasicFormsSelectSample> {

    private DivElement element;

    public static BasicFormsSelectSample create() {
        return new BasicFormsSelectSample();
    }

    public BasicFormsSelectSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(Select.<String>create()
                                        .appendChild(SelectOption.create("nothing", null, "-- please select --"))
                                        .appendChild(SelectOption.create("value10", "value10", "10"))
                                        .appendChild(SelectOption.create("value20", "value20", "20"))
                                        .appendChild(SelectOption.create("value30", "value30", "30"))
                                        .appendChild(SelectOption.create("value40", "value40", "40"))
                                        .appendChild(SelectOption.create("value50", "value50", "50"))
                                        .setSearchable(false)
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> Notification.create("Item selected : Old value[ " + oldValue + " ], New value [" + newValue + "]").show())))
                        .appendChild(Column.span6()
                                .appendChild(Select.<String>create()
                                        .appendChild(SelectOption.create("Disabled", "Disabled", "Disabled"))
                                        .selectAt(0)
                                        .disable()
                                ))
                )
                .appendChild(BlockHeader.create("Searchable select"))
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(Select.<String>create("Country")
                                        .setSearchable(true)
                                        .setMissingItemHandler((select, token, onComplete) -> {
                                            TextBox countryName = TextBox.create("Name")
                                                    .setRequired(true)
                                                    .withValue(token);
                                            TextBox countryCode = TextBox.create("code")
                                                    .setRequired(true);
                                            Popover.create(select.getWrapperElement())
                                                    .addCss(dui_rounded_sm)
                                                    .setPosition(DropDirection.BEST_MIDDLE_UP_DOWN)
                                                    .apply(popover -> {
                                                        popover.appendChild(Card.create("Create country")
                                                                .setIcon(Icons.map_marker())
                                                                .addCss(dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                                .appendChild(countryName)
                                                                .appendChild(countryCode)
                                                                .appendChild(div().addCss(dui_flex, dui_justify_center, dui_p_1)
                                                                        .appendChild(Button.create("Create country").addClickListener(evt -> {
                                                                            if (countryName.validate().isValid() && countryCode.validate().isValid()) {
                                                                                SelectOption<String> option = SelectOption.create(countryCode.getValue().toUpperCase(), countryCode.getValue().toUpperCase(), countryName.getValue());
                                                                                onComplete.accept(option);
                                                                                select.selectOption(option);
                                                                                popover.close();
                                                                            }
                                                                        }))
                                                                )
                                                        );
                                                    })
                                                    .addExpandListener(() -> {
                                                        select.getOptionsMenu().close();
                                                        countryName.focus();
                                                    })
                                                    .open();

                                        })
                                        .appendChild(SelectOption.create("nothing", "nothing", "-- please select --")
                                                .setSearchable(false)
                                        )
                                        .appendChild(SelectOption.create("USA", "USA", "America (USA)"))
                                        .appendChild(SelectOption.create("ARG", "ARG", "Argentina"))
                                        .appendChild(SelectOption.create("BRA", "BRA", "Brazil"))
                                        .appendChild(SelectOption.create("DEN", "DEN", "Denmark"))
                                        .appendChild(SelectOption.create("CRO", "CRO", "Croatia"))
                                        .appendChild(SelectOption.create("IND", "IND", "India"))
                                        .appendChild(SelectOption.create("SPA", "SPA", "Spain"))
                                        .appendChild(SelectOption.create("FRA", "FRA", "France"))
                                        .appendChild(SelectOption.create("JOR", "JOR", "Jordan"))
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Item selected [ " + newValue + " ]").show();
                                        })
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(Select.<String>create("Country")
                                        .setSearchable(true)
                                        .appendChild(SelectOption.create("nothing", "nothing", "-- please select --")
                                                .setSearchable(false)
                                        )
                                        .appendChild(SelectOption.create("USA", "USA", "America (USA)"))
                                        .appendChild(SelectOption.create("ARG", "ARG", "Argentina"))
                                        .appendChild(SelectOption.create("BRA", "BRA", "Brazil"))
                                        .appendChild(SelectOption.create("DEN", "DEN", "Denmark"))
                                        .appendChild(SelectOption.create("CRO", "CRO", "Croatia"))
                                        .appendChild(SelectOption.create("IND", "IND", "India"))
                                        .appendChild(SelectOption.create("SPA", "SPA", "Spain"))
                                        .appendChild(SelectOption.create("FRA", "FRA", "France"))
                                        .appendChild(SelectOption.create("JOR", "JOR", "Jordan"))
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Item selected [ " + newValue + " ]").show();
                                        })
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Grouping select"))
                                .appendChild(Select.<String>create("Country")
                                        .group(group -> {
                                                    group.withHeader((parent, header) -> header
                                                            .appendChild(PrefixAddOn.of(Icons.map_marker()))
                                                            .appendChild(PostfixAddOn.of(Badge.create("5").addCss(dui_bg_d_2, dui_rounded_full)))
                                                            .addCss(dui_h_8, dui_blue)
                                                            .setTitle("America")
                                                    );
                                                }, Arrays.asList(SelectOption.create("USA", "USA", "United States of America"),
                                                        SelectOption.create("BRA", "BRA", "Brazil"),
                                                        SelectOption.create("ARG", "ARG", "Argentina"),
                                                        SelectOption.create("MEX", "MEX", "Mexico"),
                                                        SelectOption.create("CHI", "CHI", "Chile")
                                                )
                                        )
                                        .group(group -> {
                                                    group.withHeader((parent, header) -> header
                                                            .appendChild(PrefixAddOn.of(Icons.map_marker()))
                                                            .appendChild(PostfixAddOn.of(Badge.create("5").addCss(dui_bg_d_2, dui_rounded_full)))
                                                            .addCss(dui_h_8, dui_teal)
                                                            .setTitle("Europe")
                                                    );
                                                }, Arrays.asList(SelectOption.create("FRA", "FRA", "France"),
                                                        SelectOption.create("GER", "GER", "Germany"),
                                                        SelectOption.create("SPA", "SPA", "Spain"),
                                                        SelectOption.create("ITA", "ITA", "Italy"),
                                                        SelectOption.create("UK", "UK", "United Kingdom")
                                                )

                                        )
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Item selected [ " + newValue + " ]").show();
                                        })
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Custom select"))
                                .appendChild(Select.<MdiIcon>create("Icon picker")
                                        .appendItems(IconOption::create, Icons.access_point(),
                                                IconsMeta.access_point_check(),
                                                IconsMeta.access_point_minus(),
                                                IconsMeta.access_point_network(),
                                                IconsMeta.access_point_network_off(),
                                                IconsMeta.access_point_off(),
                                                IconsMeta.access_point_plus(),
                                                IconsMeta.access_point_remove(),
                                                IconsMeta.antenna()
                                        )
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Item selected [ " + newValue.getName() + " ]").appendChild(newValue).show();
                                        })
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Multi select"))
                                .appendChild(MultiSelect.<String>create("Country")
                                        .appendChild(SelectOption.create("USA", "USA", "America (USA)"))
                                        .appendChild(SelectOption.create("ARG", "ARG", "Argentina"))
                                        .appendChild(SelectOption.create("BRA", "BRA", "Brazil"))
                                        .appendChild(SelectOption.create("DEN", "DEN", "Denmark"))
                                        .appendChild(SelectOption.create("CRO", "CRO", "Croatia"))
                                        .appendChild(SelectOption.create("IND", "IND", "India"))
                                        .appendChild(SelectOption.create("SPA", "SPA", "Spain"))
                                        .appendChild(SelectOption.create("FRA", "FRA", "France"))
                                        .appendChild(SelectOption.create("JOR", "JOR", "Jordan"))
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Item selected [ " + newValue + " ]").show();
                                        })
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Multi select"))
                                .appendChild(MultiSelect.<MdiIcon>create("Icon picker")
                                        .appendItems(IconOption::create, Icons.access_point(),
                                                IconsMeta.access_point_check(),
                                                IconsMeta.access_point_minus(),
                                                IconsMeta.access_point_network(),
                                                IconsMeta.access_point_network_off(),
                                                IconsMeta.access_point_off(),
                                                IconsMeta.access_point_plus(),
                                                IconsMeta.access_point_remove(),
                                                IconsMeta.antenna()
                                        )
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Icons selected : ")
                                                    .apply(self -> newValue.forEach(self::appendChild))
                                                    .show();
                                        })
                                )
                        )
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
    public static class IconOption extends SelectOption<MdiIcon> {
        public IconOption(MdiIcon mdiIcon) {
            super(mdiIcon.getName(), mdiIcon,
                    (key, value) -> elements.div()
                            .appendChild(LabeledIcon.create(mdiIcon.copy(), mdiIcon.getName())
                                    .addCss(dui_rounded_full, dui_accent, dui_p_x_1))
                    ,
                    (key, icon) -> CustomMenuItem.<MdiIcon>create()
                            .setSearchFilter((token, caseSensitive) -> icon.getMetaInfo()
                                    .getAliases()
                                    .stream()
                                    .anyMatch(alias -> compare(alias, token, caseSensitive)) ||
                                    compare(icon.getMetaInfo().getName(), token, caseSensitive) ||
                                    icon.getMetaInfo().getTags()
                                            .stream().anyMatch(iconTag -> compare(iconTag, token, caseSensitive))
                            )
                            .appendChild(elements.div()
                                    .addCss(dui_flex, dui_gap_1, dui_items_center)
                                    .appendChild(mdiIcon)
                                    .appendChild(elements.span()
                                            .addCss(dui_grow_1)
                                            .textContent(mdiIcon.getName()))
                                    .appendChild(Badge.create("version :" + mdiIcon.getMetaInfo().getVersion())
                                            .addCss(dui_rounded_full))
                            )
            );
        }

        private static boolean compare(String left, String right, boolean caseSensitive) {
            if (caseSensitive) {
                return left.contains(right);
            } else {
                return left.toLowerCase().contains(right.toLowerCase());
            }
        }

        public static IconOption create(MdiIcon icon) {
            return new IconOption(icon);
        }
    }


}
