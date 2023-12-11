package org.dominokit.pages.client.views.ui.samples.forms.decoration;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_error;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.PasswordBox;
import org.dominokit.domino.ui.forms.Radio;
import org.dominokit.domino.ui.forms.RadioGroup;
import org.dominokit.domino.ui.forms.TextAreaBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class FieldDecorationValidationSample extends BaseDominoElement<HTMLDivElement, FieldDecorationValidationSample> {

    private DivElement element;
    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    public static FieldDecorationValidationSample create() {
        return new FieldDecorationValidationSample();
    }

    public FieldDecorationValidationSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span12(TextBox.create("Name").groupBy(fieldsGrouping))
                )
                .appendChild(Row.create()
                        .span12(TextBox.create("Surename").groupBy(fieldsGrouping))
                )
                .appendChild(Row.create()
                        .span12(TextBox.create("Email").groupBy(fieldsGrouping))
                )
                .appendChild(Row.create()
                        .span12(RadioGroup.<String>create("gender", "Gender")
                                .appendChild(Radio.create("male", "Male"))
                                .appendChild(Radio.create("female", "Female"))
                                .horizontal()
                                .setShowRequiredIndicator(true)
                                .groupBy(fieldsGrouping)
                        )
                )
                .appendChild(Row.create()
                        .span12(TextAreaBox.create("Description").groupBy(fieldsGrouping))
                )
                .appendChild(Row.create()
                        .span12(PasswordBox.create("Password").groupBy(fieldsGrouping))
                )
                .appendChild(Row.create()
                        .span12(Select.<String>create("Language")
                                .appendChild(SelectOption.create("english", "English"))
                                .appendChild(SelectOption.create("france", "France"))
                                .appendChild(SelectOption.create("arabic", "Arabic"))
                                .groupBy(fieldsGrouping))
                )
                .appendChild(Row.create()
                        .span12(CheckBox.create("I have read and accept the terms").groupBy(fieldsGrouping))
                )
                .appendChild(Row.create()
                        .span12(Button.create("REGISTER")
                                .addCss(dui_accent)
                                .addClickListener(evt -> {
                                    ValidationResult validationResult = fieldsGrouping.validate();
                                    if (validationResult.isValid()) {
                                        fieldsGrouping.clear();
                                    } else {
                                        Notification.create("Error " + validationResult.getErrorMessage())
                                                .addCss(dui_error)
                                                .show();
                                    }
                                })
                        )
                );
        fieldsGrouping.setAutoValidation(true).setRequired(true);
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
