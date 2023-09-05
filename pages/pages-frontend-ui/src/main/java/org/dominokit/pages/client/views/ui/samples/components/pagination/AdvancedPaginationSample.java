package org.dominokit.pages.client.views.ui.samples.components.pagination;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.pagination.AdvancedPagination;
import org.dominokit.domino.ui.pagination.SimplePagination;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class AdvancedPaginationSample extends BaseDominoElement<HTMLDivElement, AdvancedPaginationSample> {

    private DivElement element;

    public static AdvancedPaginationSample create() {
        return new AdvancedPaginationSample();
    }

    public AdvancedPaginationSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(AdvancedPagination.create(50, 10)
                        .addChangeListener((oldPage, pageNumber) -> DomGlobal.console.info(String.valueOf(pageNumber))))
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
