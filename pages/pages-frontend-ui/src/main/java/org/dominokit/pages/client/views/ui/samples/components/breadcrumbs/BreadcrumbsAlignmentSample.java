package org.dominokit.pages.client.views.ui.samples.components.breadcrumbs;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.breadcrumbs.Breadcrumb;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BreadcrumbsAlignmentSample extends BaseDominoElement<HTMLDivElement, BreadcrumbsAlignmentSample> {

    private DivElement element;

    public static BreadcrumbsAlignmentSample create() {
        return new BreadcrumbsAlignmentSample();
    }

    public BreadcrumbsAlignmentSample() {
        this.element = div().addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4)
                .appendChild(Breadcrumb.create()
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .alignCenter()
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                        .appendChild(Icons.archive(), " Data ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .alignRight()
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                        .appendChild(Icons.archive(), " Data ", evt -> {
                        })
                        .appendChild(Icons.attachment(), " File ", evt -> {
                        })
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
