package org.dominokit.pages.client.views.ui.samples.datatable.menu;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_green_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_float_none;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.menu.RowContextMenuMeta;
import org.dominokit.domino.ui.datatable.plugins.menu.RowContextMenuPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.menu.direction.MouseBestFitDirection;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactUiUtils;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.model.ContactsProvider;

public class RowMenuSample extends BaseDominoElement<HTMLDivElement, RowMenuSample> {

    private DivElement element;

    public static RowMenuSample create() {
        return new RowMenuSample();
    }

    public RowMenuSample() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
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
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getName()))
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                )

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                )

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getEmail()))
                )

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getPhone()))
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

                )
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                )
                .addPlugin(new RowContextMenuPlugin<>(Menu.<String>create()
                                .appendChild(MenuItem.<String>create("Show notification").withValue("notify"))
                                .appendChild(MenuItem.<String>create("Activate").withValue("activate"))
                                .appendChild(MenuItem.<String>create("Disable").withValue("disable"))
                                .setContextMenu(true)
                                .setDropDirection(new MouseBestFitDirection())
                                .apply(self -> self.addSelectionListener((source, selection) -> {
                                            TableRow<Contact> tableRow = RowContextMenuMeta.<Contact>get(self).get().getTableRow();
                                            source.ifPresent(menuItem -> {
                                                switch (menuItem.getValue()) {
                                                    case "notify":
                                                        Notification.create(tableRow.getRecord().getName()).show();
                                                        break;
                                                    case "activate": {
                                                        tableRow.getRecord().setActive(true);
                                                        tableRow.updateRow();
                                                        break;
                                                    }
                                                    case "disable": {
                                                        tableRow.getRecord().setActive(false);
                                                        tableRow.updateRow();
                                                        break;
                                                    }
                                                }
                                            });

                                        })
                                )
                        )
                )
        ;

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
