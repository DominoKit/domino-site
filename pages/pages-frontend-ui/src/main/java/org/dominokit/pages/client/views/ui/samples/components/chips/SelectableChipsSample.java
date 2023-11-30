package org.dominokit.pages.client.views.ui.samples.components.chips;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.chips.ChipsGroup;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ElementHandler;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.domino.ui.utils.meta.ValueMeta;

import static org.dominokit.domino.ui.utils.Domino.*;

public class SelectableChipsSample extends BaseDominoElement<HTMLDivElement, SelectableChipsSample> {

    private DivElement element;

    public static SelectableChipsSample create() {
        return new SelectableChipsSample();
    }

    public SelectableChipsSample() {

        this.element = div().addCss(dui_p_2, dui_flex, dui_flex_col);
        ElementHandler<Chip> chipSelectionHandler = self -> {
            self
                    .addSelectionListener((source, selection) -> {
                        self.withAddon((parent, addon) -> {
                            addon.clearElement().appendChild(PrefixAddOn.of(Icons.check()));
                        });
                    })
                    .addDeselectionListener((source, selection) -> {
                        self.clearAddOn();
                    });
        };
        Chip tops = Chip.create("Tops")
                .setSelectable(true)
                .addCss(dui_grey)
                .apply(chipSelectionHandler);


        Chip bottoms = Chip.create("Bottoms")
                .setSelectable(true)
                .addCss(dui_grey)
                .apply(chipSelectionHandler);

        Chip shoes = Chip.create("Shoes").setSelectable(true)
                .setSelectable(true)
                .addCss(dui_grey)
                .apply(chipSelectionHandler);

        Chip accessories = Chip.create("Accessories")
                .setSelectable(true)
                .addCss(dui_grey)
                .apply(chipSelectionHandler);

        element.appendChild(BlockHeader.create("Multi select"));

        element.appendChild(div().addCss(dui_p_2, dui_flex, dui_gap_4, dui_flex_wrap)
                        .appendChild(tops)
                        .appendChild(bottoms)
                        .appendChild(shoes)
                        .appendChild(accessories)
                );

        element.appendChild(BlockHeader.create("Single select"));

        ChipsGroup chipsGroup = ChipsGroup.create()
                .appendChild(Chip.create("Extra small").applyMeta(ValueMeta.of("EXTRA SMALL")))
                .appendChild(Chip.create("Small").applyMeta(ValueMeta.of("SMALL")))
                .appendChild(Chip.create("Medium").applyMeta(ValueMeta.of("MEDIUM")))
                .appendChild(Chip.create("Large").applyMeta(ValueMeta.of("LARGE")))
                .appendChild(Chip.create("Extra large").applyMeta(ValueMeta.of("EXTREA LARGE")))
                .addCss(dui_teal, dui_ignore_bg);

        element.appendChild(div().addCss(dui_p_2, dui_flex, dui_gap_4, dui_flex_wrap)
                        .appendChild(chipsGroup
                                .addSelectionListener((source, selection) -> {
                                    ValueMeta.<String>get(chipsGroup.getSelectedChips().get(0))
                                            .ifPresent(valueMeta -> {
                                                Notification
                                                        .create("Chip [ " + valueMeta.getValue() + " ] is selected")
                                                        .addCss(dui_info)
                                                        .show();
                                            });
                                })
                                .selectAt(0)))
        ;

        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
