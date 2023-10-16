package org.dominokit.pages.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.view.BaseNoContentView;
import org.dominokit.domino.view.slots.ElementIdSlot;
import org.dominokit.pages.client.presenters.PagesProxy;
import org.dominokit.pages.client.views.PagesView;

import java.util.function.Consumer;

import static java.util.Objects.nonNull;


@UiView(presentable = PagesProxy.class)
public class PagesViewImpl extends BaseNoContentView implements PagesView, DominoCss {

    private PagesUiHandlers uiHandlers;

    @Override
    public void setUiHandlers(PagesUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }

    @Override
    public void enhance(Consumer<Void> handler) {
        DomGlobal.setTimeout(p0 -> {
            NavigationEnhancer.enhance();
            NavigationEnhancer.enhanceContent();
            NavigationEnhancer.enhancePadding();
            registerSlots();
            handler.accept(null);
        });
    }

    @Override
    public void enhanceContent() {
        DomGlobal.setTimeout(p0 -> {
            NavigationEnhancer.enhanceContent();
        });
    }

    @Override
    public void updateContent(String content) {

    }

    @Override
    public void replaceContent(String content, String targetElementId) {
        Element mainBody = DomGlobal.document.getElementById(targetElementId);
        elementOf(mainBody).setInnerHtml(content);
        DomGlobal.setTimeout(p0 -> {
            enhanceContent();
        }, 0);
    }

    @Override
    public void enhancePadding() {
        DomGlobal.setTimeout(p0 -> {
            NavigationEnhancer.enhancePadding();
        });
    }

    @Override
    public void registerSlots() {
        if(nonNull(DomGlobal.document.getElementById("dui-demo-sample-slot"))) {
            ClientApp.make().slotsManager().removeSlot("dui-demo-sample-slot");
            ClientApp.make().slotsManager().registerSlot("dui-demo-sample-slot", ElementIdSlot.of("dui-demo-sample-slot"));
        }
    }

    @Override
    protected Void init() {
        return null;
    }
}