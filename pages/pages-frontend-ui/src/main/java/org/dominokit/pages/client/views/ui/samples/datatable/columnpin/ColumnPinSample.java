package org.dominokit.pages.client.views.ui.samples.datatable.columnpin;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta;
import org.dominokit.domino.ui.datatable.plugins.column.PinColumnsPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactUiUtils;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.model.ContactsProvider;

public class ColumnPinSample extends BaseDominoElement<HTMLDivElement, ColumnPinSample> {

    private DivElement element;

    public static ColumnPinSample create() {
        return new ColumnPinSample();
    }

    public ColumnPinSample() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                        .setWidth("100px")
                        .minWidth("100px")
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
                        .setWidth("100px")
                        .minWidth("100px")
                        .applyMeta(PinColumnMeta.left())
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getName()))
                        .setWidth("200px")
                        .minWidth("200px")
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                        .setWidth("200px")
                        .minWidth("200px")
                )
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                        .setWidth("200px")
                        .minWidth("200px")
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                        .setWidth("400px")
                )
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getEmail()))
                        .setWidth("400px")
                        .minWidth("400px")
                )
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getPhone()))
                        .setWidth("400px")
                        .minWidth("400px")
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .addCss(dui_green, dui_float_none)
                                        .element();
                            }
                            return text("");
                        })
                        .setWidth("110px")
                        .minWidth("110px")
                        .applyMeta(PinColumnMeta.right())
                )
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                )
                .addPlugin(new PinColumnsPlugin<Contact>().configure(config -> config.setShowPinMenu(true).setShowPinIcon(true)));
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
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
