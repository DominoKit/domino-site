package org.dominokit.pages.client.views.ui.samples.datatable;

import elemental2.dom.HTMLElement;
import java.util.List;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.infoboxes.InfoBox;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.style.DisplayCss;
import org.dominokit.domino.ui.style.SpacingCss;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.model.Gender;

public class ContactsTopPanel<T> implements IsElement<HTMLElement> {

    private InfoBox loaded_items_count = InfoBox.create(Icons.timelapse(), "LOADED COUNT", "0")
            .withContent((parent, self) -> self.addCss(SpacingCss.dui_items_start))
            .withIcon((parent, self) -> self.addCss(ColorsCss.dui_bg_dominant, ColorsCss.dui_fg_indigo_l_1))
            .addCss(ColorsCss.dui_fg_indigo_l_1, DisplayCss.dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox totalItemsCount = InfoBox.create(Icons.timelapse(), "TOTAL COUNT", "0")
            .withContent((parent, self) -> self.addCss(SpacingCss.dui_items_start))
            .withIcon((parent, self) -> self.addCss(ColorsCss.dui_bg_dominant, ColorsCss.dui_fg_indigo_l_1))
            .addCss(ColorsCss.dui_fg_indigo_l_1, DisplayCss.dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox femaleCount = InfoBox.create(Icons.gender_female(), "FEMALES", "0")
            .withContent((parent, self) -> self.addCss(SpacingCss.dui_items_start))
            .withIcon((parent, self) -> self.addCss(ColorsCss.dui_fg_pink, ColorsCss.dui_bg_dominant))
            .addCss(ColorsCss.dui_fg_pink, DisplayCss.dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox maleCount = InfoBox.create(Icons.gender_male(), "MALES", "0")
            .withContent((parent, self) -> self.addCss(SpacingCss.dui_items_start))
            .withIcon((parent, self) -> self.addCss(ColorsCss.dui_fg_blue, ColorsCss.dui_bg_dominant))
            .addCss(ColorsCss.dui_fg_blue, DisplayCss.dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox goodCount = InfoBox.create(Icons.timelapse(), "GOOD BALANCE ", "0")
            .withContent((parent, self) -> self.addCss(SpacingCss.dui_items_start))
            .withIcon((parent, self) -> self.addCss(ColorsCss.dui_fg_green, ColorsCss.dui_bg_dominant))
            .addCss(ColorsCss.dui_fg_green, DisplayCss.dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox dangerCount = InfoBox.create(Icons.timelapse(), "LOW BALANCE", "0")
            .withContent((parent, self) -> self.addCss(SpacingCss.dui_items_start))
            .withIcon((parent, self) -> self.addCss(ColorsCss.dui_fg_red, ColorsCss.dui_bg_dominant))
            .addCss(ColorsCss.dui_fg_red, DisplayCss.dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private Row row = Row.create()
            .addCss(SpacingCss.dui_gap_0)
            .span2(loaded_items_count)
            .span2(totalItemsCount)
            .span2(femaleCount)
            .span2(maleCount)
            .span2(goodCount)
            .span2(dangerCount);

    public ContactsTopPanel() {

    }

    public void update(TableDataUpdatedEvent<Contact> event) {
        loaded_items_count.setInfo(event.getData().size() + "");
    }

    @Override
    public HTMLElement element() {
        return row.element();
    }

    public void update(List<Contact> contacts) {
        totalItemsCount.setInfo(contacts.size() + "");

        long males = contacts.stream().filter(c -> Gender.male.equals(c.getGender())).count();
        long females = contacts.stream().filter(c -> Gender.female.equals(c.getGender())).count();
        long goods = contacts.stream().filter(c -> c.getBalance() >= 2000).count();
        long bads = contacts.stream().filter(c -> c.getBalance() < 2000).count();

        this.femaleCount.setInfo(females + "");
        this.maleCount.setInfo(males + "");
        this.goodCount.setInfo(goods + "");
        this.dangerCount.setInfo(bads + "");
    }
}
