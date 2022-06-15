package org.dominokit.pages.client.views.ui;

import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.views.SiteView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.em;
import static org.dominokit.domino.ui.style.Unit.px;

public abstract class SiteViewImpl extends NavigableViewImpl<FakeElement> implements SiteView {

    private EventListener removeSolutionsMenuListener;
    private EventListener hideListener;

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
        for (HTMLElement solutionsLink : getElements("a[d-link=\"solutions\"]")) {
            Optional.ofNullable(solutionsLink).map(DominoElement::of).ifPresent(element -> {
                element.addClickListener(evt -> {
                    evt.preventDefault();
                    evt.stopPropagation();

                    document.addEventListener("click", removeSolutionsMenuListener);
                    DOMRect targetRect = solutionsLink.getBoundingClientRect();
                    HTMLElement menu = getElement(".dk-c-solutions-menu");

                    menu.style.setProperty("top", em.of((targetRect.top + targetRect.height + window.pageYOffset) / 16));
                    menu.style.setProperty("left", em.of(((targetRect.left + window.pageXOffset - (130 - (targetRect.width / 2)))) / 16));
                    DominoElement.of(menu).style().setDisplay("block");
                    if(nonNull(hideListener)){
                        window.removeEventListener("click", hideListener);
                    }
                    hideListener = evt1 -> DominoElement.of(menu).style().setDisplay("none");
                    window.addEventListener("click", hideListener);
                });
            });
        }

        HTMLElement mobileNav = getElement("div[class=\"dk-c-mobile-nav\"]");
        Optional.ofNullable(mobileNav).ifPresent(htmlElement -> {
            EventListener eventListener = evt1 -> {
                if (htmlElement.classList.contains("open")) {
                    htmlElement.classList.remove("open");
                } else {
                    htmlElement.classList.add("open");
                }
            };
            htmlElement.addEventListener("click", eventListener);
            htmlElement.addEventListener("touch", eventListener);
        });
    }

    protected List<HTMLElement> getElements(String selector) {
        return document.querySelectorAll(selector).asList().stream().map(element -> (HTMLElement) element)
                .collect(Collectors.toList());
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
            DominoElement.of(getElement(".dk-c-solutions-menu")).style().setDisplay("none");
            document.removeEventListener("click", removeSolutionsMenuListener);
        };
        enhanceLinks();
        enhanceMenuPosition();
        extraEnhancement();
    }

    protected void extraEnhancement() {

    }
}
