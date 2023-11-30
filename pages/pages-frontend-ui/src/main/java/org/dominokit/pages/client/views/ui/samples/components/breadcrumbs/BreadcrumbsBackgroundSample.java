package org.dominokit.pages.client.views.ui.samples.components.breadcrumbs;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.breadcrumbs.Breadcrumb;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class BreadcrumbsBackgroundSample extends BaseDominoElement<HTMLDivElement, BreadcrumbsBackgroundSample> {

    private DivElement element;

    public static BreadcrumbsBackgroundSample create() {
        return new BreadcrumbsBackgroundSample();
    }

    public BreadcrumbsBackgroundSample() {
        this.element = div().addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4)
                .appendChild(Breadcrumb.create()
                        .addCss(dui_bg_red, dui_fg_white)
                        .appendChild(" Home ", evt -> {
                        })
                        .appendChild(" Library ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .addCss(dui_bg_cyan, dui_fg_white)
                        .appendChild(" Home ", evt -> {
                        })
                        .appendChild(" Library ", evt -> {
                        })
                        .appendChild(" Data ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .addCss(dui_bg_teal, dui_fg_white)
                        .appendChild(" Home ", evt -> {
                        })
                        .appendChild(" Library ", evt -> {
                        })
                        .appendChild(" Data ", evt -> {
                        })
                        .appendChild(" File ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .addCss(dui_bg_orange, dui_fg_white)
                        .appendChild(" Home ", evt -> {
                        })
                        .appendChild(" Library ", evt -> {
                        })
                        .appendChild(" Data ", evt -> {
                        })
                        .appendChild(" File ", evt -> {
                        })
                        .appendChild(" Extensions ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .addCss(dui_bg_red, dui_fg_white)
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .addCss(dui_bg_cyan, dui_fg_white)
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                        .appendChild(Icons.archive(), " Data ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .addCss(dui_bg_teal, dui_fg_white)
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
                        .addCss(dui_bg_orange, dui_fg_white)
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
