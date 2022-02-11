package org.dominokit.pages.client.views;

public interface DocsView extends SiteView {

    void selectMenu(String menuHref);

    void enhanceTree();

    void updateDocsContent(String content);
}
