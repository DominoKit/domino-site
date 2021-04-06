package org.dominokit.site.home.client.views.ui;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsAlign;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.utils.ScreenMedia;
import org.dominokit.domino.view.BaseElementView;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.utils.DominoElement;

import org.dominokit.site.SiteColor;
import org.dominokit.site.home.client.presenters.HomeProxy;
import org.dominokit.site.home.client.views.HomeView;

import static org.jboss.elemento.Elements.h;
import static org.jboss.elemento.Elements.img;

@UiView(presentable = HomeProxy.class)
public class HomeViewImpl extends BaseElementView<HTMLDivElement> implements HomeView {

    private HomeUiHandlers uiHandlers;

    @Override
    public HTMLDivElement init() {

        NodeList<Element> allLinks = DomGlobal.document.querySelectorAll("a[domino-link]");
        for (int i = 0; i < allLinks.length; i++) {
            HTMLAnchorElement link = Js.uncheckedCast(allLinks.getAt(i));
            DominoElement.of(link)
                    .addClickListener(evt -> {
                        evt.preventDefault();
                        evt.stopPropagation();
                        loadPage(link.getAttribute("domino-link"));
                    });
        }

        return DominoElement.div()
                .element();
    }

    private void loadPage(String pageName) {
        uiHandlers.onPageRequest(pageName);
    }

    @Override
    public void setUiHandlers(HomeUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }
}