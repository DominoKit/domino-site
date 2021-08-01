package org.dominokit.pages.client.views.ui;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.presenters.DocsProxy;
import org.dominokit.pages.client.views.DocsView;

import java.util.List;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static java.util.stream.Collectors.toList;
import static org.dominokit.domino.ui.style.Unit.px;

@UiView(presentable = DocsProxy.class)
public class DocsViewImpl extends FakeView implements DocsView {
    private DocsUiHandlers uiHandlers;
    private EventListener removeSolutionsMenuListener;

    @Override
    public void enhance() {
        removeSolutionsMenuListener = evt -> {
            DominoElement.of(getElement(".solutions-menu")).style().setDisplay("none");
            document.removeEventListener("click", removeSolutionsMenuListener);
        };
        enhanceLinks();
        enhanceMenuPosition();
        List<DominoElement<HTMLElement>> treeItems = getElements("docs-menu-item-title");
        treeItems
                .forEach(element -> {
                    element.addClickListener(evt -> {
                        treeItems.forEach(e -> e.removeCss("active"));
                        element.addCss("active");
                        Element parentElement = element.element().parentElement;
                        HTMLCollection<Element> elementsByClassName = parentElement.getElementsByClassName("docs-menu-children");
                        if(elementsByClassName.length > 0) {
                            if (parentElement.classList.contains("collapsed")) {
                                parentElement.classList.remove("collapsed");
                                parentElement.classList.add("expanded");
                            } else {
                                parentElement.classList.remove("expanded");
                                parentElement.classList.add("collapsed");
                            }
                        }
                        if (element.hasAttribute("d-link")) {
                            uiHandlers.onLinkClick(element.getAttribute("d-link"));
                        }
                    });
                });
    }

    private List<DominoElement<HTMLElement>> getElements(String clazz) {
        return document.body.getElementsByClassName(clazz)
                .asList()
                .stream()
                .map(element -> (HTMLElement) element)
                .map(DominoElement::of)
                .collect(toList());
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
        window.scrollTo(0, 0);
    }

    @Override
    public void setPageTitle(String pageTitle) {
        document.title = "DominoKit - " + pageTitle;
    }

    @Override
    public void setUiHandlers(DocsUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }
}
