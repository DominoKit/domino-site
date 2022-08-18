package org.dominokit.pages.client.views.ui;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.dominokit.pages.client.views.SiteView;
import org.jboss.elemento.Elements;
import org.jboss.elemento.HtmlContentBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.em;
import static org.dominokit.domino.ui.style.Unit.px;

public abstract class SiteViewImpl extends NavigableViewImpl<FakeElement> implements SiteView {

    private EventListener hideListener;

    protected void initRoot(FakeElement root) {
    }

    protected FakeElement init() {
        return new FakeElement((attached) -> {
            if (attached) {
                this.revealHandler.onRevealed();
            } else {
                this.removeHandler.onRemoved();
            }
        }, getClass().getName());
    }

    private void enhanceMenuPosition() {
        for (HTMLElement solutionsLink : getElements("a[d-link=\"solutions\"]")) {
            Optional.ofNullable(solutionsLink).map(DominoElement::of).ifPresent(element -> {
                element.addClickListener(evt -> {
                    evt.preventDefault();
                    evt.stopPropagation();

                    DOMRect parentTargetRect = solutionsLink.parentElement.getBoundingClientRect();
                    DOMRect targetRect = solutionsLink.getBoundingClientRect();
                    HTMLElement menu = getElement(".dk-c-solutions-menu");

                    menu.style.setProperty("top", em.of((parentTargetRect.bottom + window.pageYOffset) / 16));
                    menu.style.setProperty("left", em.of(((targetRect.left + window.pageXOffset - (130 - (targetRect.width / 2)))) / 16));
                    DominoElement.of(menu).style().addCss("dk-u-fade-in");
                    if(nonNull(hideListener)){
                        window.removeEventListener("click", hideListener);
                    }
                    hideListener = evt1 -> DominoElement.of(menu).style().removeCss("dk-u-fade-in");
                    window.addEventListener("click", hideListener);
                    window.addEventListener("resize", hideListener);
                    document.addEventListener("scroll", hideListener);
                });
            });
        }

        HTMLElement mobileNav = getElement("div[class=\"dk-c-mobile-nav\"]");
        Optional.ofNullable(mobileNav).ifPresent(htmlElement -> {
            EventListener eventListener = evt1 -> {
                if (htmlElement.classList.contains("open")) {
                    htmlElement.classList.remove("open");
                } else {
                    htmlElement.classList.add("open");
                }
            };
            htmlElement.addEventListener("click", eventListener);
            htmlElement.addEventListener("touch", eventListener);
        });
    }

    protected List<HTMLElement> getElements(String selector) {
        return document.querySelectorAll(selector).asList().stream().map(element -> (HTMLElement) element)
                .collect(Collectors.toList());
    }

    protected HTMLElement getElement(String selector) {
        return Js.uncheckedCast(document.querySelector(selector));
    }

    @Override
    public void updateRootContent(String content) {
        DominoElement.of(getElement("#root")).clearElement().setInnerHtml(content);
        window.scrollTo(0, 0);
    }

    @Override
    public void setPageTitle(String pageTitle) {
        document.title = "DominoKit - " + pageTitle;
    }

    @Override
    public void enhance() {
        enhanceLinks();
        enhanceMenuPosition();
        extraEnhancement();

        FlexLayout employeeFlexLayout = FlexLayout.create();
        HtmlContentBuilder<HTMLAnchorElement> href = Elements.a("");
        href.add(employeeFlexLayout);
        FlexLayout employeesFlexLayout = FlexLayout.create();
        employeesFlexLayout.appendChild(href);
        for (Node node : employeesFlexLayout.childNodes().asList()) {
            DomGlobal.console.log(node);
        }

        DomGlobal.console.log("DEBUG: employeesFlexLayout.childNodes() raw output is " + employeesFlexLayout.childNodes());
        DomGlobal.console.log("DEBUG: employeesFlexLayout.childNodes().length is " + employeesFlexLayout.childNodes().length);

        List<Node> nodes = employeesFlexLayout.childNodes().asList();
        DomGlobal.console.log("DEBUG: employeesFlexLayout.childNodes().asList() passed");

        DomGlobal.console.log("DEBUG: nodes list has the following items:\n" + nodes.stream().map(n -> n.getClass().getName()).collect(Collectors.joining(", ")));
    }

    protected void extraEnhancement() {

    }
}
