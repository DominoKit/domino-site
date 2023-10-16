package org.dominokit.pages.client.views.ui.samples.forms.input;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.PasswordBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.UploadBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class UploadBoxSample extends BaseDominoElement<HTMLDivElement, UploadBoxSample> {

    private DivElement element;

    public static UploadBoxSample create() {
        return new UploadBoxSample();
    }

    public UploadBoxSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span6(UploadBox.create("Single upload"))
                        .span6(UploadBox.create("Multi upload").setMultiple(true))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
