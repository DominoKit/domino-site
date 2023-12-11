package org.dominokit.pages.client.views.ui.samples.components.notifications;

import static org.dominokit.domino.ui.notifications.Notification.Position.TOP_LEFT;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_error;
import static org.dominokit.domino.ui.utils.Domino.dui_fg;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_1;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_info;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_full;
import static org.dominokit.domino.ui.utils.Domino.dui_success;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;
import static org.dominokit.domino.ui.utils.Domino.dui_warning;
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ContextNotificationsSample extends BaseDominoElement<HTMLDivElement, ContextNotificationsSample> {

    private DivElement element;

    public static ContextNotificationsSample create() {
        return new ContextNotificationsSample();
    }

    public ContextNotificationsSample() {
        Button danger = Button.create("DANGER")
                .addCss(dui_error, dui_w_full)
                .addClickListener(e ->
                        Notification.create()
                                .setDismissible(true)
                                .addCss(dui_error, dui_rounded_full)
                                .setPosition(TOP_LEFT)
                                .appendChild(div()
                                        .addCss(dui_flex, dui_items_center)
                                        .appendChild(Icons.alert_circle().addCss(dui_fg))
                                        .appendChild(span().textContent("Invalid action, please try something else.!"))
                                )
                                .show());

        Button success = Button.create("SUCCESS")
                .addCss(dui_success, dui_w_full)
                .addClickListener(e ->
                        Notification.create()
                                .setDismissible(true)
                                .addCss(dui_success, dui_rounded_full)
                                .setPosition(TOP_LEFT)
                                .appendChild(div()
                                        .addCss(dui_flex, dui_items_center)
                                        .appendChild(Icons.bell_check_outline().addCss(dui_fg))
                                        .appendChild(span().textContent("Operation completed successfully."))
                                )
                                .show());

        Button warning = Button.create("WARNING")
                .addCss(dui_warning, dui_w_full)
                .addClickListener(e ->
                        Notification.create()
                                .setDismissible(true)
                                .addCss(dui_warning, dui_rounded_full)
                                .setPosition(TOP_LEFT)
                                .appendChild(div()
                                        .addCss(dui_flex, dui_items_center, dui_gap_1)
                                        .appendChild(Icons.bell_alert_outline().addCss(dui_fg))
                                        .appendChild(span().textContent("Operation completed with warnings."))
                                        .appendChild(Badge.create("15").addCss(dui_bg_d_2, dui_fg, dui_rounded_full))
                                )
                                .show());


        Button info = Button.create("INFO")
                .addCss(dui_info, dui_w_full)
                .addClickListener(e ->
                        Notification.create()
                                .setDismissible(true)
                                .addCss(dui_info, dui_rounded_full)
                                .setPosition(TOP_LEFT)
                                .appendChild(div()
                                        .addCss(dui_flex, dui_items_center, dui_gap_2)
                                        .appendChild(Icons.information_outline().addCss(dui_fg))
                                        .appendChild(span().textContent("Follow up ID generated, click to copy."))
                                        .appendChild(Badge.create("123456789").addCss(dui_bg_d_2, dui_fg, dui_rounded_full))
                                        .appendChild(Icons.content_copy().clickable())
                                )
                                .show());


        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(danger))
                        .appendChild(Column.span2().appendChild(success))
                        .appendChild(Column.span2().appendChild(warning))
                        .appendChild(Column.span2().appendChild(info))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
