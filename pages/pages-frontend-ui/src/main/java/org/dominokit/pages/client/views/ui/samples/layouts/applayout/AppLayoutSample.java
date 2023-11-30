package org.dominokit.pages.client.views.ui.samples.layouts.applayout;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.AppLayout;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import static org.dominokit.domino.ui.utils.Domino.*;

public class AppLayoutSample extends BaseDominoElement<HTMLDivElement, AppLayoutSample> {

    private AppLayout appLayout;

    public static AppLayoutSample create(){
        return new AppLayoutSample();
    }

    public AppLayoutSample() {
        this.appLayout = AppLayout.create("Layout demo")
                .addCss(dui_border, dui_border_solid, dui_border_accent)
                .withLeftDrawer()
                .withRightDrawer()
                .withNavBar()
                .withFooter()
                .setLeftDrawerSpanUp(true)
                .setLeftDrawerSpanDown(true)
                .setShrinkContent(true)
                .setAutoCloseLeftDrawer(true)
                .withRightDrawer((layout, drawer) -> {
                    drawer.appendChild(NavBar.create("Right drawer")
                            .addCss(dui_h_14, dui_border_b, dui_border_solid, dui_border_accent)
                            .appendChild(PostfixAddOn.of(Icons.close()
                                    .clickable()
                                    .addClickListener(evt -> layout.hideRightDrawer())
                            ))
                    );
                })
                .withNavBar((layout, nav) -> {
                    nav
                            .appendChild(PostfixAddOn.of(TextBox.create()
                                    .apply(self -> self.labelElement().remove())
                                    .addCss(dui_w_56)
                                    .withWrapper((parent, self) -> self.addCss(dui_bg_white, dui_fg_grey))
                                    .appendChild(PostfixAddOn.of(Icons.magnify()))
                            ))
                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                            .clickable()
                                            .setDropMenu(Menu.<String>create()
                                                    .appendChild(MenuItem.create("Action 1"))
                                                    .appendChild(MenuItem.create("Action 2"))
                                                    .appendChild(MenuItem.create("Action 3"))
                                            )
                                    )
                            )
                            .appendChild(PrefixAddOn.of(Icons.dots_vertical()
                                            .clickable()
                                            .setDropMenu(Menu.<String>create()
                                                    .appendChild(MenuItem.create("Action 1"))
                                                    .appendChild(MenuItem.create("Action 2"))
                                                    .appendChild(MenuItem.create("Action 3"))
                                            )
                                    )
                            )
                    ;
                })
                .withContent((layout, content) -> {
                    content
                            .appendChild(Card.create()
                                    .setCollapsible(true)
                                    .appendChild(div()
                                            .addCss(dui_flex, dui_gap_2, dui_flex_wrap)
                                            .appendChild(Button.create("Toggle left")
                                                    .addClickListener(evt -> layout.toggleLeftDrawer()))
                                            .appendChild(Button.create("Open left")
                                                    .addClickListener(evt -> layout.showLeftDrawer()))
                                            .appendChild(Button.create("Close left")
                                                    .addClickListener(evt -> layout.hideLeftDrawer()))
                                            .appendChild(Button.create("Toggle right")
                                                    .addClickListener(evt -> layout.toggleRightDrawer()))
                                            .appendChild(Button.create("Open right")
                                                    .addClickListener(evt -> layout.showRightDrawer()))
                                            .appendChild(Button.create("Close right")
                                                    .addClickListener(evt -> layout.hideRightDrawer()))
                                            .appendChild(Button.create("Span left up")
                                                    .addClickListener(evt -> layout.setLeftDrawerSpanUp(true)))
                                            .appendChild(Button.create("Un-span left up")
                                                    .addClickListener(evt -> layout.setLeftDrawerSpanUp(false)))
                                            .appendChild(Button.create("Span left down")
                                                    .addClickListener(evt -> layout.setLeftDrawerSpanDown(true)))
                                            .appendChild(Button.create("Un-span left down")
                                                    .addClickListener(evt -> layout.setLeftDrawerSpanDown(false)))
                                            .appendChild(Button.create("Shrink content")
                                                    .addClickListener(evt -> layout.setShrinkContent(true)))
                                            .appendChild(Button.create("Un-Shrink content")
                                                    .addClickListener(evt -> layout.setShrinkContent(false)))
                                            .appendChild(Button.create("toggle Shrink content")
                                                    .addClickListener(evt -> layout.toggleShrinkContent()))
                                            .appendChild(Button.create("Fixed footer")
                                                    .addClickListener(evt -> layout.setFixedFooter(true)))
                                            .appendChild(Button.create("Un-Fix footer")
                                                    .addClickListener(evt -> layout.setFixedFooter(false)))
                                            .appendChild(Button.create("Toggle Fix footer")
                                                    .addClickListener(evt -> layout.toggleFixedFooter()))
                                            .appendChild(Button.create("Fixe left drawer(true)")
                                                    .addClickListener(evt -> layout.setFixLeftDrawer(true)))
                                            .appendChild(Button.create("Fixe left drawer(false)")
                                                    .addClickListener(evt -> layout.setFixLeftDrawer(false)))
                                            .appendChild(Button.create("Auto close left(true)")
                                                    .addClickListener(evt -> layout.setAutoCloseLeftDrawer(true)))
                                            .appendChild(Button.create("Auto close left(false)")
                                                    .addClickListener(evt -> layout.setAutoCloseLeftDrawer(false)))
                                            .appendChild(Button.create("Auto close right(true)")
                                                    .addClickListener(evt -> layout.setAutoCloseRightDrawer(true)))
                                            .appendChild(Button.create("Auto close right(false)")
                                                    .addClickListener(evt -> layout.setAutoCloseRightDrawer(false)))

                                    )
                            )
                            .appendChild(div().addCss(dui_flex, dui_flex_wrap, dui_justify_between)
                                    .apply(self -> {
                                        for (int i = 0; i < 100; i++) {
                                            self.appendChild(div().addCss(dui_w_24, dui_h_24, dui_bg_dominant_d_4, dui_m_2));
                                        }
                                    })
                            );
                });
        init(this);

    }

    @Override
    public HTMLDivElement element() {
        return appLayout.element();
    }
}
