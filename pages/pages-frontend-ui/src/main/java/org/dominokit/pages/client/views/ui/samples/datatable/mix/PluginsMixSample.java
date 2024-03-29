package org.dominokit.pages.client.views.ui.samples.datatable.mix;

import static org.dominokit.domino.ui.utils.Domino.a;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_align_middle;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent_d_1;
import static org.dominokit.domino.ui.utils.Domino.dui_border;
import static org.dominokit.domino.ui.utils.Domino.dui_border_accent_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_green_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_float_none;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_p_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_w_24;
import static org.dominokit.domino.ui.utils.Domino.elementOf;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import java.util.List;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnFilterMeta;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.datatable.plugins.filter.header.BooleanHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.DoubleHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.EnumHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.SelectHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.TextHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.grouping.GroupingPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.TopPanelPlugin;
import org.dominokit.domino.ui.datatable.plugins.marker.RowMarkerPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.ScrollingPaginationPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.plugins.selection.SelectionPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactSearchFilter;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactSorter;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactUiUtils;
import org.dominokit.pages.client.views.ui.samples.datatable.ContactsTopPanel;
import org.dominokit.pages.client.views.ui.samples.datatable.details.ContactDetails;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.model.ContactsProvider;
import org.dominokit.pages.shared.model.Gender;

public class PluginsMixSample extends BaseDominoElement<HTMLDivElement, PluginsMixSample> {

    private DivElement element;

    public static PluginsMixSample create() {
        return new PluginsMixSample();
    }

    public PluginsMixSample() {
        ContactsTopPanel<Contact> topPanel = new ContactsTopPanel<>();
        ScrollingPaginationPlugin<Contact> scrollingPaginationPlugin = new ScrollingPaginationPlugin<>(10, 5);
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .styleCell(cellElement -> elementOf(cellElement).addCss(dui_align_middle))
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                        .setWidth("70px")
                )
                .addColumn(ColumnConfig.<Contact>create("group 1", "Group 1")
                        .addColumn(ColumnConfig.<Contact>create("status", "Status")
                                .setWidth("80px")
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
                                .setWidth("200px")
                                .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("group 2", "Group 2")
                        .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                                .setWidth("100px")
                                .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                                .setTextAlign(CellTextAlign.CENTER)
                                .applyMeta(ColumnFilterMeta.of(EnumHeaderFilter.<Contact, Gender>create(Gender.values())))
                        )
                        .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                                .styleHeader(head -> elementOf(head).addCss(dui_w_24))
                                .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                                .setTextAlign(CellTextAlign.CENTER)
                                .maxWidth("120px")
                                .applyMeta(ColumnFilterMeta.of(SelectHeaderFilter.<Contact>create()
                                                .appendChild(SelectOption.create("blue", "Blue"))
                                                .appendChild(SelectOption.create("brown", "Brown"))
                                                .appendChild(SelectOption.create("green", "Green"))
                                        )
                                )
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("group 3", "Group 3")
                        .addColumn(ColumnConfig.<Contact>create("group 2", "Group 2")
                                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                                        .sortable()
                                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                                        .setWidth("200px")
                                        .applyMeta(ColumnFilterMeta.of(DoubleHeaderFilter.<Contact>create()))
                                )
                                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                                        .setWidth("250px")
                                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getEmail()))
                                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                                )
                        )
                        .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                                .setWidth("200px")
                                .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getPhone()))
                                .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                        )
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
                .addPlugin(scrollingPaginationPlugin)
                .addPlugin(new TopPanelPlugin<Contact>() {

                    @Override
                    public HTMLElement element() {
                        return topPanel.element();
                    }

                    @Override
                    public void handleEvent(TableEvent event) {
                        if (TableDataUpdatedEvent.DATA_UPDATED.equals(event.getType())) {
                            topPanel.update((TableDataUpdatedEvent<Contact>) event);
                        }
                    }
                })
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                        .addActionElement(dataTable -> {
                            Icon<?> selectInactiveIcon = Icons.close_circle()
                                    .clickable()
                                    .setTooltip("Select Inactive")
                                    .addClickListener(evt ->
                                            dataTable.getRows().forEach(item -> {
                                                if (!item.getRecord().isActive()) {
                                                    item.select();
                                                } else {
                                                    item.deselect();
                                                }
                                            }));

                            return a().appendChild(selectInactiveIcon).element();
                        })
                        .addActionElement(dataTable -> {
                            Icon<?> selectInactiveIcon = Icons.check_circle()
                                    .clickable()
                                    .setTooltip("Select Active")
                                    .addClickListener(evt ->
                                            dataTable.getRows().forEach(tableRow -> {
                                                if (tableRow.getRecord().isActive()) {
                                                    tableRow.select();
                                                } else {
                                                    tableRow.deselect();
                                                }
                                            }));

                            return a().appendChild(selectInactiveIcon).element();

                        })
                )
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()))
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RowMarkerPlugin<>(cellInfo -> ContactUiUtils.getBalanceColor(cellInfo.getRecord()).color().getContextColor()))
                .addPlugin(new SortPlugin<>())
                .addPlugin(ColumnHeaderFilterPlugin.<Contact>create())
                .addPlugin(new GroupingPlugin<>(tableRow -> tableRow.getRecord().getGender().toString(),
                        cellInfo -> {
                            elementOf(cellInfo.getElement())
                                    .addCss(dui_border,
                                            dui_border_accent_d_3,
                                            dui_border_solid,
                                            dui_p_1,
                                            dui_bg_accent_d_1, dui_fg_white
                                    );
                            return text(cellInfo.getRecord().getGender().getLabel());
                        }));

        LocalListDataStore<Contact> localListDataSource = new LocalListDataStore<Contact>()
                .setSearchFilter(new ContactSearchFilter())
                .setRecordsSorter(new ContactSorter())
                .setPagination(scrollingPaginationPlugin.getPagination());

        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataSource);

        this.element = div().addCss(dui_p_2)
                .appendChild(table);

        List<Contact> data = ContactsProvider.instance.subList(80);
        localListDataSource.setData(data);
        topPanel.update(data);
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
