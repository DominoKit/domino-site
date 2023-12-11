package org.dominokit.pages.client.views.ui.samples.components.pagination;

import static org.dominokit.domino.ui.utils.Domino.b;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_large;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_small;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.pagination.SimplePagination;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BasicPaginationSample extends BaseDominoElement<HTMLDivElement, BasicPaginationSample> {

    private DivElement element;

    public static BasicPaginationSample create() {
        return new BasicPaginationSample();
    }

    public BasicPaginationSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(b().textContent("Large"))
                                .appendChild(SimplePagination.create(5)
                                        .addCss(dui_large)
                                        .markActivePage()
                                        .addChangeListener((oldPage, pageNumber) -> DomGlobal.console.info(String.valueOf(pageNumber)))
                                        .gotoPage(3)
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(b().textContent("Default"))
                                .appendChild(SimplePagination.create(5)
                                        .markActivePage()
                                        .addChangeListener((oldPage, pageNumber) -> DomGlobal.console.info(String.valueOf(pageNumber)))
                                        .gotoPage(3)
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(b().textContent("Small"))
                                .appendChild(SimplePagination.create(5)
                                        .addCss(dui_small)
                                        .markActivePage()
                                        .addChangeListener((oldPage, pageNumber) -> DomGlobal.console.info(String.valueOf(pageNumber)))
                                        .gotoPage(3)
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
}
