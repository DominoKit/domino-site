package org.dominokit.pages.client.views.ui.samples.components.infobox;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.counter.Counter;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.infoboxes.InfoBox;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class RightAlignedInfoBoxSample extends BaseDominoElement<HTMLDivElement, RightAlignedInfoBoxSample> {
    private DivElement element;

    public static RightAlignedInfoBoxSample create() {
        return new RightAlignedInfoBoxSample();
    }

    public RightAlignedInfoBoxSample() {
        this.element = div().addCss(dui_p_2);
        element.appendChild(Row.create()
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.email(), "MESSAGES", "15")
                        .withIcon((parent, iconElement) -> iconElement.addCss(dui_fg_pink))
                        .setFlipped(true)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.devices(), "CPU USAGE", "92%")
                        .withIcon((parent, iconElement) -> iconElement.addCss(dui_fg_blue))
                        .setFlipped(true)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.alarm(), "ALARM", "07:00 AM")
                        .withIcon((parent, iconElement) -> iconElement.addCss(dui_fg_amber))
                        .setFlipped(true)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.crosshairs_gps(), "LOCATION", "Jordan")
                        .withIcon((parent, iconElement) -> iconElement.addCss(dui_fg_deep_purple))
                        .setFlipped(true)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .element());

        element.appendChild(Row.create()
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.equalizer(), "BOUNCE RATE", "62%")
                        .addCss(dui_teal)
                        .setFlipped(true)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.airplane_takeoff(), "FLIGHT", "02:59 PM")
                        .addCss(dui_green)
                        .setFlipped(true)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.battery_charging_30(), "BATTERY", "Charging")
                        .addCss(dui_light_green)
                        .setFlipped(true)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.brightness_2(), "BRIGHTNESS RATE", "40%")
                        .addCss(dui_lime)
                        .setFlipped(true)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
        );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
