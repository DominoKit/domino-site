package org.dominokit.pages.client.views.ui;

import elemental2.dom.Element;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.NodeList;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.mvp.view.BaseDominoView;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.views.NavigableUiHandlers;
import org.dominokit.pages.client.views.NavigableView;

import java.util.HashMap;
import java.util.Map;

import static elemental2.dom.DomGlobal.document;

public abstract class NavigableViewImpl<T> extends BaseDominoView<T> implements NavigableView {

    private final Map<String, EventListener> clickListeners = new HashMap<>();
    private NavigableUiHandlers uiHandlers;

    protected void enhanceLinks() {
        NodeList<Element> elements = document.querySelectorAll("a[d-link]");
        elements.asList().forEach(element -> {
            DominoElement.of(Js.<HTMLElement>uncheckedCast(element)).apply(self -> {
                String dLink = self.getAttribute("d-link");
                if (!"solutions".equalsIgnoreCase(dLink)) {
                    if (clickListeners.containsKey(self.getDominoId())) {
                        self.removeEventListener("click", clickListeners.get(self.getDominoId()));
                        clickListeners.remove(self.getDominoId());
                    }
                    EventListener clickListener = evt -> {
                        evt.preventDefault();
                        evt.stopPropagation();
                        uiHandlers.navigateTo(dLink);
                    };
                    self.addClickListener(clickListener);
                    clickListeners.put(self.getDominoId(), clickListener);
                }
            });
        });
    }

    @Override
    public void setUiHandlers(NavigableUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }
}
