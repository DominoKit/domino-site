package org.dominokit.site.home.client.views.ui;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.view.BaseElementView;
import org.dominokit.site.home.client.presenters.HomeProxy;
import org.dominokit.site.home.client.presenters.SolutionsProxy;
import org.dominokit.site.home.client.views.HomeView;
import org.dominokit.site.home.client.views.SolutionsView;

@UiView(presentable = SolutionsProxy.class)
public class SolutionsViewImpl extends BaseElementView<HTMLDivElement> implements SolutionsView {

    private SolutionsUiHandlers uiHandlers;
    private String htmlContent;
    private DominoElement<HTMLDivElement> root = DominoElement.div();

    @Override
    public HTMLDivElement init() {
        return root
                .setAttribute("test", "AAAA")
                .element();
    }

    @Override
    public void enhance() {
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
    }

    private void loadPage(String pageName) {
        uiHandlers.onPageRequest(pageName);
    }

    public void setContent(String content){
        this.root.setInnerHtml(content);
    }

    @Override
    public void setUiHandlers(SolutionsUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }
}