package org.dominokit.pages.client.views.ui;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.themes.*;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.pages.shared.service.LoadContentServiceFactory;
import static org.dominokit.domino.ui.utils.Domino.*;

public class DemoComponent<T extends IsElement<?>> extends BaseDominoElement<HTMLDivElement, DemoComponent<T>> {

    private final DivElement root;
    private final TabsPanel demoTabs;
    private final Tab sampleTab;
    private final Tab codeTab;
    private final Card demoCard;
    private final Card codeCard;
    private final DivElement sampleContent;
    private final DemoSample<T> demoSample;

    public static <T extends IsElement<Element>> DemoComponent<T> create(DemoSample<T> demoSample) {
        return new DemoComponent<>(demoSample);
    }

    public DemoComponent(DemoSample<T> demoSample) {
        this.demoSample = demoSample;
        codeCard = Card.create().addCss(dui_elevation_0);
        this.root = div().addCss(()->"dui-site-demo-component")
                .appendChild(demoTabs = TabsPanel.create()
                        .withTabsContent((parent, content) -> content.addCss(dui_p_0))
                        .appendChild(sampleTab = Tab.create(Icons.widgets(), "Demo")
                                .addCss(()-> "dui-site-demo-component-sample-tab")
                                .appendChild(demoCard = Card.create().addCss(dui_elevation_0)
                                        .withBody((card, body) -> body.addCss(dui_p_0))
                                        .appendChild(NavBar.create("Colors selectors")
                                                .addCss(dui_h_16, dui_m_x_0, dui_m_y_2, ()-> "dui-site-demo-component-colors-nav")
                                                .appendChild(PostfixAddOn.of(div()
                                                                .addCss(()->"dui-site-demo-component-colors-list")
                                                                .appendChild(themeDiv(dui_bg_red, DominoThemeAccent.RED))
                                                                .appendChild(themeDiv(dui_bg_pink, DominoThemeAccent.PINK))
                                                                .appendChild(themeDiv(dui_bg_purple, DominoThemeAccent.PURPLE))
                                                                .appendChild(themeDiv(dui_bg_deep_purple, DominoThemeAccent.DEEP_PURPLE))
                                                                .appendChild(themeDiv(dui_bg_indigo, DominoThemeAccent.INDIGO))
                                                                .appendChild(themeDiv(dui_bg_blue, DominoThemeAccent.BLUE))
                                                                .appendChild(themeDiv(dui_bg_light_blue, DominoThemeAccent.LIGHT_BLUE))
                                                                .appendChild(themeDiv(dui_bg_cyan, DominoThemeAccent.CYAN))
                                                                .appendChild(themeDiv(dui_bg_teal, DominoThemeAccent.TEAL))
                                                                .appendChild(themeDiv(dui_bg_green, DominoThemeAccent.GREEN))
                                                                .appendChild(themeDiv(dui_bg_light_green, DominoThemeAccent.LIGHT_GREEN))
                                                                .appendChild(themeDiv(dui_bg_lime, DominoThemeAccent.LIME))
                                                                .appendChild(themeDiv(dui_bg_yellow, DominoThemeAccent.YELLOW))
                                                                .appendChild(themeDiv(dui_bg_amber, DominoThemeAccent.AMBER))
                                                                .appendChild(themeDiv(dui_bg_orange, DominoThemeAccent.ORANGE))
                                                                .appendChild(themeDiv(dui_bg_deep_orange, DominoThemeAccent.DEEP_ORANGE))
                                                                .appendChild(themeDiv(dui_bg_brown, DominoThemeAccent.BROWN))
                                                                .appendChild(themeDiv(dui_bg_grey, DominoThemeAccent.GREY))
                                                                .appendChild(themeDiv(dui_bg_blue_grey, DominoThemeAccent.BLUE_GREY))
                                                        )
                                                )
                                                .appendChild(PostfixAddOn.of(Icons.theme_light_dark()
                                                                .clickable()
                                                                .addClickListener(evt -> {
                                                                    onDarkMode();
                                                                })
                                                        )
                                                )
                                        )
                                        .appendChild(sampleContent = div()
                                                .addCss("dui-theme-default")
                                                .addCss(dui_border, dui_border_solid, dui_border_teal_l_5, dui_bg_dominant, dui_ignore_fg)
                                                .appendChild(demoSample.getComponent().get()))
                                )
                        )
                        .appendChild(codeTab = Tab.create(Icons.code_braces(), "Source code")
                                .addCss(()-> "dui-site-demo-component-code-tab")
                                .apply(self -> {
                                    self.appendChild(codeCard
                                            .withBody((card, body) -> body
                                                    .addCss(dui_p_0)
                                            )
                                    );
                                    self.addActivationHandler((tab, active) -> {
                                        LoadContentServiceFactory.INSTANCE
                                                .getSourceCode(demoSample.getSampleClass().getCanonicalName())
                                                .onSuccess(code -> {
                                                    codeCard.appendChild(DemoCode.create(code));
                                                })
                                                .onFailed(failedResponseBean -> {
                                                    codeCard.appendChild(DemoCode.create("Failed to load code."));
                                                })
                                                .send();
                                    });
                                })

                        )
                )
        ;
        init(this);
        demoSample.onRender(this);
        ElementThemeManager.INSTANCE.apply(DominoThemeAccent.TEAL, sampleContent);
    }

    private DivElement themeDiv(CssClass bg, IsDominoTheme theme) {
        return div()
                .addCss(bg, dui_w_4, dui_h_4, dui_cursor_pointer, dui_border, dui_border_solid, dui_border_white)
                .addClickListener(evt -> {
                    ElementThemeManager.INSTANCE.apply(theme, sampleContent);
                });
    }

    private void onDarkMode() {
        if (DominoThemeDark.INSTANCE.isApplied(sampleContent)) {
            ElementThemeManager.INSTANCE.apply(DominoThemeLight.INSTANCE, sampleContent);
        } else {
            ElementThemeManager.INSTANCE.apply(DominoThemeDark.INSTANCE, sampleContent);
        }
    }

    public DemoComponent<T> withSampleTab(ChildHandler<DemoComponent<T>, Tab> handler) {
        handler.apply(this, sampleTab);
        return this;
    }

    public DemoComponent<T> withCodeTab(ChildHandler<DemoComponent<T>, Tab> handler) {
        handler.apply(this, codeTab);
        return this;
    }

    public DemoComponent<T> withSampleCard(ChildHandler<DemoComponent<T>, Card> handler) {
        handler.apply(this, demoCard);
        return this;
    }

    public DemoComponent<T> withCodeCard(ChildHandler<DemoComponent<T>, Card> handler) {
        handler.apply(this, codeCard);
        return this;
    }

    public DemoComponent<T> withDemoTabs(ChildHandler<DemoComponent<T>, TabsPanel> handler) {
        handler.apply(this, demoTabs);
        return this;
    }

    public DemoComponent<T> withSampleContainer(ChildHandler<DemoComponent<T>, DivElement> handler) {
        handler.apply(this, sampleContent);
        return this;
    }

    public DemoComponent<T> withDemoSample(ChildHandler<DemoComponent<T>, DemoSample<T>> handler) {
        handler.apply(this, this.demoSample);
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}