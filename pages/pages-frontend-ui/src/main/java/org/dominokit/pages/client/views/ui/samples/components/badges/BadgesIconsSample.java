package org.dominokit.pages.client.views.ui.samples.components.badges;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_amber;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_red;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_full;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_md;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_xl;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BadgesIconsSample extends BaseDominoElement<HTMLDivElement, BadgesIconsSample> {

    private DivElement element;

    public static BadgesIconsSample create() {
        return new BadgesIconsSample();
    }

    public BadgesIconsSample() {
        this.element = div().addCss(dui_p_4)
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(Icons.bell()
                                        .appendChild(Badge.create("4").addCss(dui_bg_red, dui_rounded_full, dui_fg_white))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Icons.bell()
                                        .appendChild(Badge.create("9999999999").addCss(dui_bg_red, dui_rounded_full, dui_fg_white))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Icons.account()
                                        .appendChild(Badge.create("5")
                                                .addCss(dui_bg_amber,
                                                        dui_rounded_md,
                                                        dui_fg_white
                                                )
                                        )
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Icons.account()
                                        .clickable()
                                        .appendChild(Badge.create("10")
                                                .addCss(dui_bg_amber,
                                                        dui_rounded_xl,
                                                        dui_fg_white
                                                )
                                        )
                                )
                        )
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
