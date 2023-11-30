package org.dominokit.pages.client.views.ui.samples.components.dialogs;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.AbstractDialog;
import org.dominokit.domino.ui.dialogs.AlertMessageDialog;
import org.dominokit.domino.ui.dialogs.MessageDialog;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import static org.dominokit.domino.ui.utils.Domino.*;

public class BasicDialogsSample extends BaseDominoElement<HTMLDivElement, BasicDialogsSample> {

    private DivElement element;

    public static BasicDialogsSample create() {
        return new BasicDialogsSample();
    }

    public BasicDialogsSample() {
        this.element = div().addCss(dui_p_2);
        MessageDialog basicMessage = MessageDialog.create()
                .setMessage("You have just opened a message dialog.")
                .onConfirm(AbstractDialog::close);

        MessageDialog basicWithHeaderMessage = MessageDialog.create()
                .setTitle("Message title")
                .setMessage("You have just opened a message dialog.")
                .onConfirm(AbstractDialog::close);

        AlertMessageDialog successMessage = AlertMessageDialog.create()
                .setTitle("Operation completed")
                .setIconAnimationDuration(500)
                .setIconStartTransition(Transition.ROTATE_IN)
                .setIconEndTransition(Transition.PULSE)
                .setAlertIcon(Icons.check_circle().addCss(dui_fg_green, dui_font_size_32))
                .setMessage("You have just opened a message dialog.")
                .onConfirm(AbstractDialog::close);

        AlertMessageDialog errorMessage = AlertMessageDialog.create()
                .setTitle("Operation failed!")
                .setIconAnimationDuration(500)
                .setIconStartTransition(Transition.SHAKE)
                .setIconEndTransition(Transition.TADA)
                .setAlertIcon(Icons.alert_circle().addCss(dui_fg_error, dui_font_size_32))
                .setMessage("You have just opened a message dialog.")
                .onConfirm(AbstractDialog::close);

        AlertMessageDialog warningMessage = AlertMessageDialog.create()
                .setTitle("Attention required!")
                .setIconAnimationDuration(500)
                .setIconStartTransition(Transition.PULSE)
                .setIconEndTransition(Transition.FLASH)
                .setAlertIcon(Icons.alert_circle().addCss(dui_fg_warning, dui_font_size_32))
                .setMessage("You have just opened a message dialog.")
                .onConfirm(AbstractDialog::close);

        AlertMessageDialog infoMessage = AlertMessageDialog.create()
                .setTitle("Got an idea?")
                .setIconAnimationDuration(500)
                .setIconStartTransition(Transition.FLASH)
                .setIconEndTransition(Transition.PULSE)
                .setAlertIcon(Icons.lightbulb_on_outline().addCss(dui_fg_info, dui_font_size_32))
                .setMessage("You have just opened a message dialog.")
                .onConfirm(AbstractDialog::close);

        AlertMessageDialog customColorsMessage = AlertMessageDialog.create()
                .addCss(dui_teal)
                .setTitle("Got an idea?")
                .setIconAnimationDuration(500)
                .setIconStartTransition(Transition.FLASH)
                .setIconEndTransition(Transition.PULSE)
                .setAlertIcon(Icons.lightbulb_on_outline().addCss(dui_font_size_32))
                .setMessage("You have just opened a message dialog.")
                .withConfirmButton((parent, button) -> button.addCss(dui_bg_teal_d_2))
                .onConfirm(AbstractDialog::close);

        AlertMessageDialog customContentMessage = AlertMessageDialog.create()
                .withHeader((dialog, header) -> {
                    header
                            .addCss(dui_orange)
                            .appendChild(NavBar.create("Custom header")
                                    .addCss(dui_h_8)
                                    .appendChild(PostfixAddOn.of(Icons.close_circle()
                                                    .clickable()
                                                    .addClickListener(evt -> dialog.close())
                                            )
                                    )
                                    .appendChild(PrefixAddOn.of(Icons.information()))
                            );
                })
                .withContentFooter((parent, footer) -> footer.addCss(dui_bg_orange_l_1, dui_fg_white))
                .withContentBody((parent, body) -> {
                    body
                            .addCss(dui_amber)
                            .appendChild(img(GWT.getModuleBaseURL() + "/assets/image-gallery/9.jpg")
                                    .addCss(dui_image_responsive, dui_m_auto, dui_w_32, dui_h_32)
                            );
                })
                .withConfirmButton((parent, button) -> button.addCss(dui_bg_orange_d_2))
                .onConfirm(AbstractDialog::close);

        element
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(p().textContent("Simple dialog"))
                                .appendChild(Button.create(Icons.cursor_default_click(), "CLICK ME")
                                        .addClickListener(evt -> basicMessage.open())
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(p().textContent("Simple dialog with header"))
                                .appendChild(Button.create(Icons.cursor_default_click(), "CLICK ME")
                                        .addClickListener(evt -> basicWithHeaderMessage.open())
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(p().textContent("Success alert"))
                                .appendChild(Button.create(Icons.cursor_default_click(), "CLICK ME")
                                        .addClickListener(evt -> successMessage.open())
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(p().textContent("Error message"))
                                .appendChild(Button.create(Icons.cursor_default_click(), "CLICK ME")
                                        .addClickListener(evt -> errorMessage.open())
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(p().textContent("Warning alert"))
                                .appendChild(Button.create(Icons.cursor_default_click(), "CLICK ME")
                                        .addClickListener(evt -> warningMessage.open())
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(p().textContent("Info alert"))
                                .appendChild(Button.create(Icons.cursor_default_click(), "CLICK ME")
                                        .addClickListener(evt -> infoMessage.open())
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(p().textContent("Custom colors"))
                                .appendChild(Button.create(Icons.cursor_default_click(), "CLICK ME")
                                        .addClickListener(evt -> customColorsMessage.open())
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(p().textContent("Custom content"))
                                .appendChild(Button.create(Icons.cursor_default_click(), "CLICK ME")
                                        .addClickListener(evt -> customContentMessage.open())
                                )
                        )
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
