package org.dominokit.pages.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.List;
import java.util.Optional;

public class DocsTreeItem {

    private final DocsTree docsTree;
    private final DominoElement<HTMLElement> root;
    private final DocsTreeItem parent;
    private final List<DocsTreeItem> subItems;
    private final DominoElement<HTMLAnchorElement> hrefElement;

    public DocsTreeItem(DocsTree docsTree, DominoElement<HTMLElement> root, DocsTreeItem parent, List<DocsTreeItem> subItems) {
        this.docsTree = docsTree;
        this.root = root;
        this.parent = parent;
        this.subItems = subItems;
        hrefElement = DominoElement.of((HTMLAnchorElement) root.element().querySelector("a.docs-menu-item-title"));
        hrefElement.addClickListener(evt -> {
            docsTree.deselectAll();
            select();
        });
    }

    public void select() {
        hrefElement.addCss("active");
        expand();
        if (parent != null) {
            parent.expand();
        }
    }

    private void expand() {
        if (isParent()) {
            root.addCss("expanded");
            root.removeCss("collapsed");
        }
    }

    private void collapse() {
        if (isParent()) {
            root.removeCss("expanded");
            root.addCss("collapsed");
        }
    }

    private boolean isParent() {
        return !subItems.isEmpty();
    }

    public void deselect() {
        hrefElement.removeCss("active");
        subItems.forEach(DocsTreeItem::deselect);
        collapse();
    }

    public Optional<DocsTreeItem> itemHasHref(String menuHref) {
        if (hrefElement.element().href.endsWith(menuHref)) {
            return Optional.of(this);
        }
        for (DocsTreeItem subItem : subItems) {
            if(subItem.itemHasHref(menuHref).isPresent()){
                return Optional.of(subItem);
            }
        }
        return Optional.empty();
    }
}
