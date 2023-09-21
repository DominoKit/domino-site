package org.dominokit.pages.client.views.ui.samples.datatable.pagination;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.ScrollingPaginationPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SimplePaginationPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactSearchFilter;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactSorter;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactUiUtils;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.model.ContactsProvider;

public class ScrollingPaginationSample extends BaseDominoElement<HTMLDivElement, ScrollingPaginationSample> {

    private DivElement element;

    public static ScrollingPaginationSample create() {
        return new ScrollingPaginationSample();
    }

    public ScrollingPaginationSample() {
        ScrollingPaginationPlugin<Contact> scrollingPagination = new ScrollingPaginationPlugin<>(10, 5);//page size
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .sortable()
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
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getName())))

                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .addCss(dui_green, dui_float_none)
                                        .element();
                            }
                            return text("");
                        }));

        tableConfig
                .addPlugin(new SortPlugin<>())

                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                        .addActionElement(new HeaderBarPlugin.ClearSearch<>())
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<Contact>()
                                .withSearchBox((parent, searchBox) -> {
                                    searchBox.addCss(dui_max_w_64, dui_bg_dominant_d_1, dui_rounded_md);
                                })
                        )
                )
                .addPlugin(scrollingPagination);

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        localListDataStore.setRecordsSorter(new ContactSorter());
        localListDataStore.setSearchFilter(new ContactSearchFilter());
        localListDataStore.setPagination(scrollingPagination.getPagination());
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        this.element = div().addCss(dui_p_2)
                .appendChild(table);

        localListDataStore.setData(ContactsProvider.instance.subList(100));
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
