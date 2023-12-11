package org.dominokit.pages.client.views.ui.samples.components.breadcrumbs;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_cyan;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_pink;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.breadcrumbs.Breadcrumb;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BreadcrumbsBasicSample extends BaseDominoElement<HTMLDivElement, BreadcrumbsBasicSample> {

    private DivElement element;

    public static BreadcrumbsBasicSample create() {
        return new BreadcrumbsBasicSample();
    }

    public BreadcrumbsBasicSample() {
        this.element = div().addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4)
                .appendChild(Breadcrumb.create()
                        .appendChild(" Home ", evt -> {
                        }))
                .appendChild(Breadcrumb.create()
                        .appendChild(" Home ", evt -> {
                        })
                        .appendChild(" Library ", evt -> {
                        }))
                .appendChild(Breadcrumb.create()
                        .disable()
                        .appendChild(" Home ", evt -> {
                        })
                        .appendChild(" Library ", evt -> {
                        })
                        .appendChild(" Data ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .addCss(dui_accent_pink)
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .addCss(dui_accent_cyan)
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                        .appendChild(Icons.archive(), " Data ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .addCss(dui_accent_teal)
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                        .appendChild(Icons.archive(), " Data ", evt -> {
                        })
                        .appendChild(Icons.attachment(), " File ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .addCss(dui_accent_orange)
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                        .appendChild(Icons.archive(), " Data ", evt -> {
                        })
                        .appendChild(Icons.attachment(), " File ", evt -> {
                        })
                        .appendChild(Icons.widgets(), " Extensions ", evt -> {
                        })
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
