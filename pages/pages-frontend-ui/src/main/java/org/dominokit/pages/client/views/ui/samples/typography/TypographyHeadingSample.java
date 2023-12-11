package org.dominokit.pages.client.views.ui.samples.typography;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class TypographyHeadingSample extends BaseDominoElement<HTMLDivElement, TypographyHeadingSample> {

    public static final String SAMPLE_TEXT = "In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.";
    private DivElement element;

    public static TypographyHeadingSample create() {
        return new TypographyHeadingSample();
    }

    public TypographyHeadingSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(h(1).textContent("h1. Text Heading."))
                .appendChild(p(SAMPLE_TEXT))
                .appendChild(h(2).textContent("h2. Text Heading."))
                .appendChild(p(SAMPLE_TEXT))
                .appendChild(h(3).textContent("h3. Text Heading."))
                .appendChild(p(SAMPLE_TEXT))
                .appendChild(h(4).textContent("h4. Text Heading."))
                .appendChild(p(SAMPLE_TEXT))
                .appendChild(h(5).textContent("h5. Text Heading."))
                .appendChild(p(SAMPLE_TEXT))
                .appendChild(h(6).textContent("h6. Text Heading."))
                .appendChild(p(SAMPLE_TEXT));
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
