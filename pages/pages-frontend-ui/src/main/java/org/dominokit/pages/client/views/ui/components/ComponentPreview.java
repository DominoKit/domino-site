package org.dominokit.pages.client.views.ui.components;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLPreElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.views.ui.PR;
import org.jboss.elemento.Elements;
import org.jboss.elemento.IsElement;

public class ComponentPreview extends BaseDominoElement<HTMLElement, ComponentPreview> {

    private final DominoElement<HTMLDivElement> root = DominoElement.div().css("component-preview");
    private final DominoElement<HTMLPreElement> codeRoot = DominoElement.of(Elements.pre()).addCss("component-code", "prettyprint");
    private final DominoElement<HTMLDivElement> componentContent = DominoElement.div().css("component-container");

    public static ComponentPreview create() {
        return new ComponentPreview();
    }

    private ComponentPreview() {
        root
                .appendChild(componentContent);
    }

    @Override
    public ComponentPreview appendChild(IsElement<?> isElement) {
        return appendChild(isElement.element());
    }

    @Override
    public ComponentPreview appendChild(Node node) {
        componentContent.appendChild(node);
        return this;
    }

    public void setCode(String code) {
        codeRoot.setInnerHtml(PR.prettyPrintOne(code, null, false));
    }

    @Override
    public HTMLElement element() {
        return root.element();
    }
}
