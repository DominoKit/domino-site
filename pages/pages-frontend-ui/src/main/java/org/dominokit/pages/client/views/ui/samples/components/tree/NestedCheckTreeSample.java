package org.dominokit.pages.client.views.ui.samples.components.tree;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.tree.ToggleTarget;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.tree.CheckTree;
import org.dominokit.pro.domino.ui.tree.CheckTreeItem;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class NestedCheckTreeSample extends BaseDominoElement<HTMLDivElement, NestedCheckTreeSample> {
    private DivElement element;

    public static NestedCheckTreeSample create() {
        return new NestedCheckTreeSample();
    }

    public NestedCheckTreeSample() {

        CheckTree<String> hardwareTree = CheckTree.<String>create("HARDWARE")
                .addNodeActivationListener((parent, self) -> {
                    Notification.create(self.getValue()).show();
                })
                .appendChild(CheckTreeItem.create(Icons.desktop_classic(), "Computer")
                        .addSelectionChangeListener((source, selection) -> Notification.create("Computer").show())
                        .appendChild(CheckTreeItem.create(Icons.headset(), "Headset")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Headset").show()))
                        .appendChild(CheckTreeItem.create(Icons.keyboard(), "Keyboard")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Keyboard").show()))
                        .appendChild(CheckTreeItem.create(Icons.mouse(), "Mouse")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Mouse").show())))

                .appendChild(CheckTreeItem.create(Icons.laptop(), "Laptop")
                        .addSelectionChangeListener((source, selection) -> Notification.create("Laptop").show())

                        .appendChild(CheckTreeItem.create(Icons.laptop(), "Chromebook")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Chromebook").show()))
                        .appendChild(CheckTreeItem.create(Icons.laptop_account(), "MacBook")
                                .addSelectionChangeListener((source, selection) -> Notification.create("MacBook").show())))

                .appendChild(CheckTreeItem.create(Icons.cellphone(), "Smart phone")
                        .addSelectionChangeListener((source, selection) -> Notification.create("Smart phone").show())
                        .appendChild(CheckTreeItem.create(Icons.tablet(), "Tablet")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Tablet").show()))
                        .appendChild(CheckTreeItem.create(Icons.cellphone(), "Android")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Android").show()))
                        .appendChild(CheckTreeItem.create(Icons.cellphone_cog(), "iPhone")
                                .addSelectionChangeListener((source, selection) -> Notification.create("iPhone").show())));


        CheckTree<String> hardwareMenu2 = CheckTree.<String>create("FILES")
                .setToggleTarget(ToggleTarget.ICON)
                .setAutoCollapse(false)
                .addSelectionChangeListener((treeItem, selection) -> DomGlobal.console.info(treeItem.get().getValue()))
                .withHeader((tree, header)-> {
                    header.withPostfixElement((head, postfix) -> {
                        postfix.appendChild(Icons.checkbox_multiple_outline().clickable().addClickListener(evt-> tree.selectAll()));
                        postfix.appendChild(Icons.checkbox_multiple_blank_outline().clickable().addClickListener(evt-> tree.deselectAll()));
                    });
                })

                .appendChild(CheckTreeItem.create(Icons.folder(), "Folder")
                        .addSelectionChangeListener((source, selection) -> Notification.create("Folder").show())
                        .appendChild(CheckTreeItem.create(Icons.folder_star(), "My files")
                                .addSelectionChangeListener((source, selection) -> Notification.create("My files").show())
                                .appendChild(CheckTreeItem.create(Icons.note(), "File 1")
                                        .addSelectionChangeListener((source, selection) -> Notification.create("File 1").show()))
                                .appendChild(CheckTreeItem.create(Icons.note(), "File 2")
                                        .addSelectionChangeListener((source, selection) -> Notification.create("File 2").show()))
                                .appendChild((CheckTreeItem.create(Icons.note(), "File 3"))
                                        .addSelectionChangeListener((source, selection) -> Notification.create("File 3").show()))
                                .appendChild(CheckTreeItem.create(Icons.note(), "File 4")
                                        .addSelectionChangeListener((source, selection) -> Notification.create("File 4").show()))
                        )
                        .appendChild(CheckTreeItem.create(Icons.file_upload(), "Upload"))
                        .appendChild(CheckTreeItem.create(Icons.file_download(), "Download"))
                        .appendChild(CheckTreeItem.create(Icons.folder_plus(), "New folder"))
                        .appendChild(CheckTreeItem.create(Icons.folder_account(), "Shared"))
                        .appendChild(CheckTreeItem.create(Icons.attachment(), "Attachments"))
                ).appendChild(CheckTreeItem.create(Icons.cloud(), "Cloud")
                        .appendChild(CheckTreeItem.create(Icons.cloud_upload(), "Upload"))
                        .appendChild(CheckTreeItem.create(Icons.cloud_download(), "Download"))
                        .appendChild(CheckTreeItem.create(Icons.cloud_off_outline(), "Offline"))
                        .appendChild(CheckTreeItem.create(Icons.cloud_question(), "Queue"))
                );

        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Auto collapse"))
                                .appendChild(hardwareTree)
                        )
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Auto collapse OFF"))
                                .appendChild(hardwareMenu2)
                        )
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
