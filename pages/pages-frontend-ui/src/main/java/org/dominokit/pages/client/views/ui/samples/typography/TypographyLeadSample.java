package org.dominokit.pages.client.views.ui.samples.typography;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class TypographyLeadSample extends BaseDominoElement<HTMLDivElement, TypographyLeadSample> {

    public static final String LARGE_PARAGRAPH = "Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget";
    private DivElement element;

    public static TypographyLeadSample create() {
        return new TypographyLeadSample();
    }

    public TypographyLeadSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("Leading none"))
                .appendChild(p().addCss(dui_leading_none).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading tight"))
                .appendChild(p().addCss(dui_leading_tight).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading snug"))
                .appendChild(p().addCss(dui_leading_snug).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading normal"))
                .appendChild(p().addCss(dui_leading_normal).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading relaxed"))
                .appendChild(p().addCss(dui_leading_relaxed).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading loose"))
                .appendChild(p().addCss(dui_leading_loose).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 3"))
                .appendChild(p().addCss(dui_leading_3).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 4"))
                .appendChild(p().addCss(dui_leading_4).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 5"))
                .appendChild(p().addCss(dui_leading_5).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 6"))
                .appendChild(p().addCss(dui_leading_6).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 7"))
                .appendChild(p().addCss(dui_leading_7).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 8"))
                .appendChild(p().addCss(dui_leading_8).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 9"))
                .appendChild(p().addCss(dui_leading_9).textContent(LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 10"))
                .appendChild(p().addCss(dui_leading_10).textContent(LARGE_PARAGRAPH));
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
