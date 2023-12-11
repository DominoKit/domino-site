package org.dominokit.pages.client.views.ui.samples.components.badges;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_error;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_grey_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_primary;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_full;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_md;
import static org.dominokit.domino.ui.utils.Domino.dui_success;
import static org.dominokit.domino.ui.utils.Domino.dui_warning;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BadgesButtonsSample extends BaseDominoElement<HTMLDivElement, BadgesButtonsSample> {

    private DivElement element;

    public static BadgesButtonsSample create() {
        return new BadgesButtonsSample();
    }

    public BadgesButtonsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span3().appendChild(Button.create("SUCCESS")
                                .addCss(dui_success)
                                .appendChild(Badge.create("4").addCss(dui_rounded_full))
                        ))
                        .appendChild(Column.span3().appendChild(Button.create("PRIMARY")
                                .addCss(dui_primary)
                                .appendChild(Badge.create("10+").addCss(dui_bg_white, dui_fg_grey_d_2, dui_rounded_full))
                        ))
                        .appendChild(Column.span3().appendChild(Button.create("DANGER")
                                .addCss(dui_error)
                                .appendChild(Badge.create("8").addCss(dui_bg_white, dui_fg_red, dui_rounded_md))
                        ))
                        .appendChild(Column.span3().appendChild(Button.create("WARNING")
                                .addCss(dui_warning)
                                .appendChild(Badge.create("99999999+").addCss(dui_bg_white, dui_fg_grey_d_2))
                        ))
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
