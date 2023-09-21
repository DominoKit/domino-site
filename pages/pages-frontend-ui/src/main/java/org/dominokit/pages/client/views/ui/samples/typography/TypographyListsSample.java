package org.dominokit.pages.client.views.ui.samples.typography;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class TypographyListsSample extends BaseDominoElement<HTMLDivElement, TypographyListsSample> {

    private DivElement element;

    public static TypographyListsSample create() {
        return new TypographyListsSample();
    }

    public TypographyListsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(ul()
                                        .appendChild(li().textContent("Lorem ipsum dolor sit amet"))
                                        .appendChild(li().textContent("Consectetur adipiscing elit"))
                                        .appendChild(li().textContent("Integer molestie lorem at massa"))
                                        .appendChild(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .appendChild(li().textContent("Nulla volutpat aliquam velit")
                                                .appendChild(ul()
                                                        .appendChild(li().textContent("Phasellus iaculis neque"))
                                                        .appendChild(li().textContent("Purus sodales ultricies"))
                                                        .appendChild(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .appendChild(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .appendChild(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .appendChild(li().textContent("Aenean sit amet erat nunc"))
                                        .appendChild(li().textContent("Eget porttitor lorem")))
                        )
                        .appendChild(Column.span4()
                                .appendChild(ol()
                                        .appendChild(li().textContent("Lorem ipsum dolor sit amet"))
                                        .appendChild(li().textContent("Consectetur adipiscing elit"))
                                        .appendChild(li().textContent("Integer molestie lorem at massa"))
                                        .appendChild(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .appendChild(li().textContent("Nulla volutpat aliquam velit")
                                                .appendChild(ol()
                                                        .appendChild(li().textContent("Phasellus iaculis neque"))
                                                        .appendChild(li().textContent("Purus sodales ultricies"))
                                                        .appendChild(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .appendChild(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .appendChild(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .appendChild(li().textContent("Aenean sit amet erat nunc"))
                                        .appendChild(li().textContent("Eget porttitor lorem"))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(ul().addCss(dui_list_none)
                                        .appendChild(li().textContent("Lorem ipsum dolor sit amet"))
                                        .appendChild(li().textContent("Consectetur adipiscing elit"))
                                        .appendChild(li().textContent("Integer molestie lorem at massa"))
                                        .appendChild(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .appendChild(li().textContent("Nulla volutpat aliquam velit")
                                                .appendChild(ul().addCss(dui_list_none)
                                                        .appendChild(li().textContent("Phasellus iaculis neque"))
                                                        .appendChild(li().textContent("Purus sodales ultricies"))
                                                        .appendChild(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .appendChild(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .appendChild(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .appendChild(li().textContent("Aenean sit amet erat nunc"))
                                        .appendChild(li().textContent("Eget porttitor lorem"))
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
