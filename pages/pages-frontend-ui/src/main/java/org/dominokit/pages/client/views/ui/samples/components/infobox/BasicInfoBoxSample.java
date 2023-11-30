package org.dominokit.pages.client.views.ui.samples.components.infobox;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.counter.Counter;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.infoboxes.InfoBox;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class BasicInfoBoxSample extends BaseDominoElement<HTMLDivElement, BasicInfoBoxSample> {
    private DivElement element;
    private Counter counter;

    public static BasicInfoBoxSample create() {
        return new BasicInfoBoxSample();
    }

    public BasicInfoBoxSample() {
        this.element = div().addCss(dui_p_2);
        element.appendChild(Row.create()
                .appendChild(Column.span3()
                        .appendChild(InfoBox.create(Icons.cart(), "NEW ORDERS", "125")
                                .withIcon((infoBox, icon) -> icon.addCss(dui_red))
                        )
                )
                .appendChild(Column.span3()
                        .appendChild(InfoBox.create(Icons.face_man(), "NEW MEMBERS", "257")
                                .withIcon((infoBox, icon) -> icon.addCss(dui_indigo))
                        )
                )
                .appendChild(Column.span3()
                        .appendChild(InfoBox.create(Icons.cart(), "BOOKMARKS", "117")
                                .withIcon((infoBox, icon) -> icon.addCss(dui_purple))
                        )
                )
                .appendChild(Column.span3().appendChild(InfoBox.create(Icons.star(), "LIKES", "1432")
                                .withIcon((infoBox, icon) -> icon.addCss(dui_deep_purple))
                        )
                ));

        InfoBox new_orders = InfoBox.create(Icons.cart(), "NEW ORDERS", "0")
                .setHoverEffect(InfoBox.HoverEffect.ZOOM)
                .withIcon((parent, icon) -> icon.addCss(dui_red));
        InfoBox new_members = InfoBox.create(Icons.face_man(), "NEW MEMBERS", "0")
                .setHoverEffect(InfoBox.HoverEffect.ZOOM)
                .withIcon((parent, icon) -> icon.addCss(dui_indigo));
        InfoBox bookmarks = InfoBox.create(Icons.cart(), "BOOKMARKS", "0")
                .setHoverEffect(InfoBox.HoverEffect.ZOOM)
                .withIcon((parent, icon) -> icon.addCss(dui_purple));
        InfoBox likes = InfoBox.create(Icons.star(), "LIKES", "0")
                .setHoverEffect(InfoBox.HoverEffect.ZOOM)
                .withIcon((parent, icon) -> icon.addCss(dui_deep_purple));

        element.appendChild(Row.create()
                .appendChild(Column.span3()
                        .appendChild(new_orders)
                )
                .appendChild(Column.span3()
                        .appendChild(new_members)
                )
                .appendChild(Column.span3()
                        .appendChild(bookmarks)
                )
                .appendChild(Column.span3()
                        .appendChild(likes)
                )
        );

        counter = Counter.countFrom(0)
                .countTo(125)
                .every(60)
                .incrementBy(5)
                .onCount(count -> {
                    new_orders.getInfo().setTextContent(Integer.toString(count));
                    new_members.getInfo().setTextContent(Integer.toString(count));
                    bookmarks.getInfo().setTextContent(Integer.toString(count));
                    likes.getInfo().setTextContent(Integer.toString(count));
                });
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
