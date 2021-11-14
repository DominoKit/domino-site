package org.dominokit.pages.client.views.ui.components;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLPreElement;
import elemental2.dom.Response;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.views.ui.PR;
import org.jboss.elemento.Elements;

import static elemental2.dom.DomGlobal.fetch;

public class CodePreview extends BaseDominoElement<HTMLElement, CodePreview> {

    private final DominoElement<HTMLPreElement> root = DominoElement.of(Elements.pre()).addCss("component-code", "prettyprint");

    public static CodePreview create(String url) {
        return new CodePreview(url);
    }

    private CodePreview(String url) {
        fetch(url)
                .then(Response::text)
                .then(p0 -> {
                    root.setInnerHtml(PR.prettyPrintOne(p0, null, false));
                    return null;
                });
    }

    @Override
    public HTMLElement element() {
        return root.element();
    }
}
