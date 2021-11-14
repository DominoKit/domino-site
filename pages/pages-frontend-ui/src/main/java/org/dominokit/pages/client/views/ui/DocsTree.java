package org.dominokit.pages.client.views.ui;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static elemental2.dom.DomGlobal.document;
import static java.util.stream.Collectors.toList;

public class DocsTree {

    private final List<DocsTreeItem> treeItems = new ArrayList<>();

    public void build() {
        treeItems.addAll(getElements(document.body, "ul.docs-menu-root")
                .stream()
                .map(element -> getElements(element.element(), ".docs-menu-item.parent"))
                .flatMap(Collection::stream)
                .map(element -> createTreeItem(element, null))
                .collect(toList()));
    }

    private DocsTreeItem createTreeItem(DominoElement<HTMLElement> item, DocsTreeItem parent) {
        ArrayList<DocsTreeItem> subItems = new ArrayList<>();
        DocsTreeItem docsTreeItem = new DocsTreeItem(this, item, parent, subItems);
        subItems.addAll(getElements(item.element(), ".docs-menu-children .docs-menu-item")
                .stream()
                .map(element -> createTreeItem(element, docsTreeItem))
                .collect(toList()));
        return docsTreeItem;
    }

    private List<DominoElement<HTMLElement>> getElements(HTMLElement root, String className) {
        return root.querySelectorAll(className)
                .asList()
                .stream()
                .map(element -> (HTMLElement) element)
                .map(DominoElement::of)
                .collect(toList());
    }

    public void deselectAll() {
        treeItems.forEach(DocsTreeItem::deselect);
    }

    public void selectItem(String menuHref) {
        deselectAll();
        treeItems.stream()
                .map(docsTreeItem -> docsTreeItem.itemHasHref(menuHref))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findAny()
                .ifPresent(DocsTreeItem::select);
    }
}
