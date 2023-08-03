package org.dominokit.pages.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.NodeList;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.history.StateToken;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementsFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class NavigationBarEnhancer implements DominoCss, ElementsFactory {

    private static SingleElementCssClass activeCss = SingleElementCssClass.of(dui_active);
    private static SingleElementCssClass menuActiveELementCss = SingleElementCssClass.of(dui_active);

    private static final CssClass dui_site_menu_padded_content = () -> "dui-site-menu-padded-content";
    private static Popover popover;

    public static void enhance() {
        NodeList<Element> navElements = DomGlobal.document.querySelectorAll("[dui-site-section='main-nav']");
        navElements.asList().stream()
                .map(elements::elementOf)
                .collect(Collectors.toSet())
                .forEach(element -> {
                    DominoElement<HTMLElement> anchorElement = element.querySelector("[dui-site-data='nav-anchor']");
                    if (dui_active.isAppliedTo(element)) {
                        activeCss.apply(element);
                    }
                    String data = element.getAttribute("dui-site-data");
                    if (ClientApp.make().getHistory().currentToken().startsWithPath(data)) {
                        activeCss.apply(element);
                    }

                    if ("solutions".equalsIgnoreCase(data)) {
                        setupSolutionsMenu(element);
                    }

                    if (nonNull(anchorElement)) {
                        anchorElement.addClickListener(evt -> {
                            evt.stopPropagation();
                            evt.preventDefault();
                            activeCss.apply(element);
                            if (!"solutions".equalsIgnoreCase(data)) {
                                String href = anchorElement.getAttribute("href");
                                if (nonNull(href) && !href.isEmpty()) {
                                    if (href.startsWith("/")) {
                                        href = href.substring(1);
                                    }
                                    popover.close();
                                    ClientApp.make().getHistory().fireState(StateToken.of(href));
                                }
                            }
                        });
                    }
                });

    }

    private static void setupSolutionsMenu(DominoElement<Element> element) {
        Element solutionsMenuElement = DomGlobal.document.querySelector("[dui-site-section='solutions-menu']");

        if (nonNull(solutionsMenuElement)) {
            dui_hidden.remove(solutionsMenuElement);
            DominoElement<HTMLElement> anchorElement = element.querySelector("[dui-site-data='nav-anchor']");
            popover = Popover.create(Js.<HTMLElement>uncheckedCast(anchorElement.element()))
                    .addCss("dui-site-solutions-menu")
                    .appendChild(solutionsMenuElement)
                    .setOpenOnClick(false)
                    .setPosition(DropDirection.BOTTOM_MIDDLE)
                    .addCss(dui_rounded_md, dui_accent_white);

            List<DominoElement<Element>> navItems = elements.elementOf(solutionsMenuElement).querySelectorAll("[dui-site-data='nav-anchor']");

            navItems.forEach(anchor -> {
                if (nonNull(anchor)) {
                    anchor.addClickListener(evt -> {
                        evt.stopPropagation();
                        evt.preventDefault();
                        String href = anchor.getAttribute("href");
                        if (nonNull(href) && !href.isEmpty()) {
                            if (href.startsWith("/")) {
                                href = href.substring(1);
                            }
                            popover.close();
                            ClientApp.make().getHistory().fireState(StateToken.of(href));
                        }
                    });
                }
            });

            anchorElement.addClickListener(evt -> {
                evt.stopPropagation();
                evt.preventDefault();
                popover.open();
            });
        }
    }

    public static void enhanceContent() {
        Element contentContainer = DomGlobal.document.getElementById("dui-content-container");
        Optional.ofNullable(contentContainer)
                .ifPresent(container -> {
                    elements.elementOf(container).querySelectorAll("[dui-site-data='nav-anchor']")
                            .stream()
                            .filter(element -> !element.hasAttribute("dui-processed"))
                            .forEach(anchorElement -> {
                                anchorElement.setAttribute("dui-processed", "true");
                                anchorElement.addClickListener(evt -> {
                                    evt.stopPropagation();
                                    evt.preventDefault();
                                    String href = anchorElement.getAttribute("href");
                                    if (nonNull(href) && !href.isEmpty()) {
                                        if (href.startsWith("/")) {
                                            href = href.substring(1);
                                        }
                                        ClientApp.make().getHistory().fireState(StateToken.of(href));
                                    }
                                });
                            });
                });

        NodeList<Element> codeBlocks = DomGlobal.document.querySelectorAll("code");
        codeBlocks.asList()
                .stream()
                .filter(element -> !element.hasAttribute("dui-processed"))
                .forEach(element -> {
                    element.setAttribute("dui-processed", "true");
                    elements.elementOf(element).setInnerHtml(PR.prettyPrintOne(element.textContent.replace("<", "&lt;").replace(">", "&gt;"), null, false));
                });
    }

    public static void enhancePadding() {
        Element menuElement = DomGlobal.document.body.querySelector("#dui-site-left-menu");
        elements.body().addCss(BooleanCssClass.of(dui_site_menu_padded_content, nonNull(menuElement)));
        if (nonNull(menuElement)) {
            String path = ClientApp.make().getHistory().currentToken().path();
            Element activeAnchor = menuElement.querySelector("[href$='" + path + "']");
            if (nonNull(activeAnchor)) {
                menuActiveELementCss.apply(activeAnchor);
            }
        }
    }
}
