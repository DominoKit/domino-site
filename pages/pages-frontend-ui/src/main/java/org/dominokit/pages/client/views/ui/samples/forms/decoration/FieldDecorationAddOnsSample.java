package org.dominokit.pages.client.views.ui.samples.forms.decoration;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.PasswordBox;
import org.dominokit.domino.ui.forms.TextAreaBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class FieldDecorationAddOnsSample extends BaseDominoElement<HTMLDivElement, FieldDecorationAddOnsSample> {

    private DivElement element;

    public static FieldDecorationAddOnsSample create() {
        return new FieldDecorationAddOnsSample();
    }

    public FieldDecorationAddOnsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(TextBox.create("Username")
                        .appendChild(PrefixAddOn.of(Icons.account_circle()))
                        .apply(self -> {
                            self.appendChild(PostfixAddOn.of(Icons.close_circle()
                                    .clickable()
                                    .addClickListener(evt -> self.clear())));
                        }))
                .appendChild(PasswordBox.create("Password")
                        .appendChild(PrefixAddOn.of(Icons.shield()))
                        .apply(self1 -> self1
                                .appendChild(PostfixAddOn.of(Icons.eye_off()
                                                .clickable()
                                                .addEventListener("mousedown", evt1 -> self1.getInputElement().element().type = "text")
                                                .addEventListener("mouseup", evt1 -> self1.getInputElement().element().type = "password")
                                        )
                                )))
                .appendChild(TextAreaBox.create("Description")
                        .appendChild(PrefixAddOn.of(Icons.note()))
                        .appendChild(PostfixAddOn.of(Icons.text()))
                )
                .appendChild(Select.<String>create("Language")
                        .appendChild(PrefixAddOn.of(Icons.earth()))
                        .appendChild(PostfixAddOn.of(Icons.information()
                                .setTooltip("All system pages will be shown in the selected language", DropDirection.BEST_SIDE_UP_DOWN)
                        ))
                        .appendChild(SelectOption.create("english", "English"))
                        .appendChild(SelectOption.create("france", "France"))
                        .appendChild(SelectOption.create("arabic", "Arabic"))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
