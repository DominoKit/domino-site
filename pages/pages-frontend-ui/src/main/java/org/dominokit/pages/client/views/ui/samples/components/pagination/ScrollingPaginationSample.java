package org.dominokit.pages.client.views.ui.samples.components.pagination;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.pagination.ScrollingPagination;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ScrollingPaginationSample extends BaseDominoElement<HTMLDivElement, ScrollingPaginationSample> {

    private DivElement element;

    public static ScrollingPaginationSample create() {
        return new ScrollingPaginationSample();
    }

    public ScrollingPaginationSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(ScrollingPagination.create(500, 10, 5)
                        .addChangeListener((oldPage, pageNumber) -> DomGlobal.console.info(String.valueOf(pageNumber))))
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
