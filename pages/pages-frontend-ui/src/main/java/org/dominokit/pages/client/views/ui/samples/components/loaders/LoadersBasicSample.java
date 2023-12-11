package org.dominokit.pages.client.views.ui.samples.components.loaders;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_text_center;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.timer.client.Timer;

public class LoadersBasicSample extends BaseDominoElement<HTMLDivElement, LoadersBasicSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";
    private DivElement element;

    public static LoadersBasicSample create() {
        return new LoadersBasicSample();
    }

    public LoadersBasicSample() {
        this.element = div()
                .addCss(dui_p_2)
                .appendChild(Row.create()
                        .span4(createCard(LoaderEffect.BOUNCE, "Loading ... ", Color.BLUE_GREY))
                        .span4(createCard(LoaderEffect.FACEBOOK, "Loading ... ", Color.LIGHT_BLUE))
                        .span4(createCard(LoaderEffect.IOS, "Loading ... ", Color.LIGHT_GREEN))
                )
                .appendChild(Row.create()
                        .span4(createCard(LoaderEffect.ROTATE_PLANE, "Waiting ... ", Color.BLUE_GREY))
                        .span4(createCard(LoaderEffect.ROTATION, "Waiting ... ", Color.LIGHT_BLUE))
                        .span4(createCard(LoaderEffect.ROUND_BOUNCE, "Waiting ... ", Color.LIGHT_GREEN))
                )
                .appendChild(Row.create()
                        .span4(createCard(LoaderEffect.TIMER, " ... ", Color.BLUE_GREY))
                        .span4(createCard(LoaderEffect.WIN8, " ... ", Color.LIGHT_BLUE))
                        .span4(createCard(LoaderEffect.WIN8_LINEAR, " ... ", Color.LIGHT_GREEN))
                )
                .appendChild(Row.create()
                        .span4(createCard(LoaderEffect.PULSE, "Loading ... ", Color.BLUE_GREY))
                        .span4(createCard(LoaderEffect.PROGRESS_BAR, "Loading ... ", Color.LIGHT_BLUE))
                        .span4(createCard(LoaderEffect.BOUNCE_PULSE, "Loading ... ", Color.LIGHT_GREEN))
                )
                .appendChild(Row.create()
                        .span4(createCard(LoaderEffect.ORBIT, "", Color.BLUE_GREY))
                        .span4(createCard(LoaderEffect.STRETCH, "", Color.LIGHT_BLUE))
                        .span4(createCard(LoaderEffect.NONE, "", Color.LIGHT_GREEN))
                )
        ;
        init(this);
    }

    private Card createCard(LoaderEffect effect, String loadingText, Color color) {
        Card card = Card.create(effect.toString(), effect.toString().toLowerCase() + " loader effect.")
                .addCss(color.getCss());

        EventListener loaderListener = e -> {
            Loader loader = Loader.create(card.element(), effect)
                    .setLoadingText(loadingText)
                    .start();
            new Timer() {
                @Override
                public void run() {
                    loader.stop();
                }
            }.schedule(7000);
        };

        Button button = Button.create(Icons.cursor_default_click(), "CLICK ME").addClickListener(loaderListener);

        card.appendChild(div()
                        .addCss(dui_flex, dui_items_center, dui_flex_col, dui_gap_4)
                        .appendChild(p(SAMPLE_CONTENT).addCss(dui_text_center))
                        .appendChild(button)
                );

        return card;
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
