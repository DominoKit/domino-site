package org.dominokit.pages.client.views.ui.samples.forms.steppers;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.CustomEvents;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.stepper.Step;
import org.dominokit.domino.ui.stepper.StepState;
import org.dominokit.domino.ui.stepper.Stepper;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import java.util.Objects;

import static org.dominokit.domino.ui.utils.Domino.*;

public class HorizontalStepperSample extends BaseDominoElement<HTMLDivElement, HorizontalStepperSample> {

    private DivElement element;

    public static HorizontalStepperSample create() {
        return new HorizontalStepperSample();
    }

    public HorizontalStepperSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Stepper.create()
                        .addCss(dui_reversed)
                        .appendChild(Step.create("Name and Nickname")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("1. Personal info").addCss(dui_m_0, dui_p_l_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.account()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Name and nickname will be used in notifications and user info.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    TextBox firstName = TextBox.create("First name")
                                            .groupBy(stepGroup);
                                    TextBox lastName = TextBox.create("Last name")
                                            .groupBy(stepGroup);
                                    TextBox nickname = TextBox.create("Nickname")
                                            .groupBy(stepGroup);
                                    stepGroup.setRequired(true);

                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_p_x_48, dui_items_center, dui_justify_center, dui_flex_col)
                                                    .appendChild(firstName)
                                                    .appendChild(lastName)
                                                    .appendChild(nickname)
                                            );

                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_flex, dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Next")
                                                        .addCss(dui_success, dui_w_24)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                step.next((deactivated, activated) -> {
                                                                    deactivated.ifPresent(stepTracker -> step.setState(StepState.COMPLETED));
                                                                    activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                });
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .appendChild(Step.create("Residency location")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("2. Address").addCss(dui_m_0, dui_p_l_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.map_marker()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Will be used for shipments.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    TextBox country = TextBox.create("Country")
                                            .groupBy(stepGroup);
                                    TextBox city = TextBox.create("City")
                                            .groupBy(stepGroup);
                                    TextBox zipCode = TextBox.create("ZIP Code")
                                            .setHelperText("Leave empty to mark step with warning.");
                                    stepGroup.setRequired(true);
                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        zipCode.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });
                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_p_x_48, dui_items_center, dui_justify_center, dui_flex_col)
                                                    .appendChild(country)
                                                    .appendChild(city)
                                                    .appendChild(zipCode)
                                            );

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Back")
                                                        .setIcon(Icons.arrow_left())
                                                        .addClickListener(evt -> {
                                                            step.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> step.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        })
                                                )
                                                .appendChild(Button.create("Next")
                                                        .addCss(dui_success)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                if (zipCode.isEmpty()) {
                                                                    step.next((deactivated, activated) -> {
                                                                        deactivated.ifPresent(stepTracker -> step.setState(StepState.WARNING));
                                                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                    });
                                                                } else {
                                                                    step.next((deactivated, activated) -> {
                                                                        deactivated.ifPresent(stepTracker -> step.setState(StepState.COMPLETED));
                                                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                    });
                                                                }
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .appendChild(Step.create("Notification channels")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("3. Contact information").addCss(dui_m_0, dui_p_l_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.phone()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Will be used for notifications and verification.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    EmailBox email = EmailBox.create("Email")
                                            .groupBy(stepGroup);
                                    TelephoneBox phone = TelephoneBox.create("Phone number")
                                            .groupBy(stepGroup);
                                    stepGroup.setRequired(true);
                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });
                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_p_x_48, dui_items_center, dui_justify_center, dui_flex_col)
                                                    .appendChild(email)
                                                    .appendChild(phone)
                                            );

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Back")
                                                        .setIcon(Icons.arrow_left())
                                                        .addClickListener(evt -> {
                                                            step.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> step.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        })
                                                )
                                                .appendChild(Button.create("Next")
                                                        .addCss(dui_success)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                step.next((deactivated, activated) -> {
                                                                    deactivated.ifPresent(stepTracker -> step.setState(StepState.COMPLETED));
                                                                    activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                });
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .appendChild(Step.create("Account protection")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("4. Security").addCss(dui_m_0, dui_p_l_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.shield()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Will be used for login and verification.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    PasswordBox password = PasswordBox.create("Password")
                                            .groupBy(stepGroup);
                                    PasswordBox confirm = PasswordBox.create("Confirm password")
                                            .groupBy(stepGroup);
                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });
                                    stepGroup
                                            .setRequired(true)
                                            .addValidator(group -> {
                                                if (Objects.equals(password.getValue(), confirm.getValue())) {
                                                    return ValidationResult.valid();
                                                } else {
                                                    return ValidationResult.invalid("Password and confirmation does not match.");
                                                }
                                            });

                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_p_x_48, dui_items_center, dui_justify_center, dui_flex_col)
                                                    .appendChild(password)
                                                    .appendChild(confirm)
                                            );

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Back")
                                                        .setIcon(Icons.arrow_left())
                                                        .addClickListener(evt -> {
                                                            step.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> step.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        })
                                                )
                                                .appendChild(Button.create("Finish")
                                                        .addCss(dui_success)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                step.finish(StepState.COMPLETED);
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .withFinishContent((stepper, finishElement) -> {
                            finishElement
                                    .addCss(dui_flex, dui_p_x_48, dui_items_center, dui_justify_center, dui_flex_col)
                                    .appendChild(Icons.checkbox_marked_circle_outline()
                                            .addCss(dui_fg_success, dui_font_size_32)
                                    )
                                    .appendChild(h(2).textContent("Registration completed."))
                                    .appendChild(Button.create("RESET")
                                            .addCss(dui_success)
                                            .setIcon(Icons.reply_all_outline())
                                            .setReversed(true)
                                            .addClickListener(evt -> {
                                                stepper.reset(StepState.ACTIVE, steps -> {
                                                    steps.forEach(step -> step.dispatchEvent(CustomEvents.create("stepreset")));
                                                });
                                            }));
                        })
                        .start(StepState.ACTIVE)
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
