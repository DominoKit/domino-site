package org.dominokit.pages.client.views.ui.samples.animations;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_blue_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_1;
import static org.dominokit.domino.ui.utils.Domino.dui_image_responsive;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_center;
import static org.dominokit.domino.ui.utils.Domino.dui_large;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.img;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class AnimationsBasicSample extends BaseDominoElement<HTMLDivElement, AnimationsBasicSample> {

    private DivElement element;

    public static AnimationsBasicSample create() {
        return new AnimationsBasicSample();
    }

    public AnimationsBasicSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.BOUNCE)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FLASH)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.PULSE)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.RUBBER_BAND)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.SHAKE)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.SWING)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.TADA)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.WOBBLE)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.JELLO)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.BOUNCE_IN)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.BOUNCE_IN_DOWN)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.BOUNCE_IN_LEFT)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.BOUNCE_IN_RIGHT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.BOUNCE_IN_UP)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.BOUNCE_OUT)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.BOUNCE_OUT_DOWN)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.BOUNCE_OUT_LEFT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.BOUNCE_OUT_RIGHT)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.BOUNCE_OUT_UP)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_IN)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_IN_DOWN)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_IN_DOWN_BIG)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_IN_LEFT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_IN_LEFT_BIG)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_IN_RIGHT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_IN_RIGHT_BIG)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_IN_UP)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_IN_UP_BIG)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_OUT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_OUT_DOWN)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_OUT_DOWN_BIG)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_OUT_LEFT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_OUT_LEFT_BIG)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_OUT_RIGHT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_OUT_RIGHT_BIG)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_OUT_UP)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FADE_OUT_UP_BIG)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FLIP)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FLIP_IN_X)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FLIP_IN_Y)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FLIP_OUT_X)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.FLIP_OUT_Y)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.LIGHT_SPEED_IN)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.LIGHT_SPEED_OUT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROTATE_IN)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROTATE_IN_DOWN_LEFT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROTATE_IN_DOWN_RIGHT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROTATE_IN_UP_LEFT)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROTATE_IN_UP_RIGHT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROTATE_OUT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROTATE_OUT_DOWN_LEFT)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROTATE_OUT_DOWN_RIGHT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROTATE_OUT_UP_LEFT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROTATE_OUT_UP_RIGHT)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.SLIDE_IN_UP)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.SLIDE_IN_DOWN)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.SLIDE_IN_LEFT)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.SLIDE_IN_RIGHT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.SLIDE_OUT_UP)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.SLIDE_OUT_DOWN)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.SLIDE_OUT_LEFT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.SLIDE_OUT_RIGHT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ZOOM_IN)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ZOOM_IN_DOWN)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ZOOM_IN_LEFT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ZOOM_IN_RIGHT)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ZOOM_IN_UP)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ZOOM_OUT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ZOOM_OUT_DOWN)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ZOOM_OUT_LEFT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ZOOM_OUT_RIGHT)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ZOOM_OUT_UP)
                                ))

                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.HINGE)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROLL_IN)
                                ))
                        .appendChild(Column.span4()
                                .appendChild(createCard(Transition.ROLL_OUT)
                                ))

                );
        init(this);
    }

    private Card createCard(Transition transition) {

        Card animationCard = Card.create()
                .addCss(dui_blue_grey)
                .appendChild(img( "/assets/image-gallery/animation-bg.jpg").addCss(dui_image_responsive));

        Card card = Card.create(transition.getName(), transition.getStyle() + " animation.")
               ;

        Button animate = Button.create(transition.getName()).addCss(dui_large);
        animate.getClickableElement().addEventListener("click", e ->
                Animation.create(animationCard)
                        .beforeStart(element -> {/*do something here*/})
                        .transition(transition)
                        .duration(1000)
                        .animate());

        Button infiniteAnimate = Button.create("INFINITE")
                .addCss(dui_large);
        infiniteAnimate.getClickableElement().addEventListener("click", e -> {

            Animation animation = Animation.create(animationCard)
                    .transition(transition)
                    .infinite()
                    .duration(1000);
            if (Style.of(animationCard).containsCss("animated")) {
                animation.stop();
                Style.of(animate).setDisplay("inline-block");
                infiniteAnimate.setText("INFINITE");
            } else {
                animation.animate();
                Style.of(animate).setDisplay("none");
                infiniteAnimate.setText("STOP");
            }
        });

        card.appendChild(animationCard)
                .appendChild(div().addCss(dui_flex, dui_justify_center, dui_gap_1)
                        .appendChild(animate)
                        .appendChild(infiniteAnimate)
                );

        return card;
    }

    private void transitionType() {
        Animation.create(element)
                .transition(Transition.BOUNCE)
                .duration(1000)
                .animate();
    }

    private void delay() {
        Animation.create(element)
                .transition(Transition.FLASH)
                .duration(1000)
                .delay(1000)
                .animate();
    }

    private void onBeforeStart() {
        Animation.create(element)
                .transition(Transition.FLASH)
                .duration(1000)
                .beforeStart(element -> {/*do something here*/})
                .animate();
    }

    private void infinite() {
        Animation.create(element)
                .transition(Transition.FLIP)
                .duration(1000)
                .infinite()
                .animate();
    }

    private void stop() {
        Animation animation = Animation.create(element)
                .transition(Transition.TADA)
                .duration(1000)
                .infinite()
                .animate();

        animation.stop();
    }


    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
