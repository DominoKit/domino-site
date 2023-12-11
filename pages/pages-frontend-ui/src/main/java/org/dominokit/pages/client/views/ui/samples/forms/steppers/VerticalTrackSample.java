package org.dominokit.pages.client.views.ui.samples.forms.steppers;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_center;
import static org.dominokit.domino.ui.utils.Domino.dui_m_0;
import static org.dominokit.domino.ui.utils.Domino.dui_m_2;
import static org.dominokit.domino.ui.utils.Domino.dui_m_4;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_4;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_8;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_2;
import static org.dominokit.domino.ui.utils.Domino.dui_vertical;
import static org.dominokit.domino.ui.utils.Domino.p;
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.stepper.StepState;
import org.dominokit.domino.ui.stepper.StepTracker;
import org.dominokit.domino.ui.stepper.StepperTrack;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

public class VerticalTrackSample extends BaseDominoElement<HTMLDivElement, VerticalTrackSample> {

    private DivElement element;

    public static VerticalTrackSample create() {
        return new VerticalTrackSample();
    }

    public VerticalTrackSample() {

        StepperTrack simpleTrack;
        StepperTrack withText;
        StepperTrack withTextReversed;
        StepperTrack withAddons;
        this.element = div().addCss(dui_p_2)
                        .appendChild(Row.create()
                                .appendChild(Column.span6()
                                        .appendChild(BlockHeader.create("SIMPLE").addCss(dui_m_y_8))
                                        .appendChild(div()
                                                .addCss(dui_flex, dui_gap_4)
                                                .appendChild(simpleTrack = StepperTrack.create()
                                                        .setCssProperty("height", "800px")
                                                        .addCss(dui_vertical, dui_m_y_4)
                                                        .appendChild(StepTracker.create())
                                                        .appendChild(StepTracker.create())
                                                        .appendChild(StepTracker.create())
                                                        .appendChild(StepTracker.create())
                                                        .appendChild(StepTracker.create()
                                                                .disable()
                                                                .setState(StepState.DISABLED)
                                                        )
                                                        .appendChild(StepTracker.create())
                                                        .appendChild(StepTracker.create())
                                                        .start(StepState.ACTIVE)
                                                )
                                                .appendChild(div()
                                                        .addCss(dui_flex, dui_justify_center, dui_gap_4, dui_flex_col)
                                                        .appendChild(Button.create("Previous").addClickListener(evt -> {
                                                            simpleTrack.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                                            simpleTrack.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                                            simpleTrack.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                                            simpleTrack.next(1, (deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                                            simpleTrack.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                                            simpleTrack.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                )
                                        )
                                )
                                .appendChild(Column.span6()
                                        .appendChild(BlockHeader.create("WITH TEXT").addCss(dui_m_y_8))
                                        .appendChild(div()
                                                .addCss(dui_flex, dui_gap_4)
                                                .appendChild(withText = StepperTrack.create()
                                                        .setCssProperty("height", "800px")
                                                        .addCss(dui_vertical, dui_m_y_4)
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("1. Step one").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("2. Step two").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("3. Step three").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("4. Step four").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("5. Step five").addCss(dui_m_0, dui_p_l_2))
                                                                .disable()
                                                                .setState(StepState.DISABLED)
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("6. Step Six").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("7. Step seven").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .start(StepState.ACTIVE)
                                                )
                                                .appendChild(div()
                                                        .addCss(dui_flex, dui_justify_center, dui_gap_4, dui_flex_col)
                                                        .appendChild(Button.create("Previous").addClickListener(evt -> {
                                                            withText.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                                            withText.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                                            withText.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                                            withText.next(1, (deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                                            withText.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                                            withText.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))

                                                )
                                        )
                                )

                        )
                        .appendChild(Row.create()
                                .appendChild(Column.span6()
                                        .appendChild(BlockHeader.create("WITH TEXT POSITION REVERSED").addCss(dui_m_y_8))
                                        .appendChild(div()
                                                .addCss(dui_flex, dui_gap_4)
                                                .appendChild(withTextReversed = StepperTrack.create()
                                                        .setCssProperty("height", "800px")
                                                        .setTextPositionReversed(true)
                                                        .addCss(dui_vertical, dui_m_y_4)
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step one 1.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step two 2.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step three 3.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step four 4.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step five 5.").addCss(dui_m_0, dui_p_l_2))
                                                                .disable()
                                                                .setState(StepState.DISABLED)
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step Six 6.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step seven 7.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .start(StepState.ACTIVE)
                                                )
                                                .appendChild(div()
                                                        .addCss(dui_flex, dui_justify_center, dui_gap_4, dui_flex_col)
                                                        .appendChild(Button.create("Previous").addClickListener(evt -> {
                                                            withTextReversed.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                                            withTextReversed.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                                            withTextReversed.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                                            withTextReversed.next(1, (deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                                            withTextReversed.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                                            withTextReversed.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                )
                                        )
                                )
                                .appendChild(Column.span6()
                                        .appendChild(BlockHeader.create("WITH ADDONS").addCss(dui_m_y_8))
                                        .appendChild(div()
                                                .addCss(dui_flex, dui_gap_4)
                                                .appendChild(withAddons = StepperTrack.create()
                                                        .setCssProperty("height", "800px")
                                                        .addCss(dui_vertical, dui_m_y_4)
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(PrefixAddOn.of(span().textContent("1.").addCss(dui_m_2)))
                                                                .appendChild(PostfixAddOn.of(Icons.account().addCss(dui_fg_accent, dui_m_2)))
                                                                .appendChild(p("Personal info").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(PrefixAddOn.of(span().textContent("2.").addCss(dui_m_2)))
                                                                .appendChild(PostfixAddOn.of(Icons.phone().addCss(dui_fg_accent, dui_m_2)))
                                                                .appendChild(p("Contact info").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(PrefixAddOn.of(span().textContent("3.").addCss(dui_m_2)))
                                                                .appendChild(PostfixAddOn.of(Icons.map_marker_account().addCss(dui_fg_accent, dui_m_2)))
                                                                .appendChild(p("Address").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(PrefixAddOn.of(span().textContent("4.").addCss(dui_m_4)))
                                                                .appendChild(PostfixAddOn.of(Icons.cloud_upload().addCss(dui_fg_accent, dui_m_2)))
                                                                .appendChild(p("Photo upload").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(PrefixAddOn.of(span().textContent("5.").addCss(dui_m_2)))
                                                                .appendChild(PostfixAddOn.of(Icons.shield_check().addCss(dui_fg_accent, dui_m_2)))
                                                                .appendChild(p("Verification").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                )
                                                .appendChild(div()
                                                        .addCss(dui_flex, dui_justify_center, dui_gap_4, dui_flex_col)
                                                        .appendChild(Button.create("Previous").addClickListener(evt -> {
                                                            withAddons.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                                            withAddons.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                                            withAddons.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                                            withAddons.next(1, (deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                                            withAddons.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                                            withAddons.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                )
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
