package org.dominokit.pages.client.views.ui.samples.datatable.tree;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.marker.RowMarkerPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.plugins.selection.SelectionPlugin;
import org.dominokit.domino.ui.datatable.plugins.tree.TreeGridPlugin;
import org.dominokit.domino.ui.datatable.plugins.tree.store.LocalTreeDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactSorter;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactUiUtils;
import org.dominokit.pages.client.views.ui.samples.datatable.details.ContactDetails;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.model.ContactsProvider;

import java.util.Optional;

import static org.dominokit.domino.ui.utils.Domino.*;

public class LazyTreeTableLargeDataSetSample extends BaseDominoElement<HTMLDivElement, LazyTreeTableLargeDataSetSample> {

    private DivElement element;

    public static LazyTreeTableLargeDataSetSample create() {
        return new LazyTreeTableLargeDataSetSample();
    }

    public LazyTreeTableLargeDataSetSample() {

        IntegerBox rootsCount = IntegerBox.create("Roots count").withValue(50);
        IntegerBox leafCounts = IntegerBox.create("Leaves count").withValue(3);
        IntegerBox depth = IntegerBox.create("Depth").withValue(3);
        Button updateListButton = Button.create("Update");

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setSortable(true)
                        .setWidth("50px")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setWidth("100px")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Icons.check_circle().addCss(dui_fg_green_d_3).element();
                            } else {
                                return Icons.close_circle().addCss(dui_fg_red_d_3).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .setWidth("100px")
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .setWidth("100px")
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                        .setWidth("200px")
                )

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getEmail()))
                        .setWidth("200px")
                )

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getPhone()))
                        .setWidth("300px")
                )

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setWidth("100px")
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
                            .setSortable(true, "id")
                            .setTitle("First name");
                })
                .setMultiSelect(true)
                .addPlugin(new SortPlugin<>())
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()))
                .addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord()).color().getContextColor()))
                .addPlugin(new TreeGridPlugin<Contact>()
                        .configure(config -> {
                            config.setIndentColumnElementSupplier(tableRow -> p(tableRow.getRecord().getName()).addCss(dui_m_0).element())
                                    .setIndent(60)
                                    .setLazy(true);
                        })
                )
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                );

        LocalTreeDataStore<Contact> localListDataStore = new LocalTreeDataStore<>((parent, itemsConsumer) -> {
            ContactsProvider.instance.addFriends(parent, leafCounts.getValue(), 1, depth.getValue());
            itemsConsumer.accept(Optional.ofNullable(parent.getFriends()));
        });
        localListDataStore.setRecordsSorter(new ContactSorter());
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span3().appendChild(rootsCount))
                        .appendChild(Column.span3().appendChild(leafCounts))
                        .appendChild(Column.span3().appendChild(depth))
                        .appendChild(Column.span3().appendChild(updateListButton))
                )
                .appendChild(new TableStyleActions(table))
                .appendChild(table);

        localListDataStore.setData(ContactsProvider.instance.subList(20));
        updateListButton.addClickListener(evt -> localListDataStore.setData(ContactsProvider.instance.subList(rootsCount.getValue())));
        localListDataStore.setData(ContactsProvider.instance.subList(rootsCount.getValue()));
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }

    public static class TableStyleActions extends BaseDominoElement<HTMLDivElement, TableStyleActions> {

        private DataTable<?> dataTable;
        private DivElement root;

        public TableStyleActions(DataTable<?> dataTable) {
            this.dataTable = dataTable;
            this.root = div().addCss(dui_flex, dui_gap_4, dui_justify_end, dui_p_4);
            init();
        }

        private void init() {
            this.root
                    .appendChild(createAction("Condense", "Expand", Icons.arrow_collapse_vertical(), Icons.arrow_expand_vertical(), ()->dataTable.setCondensed(true), ()->dataTable.setCondensed(false), dataTable::isCondensed))
                    .appendChild(createAction("No Stripes", "Stripped", Icons.view_day_outline(), Icons.view_day(), ()->dataTable.setStriped(true), ()->dataTable.setStriped(false), dataTable::isStriped))
                    .appendChild(createAction("No Borders", "Borders", Icons.border_vertical(), Icons.border_none(), ()->dataTable.setBordered(true), ()->dataTable.setBordered(false), dataTable::isBordered))
                    .appendChild(createAction("No Hover", "Hovered", Icons.blur_off(), Icons.blur(), ()->dataTable.setHover(false), ()->dataTable.setHover(true), () -> !dataTable.isHover()));

        }

        private ToggleMdiIcon createAction(String initialTooltip, String toggeledTooltip, MdiIcon initialIcon, MdiIcon toggeledIcon, Action initialAction, Action toggeledAction, Condition condition) {
            return ToggleMdiIcon.create(initialIcon, toggeledIcon)
                    .clickable(true)
                    .setTooltip(initialTooltip)
                    .toggleOnClick(true)
                    .apply(self -> {
                        self.addClickListener(evt -> {
                            if (condition.check()) {
                                toggeledAction.execute();
                                self.setTooltip(initialTooltip);
                            } else {
                                initialAction.execute();
                                self.setTooltip(toggeledTooltip);
                            }
                        });
                    });

        }

        @Override
        public HTMLDivElement element() {
            return this.root.element();
        }

        @FunctionalInterface
        private interface Action {
            void execute();
        }

        @FunctionalInterface
        public interface Condition {
            boolean check();
        }
    }
}
