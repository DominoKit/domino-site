package org.dominokit.pages.client.views.ui.samples.components.chips;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PrefixAddOn;

public class ChipsWithIconsAndImagesSample extends BaseDominoElement<HTMLDivElement, ChipsWithIconsAndImagesSample> {

    private DivElement element;

    public static ChipsWithIconsAndImagesSample create() {
        return new ChipsWithIconsAndImagesSample();
    }

    public ChipsWithIconsAndImagesSample() {
        this.element = div().addCss(dui_p_2, dui_flex, dui_gap_4, dui_flex_wrap)
                .appendChild(Chip.create("Add to calendar")
                        .addClickListener(evt -> {
                            Notification.create("Added to your calendar").addCss(dui_success).show();
                        })
                        .appendChild(PrefixAddOn.of(Icons.calendar_range()))
                )
                .appendChild(Chip.create("Bookmark")
                        .addClickListener(evt -> {
                            Notification.create("Bookmark added").addCss(dui_success).show();
                        })
                        .appendChild(PrefixAddOn.of(Icons.bookmark()))
                )
                .appendChild(Chip.create("Set alarm")
                        .addClickListener(evt -> {
                            Notification.create("Alarm has been set").addCss(dui_success).show();
                        })
                        .appendChild(PrefixAddOn.of(Icons.alarm()))
                )
                .appendChild(Chip.create("Get directions")
                        .addClickListener(evt -> {
                            Notification.create("Directions has been sent to your email").addCss(dui_success).show();
                        })
                        .appendChild(PrefixAddOn.of(Icons.directions()))
                )
                .appendChild(Chip.create("Schroeder Coleman")
                        .addCss(dui_transparent, dui_border, dui_border_solid, dui_border_indigo)
                        .setImage(img("https://randomuser.me/api/portraits/med/men/0.jpg")))
                .appendChild(Chip.create("Renee Mcintyre")
                        .addCss(dui_grey)
                        .setImage(img("https://randomuser.me/api/portraits/med/men/1.jpg")))
                .appendChild(Chip.create("Casey Garza")
                        .addCss(dui_blue)
                        .setImage(img("https://randomuser.me/api/portraits/med/men/2.jpg")))
                .appendChild(Chip.create("Ferguson Hudson")
                        .addCss(dui_black)
                        .setImage(img("https://randomuser.me/api/portraits/med/men/3.jpg")))
                .appendChild(Chip.create("Serrano Green")
                        .addCss(dui_cyan)
                        .setImage(img("https://randomuser.me/api/portraits/med/men/4.jpg")))
                .appendChild(Chip.create("Camacho Solis")
                        .addCss(dui_blue_grey)
                        .setImage(img("https://randomuser.me/api/portraits/med/men/5.jpg")))
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
