package org.dominokit.pages.client.views.ui.samples.layouts.split;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent_l_2;
import static org.dominokit.domino.ui.utils.Domino.dui_h_96;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;
import static org.dominokit.domino.ui.utils.Domino.hr;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.splitpanel.HSplitPanel;
import org.dominokit.domino.ui.splitpanel.SplitPanel;
import org.dominokit.domino.ui.splitpanel.VSplitPanel;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class SplitPanelMultiple extends BaseDominoElement<HTMLDivElement, SplitPanelMultiple> {

    private final DivElement element;
    private final CssClass demo_split_div = () -> "demo-split-div";

    public static SplitPanelMultiple create() {
        return new SplitPanelMultiple();
    }

    public SplitPanelMultiple() {
        this.element = div()
                .appendChild(HSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setWidth("20%")
                                .appendChild(div()
                                        .addCss(demo_split_div, dui_bg_accent_l_2)))
                        .appendChild(SplitPanel.create()
                                .setWidth("50%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_d_2)))
                        .appendChild(SplitPanel.create()
                                .setWidth("30%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                        .addCss(dui_h_96, dui_w_full)
                )
                .appendChild(hr())
                .appendChild(VSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setHeight("20%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                        .appendChild(SplitPanel.create()
                                .setHeight("50%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_d_2)))
                        .appendChild(SplitPanel.create()
                                .setHeight("30%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                        .addCss(dui_h_96, dui_w_full)
                );

        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
