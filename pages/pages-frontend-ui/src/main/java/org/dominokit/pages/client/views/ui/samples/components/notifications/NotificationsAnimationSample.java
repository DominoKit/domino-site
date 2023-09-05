package org.dominokit.pages.client.views.ui.samples.components.notifications;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.notifications.Notification.Position.*;

public class NotificationsAnimationSample extends BaseDominoElement<HTMLDivElement, NotificationsAnimationSample> {

    private DivElement element;

    public static NotificationsAnimationSample create() {
        return new NotificationsAnimationSample();
    }

    public NotificationsAnimationSample() {
        Button fadeInOut = Button.create("FADE IN OUT")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FADE_IN)
                                .outTransition(Transition.FADE_OUT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button fadeInOutLeft = Button.create("FADE IN OU LEFT")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FADE_IN_LEFT)
                                .outTransition(Transition.FADE_OUT_LEFT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button fadeInOutRight = Button.create("FADE IN OUT RIGHT")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FADE_IN_RIGHT)
                                .outTransition(Transition.FADE_OUT_RIGHT)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button fadeInOutUp = Button.create("FADE IN OUT UP")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FADE_IN_UP)
                                .outTransition(Transition.FADE_OUT_UP)
                                .setPosition(TOP_MIDDLE)
                                .show());

        Button fadeInOutDown = Button.create("FADE IN OUT DOWN")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FADE_IN_DOWN)
                                .outTransition(Transition.FADE_OUT_DOWN)
                                .setPosition(TOP_LEFT)
                                .show());

        Button bouneInOut = Button.create("BOUNCE IN OUT")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.BOUNCE_IN)
                                .outTransition(Transition.BOUNCE_OUT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button bounceInOutLeft = Button.create("BOUNCE IN OUT LEFT")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.BOUNCE_IN_LEFT)
                                .outTransition(Transition.BOUNCE_OUT_LEFT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button bounceInOutRight = Button.create("BOUNCE IN OUT RIGHT")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.BOUNCE_IN_RIGHT)
                                .outTransition(Transition.BOUNCE_OUT_RIGHT)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button bounceInOutUp = Button.create("BOUNCE IN OUT UP")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.BOUNCE_IN_UP)
                                .outTransition(Transition.BOUNCE_OUT_UP)
                                .setPosition(TOP_MIDDLE)
                                .show());


        Button bounceInOutDown = Button.create("BOUNCE IN OUT DOWN")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.BOUNCE_IN_DOWN)
                                .outTransition(Transition.BOUNCE_OUT_DOWN)
                                .setPosition(TOP_MIDDLE)
                                .show());

        Button rotateInOut = Button.create("ROTATE IN OUT")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ROTATE_IN)
                                .outTransition(Transition.ROTATE_OUT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button rotateInOutUpLeft = Button.create("ROTATE IN OUT UP LEFT")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ROTATE_IN_UP_LEFT)
                                .outTransition(Transition.ROTATE_OUT_UP_LEFT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button rotateInOutUpRight = Button.create("ROTATE IN OUT UP RIGHT")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ROTATE_IN_UP_RIGHT)
                                .outTransition(Transition.ROTATE_OUT_UP_RIGHT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button rotateInOutDownLeft = Button.create("ROTATE IN OUT DOWN LEFT")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ROTATE_IN_DOWN_LEFT)
                                .outTransition(Transition.ROTATE_OUT_DOWN_LEFT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button rotateInOutDownRight = Button.create("ROTATE IN OUT DOWN RIGHT")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ROTATE_IN_DOWN_RIGHT)
                                .outTransition(Transition.ROTATE_OUT_DOWN_RIGHT)
                                .setPosition(TOP_LEFT)
                                .show());


        Button zoomInOut = Button.create("ZOOM IN OUT")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ZOOM_IN)
                                .outTransition(Transition.ZOOM_OUT)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button zoomInOutLeft = Button.create("ZOOM IN OUT LEFT")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ZOOM_IN_LEFT)
                                .outTransition(Transition.ZOOM_OUT_LEFT)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button zoomInOutRight = Button.create("ZOOM IN OUT RIGHT")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ZOOM_IN_RIGHT)
                                .outTransition(Transition.ZOOM_OUT_RIGHT)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button zoomInOutUp = Button.create("ZOOM IN OUT UP")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ZOOM_IN_UP)
                                .outTransition(Transition.ZOOM_OUT_UP)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button zoomInOutDown = Button.create("ZOOM IN OUT DOWN")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ZOOM_IN_DOWN)
                                .outTransition(Transition.ZOOM_OUT_DOWN)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button flipInOutX = Button.create("FLIP IN OUT X")
                .addCss(dui_purple, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FLIP_IN_X)
                                .outTransition(Transition.FLIP_OUT_X)
                                .setPosition(BOTTOM_LEFT)
                                .show());

        Button flipInOutY = Button.create("FLIP IN OUT Y")
                .addCss(dui_purple, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FLIP_IN_Y)
                                .outTransition(Transition.FLIP_OUT_Y)
                                .setPosition(BOTTOM_RIGHT)
                                .show());

        Button lightSpeedInOut = Button.create("LIGHT SPEED IN OUT")
                .addCss(dui_indigo, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.LIGHT_SPEED_IN)
                                .outTransition(Transition.LIGHT_SPEED_OUT)
                                .setPosition(TOP_MIDDLE)
                                .show());

        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(fadeInOut))
                        .appendChild(Column.span2().appendChild(fadeInOutLeft))
                        .appendChild(Column.span2().appendChild(fadeInOutRight))
                        .appendChild(Column.span2().appendChild(fadeInOutUp))
                        .appendChild(Column.span2().appendChild(fadeInOutDown))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(bouneInOut))
                        .appendChild(Column.span2().appendChild(bounceInOutLeft))
                        .appendChild(Column.span2().appendChild(bounceInOutRight))
                        .appendChild(Column.span2().appendChild(bounceInOutUp))
                        .appendChild(Column.span2().appendChild(bounceInOutDown))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(rotateInOut))
                        .appendChild(Column.span2().appendChild(rotateInOutUpLeft))
                        .appendChild(Column.span2().appendChild(rotateInOutUpRight))
                        .appendChild(Column.span2().appendChild(rotateInOutDownLeft))
                        .appendChild(Column.span2().appendChild(rotateInOutDownRight))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(zoomInOut))
                        .appendChild(Column.span2().appendChild(zoomInOutLeft))
                        .appendChild(Column.span2().appendChild(zoomInOutRight))
                        .appendChild(Column.span2().appendChild(zoomInOutUp))
                        .appendChild(Column.span2().appendChild(zoomInOutDown))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(flipInOutX))
                        .appendChild(Column.span2().appendChild(flipInOutY))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(lightSpeedInOut))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
