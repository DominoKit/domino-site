package org.dominokit.pages.client.views.ui;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.presenters.BaseHomeProxy;
import org.dominokit.pages.client.views.HomeView;

@UiView(presentable = {
        BaseHomeProxy.HomeProxy.class,
        BaseHomeProxy.NewsProxy.class,
        BaseHomeProxy.ServicesProxy.class,
        BaseHomeProxy.AboutProxy.class
})
public class HomeViewImpl extends SiteViewImpl implements HomeView {

    @Override
    protected boolean emptyContent() {
        return false;
    }

    @Override
    protected void extraEnhancement() {
        enhanceClientsNavigation();
    }

    public void enhanceClientsNavigation() {
        HTMLElement element = getElement("#nav-client-prev");
        if (element != null) {
            DominoElement.of(element)
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
        }
        HTMLElement element1 = getElement("#nav-client-next");
        if (element1 != null) {
            DominoElement.of(element1)
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
    }

    private int getActiveClient() {
        return Integer.parseInt(DominoElement.of(getElement(getElement(".clients-main"), ".active"))
                .getAttribute("d-client-card"));
    }

    private HTMLElement getElement(Element root, String selector) {
        return Js.uncheckedCast(root.querySelector(selector));
    }
}
