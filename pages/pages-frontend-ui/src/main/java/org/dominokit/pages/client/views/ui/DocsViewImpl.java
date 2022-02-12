package org.dominokit.pages.client.views.ui;

import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.view.slots.SingleElementSlot;
import org.dominokit.pages.client.presenters.DocsProxy;
import org.dominokit.pages.client.views.DocsView;

import static elemental2.dom.DomGlobal.window;

@UiView(presentable = DocsProxy.class)
public class DocsViewImpl extends SiteViewImpl implements DocsView {

    private DocsTree docsTree;

    @Override
    public void selectMenu(String menuHref) {
        docsTree.selectItem(menuHref);
    }

    @Override
    public void updateDocsContent(String content) {
        DominoElement.of(getElement(".docs-content"))
                .clearElement()
                .setInnerHtml(content);
        window.scrollTo(0, 0);
    }

    @Override
    public void enhanceTree() {
        docsTree = new DocsTree();
        docsTree.build();
    }

    @Override
    protected void extraEnhancement() {
        ClientApp.make().slotsManager().registerSlot("docs-content", SingleElementSlot.of(getElement(".docs-content")));
    }

}
