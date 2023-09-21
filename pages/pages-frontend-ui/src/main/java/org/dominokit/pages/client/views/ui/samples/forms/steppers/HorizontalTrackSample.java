package org.dominokit.pages.client.views.ui.samples.forms.steppers;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextAreaBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.stepper.StepState;
import org.dominokit.domino.ui.stepper.StepTracker;
import org.dominokit.domino.ui.stepper.StepperTrack;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

public class HorizontalTrackSample extends BaseDominoElement<HTMLDivElement, HorizontalTrackSample> {

    private DivElement element;

    public static HorizontalTrackSample create() {
        return new HorizontalTrackSample();
    }

    public HorizontalTrackSample() {
        StepperTrack simpleTrack;
        StepperTrack withText;
        StepperTrack withTextReversed;
        StepperTrack withAddons;
        StepTracker.TrackerListener trackerListener = (tracker, state) -> DomGlobal.console.info("Tracker [" + tracker.getKey() + "] changed state to [" + state.getKey() + "], active : " + tracker.isActive());
        this.element = div().addCss(dui_p_2)
                        .appendChild(BlockHeader.create("SIMPLE").addCss(dui_m_y_8))
                        .appendChild(simpleTrack = StepperTrack.create()
                                .addCss(dui_m_y_4)
                                .appendChild(StepTracker.create("Step 1")
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 2")
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 3")
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 4")
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 5")
                                        .disable()
                                        .setState(StepState.DISABLED)
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 6")
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 7")
                                        .addStateListener(trackerListener)
                                )
                                .start(StepState.ACTIVE)
                        )
                        .appendChild(div()
                                .addCss(dui_flex, dui_justify_center, dui_gap_4)
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
                        .appendChild(BlockHeader.create("WITH TEXT").addCss(dui_m_y_8))
                        .appendChild(withText = StepperTrack.create()
                                .addCss(dui_m_y_4)
                                .appendChild(StepTracker.create()
                                        .appendChild(p("1. Step one").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("2. Step two").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("3. Step three").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("4. Step four").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("5. Step five").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                        .disable()
                                        .setState(StepState.DISABLED)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("6. Step Six").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("7. Step seven").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .start(StepState.ACTIVE)
                        )
                        .appendChild(div()
                                .addCss(dui_flex, dui_justify_center, dui_gap_4)
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
                        .appendChild(BlockHeader.create("WITH TEXT POSITION REVERSED").addCss(dui_m_y_8))
                        .appendChild(withTextReversed = StepperTrack.create()
                                .addCss(dui_m_y_4)
                                .setTextPositionReversed(true)
                                .appendChild(StepTracker.create()
                                        .appendChild(p("1. Step one").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("2. Step two").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("3. Step three").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("4. Step four").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("5. Step five").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                        .disable()
                                        .setState(StepState.DISABLED)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("6. Step Six").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("7. Step seven").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .start(StepState.ACTIVE)
                        )
                        .appendChild(div()
                                .addCss(dui_flex, dui_justify_center, dui_gap_4)
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
                        .appendChild(BlockHeader.create("WITH ADDONS").addCss(dui_m_y_8))
                        .appendChild(withAddons = StepperTrack.create()
                                .addCss(dui_m_y_4)
                                .appendChild(StepTracker.create()
                                        .appendChild(PrefixAddOn.of(span().textContent("1.").addCss(dui_m_2)))
                                        .appendChild(PostfixAddOn.of(Icons.account().addCss(dui_fg_accent, dui_m_2)))
                                        .appendChild(p("Personal info").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(PrefixAddOn.of(span().textContent("2.").addCss(dui_m_2)))
                                        .appendChild(PostfixAddOn.of(Icons.phone().addCss(dui_fg_accent, dui_m_2)))
                                        .appendChild(p("Contact info").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(PrefixAddOn.of(span().textContent("3.").addCss(dui_m_2)))
                                        .appendChild(PostfixAddOn.of(Icons.map_marker_account().addCss(dui_fg_accent, dui_m_2)))
                                        .appendChild(p("Address").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(PrefixAddOn.of(span().textContent("4.").addCss(dui_m_2)))
                                        .appendChild(PostfixAddOn.of(Icons.cloud_upload().addCss(dui_fg_accent, dui_m_2)))
                                        .appendChild(p("Photo upload").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(PrefixAddOn.of(span().textContent("5.").addCss(dui_m_2)))
                                        .appendChild(PostfixAddOn.of(Icons.shield_check().addCss(dui_fg_accent, dui_m_2)))
                                        .appendChild(p("Verification").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .start(StepState.ACTIVE)
                        )
                        .appendChild(div()
                                .addCss(dui_flex, dui_justify_center, dui_gap_4)
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
                );

        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
