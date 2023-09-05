package org.dominokit.pages.client.views.ui.samples.components.notifications;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.notifications.Notification.Position.*;
import static org.dominokit.domino.ui.notifications.Notification.Position.BOTTOM_RIGHT;

public class BasicNotificationsSample extends BaseDominoElement<HTMLDivElement, BasicNotificationsSample> {

    private DivElement element;

    public static BasicNotificationsSample create() {
        return new BasicNotificationsSample();
    }

    public BasicNotificationsSample() {
        Button topLeft = Button.create("TOP LEFT")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(TOP_LEFT)
                                .addCss(dui_black)
                                .show());

        Button topCenter = Button.create("TOP CENTER")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(TOP_MIDDLE)
                                .addCss(dui_black)
                                .show());

        Button topRight = Button.create("TOP RIGHT")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(TOP_RIGHT)
                                .addCss(dui_black)
                                .show());


        Button bottomLeft = Button.create("BOTTOM LEFT")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(BOTTOM_LEFT)
                                .addCss(dui_black)
                                .show());

        Button bottomCenter = Button.create("BOTTOM CENTER")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(BOTTOM_MIDDLE)
                                .addCss(dui_black)
                                .show());

        Button bottomRight = Button.create("BOTTOM RIGHT")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(BOTTOM_RIGHT)
                                .addCss(dui_black)
                                .show());

        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(topLeft))
                        .appendChild(Column.span2().appendChild(topCenter))
                        .appendChild(Column.span2().appendChild(topRight))
                        .appendChild(Column.span2().appendChild(bottomLeft))
                        .appendChild(Column.span2().appendChild(bottomCenter))
                        .appendChild(Column.span2().appendChild(bottomRight))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
