package org.dominokit.pages.client.views.ui;

import elemental2.dom.DOMRect;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.views.SiteView;

import java.util.Optional;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.px;

public abstract class SiteViewImpl extends NavigableViewImpl<FakeElement> implements SiteView {

    private EventListener removeSolutionsMenuListener;

    protected void initRoot(FakeElement root) {
    }

    protected FakeElement init() {
        return new FakeElement((attached) -> {
            if (attached) {
                this.revealHandler.onRevealed();
            } else {
                this.removeHandler.onRemoved();
            }
        }, getClass().getName());
    }

    private void enhanceMenuPosition() {
        HTMLElement solutionsLink = getElement("a[d-link=\"solutions\"]");
        Optional.ofNullable(solutionsLink).map(DominoElement::of).ifPresent(element -> element.addClickListener(evt -> {
            evt.preventDefault();
            evt.stopPropagation();

            document.addEventListener("click", removeSolutionsMenuListener);
            DOMRect targetRect = solutionsLink.getBoundingClientRect();
            HTMLElement menu = getElement(".solutions-menu");

            menu.style.setProperty("top", px.of((targetRect.top + targetRect.height + window.pageYOffset)));
            menu.style.setProperty("left", px.of((targetRect.left + window.pageXOffset - (145 - (targetRect.width / 2)))));
            DominoElement.of(menu).style().setDisplay("block");
        }));
    }

    protected HTMLElement getElement(String selector) {
        return Js.uncheckedCast(document.querySelector(selector));
    }

    @Override
    public void updateRootContent(String content) {
        DominoElement.of(getElement("#root")).clearElement().setInnerHtml(content);
        window.scrollTo(0, 0);
    }

    @Override
    public void setPageTitle(String pageTitle) {
        document.title = "DominoKit - " + pageTitle;
    }

    @Override
    public void enhance() {
        removeSolutionsMenuListener = evt -> {
            DominoElement.of(getElement(".solutions-menu")).style().setDisplay("none");
            document.removeEventListener("click", removeSolutionsMenuListener);
        };
        enhanceLinks();
        enhanceMenuPosition();
        extraEnhancement();
    }

    protected void extraEnhancement() {

    }
}
