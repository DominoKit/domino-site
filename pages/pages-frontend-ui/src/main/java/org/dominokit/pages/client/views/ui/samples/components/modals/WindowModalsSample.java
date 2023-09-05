package org.dominokit.pages.client.views.ui.samples.components.modals;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.Dialog;
import org.dominokit.domino.ui.dialogs.DialogSize;
import org.dominokit.domino.ui.dialogs.Window;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

public class WindowModalsSample extends BaseDominoElement<HTMLDivElement, WindowModalsSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    public static WindowModalsSample create() {
        return new WindowModalsSample();
    }

    public WindowModalsSample() {

        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(Button.create("SIMPLE WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("Simple window")
                                                    .setFixed()
                                                    .setStretchWidth(DialogSize.SMALL)
                                                    .setStretchHeight(DialogSize.SMALL)
                                                    .withHeader((parent, header) -> header.addCss(dui_pink))
                                                    .appendChild(text(SAMPLE_CONTENT))
                                                    .open();
                                        })
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("MODAL WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("Modal window")
                                                    .setFixed()
                                                    .setModal(true)
                                                    .setStretchWidth(DialogSize.SMALL)
                                                    .setStretchHeight(DialogSize.SMALL)
                                                    .withHeader((parent, header) -> header.addCss(dui_accent))
                                                    .appendChild(text(SAMPLE_CONTENT))
                                                    .open();
                                        })
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("NO DRAG WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("No drag window")
                                                    .setFixed()
                                                    .setModal(true)
                                                    .setDraggable(false)
                                                    .setStretchWidth(DialogSize.SMALL)
                                                    .setStretchHeight(DialogSize.SMALL)
                                                    .withHeader((parent, header) -> header.addCss(dui_teal))
                                                    .appendChild(text(SAMPLE_CONTENT))
                                                    .open();
                                        })
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("LARGE WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("Large window")
                                                    .setFixed()
                                                    .setModal(true)
                                                    .setStretchWidth(DialogSize.LARGE)
                                                    .setStretchHeight(DialogSize.LARGE)
                                                    .withHeader((parent, header) -> header.addCss(dui_indigo))
                                                    .appendChild(text(SAMPLE_CONTENT))
                                                    .open();
                                        })
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
