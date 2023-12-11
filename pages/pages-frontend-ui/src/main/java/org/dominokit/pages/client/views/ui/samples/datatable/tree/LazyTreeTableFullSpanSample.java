package org.dominokit.pages.client.views.ui.samples.datatable.tree;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_green_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_float_none;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_m_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.p;
import static org.dominokit.domino.ui.utils.Domino.td;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLTableCellElement;
import java.util.Collections;
import java.util.Optional;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.marker.RowMarkerPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.plugins.selection.SelectionPlugin;
import org.dominokit.domino.ui.datatable.plugins.tree.TreeGridPlugin;
import org.dominokit.domino.ui.datatable.plugins.tree.store.LocalTreeDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactUiUtils;
import org.dominokit.pages.client.views.ui.samples.datatable.details.ContactDetails;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.model.ContactsProvider;

public class LazyTreeTableFullSpanSample extends BaseDominoElement<HTMLDivElement, LazyTreeTableFullSpanSample> {

    private DivElement element;

    public static LazyTreeTableFullSpanSample create() {
        return new LazyTreeTableFullSpanSample();
    }

    public LazyTreeTableFullSpanSample() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
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
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
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
                        }))
                .onUtilityColumn(utilityColumn -> {
                    utilityColumn
                            .setTitle("First name")
                            .setSortable(true, "id");
                })
                .setMultiSelect(true)
                .addPlugin(new SortPlugin<>())
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()))
                .addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord()).color().getContextColor()))
                .addPlugin(new TreeGridPlugin<Contact>()
                        .configure(config -> {
                            config
                                    .setIndentColumnElementSupplier(tableRow -> p(tableRow.getRecord().getName()).addCss(dui_m_0).element())
                                    .setParentRowCellsSupplier((dataTable, tableRow) -> {
                                        HTMLTableCellElement cellElement = td()
                                                .setAttribute("colspan", "8")
                                                .element();
                                        RowCell<Contact> rowCell =
                                                new RowCell<>(new CellRenderer.CellInfo<>(tableRow, cellElement), dataTable.getTableConfig().getColumnByName("id"));
                                        return Collections.singletonList(rowCell);
                                    })
                                    .setIndent(60);
                        })
                )
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                );

        LocalTreeDataStore<Contact> localListDataStore = new LocalTreeDataStore<>((parent, itemsConsumer) -> {
            // If the friend is in the max depth it will automatically set has children to false, check ContactsProvider.instance.addFriends method
            ContactsProvider.instance.addFriends(parent, 2, 1, 2);
            itemsConsumer.accept(Optional.ofNullable(parent.getFriends()));
        }, Contact::isHasChildren);
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        this.element = div().addCss(dui_p_2)
                .appendChild(table);

        localListDataStore.setData(ContactsProvider.instance.subList(20));
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
