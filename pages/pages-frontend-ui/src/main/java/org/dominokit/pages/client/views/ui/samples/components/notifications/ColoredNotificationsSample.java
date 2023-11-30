package org.dominokit.pages.client.views.ui.samples.components.notifications;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.notifications.Notification.Position.TOP_LEFT;
import static org.dominokit.domino.ui.utils.Domino.*;

public class ColoredNotificationsSample extends BaseDominoElement<HTMLDivElement, ColoredNotificationsSample> {

    private DivElement element;

    public static ColoredNotificationsSample create() {
        return new ColoredNotificationsSample();
    }

    public ColoredNotificationsSample() {
        Button redButton = Button.create("RED")
                .addCss(dui_red, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_red)
                                .setPosition(TOP_LEFT)
                                .show());

        Button greenButton = Button.create("GREEN")
                .addCss(dui_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_green)
                                .setPosition(TOP_LEFT)
                                .show());

        Button orangeButton = Button.create("ORANGE")
                .addCss(dui_orange, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_orange)
                                .setPosition(TOP_LEFT)
                                .show());

        Button blueButton = Button.create("BLUE")
                .addCss(dui_blue, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_blue)
                                .setPosition(TOP_LEFT)
                                .show());

        Button tealButton = Button.create("TEAL")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_teal)
                                .setPosition(TOP_LEFT)
                                .show());

        Button cyanButton = Button.create("CYAN")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_cyan)
                                .setPosition(TOP_LEFT)
                                .show());

        Button pinkButton = Button.create("PINK")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_pink)
                                .setPosition(TOP_LEFT)
                                .show());

        Button purpleButton = Button.create("PURPLE")
                .addCss(dui_purple, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_purple)
                                .setPosition(TOP_LEFT)
                                .show());

        Button blueGreyButton = Button.create("BLUE GREY")
                .addCss(dui_blue_grey, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_blue_grey)
                                .setPosition(TOP_LEFT)
                                .show());


        Button deepOrangeButton = Button.create("DEEP ORANGE")
                .addCss(dui_deep_orange, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_deep_orange)
                                .setPosition(TOP_LEFT)
                                .show());

        Button lightGreenButton = Button.create("LIGHT GREEN")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_light_green)
                                .setPosition(TOP_LEFT)
                                .show());

        Button blackButton = Button.create("BLACK")
                .addCss(dui_black, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_black)
                                .setPosition(TOP_LEFT)
                                .show());

        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(redButton))
                        .appendChild(Column.span2().appendChild(greenButton))
                        .appendChild(Column.span2().appendChild(orangeButton))
                        .appendChild(Column.span2().appendChild(blueButton))
                        .appendChild(Column.span2().appendChild(tealButton))
                        .appendChild(Column.span2().appendChild(cyanButton))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(pinkButton))
                        .appendChild(Column.span2().appendChild(purpleButton))
                        .appendChild(Column.span2().appendChild(blueGreyButton))
                        .appendChild(Column.span2().appendChild(deepOrangeButton))
                        .appendChild(Column.span2().appendChild(lightGreenButton))
                        .appendChild(Column.span2().appendChild(blackButton))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
