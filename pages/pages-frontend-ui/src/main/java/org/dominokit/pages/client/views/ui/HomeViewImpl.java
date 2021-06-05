package org.dominokit.pages.client.views.ui;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.presenters.BaseHomeProxy;
import org.dominokit.pages.client.presenters.SolutionsProxy;
import org.dominokit.pages.client.views.HomeView;
import org.gwtproject.core.client.GWT;
import org.gwtproject.core.client.Scheduler;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.px;

@UiView(presentable = {
        BaseHomeProxy.HomeProxy.class,
        BaseHomeProxy.NewsProxy.class,
        BaseHomeProxy.AboutProxy.class
})
public class HomeViewImpl extends FakeView implements HomeView {

    private HomeUiHandlers uiHandlers;
    private EventListener removeSolutionsMenuListener;

    @Override
    public void enhance() {
        removeSolutionsMenuListener = evt -> {
            DominoElement.of(getElement(".solutions-menu")).style().setDisplay("none");
            document.removeEventListener("click", removeSolutionsMenuListener);
        };
        enhanceLinks();
        enhanceMenuPosition();
    }

    private void enhanceLinks() {
        NodeList<Element> elements = getElements("a[d-link]");
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

    public void enhanceClientsNavigation() {
        DominoElement.of(getElement("#nav-client-prev"))
                .addClickListener(evt -> {
                    evt.stopPropagation();
                    evt.preventDefault();
                    int activeIndex = getActiveClient();
                    HTMLElement main = getElement(".clients-main");
                    if (activeIndex > 0) {
                        for (int i = 0; i < activeIndex; i++) {
                            HTMLElement card = getElement(main, "div[d-client-card=\"" + i + "\"]");
                            int index = i;
                            card.classList.asList()
                                    .forEach(cssClass -> {
                                        if (cssClass.startsWith("client-card-l-")) {
                                            card.classList.remove(cssClass);
                                            if (index == activeIndex - 1) {
                                                DominoElement.of(card).css("active");
                                            } else {
                                                DominoElement.of(card).css("client-card-l-" + (activeIndex - index));
                                            }
                                        }
                                    });
                        }
                        DominoElement.of(getElement(main, "div[d-client-card=\"" + activeIndex + "\"]"))
                                .removeCss("active")
                                .css("client-card-r-" + activeIndex);

                        int newActiveIndex = getActiveClient();
                        for (int i = newActiveIndex + 1; i < 5; i++) {
                            HTMLElement card = getElement(main, "div[d-client-card=\"" + i + "\"]");
                            int index = i;
                            card.classList.asList()
                                    .forEach(cssClass -> {
                                        if (cssClass.startsWith("client-card-l-") || cssClass.startsWith("client-card-r-")) {
                                            card.classList.remove(cssClass);
                                            DominoElement.of(card).css("client-card-r-" + (index - newActiveIndex));
                                        }
                                    });
                        }
                    }
                });

        DominoElement.of(getElement("#nav-client-next"))
                .addClickListener(evt -> {
                    evt.stopPropagation();
                    evt.preventDefault();
                    int activeIndex = getActiveClient();
                    HTMLElement main = getElement(".clients-main");
                    if (activeIndex < 4) {
                        for (int i = activeIndex + 1; i < 5; i++) {
                            HTMLElement card = getElement(main, "div[d-client-card=\"" + i + "\"]");
                            int index = i;
                            card.classList.asList()
                                    .forEach(cssClass -> {
                                        if (cssClass.startsWith("client-card-r-")) {
                                            card.classList.remove(cssClass);
                                            if (index == activeIndex + 1) {
                                                DominoElement.of(card).css("active");
                                            } else {
                                                DominoElement.of(card).css("client-card-r-" + (index - activeIndex));
                                            }
                                        }
                                    });
                        }
                        DominoElement.of(getElement(main, "div[d-client-card=\"" + activeIndex + "\"]"))
                                .removeCss("active")
                                .css("client-card-l-" + activeIndex);

                        int newActiveIndex = getActiveClient();
                        for (int i = newActiveIndex - 1; i >= 0; i--) {
                            HTMLElement card = getElement(main, "div[d-client-card=\"" + i + "\"]");
                            int index = i;
                            card.classList.asList()
                                    .forEach(cssClass -> {
                                        if (cssClass.startsWith("client-card-l-") || cssClass.startsWith("client-card-r-")) {
                                            card.classList.remove(cssClass);
                                            DominoElement.of(card).css("client-card-l-" + (newActiveIndex - index));
                                        }
                                    });
                        }
                    }
                });
    }

    private int getActiveClient() {
        return Integer.parseInt(DominoElement.of(getElement(getElement(".clients-main"), ".active"))
                .getAttribute("d-client-card"));
    }

    private NodeList<Element> getElements(String selector) {
        return DomGlobal.document.querySelectorAll(selector);
    }

    private NodeList<Element> getElements(Element root, String selector) {
        return root.querySelectorAll(selector);
    }

    private HTMLElement getElement(String selector) {
        return Js.uncheckedCast(DomGlobal.document.querySelector(selector));
    }

    private HTMLElement getElement(Element root, String selector) {
        return Js.uncheckedCast(root.querySelector(selector));
    }

    @Override
    public void updateContent(String content) {
        DominoElement.of(getElement("#root"))
                .clearElement()
                .setInnerHtml(content);
        window.scrollTo(0,0);
    }

    @Override
    public void setPageTitle(String pageTitle) {
        document.title = "DominoKit - " + pageTitle;
    }

    @Override
    public void setUiHandlers(HomeUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }
}
