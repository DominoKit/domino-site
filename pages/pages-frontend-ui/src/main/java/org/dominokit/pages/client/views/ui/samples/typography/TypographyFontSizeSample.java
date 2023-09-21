package org.dominokit.pages.client.views.ui.samples.typography;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class TypographyFontSizeSample extends BaseDominoElement<HTMLDivElement, TypographyFontSizeSample> {

    private DivElement element;

    public static TypographyFontSizeSample create() {
        return new TypographyFontSizeSample();
    }

    public TypographyFontSizeSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("Font 0"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_0)))
                .appendChild(BlockHeader.create("Font px"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_px)))
                .appendChild(BlockHeader.create("Font 2px"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_2px)))
                .appendChild(BlockHeader.create("Font 4px"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_4px)))
                .appendChild(BlockHeader.create("Font 8px"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_8px)))
                .appendChild(BlockHeader.create("Font 0.5"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_0_5)))
                .appendChild(BlockHeader.create("Font 1"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_1)))
                .appendChild(BlockHeader.create("Font 1.5"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_1_5)))
                .appendChild(BlockHeader.create("Font 2"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_2)))
                .appendChild(BlockHeader.create("Font 2.5"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_2_5)))
                .appendChild(BlockHeader.create("Font 3"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_3)))
                .appendChild(BlockHeader.create("Font 3.5"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_3_5)))
                .appendChild(BlockHeader.create("Font 4"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_4)))
                .appendChild(BlockHeader.create("Font 5"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_5)))
                .appendChild(BlockHeader.create("Font 6"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_6)))
                .appendChild(BlockHeader.create("Font 7"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_7)))
                .appendChild(BlockHeader.create("Font 8"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_8)))
                .appendChild(BlockHeader.create("Font 9"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_9)))
                .appendChild(BlockHeader.create("Font 10"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_10)))
                .appendChild(BlockHeader.create("Font 11"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_11)))
                .appendChild(BlockHeader.create("Font 12"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_12)))
                .appendChild(BlockHeader.create("Font 14"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_14)))
                .appendChild(BlockHeader.create("Font 16"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.6").addCss(dui_font_size_16)))
                .appendChild(BlockHeader.create("Font 20"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_20)))
                .appendChild(BlockHeader.create("Font 24"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_24)))
                .appendChild(BlockHeader.create("Font 28"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_28)))
                .appendChild(BlockHeader.create("Font 32"))
                .appendChild(p().appendChild(b().textContent("font 32").addCss(dui_font_size_32)))
                .appendChild(BlockHeader.create("Font 36"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_36)))
                .appendChild(BlockHeader.create("Font 40"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_40)))
                .appendChild(BlockHeader.create("Font 44"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_44)))
                .appendChild(BlockHeader.create("Font 48"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_48)))
                .appendChild(BlockHeader.create("Font 52"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_52)))
                .appendChild(BlockHeader.create("Font 56"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_56)))
                .appendChild(BlockHeader.create("Font 60"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_60)))
                .appendChild(BlockHeader.create("Font 64"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_64)))
                .appendChild(BlockHeader.create("Font 72"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_72)))
                .appendChild(BlockHeader.create("Font 80"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_80)))
                .appendChild(BlockHeader.create("Font 96"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_96)))
                .appendChild(BlockHeader.create("Font 50%"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_1_2p)))
                .appendChild(BlockHeader.create("Font 33%"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_1_3p)))
                .appendChild(BlockHeader.create("Font 66%"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_2_3p)))
                .appendChild(BlockHeader.create("Font 25%"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_1_4p)))
                .appendChild(BlockHeader.create("Font 75%"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_3_4p)))
                .appendChild(BlockHeader.create("Font 100%"))
                .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_full)))
                ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
