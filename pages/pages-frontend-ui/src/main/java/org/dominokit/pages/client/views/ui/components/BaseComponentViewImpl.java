package org.dominokit.pages.client.views.ui.components;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.view.BaseElementView;
import org.dominokit.pages.client.views.components.ComponentView;
import org.dominokit.pages.client.views.ui.NavigableViewImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;

public abstract class BaseComponentViewImpl extends NavigableViewImpl<HTMLElement> implements ComponentView {

    private DominoElement<HTMLDivElement> root;

    @Override
    protected void initRoot(HTMLElement root) {
        if (Objects.nonNull(root)) {
            ElementUtil.onAttach(root, (mutationRecord) -> {
                this.revealHandler.onRevealed();
            });
            ElementUtil.onDetach(root, (mutationRecord) -> {
                this.removeHandler.onRemoved();
                this.clear();
            });
        }
    }

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
        enhanceLinks();
    }

}
