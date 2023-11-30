package org.dominokit.pages.client.views.ui.samples.datatable;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pages.client.views.ui.samples.datatable.details.ContactDetails;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.model.ContactsProvider;

import static org.dominokit.domino.ui.utils.Domino.*;

public class RecordDetailsSample extends BaseDominoElement<HTMLDivElement, RecordDetailsSample> {

    private DivElement element;

    public static RecordDetailsSample create() {
        return new RecordDetailsSample();
    }

    public RecordDetailsSample() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setCellRenderer(cell1 -> text(cell1.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setCellRenderer(cell1 -> {
                            if (cell1.getTableRow().getRecord().isActive()) {
                                return Icons.check_circle().addCss(dui_fg_green_d_3).element();
                            } else {
                                return Icons.close_circle().addCss(dui_fg_red_d_3).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell1 -> text(cell1.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell1 -> ContactUiUtils.getGenderElement(cell1.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                )

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell1 -> ContactUiUtils.getEyeColorElement(cell1.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                )

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell1 -> text(cell1.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell1 -> text(cell1.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell1 -> {
                            if (cell1.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .addCss(dui_green, dui_float_none)
                                        .element();
                            }
                            return text("");
                        }))

                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                );

        tableConfig.addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()));
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
