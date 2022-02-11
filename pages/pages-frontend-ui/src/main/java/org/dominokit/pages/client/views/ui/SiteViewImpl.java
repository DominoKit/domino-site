package org.dominokit.pages.client.views.ui;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.mvp.view.BaseDominoView;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.views.SiteView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.px;

public abstract class SiteViewImpl extends BaseDominoView<FakeElement> implements SiteView {

    private EventListener removeSolutionsMenuListener;
    protected SiteView.SiteUiHandlers uiHandlers;
    private final Map<String, EventListener> clickListeners = new HashMap<>();

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

    private void enhanceLinks() {
        NodeList<Element> elements = document.querySelectorAll("a[d-link]");
        elements.asList().forEach(element -> {
            DominoElement.of(Js.<HTMLElement>uncheckedCast(element)).apply(self -> {
                String dLink = self.getAttribute("d-link");
                if (!"solutions".equalsIgnoreCase(dLink)) {
                    if (clickListeners.containsKey(self.getDominoId())) {
                        self.removeEventListener("click", clickListeners.get(self.getDominoId()));
                        clickListeners.remove(self.getDominoId());
                    }
                    EventListener clickListener = evt -> {
                        evt.preventDefault();
                        evt.stopPropagation();
                        uiHandlers.navigateTo(dLink);
                    };
                    self.addClickListener(clickListener);
                    clickListeners.put(self.getDominoId(), clickListener);
                }
            });
        });
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

    protected abstract boolean emptyContent();

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

    @Override
    public void setUiHandlers(SiteView.SiteUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }
}
