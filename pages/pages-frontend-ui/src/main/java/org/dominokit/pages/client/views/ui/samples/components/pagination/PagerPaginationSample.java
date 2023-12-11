package org.dominokit.pages.client.views.ui.samples.components.pagination;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.pagination.Pager;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class PagerPaginationSample extends BaseDominoElement<HTMLDivElement, PagerPaginationSample> {

    private DivElement element;

    public static PagerPaginationSample create() {
        return new PagerPaginationSample();
    }

    public PagerPaginationSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page.")))
                .appendChild(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
                        .nextText("Newer")
                        .previousText("Older")
                        .showArrows())
                .appendChild(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
                        .nextText("Newer")
                        .previousText("Older")
                        .showArrows()
                        .spread(true))
                .appendChild(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
                        .nextText("Newer")
                        .previousText("Older")
                        .showArrows()
                        .disablePrevious())
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
