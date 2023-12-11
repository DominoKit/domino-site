package org.dominokit.pages.client.views.ui.samples.components.infobox;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_amber;
import static org.dominokit.domino.ui.utils.Domino.dui_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_cyan;
import static org.dominokit.domino.ui.utils.Domino.dui_deep_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_deep_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_light_green;
import static org.dominokit.domino.ui.utils.Domino.dui_lime;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_pink;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_lg;
import static org.dominokit.domino.ui.utils.Domino.dui_teal;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.infoboxes.InfoBox;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class HoverInfoBoxSample extends BaseDominoElement<HTMLDivElement, HoverInfoBoxSample> {
    private DivElement element;

    public static HoverInfoBoxSample create() {
        return new HoverInfoBoxSample();
    }

    public HoverInfoBoxSample() {
        this.element = div().addCss(dui_p_2);
        element.appendChild(Row.create()
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.email(), "MESSAGES", "15")
                        .addCss(dui_pink)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.devices(), "CPU USAGE", "92%")
                        .addCss(dui_blue)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.alarm(), "ALARM", "07:00 AM")
                        .addCss(dui_amber)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.crosshairs_gps(), "LOCATION", "Jordan")
                        .addCss(dui_deep_purple)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .element());

        element.appendChild(Row.create()
                .appendChild(Column.span3()
                        .appendChild(InfoBox.create(Icons.equalizer(), "BOUNCE RATE", "62%")
                                .withIcon((parent, iconElement) -> iconElement.addCss(dui_teal))
                                .addCss(dui_cyan, dui_rounded_lg)
                                .setHoverEffect(InfoBox.HoverEffect.EXPAND)
                        )
                )
                .appendChild(Column.span3()
                        .appendChild(InfoBox.create(Icons.airplane_takeoff(), "FLIGHT", "02:59 PM")
                                .withIcon((parent, iconElement) -> iconElement.addCss(dui_green))
                                .addCss(dui_lime, dui_rounded_lg)
                                .setHoverEffect(InfoBox.HoverEffect.EXPAND)
                        )
                )
                .appendChild(Column.span3()
                        .appendChild(InfoBox.create(Icons.battery_charging_90(), "BATTERY", "Charging")
                                .withIcon((parent, iconElement) -> iconElement.addCss(dui_light_green))
                                .addCss(dui_green, dui_rounded_lg)
                                .setHoverEffect(InfoBox.HoverEffect.EXPAND)
                        )
                )
                .appendChild(Column.span3()
                        .appendChild(InfoBox.create(Icons.brightness_2(), "BRIGHTNESS RATE", "40%")
                                .withIcon((parent, iconElement) -> iconElement.addCss(dui_deep_orange))
                                .addCss(dui_amber, dui_rounded_lg)
                                .setHoverEffect(InfoBox.HoverEffect.EXPAND)
                        )
                )
        );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
