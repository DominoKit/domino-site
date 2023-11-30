package org.dominokit.pages.client.views.ui.samples.forms.input;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.PasswordBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class BasicFormsInputSample extends BaseDominoElement<HTMLDivElement, BasicFormsInputSample> {

    private DivElement element;

    public static BasicFormsInputSample create() {
        return new BasicFormsInputSample();
    }

    public BasicFormsInputSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("Basic Example"))
                .appendChild(Row.create()
                        .span12(TextBox.create().setLabel("User name")
                                .setPlaceholder("Username")
                        )
                )
                .appendChild(Row.create()
                        .span12(PasswordBox.create().setLabel("Password").setPlaceholder("Password"))
                )
                .appendChild(BlockHeader.create("Different Widths"))
                .appendChild(Row.create()
                        .span6(TextBox.create().setPlaceholder("col-sm-6"))
                        .span6(TextBox.create().setPlaceholder("col-sm-6"))
                )
                .appendChild(Row.create()
                        .span4(TextBox.create().setPlaceholder("col-sm-4"))
                        .span4(TextBox.create().setPlaceholder("col-sm-4"))
                        .span4(TextBox.create().setPlaceholder("col-sm-4"))
                )
                .appendChild(Row.create()
                        .span3(TextBox.create().setPlaceholder("col-sm-3"))
                        .span3(TextBox.create().setPlaceholder("col-sm-3"))
                        .span3(TextBox.create().setPlaceholder("col-sm-3"))
                        .span3(TextBox.create().setPlaceholder("col-sm-3"))
                )
                .appendChild(BlockHeader.create("Input Status"))
                .appendChild(Row.create()
                        .span4(TextBox.create("Focused").withValue("Focused"))
                        .span4(TextBox.create("Disabled")
                                        .withValue("disabled")
                                        .disable())
                        .span4(TextBox.create("Read only")
                                        .withValue("Sample value")
                                        .setReadOnly(true))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
