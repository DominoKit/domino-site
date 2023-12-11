package org.dominokit.pages.client.views.ui;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.NodeList;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.history.StateToken;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.style.ToggleCssClass;
import org.dominokit.domino.ui.utils.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;

public class NavigationEnhancer implements DominoCss, ElementsFactory {

    private static SingleElementCssClass activeCss = SingleElementCssClass.of(dui_active);
    private static SingleElementCssClass menuActiveELementCss = SingleElementCssClass.of(dui_active);
    private static SingleElementCssClass activeSubMenuCss = SingleElementCssClass.of(dui_active);
    private static ToggleCssClass rightSideMenuOpenCss = ToggleCssClass.of(dui_active);
    private static ToggleCssClass leftSideMenuOpenCss = ToggleCssClass.of(dui_active);
    private static ToggleCssClass rightSideDocsMenuOpenCss = ToggleCssClass.of(dui_active);
    private static SingleElementCssClass activeClientCardCss = SingleElementCssClass.of(dui_active);

    private static final CssClass dui_site_menu_padded_content = () -> "dui-site-menu-padded-content";
    private static Popover popover;

    public static void enhance() {
        NodeList<Element> navElements = document.querySelectorAll("[dui-site-section='main-nav']");
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
                                    if (anchorElement.hasAttribute("dui-side-menu-link")) {
                                        Optional.ofNullable(document.getElementById("dui-site-left-menu"))
                                                .ifPresent(menu -> leftSideMenuOpenCss.apply(menu));
                                    }
                                    ElementUtil.scrollTop();
                                }
                            }
                        });
                    }
                });

        Element sideMenuButton = document.getElementById("dui-site-sm-nav-menu-button");
        elements.elementOf(sideMenuButton)
                .addClickListener(evt -> {
                    evt.stopPropagation();
                    evt.preventDefault();
                    rightSideMenuOpenCss.apply(document.getElementById("dui-site-sm-nav-side-menu"));
                });
        elements.body().addClickListener(evt -> rightSideMenuOpenCss.remove(document.getElementById("dui-site-sm-nav-side-menu")));

        Optional.ofNullable(document.getElementById("dui-site-docs-left-menu-button"))
                .ifPresent(element -> {
                    elements.elementOf(element)
                            .addClickListener(evt -> {
                                evt.stopPropagation();
                                evt.preventDefault();
                                leftSideMenuOpenCss.apply(document.getElementById("dui-site-left-menu"));
                            })
                            .setAttribute("dui-processed", true);
                });

        elements.body().addClickListener(evt -> {
            Optional.ofNullable(document.getElementById("dui-site-left-menu"))
                    .ifPresent(element -> leftSideMenuOpenCss.remove(element));
        });

        Optional.ofNullable(document.getElementById("dui-site-doc-page-side-nav-button"))
                .ifPresent(element -> {
                    elements.elementOf(element)
                            .addClickListener(evt -> {
                                evt.stopPropagation();
                                evt.preventDefault();
                                rightSideDocsMenuOpenCss.apply(document.getElementById("dui-site-doc-page-side-nav"));
                            })
                            .setAttribute("dui-processed", true);
                });

        elements.body().addClickListener(evt -> {
            Optional.ofNullable(document.getElementById("dui-site-doc-page-side-nav"))
                    .ifPresent(element -> rightSideDocsMenuOpenCss.remove(element));
        });
    }

    private static void setupSolutionsMenu(DominoElement<Element> element) {
        Element solutionsMenuElement = document.querySelector("[dui-site-section='solutions-menu']");

        if (nonNull(solutionsMenuElement)) {
            dui_hidden.remove(solutionsMenuElement);
            DominoElement<HTMLElement> anchorElement = element.querySelector("[dui-site-data='nav-anchor']");
            popover = Popover.create(Js.<HTMLElement>uncheckedCast(anchorElement.parent().element()))
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
                            Optional.ofNullable(document.getElementById("dui-site-left-menu"))
                                    .ifPresent(menu -> leftSideMenuOpenCss.apply(menu));
                            ElementUtil.scrollTop();
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
        Element contentContainer = document.getElementById("dui-content-container");
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

                                        if (anchorElement.hasAttribute("dui-side-menu-link")) {
                                            Optional.ofNullable(document.getElementById("dui-site-left-menu"))
                                                    .ifPresent(menu -> leftSideMenuOpenCss.apply(menu));
                                        }
                                        ElementUtil.scrollTop();
                                    }
                                });
                            });
                });

        NodeList<Element> codeBlocks = document.querySelectorAll("code:not(.dui-site-component-docs pre code)");
        codeBlocks.asList()
                .stream()
                .filter(element -> !element.hasAttribute("dui-processed"))
                .forEach(element -> {
                    element.setAttribute("dui-processed", "true");
                    elements.elementOf(element).setInnerHtml(PR.prettyPrintOne(element.textContent.replace("<", "&lt;").replace(">", "&gt;"), null, false));
                });

        NodeList<Element> mainMenuElements = document.querySelectorAll(".dui-site-docs-menu-item");
        mainMenuElements.asList()
                .stream()
                .filter(element -> !element.hasAttribute("dui-processed"))
                .forEach(element -> {
                    element.setAttribute("dui-processed", "true");
                    elements.elementOf(element).addClickListener(evt -> {
                        evt.stopPropagation();
                        Element subMenuElement = element.querySelector(".dui-site-docs-sub-menu");
                        if (nonNull(subMenuElement)) {
                            activeSubMenuCss.apply(subMenuElement);
                        }
                    });
                });

        Element clientPrev = document.getElementById("nav-client-prev");
        if (nonNull(clientPrev)) {
            elements.elementOf(clientPrev)
                    .addClickListener(evt -> {
                        prevCard();
                    });

        }

        Element clientNext = document.getElementById("nav-client-next");
        if (nonNull(clientNext)) {
            elements.elementOf(clientNext)
                    .addClickListener(evt -> {
                        nextCard();
                    });

        }

        document.querySelectorAll(".client-card")
                .asList()
                .forEach(element -> {
                    SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.RIGHT, Js.uncheckedCast(element), evt -> {
                        nextCard();
                    });
                });

        document.querySelectorAll(".client-card")
                .asList()
                .forEach(element -> {
                    SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.LEFT, Js.uncheckedCast(element), evt -> {
                        prevCard();
                    });
                });

        Optional.ofNullable(document.getElementById("dui-site-docs-left-menu-button"))
                .ifPresent(element -> {
                    elements.elementOf(element)
                            .applyIf(e -> !e.hasAttribute("dui-processed"), self -> {
                                self
                                        .setAttribute("dui-processed", true)
                                        .addClickListener(evt -> {
                                            evt.stopPropagation();
                                            evt.preventDefault();
                                            leftSideMenuOpenCss.apply(document.getElementById("dui-site-left-menu"));
                                        });
                            });
                });

        Optional.ofNullable(document.getElementById("dui-site-doc-page-side-nav-button"))
                .ifPresent(element -> {
                    elements.elementOf(element)
                            .applyIf(e -> !e.hasAttribute("dui-processed"), self -> {
                                self
                                        .setAttribute("dui-processed", true)
                                        .addClickListener(evt -> {
                                            evt.stopPropagation();
                                            evt.preventDefault();
                                            rightSideDocsMenuOpenCss.apply(document.getElementById("dui-site-doc-page-side-nav"));
                                        });
                            });
                });

        Optional<Element> openLeftMenuButton = Optional.ofNullable(document.getElementById("dui-site-docs-open-left-menu"));
        openLeftMenuButton.ifPresent(element -> {
            if(!element.hasAttribute("dui-processed")){
                element.addEventListener("click", evt -> {
                    evt.stopPropagation();
                    leftSideMenuOpenCss.apply(document.getElementById("dui-site-left-menu"));
                });
                element.setAttribute("dui-processed", true);
            }
        });
    }

    private static void prevCard() {
        NodeList<Element> clientCards = document.querySelectorAll(".client-card");
        clientCards.asList()
                .stream()
                .sorted(Comparator.comparingInt(left -> Integer.parseInt(left.getAttribute("dui-data-index"))))
                .forEach(element -> {
                    DominoElement<Element> clientCard = elements.elementOf(element);
                    int currentIndex = Integer.parseInt(clientCard.getAttribute("dui-data-index"));
                    if (currentIndex == 2) {
                        dui_active.remove(clientCard);
                    }
                    if (currentIndex == 0) {
                        clientCard.setAttribute("dui-data-index", "4");
                    } else {
                        int newIndex = currentIndex - 1;
                        clientCard.setAttribute("dui-data-index", newIndex);
                        if (newIndex == 2) {
                            activeClientCardCss.apply(clientCard);
                        }
                    }
                });
    }

    private static void nextCard() {
        NodeList<Element> clientCards = document.querySelectorAll(".client-card");
        clientCards.asList()
                .stream()
                .sorted(Comparator.comparingInt(left -> Integer.parseInt(left.getAttribute("dui-data-index"))))
                .forEach(element -> {
                    DominoElement<Element> clientCard = elements.elementOf(element);
                    int currentIndex = Integer.parseInt(clientCard.getAttribute("dui-data-index"));
                    if (currentIndex == 2) {
                        dui_active.remove(clientCard);
                    }
                    if (currentIndex == 4) {
                        clientCard.setAttribute("dui-data-index", "0");
                    } else {
                        int newIndex = currentIndex + 1;
                        clientCard.setAttribute("dui-data-index", newIndex);
                        if (newIndex == 2) {
                            activeClientCardCss.apply(clientCard);
                        }
                    }
                });
    }


    public static void enhancePadding() {
        Element menuElement = document.querySelector("#dui-site-left-menu-body");
        elements.body().addCss(BooleanCssClass.of(dui_site_menu_padded_content, nonNull(menuElement)));
        if (nonNull(menuElement)) {
            activateCurrentPageMenuItem(menuElement);

            Element searchElement = document.getElementById("dui-site-menu-search-box");
            DominoElement<Element> searchBox = elements.elementOf(searchElement);
            if (!searchBox.hasAttribute("dui-processed")) {
                HTMLInputElement searchInput = Js.uncheckedCast(searchElement);
                searchBox.setAttribute("dui-processed", true);
                DelayedTextInput.create(searchInput, 500, () -> {
                    NodeList<Element> menuItems = menuElement.querySelectorAll(".dui-site-docs-sub-menu-item");
                    String searchToken = searchInput.value;
                    if (nonNull(searchToken) && !searchToken.trim().isEmpty()) {
                        menuItems.asList().forEach(menuItem -> {
                            Element menuAnchor = menuItem.firstElementChild;
                            Element menuTextElement = menuAnchor.querySelector(".dui-site-menu-item-text");
                            if (menuTextElement.textContent.toLowerCase().contains(searchToken.toLowerCase())) {
                                elements.elementOf(menuItem).removeCss(dui_hidden);
                                if (menuAnchor.hasAttribute("dui-sub-menu-id")) {
                                    DominoElement<Element> subMenu = elements.elementOf(document.getElementById(menuAnchor.getAttribute("dui-sub-menu-id")));
                                    subMenu.removeCss(dui_hidden);
                                    elements.elementOf(menuItem.parentElement).addCss(dui_active);
                                }
                            } else {
                                elements.elementOf(menuItem).addCss(dui_hidden);
                            }
                        });
                    } else {
                        menuItems.asList().forEach(menuItem -> {
                                    Element menuAnchor = menuItem.firstElementChild;
                                    elements.elementOf(menuItem).removeCss(dui_hidden);
                                    if (menuAnchor.hasAttribute("dui-sub-menu-id")) {
                                        DominoElement<Element> subMenu = elements.elementOf(document.getElementById(menuAnchor.getAttribute("dui-sub-menu-id")));
                                        subMenu.removeCss(dui_hidden);
                                        elements.elementOf(menuItem.parentElement).removeCss(dui_active);
                                    }
                                }
                        );
                        activateCurrentPageMenuItem(menuElement);
                    }

                });
        }
    }

}

    private static void activateCurrentPageMenuItem(Element menuElement) {
        String path = ClientApp.make().getHistory().currentToken().path();
        Element activeAnchor = menuElement.querySelector("[href$='" + path + "']");
        if (nonNull(activeAnchor)) {
            menuActiveELementCss.apply(activeAnchor);
            String subMenuId = activeAnchor.getAttribute("dui-sub-menu-id");
            if (nonNull(subMenuId)) {
              Element subMenu = document.getElementById(subMenuId);
              if(nonNull(subMenu)) {
                Element siteDocsSubMenu = subMenu
                    .querySelector(".dui-site-docs-sub-menu");
                if(nonNull(siteDocsSubMenu)) {
                  activeSubMenuCss.apply(siteDocsSubMenu);
                }
              }
            }
        }
    }
}
