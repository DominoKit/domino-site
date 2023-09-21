package org.dominokit.pages.client.views.ui.samples.datatable.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.BodyScrollPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.datatable.store.LocalListScrollingDataSource;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactSearchFilter;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactSorter;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactUiUtils;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.model.ContactsProvider;

public class ScrollLoadingSample extends BaseDominoElement<HTMLDivElement, ScrollLoadingSample> {

    private DivElement element;

    public static ScrollLoadingSample create() {
        return new ScrollLoadingSample();
    }

    public ScrollLoadingSample() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .styleCell(cellElement -> elementOf(cellElement).addCss(dui_align_middle))
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getIndex() + 1 + "")))
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Icons.check_circle().addCss(dui_fg_green_d_3).element();
                            } else {
                                return Icons.close_circle().addCss(dui_fg_red_d_3).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getName()))
                        .setWidth("200px"))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER))
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .styleHeader(head -> elementOf(head).addCss(dui_w_24))
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                        .setWidth("250px"))
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setWidth("250px")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getEmail())))
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setWidth("150px")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getPhone())))
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .addCss(dui_green, dui_float_none)
                                        .element();
                            }
                            return text("");
                        }))
                .addPlugin(new BodyScrollPlugin<>())
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                )
                .addPlugin(new SortPlugin<>());

        LocalListScrollingDataSource<Contact> scrollingDataSource = new LocalListScrollingDataSource<Contact>(10)
                .setSearchFilter(new ContactSearchFilter())
                .setRecordsSorter(new ContactSorter());

        DataTable<Contact> table = new DataTable<>(tableConfig, scrollingDataSource);

        this.element = div().addCss(dui_p_2)
                .appendChild(table);

        scrollingDataSource.setData(ContactsProvider.instance.subList(100));
        scrollingDataSource.load();
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
