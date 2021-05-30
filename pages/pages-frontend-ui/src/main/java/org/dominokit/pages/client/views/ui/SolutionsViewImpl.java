package org.dominokit.pages.client.views.ui;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.presenters.SolutionsProxy;
import org.dominokit.pages.client.views.SolutionsView;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.px;

@UiView(presentable = SolutionsProxy.class)
public class SolutionsViewImpl extends FakeView implements SolutionsView {
    private SolutionsUiHandlers uiHandlers;
    private EventListener removeSolutionsMenuListener;

    @Override
    public void enhance() {
        removeSolutionsMenuListener = evt -> {
            DominoElement.of(getElement(".solutions-menu")).style().setDisplay("none");
            document.removeEventListener("click", removeSolutionsMenuListener);
        };
        enhanceLinks();
        enhanceMenuPosition();
//        enhanceGettingStarted();
    }

    private void enhanceGettingStarted() {
        HTMLCollection<Element> gettingStartedNodes = document.body.getElementsByClassName("getting-started");
        gettingStartedNodes.asList().forEach(element -> {
            HTMLElement htmlElement = Js.uncheckedCast(element);
            DominoElement.of(htmlElement)
                    .addClickListener(evt -> {
                        uiHandlers.onLinkClick(htmlElement.getAttribute("href"));
                    });
        });
    }

    private void enhanceLinks() {
        NodeList<Element> elements = document.querySelectorAll("a[d-link]");
        elements.asList()
                .forEach(element -> {
                    DominoElement.of(Js.<HTMLElement>uncheckedCast(element))
                            .apply(self -> {
                                if (!"solutions".equalsIgnoreCase(self.getAttribute("d-link"))) {
                                    self.addClickListener(evt -> {
                                        evt.preventDefault();
                                        uiHandlers.onLinkClick(self.getAttribute("d-link"));
                                    });
                                }
                            });
                });
    }

    private void enhanceMenuPosition() {
        HTMLElement solutionsLink = getElement("a[d-link=\"solutions\"]");
        DominoElement.of(solutionsLink)
                .addClickListener(evt -> {
                    evt.preventDefault();
                    evt.stopPropagation();

                    document.addEventListener("click", removeSolutionsMenuListener);
                    DOMRect targetRect = solutionsLink.getBoundingClientRect();
                    HTMLElement menu = getElement(".solutions-menu");

                    menu.style.setProperty(
                            "top", px.of((targetRect.top + targetRect.height + window.pageYOffset)));
                    menu.style.setProperty("left", px.of((targetRect.left + window.pageXOffset - (145 - (targetRect.width / 2)))));
                    DominoElement.of(menu).style().setDisplay("block");
                });
    }

    private HTMLElement getElement(String selector) {
        return Js.uncheckedCast(document.querySelector(selector));
    }

    @Override
    public void updateContent(String content) {
        DominoElement.of(getElement("#root"))
                .clearElement()
                .setInnerHtml(content);
    }

    @Override
    public void setPageTitle(String pageTitle) {
        document.title = "DominoKit - " + pageTitle;
    }

    @Override
    public void setUiHandlers(SolutionsUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }
}
