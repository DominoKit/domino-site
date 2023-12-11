package org.dominokit.pages.client.views.ui.samples.components.badges;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_cyan;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_inherit;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_red;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_border;
import static org.dominokit.domino.ui.utils.Domino.dui_border_1;
import static org.dominokit.domino.ui.utils.Domino.dui_border_accent_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_border_amber;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_border_teal_d_4;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_inherit;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_grow_1;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_full;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_md;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.HTMLDivElement;
import java.util.Arrays;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BadgesListsSample extends BaseDominoElement<HTMLDivElement, BadgesListsSample> {

    private DivElement element;

    public static BadgesListsSample create() {
        return new BadgesListsSample();
    }

    public BadgesListsSample() {
        ListGroup<BadgeSample> listGroup = ListGroup.<BadgeSample>create()
                .setItemRenderer((listGroup1, listItem) -> {
                    listItem.appendChild(div().addCss(dui_flex, dui_p_4)
                            .appendChild(div().addCss(dui_flex, dui_items_center, dui_grow_1)
                                    .appendChild(text(listItem.getValue().desc))
                            )
                            .appendChild(div()
                                    .appendChild(Badge.create(listItem.getValue().badgeText)
                                            .addCss(listItem.getValue().cssClasses)
                                    )
                            )
                    );
                })
                .setItems(Arrays.asList(
                        new BadgeSample("Cras justo odio", "14 new", dui_bg_red, dui_rounded_md),
                        new BadgeSample("Dapibus ac facilisis in", "99 unread", dui_bg_cyan, dui_rounded_full),
                        new BadgeSample("Morbi leo risus", "99+", dui_bg_teal, dui_border, dui_border_solid, dui_border_teal_d_4),
                        new BadgeSample("Porta ac consectetur ac", "21", dui_bg_orange, dui_rounded_full, dui_border_1, dui_border_solid, dui_border_amber),
                        new BadgeSample("Vestibulum at eros", "18", dui_bg_inherit, dui_fg_inherit, dui_border_1, dui_border_solid, dui_border_accent_d_2)
                ));

        this.element = div().addCss(dui_p_2)
                .appendChild(listGroup);
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }

    private static class BadgeSample {
        private final String desc;
        private final String badgeText;
        private final CssClass[] cssClasses;

        public BadgeSample(String desc, String badgeText, CssClass... cssClasses) {
            this.desc = desc;
            this.badgeText = badgeText;
            this.cssClasses = cssClasses;
        }
    }
}
