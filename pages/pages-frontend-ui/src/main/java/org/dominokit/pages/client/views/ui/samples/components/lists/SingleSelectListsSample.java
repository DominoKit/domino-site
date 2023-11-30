package org.dominokit.pages.client.views.ui.samples.components.lists;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pages.client.views.ui.ContactUiUtils;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.service.DemoServiceFactory;

import java.util.Random;

import static org.dominokit.domino.ui.utils.Domino.*;

public class SingleSelectListsSample extends BaseDominoElement<HTMLDivElement, SingleSelectListsSample> {

    private DivElement element;

    public static SingleSelectListsSample create() {
        return new SingleSelectListsSample();
    }

    public SingleSelectListsSample() {
        ListGroup<Contact> singleSelectList;
        this.element = div().addCss(dui_p_2)
                .appendChild(singleSelectList = ListGroup.<Contact>create()
                        .setItemRenderer((listGroup, item) -> {
                            item
                                    .setSelectable(true)
                                    .appendChild(div().addCss(dui_flex, dui_items_center, dui_h_16, BooleanCssClass.of(dui_opacity_50, !item.getValue().isActive()))
                                            .appendChild(span().addCss(dui_h_full, dui_w_1, dui_self_stretch, ContactUiUtils.getColor(item.getValue()).getBackground()))
                                            .appendChild(img(ContactUiUtils.getAvatarUrl(item.getValue()))
                                                    .addCss(dui_h_16, dui_w_16)
                                                    .setOrRemoveCssProperty("filter", "grayscale(100%)", imageElement -> !item.getValue().isActive())
                                            )
                                            .appendChild(span()
                                                    .textContent(item.getValue().getName())
                                                    .addCss(dui_grow_1, dui_p_1)
                                            )
                                            .appendChild(Badge
                                                    .create(String.valueOf(item.getValue().getBalance()))
                                                    .addCss(ContactUiUtils.getColor(item.getValue()).getCss(), dui_fg_white, dui_order_none)
                                            )
                                            .appendChild(ContactUiUtils.getGenderElement(item.getValue()))
                                    )
                                    .setDisabled(!item.getValue().isActive())
                                    .addSelectionListener((source, selection) -> {
                                        item.addCss(BooleanCssClass.of(dui_bg_accent_l_4, selection.contains(item)));
                                    });
                        })
                )
        ;

        Random random = new Random();
        int i = random.nextInt(100 - 10);
        DemoServiceFactory.INSTANCE
                .list()
                .onSuccess(items -> {
                    singleSelectList.setItems(items.subList(i, i + 10));
                })
                .onFailed(failedResponse -> {
                })
                .send();
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
