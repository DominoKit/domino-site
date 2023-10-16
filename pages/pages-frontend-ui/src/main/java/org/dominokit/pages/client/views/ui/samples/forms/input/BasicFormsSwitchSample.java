package org.dominokit.pages.client.views.ui.samples.forms.input;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BasicFormsSwitchSample extends BaseDominoElement<HTMLDivElement, BasicFormsSwitchSample> {

    private DivElement element;

    public static BasicFormsSwitchSample create() {
        return new BasicFormsSwitchSample();
    }

    public BasicFormsSwitchSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(h(5).textContent("Basic Examples").style("margin-bottom: 25px;"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON"))
                        )
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON")
                                        .disable())
                        )
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON")
                                        .check()
                                        .disable())
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON")
                                        .setReadOnly(true)
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON")
                                        .disable())
                        )
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON")
                                        .check()
                                        .disable())
                        )
                )
                .appendChild(h(5).textContent("With Material Design Colors"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create().setOffTitle("ACCENT").check()))
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create().setOffTitle("RED").addCss(dui_accent_red).check()))
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create().setOffTitle("AMBER").addCss(dui_accent_amber).check()))
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create().setOffTitle("INDIGO").addCss(dui_accent_teal).check()))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
