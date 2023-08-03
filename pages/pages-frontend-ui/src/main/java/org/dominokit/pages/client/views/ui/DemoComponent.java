package org.dominokit.pages.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

public class DemoComponent extends BaseDominoElement<HTMLDivElement, DemoComponent> {

    private final DivElement root;
    private final TabsPanel demoTabs;
    private final Tab sampleTab;
    private final Tab codeTab;
    private final Card demoCard;
    private final Card codeCard;

    public static DemoComponent create(DemoSample demoSample) {
        return new DemoComponent(demoSample);
    }

    public DemoComponent(DemoSample demoSample) {
        this.root = div()
                .appendChild(demoTabs = TabsPanel.create()
                        .withTabsContent((parent, content) -> content.addCss(dui_p_0))
                        .appendChild(sampleTab = Tab.create(Icons.widgets(), "Demo")
                                .appendChild(demoCard = Card.create().addCss(dui_elevation_0)
                                        .appendChild(demoSample.getComponent().get())
                                )
                        )
                        .appendChild(codeTab = Tab.create(Icons.code_braces(), "Source code")
                                .appendChild(codeCard = Card.create().addCss(dui_elevation_0)

                                ))
                )
        ;
        init(this);
        demoSample.onRender(this);
    }

    public DemoComponent withSampleTab(ChildHandler<DemoComponent, Tab> handler){
        handler.apply(this, sampleTab);
        return this;
    }

    public DemoComponent withCodeTab(ChildHandler<DemoComponent, Tab> handler){
        handler.apply(this, codeTab);
        return this;
    }

    public DemoComponent withSampleCard(ChildHandler<DemoComponent, Card> handler){
        handler.apply(this, demoCard);
        return this;
    }

    public DemoComponent withCodeCard(ChildHandler<DemoComponent, Card> handler){
        handler.apply(this, codeCard);
        return this;
    }

    public DemoComponent withDemoTabs(ChildHandler<DemoComponent, TabsPanel> handler){
        handler.apply(this, demoTabs);
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}