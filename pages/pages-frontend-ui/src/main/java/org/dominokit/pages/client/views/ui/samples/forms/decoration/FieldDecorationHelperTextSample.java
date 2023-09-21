package org.dominokit.pages.client.views.ui.samples.forms.decoration;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class FieldDecorationHelperTextSample extends BaseDominoElement<HTMLDivElement, FieldDecorationHelperTextSample> {

    private DivElement element;

    public static FieldDecorationHelperTextSample create() {
        return new FieldDecorationHelperTextSample();
    }

    public FieldDecorationHelperTextSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("Text Box"))
                .appendChild(TextBox.create("Task Name")
                        .setHelperText("Each task should have unique name."))
                .appendChild(br())
                .appendChild(BlockHeader.create("Text Area"))
                .appendChild(TextAreaBox.create("Description").setHelperText("Less than 100 words"))
                .appendChild(br())
                .appendChild(BlockHeader.create("Select"))
                .appendChild(Select.<String>create("Task type")
                        .appendChild(SelectOption.create("-- Select a type --", "-- Select a type --"))
                        .appendChild(SelectOption.create("Story", "Story"))
                        .appendChild(SelectOption.create("Bugfix", "Bugfix"))
                        .appendChild(SelectOption.create("Hotfix", "Hotfix"))
                        .setHelperText("Helps with tracking the issues"))
                .appendChild(br())
                .appendChild(BlockHeader.create("Checkbox"))
                .appendChild(CheckBox.create("I want to receive an news about this task")
                        .setHelperText("news will be sent via email"))
                .appendChild(br())
                .appendChild(BlockHeader.create("Radio"))
                .appendChild(RadioGroup.<String>create("estimation", "Estimation")
                        .appendChild(Radio.create("storyPoint", "Story points"))
                        .appendChild(Radio.create("hours", "Effective hours"))
                        .horizontal()
                        .setHelperText("Helps with sprint reports")
                )
                .appendChild(br())
                .appendChild(BlockHeader.create("Switch"))
                .appendChild(SwitchButton.create().setOffTitle("Notifications: ")
                        .setHelperText("Notifications will be sent via the system"))
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
