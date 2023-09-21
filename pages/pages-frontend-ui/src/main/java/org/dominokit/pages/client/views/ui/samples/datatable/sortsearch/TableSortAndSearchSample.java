package org.dominokit.pages.client.views.ui.samples.datatable.sortsearch;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnFilterMeta;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.datatable.plugins.filter.header.*;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactSearchFilter;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactSorter;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactUiUtils;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.model.ContactsProvider;
import org.dominokit.pages.shared.model.Gender;

public class TableSortAndSearchSample extends BaseDominoElement<HTMLDivElement, TableSortAndSearchSample> {

    private DivElement element;

    public static TableSortAndSearchSample create() {
        return new TableSortAndSearchSample();
    }

    public TableSortAndSearchSample() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .sortable()
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Icons.check_circle().addCss(dui_fg_green_d_3).element();
                            } else {
                                return Icons.close_circle().addCss(dui_fg_red_d_3).element();
                            }
                        })
                        .applyMeta(ColumnFilterMeta.of(BooleanHeaderFilter.<Contact>create("Active", "Inactive", "Both")))
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getName()))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                        .applyMeta(ColumnFilterMeta.of(EnumHeaderFilter.<Contact, Gender>create(Gender.values())))
                )
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                        .applyMeta(ColumnFilterMeta.of(SelectHeaderFilter.<Contact>create()
                                .appendChild(SelectOption.create("blue","blue", "Blue"))
                                .appendChild(SelectOption.create("brown","brown", "Brown"))
                                .appendChild(SelectOption.create("green","green", "Green"))
                        ))
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                        .applyMeta(ColumnFilterMeta.of(DoubleHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getEmail()))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getPhone()))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .addCss(dui_green, dui_float_none)
                                        .element();
                            }
                            return text("");
                        }));

        ColumnHeaderFilterPlugin<Contact> contactColumnHeaderFilterPlugin = ColumnHeaderFilterPlugin.<Contact>create();
        tableConfig
                .addPlugin(new SortPlugin<>())
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                        .addActionElement(dataTable -> Icons.filter_menu_outline()
                                .clickable()
                                .addClickListener(evt -> contactColumnHeaderFilterPlugin.getFiltersRowElement()
                                        .toggleDisplay())
                                .element())
                        .addActionElement(new HeaderBarPlugin.ClearSearch<>())
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<Contact>()
                                .withSearchBox((parent, searchBox) -> {
                                    searchBox.addCss(dui_max_w_64, dui_bg_dominant_d_1, dui_rounded_md);
                                })
                        )
                )
                .addPlugin(contactColumnHeaderFilterPlugin);

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        localListDataStore.setRecordsSorter(new ContactSorter());
        localListDataStore.setSearchFilter(new ContactSearchFilter());
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        this.element = div().addCss(dui_p_2)
                .appendChild(table);

        localListDataStore.setData(ContactsProvider.instance.subList());
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
