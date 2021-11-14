package org.dominokit.pages.client.views.ui;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.view.slots.SingleElementSlot;
import org.dominokit.pages.client.presenters.DocsProxy;
import org.dominokit.pages.client.views.DocsView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static java.util.stream.Collectors.toList;

@UiView(presentable = DocsProxy.class)
public class DocsViewImpl extends SiteViewImpl implements DocsView {

    private static final String D_LINK = "d-link";
    private Map<String, SingleElementSlot> slots = new HashMap<>();
    private DocsTree docsTree;

    @Override
    protected void extraEnhancement() {
        registerSlots();
    }

    private void registerSlots() {
        slots.forEach((s, singleElementSlot) -> ClientApp.make().slotsManager().removeSlot(s));
        slots = document.body.querySelectorAll("div[component-slot]")
                .asList()
                .stream()
                .collect(Collectors.toMap(element -> element.getAttribute("component-slot"), element -> SingleElementSlot.of((HTMLElement) element)));

        slots.forEach((s, singleElementSlot) -> ClientApp.make().slotsManager().registerSlot(s, singleElementSlot));
    }

    private List<DominoElement<HTMLElement>> getElements() {
        return document.body.getElementsByClassName("docs-menu-item-title")
                .asList()
                .stream()
                .map(element -> (HTMLElement) element)
                .map(DominoElement::of)
                .collect(toList());
    }

    @Override
    public void selectMenu(String menuHref) {
        docsTree.selectItem(menuHref);
    }

    @Override
    public void updateContent(String content) {
        DominoElement.of(getElement(".docs-content"))
                .clearElement()
                .setInnerHtml(content);
        window.scrollTo(0, 0);
        registerSlots();
    }

    @Override
    public void enhanceTree() {
        docsTree = new DocsTree();
        docsTree.build();
    }
}
