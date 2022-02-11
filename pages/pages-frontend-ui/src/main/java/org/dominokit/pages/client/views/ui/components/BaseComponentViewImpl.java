package org.dominokit.pages.client.views.ui.components;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.view.BaseElementView;
import org.dominokit.pages.client.views.components.ComponentView;

import java.util.Optional;

import static java.util.Objects.nonNull;

public abstract class BaseComponentViewImpl extends BaseElementView<HTMLElement> implements ComponentView {

    private DominoElement<HTMLDivElement> root;

    @Override
    protected HTMLElement init() {
        root = DominoElement.div();
        return root.element();
    }

    @Override
    public void scrollTo(String section) {
        if (nonNull(section) && !section.isEmpty())
            getElementBySection(section)
                    .ifPresent(Element::scrollIntoView);
    }

    @Override
    public void appendContent(String content) {
        root.setInnerHtml(content);
    }

    protected Optional<Element> getElementBySection(String section) {
        return Optional.ofNullable(DomGlobal.document.querySelector("*[section=" + section + "]"));
    }

    @Override
    public void enhance() {
    }
}
