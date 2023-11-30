package org.dominokit.pages.client.views.ui.samples.components.tree;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.tree.ToggleTarget;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class NestedTreeSample extends BaseDominoElement<HTMLDivElement, NestedTreeSample> {
    private DivElement element;

    public static NestedTreeSample create() {
        return new NestedTreeSample();
    }

    public NestedTreeSample() {

        Tree<String> hardwareTree = Tree.<String>create("HARDWARE")
                .appendChild(TreeItem.create(Icons.desktop_classic(), "Computer")
                        .addClickListener(evt -> Notification.create("Computer").show())
                        .appendChild(TreeItem.create(Icons.headset(), "Headset")
                                .addClickListener(evt -> Notification.create("Headset").show()))
                        .appendChild(TreeItem.create(Icons.keyboard(), "Keyboard")
                                .addClickListener(evt -> Notification.create("Keyboard").show()))
                        .appendChild(TreeItem.create(Icons.mouse(), "Mouse")
                                .addClickListener(evt -> Notification.create("Mouse").show())))

                .appendChild(TreeItem.create(Icons.laptop(), "Laptop")
                        .addClickListener(evt -> Notification.create("Laptop").show())

                        .appendChild(TreeItem.create(Icons.laptop(), "Chromebook")
                                .addClickListener(evt -> Notification.create("Chromebook").show()))
                        .appendChild(TreeItem.create(Icons.laptop_account(), "MacBook")
                                .addClickListener(evt -> Notification.create("MacBook").show())))

                .appendChild(TreeItem.create(Icons.cellphone(), "Smart phone")
                        .addClickListener(evt -> Notification.create("Smart phone").show())

                        .appendChild(TreeItem.create(Icons.tablet(), "Tablet")
                                .addClickListener(evt -> Notification.create("Tablet").show()))
                        .appendChild(TreeItem.create(Icons.cellphone(), "Android")
                                .addClickListener(evt -> Notification.create("Android").show()))
                        .appendChild(TreeItem.create(Icons.cellphone_cog(), "iPhone")
                                .addClickListener(evt -> Notification.create("iPhone").show())));


        Tree<String> hardwareMenu2 = Tree.<String>create("FILES")
                .setToggleTarget(ToggleTarget.ICON)
                .setAutoCollapse(false)
                .addSelectionListener((treeItem, selection) -> DomGlobal.console.info(treeItem.get().getValue()))
                .appendChild(TreeItem.create(Icons.folder(), "Folder")
                        .appendChild(TreeItem.create(Icons.folder_star(), "My files")
                                .appendChild(TreeItem.create(Icons.note(), "File 1")
                                        .addClickListener(evt -> Notification.create("File 1").show()))
                                .appendChild(TreeItem.create(Icons.note(), "File 2")
                                        .addClickListener(evt -> Notification.create("File 2").show()))
                                .appendChild((TreeItem.create(Icons.note(), "File 3"))
                                        .addClickListener(evt -> Notification.create("File 3").show()))
                                .appendChild(TreeItem.create(Icons.note(), "File 4")
                                        .addClickListener(evt -> Notification.create("File 4").show()))
                        )
                        .appendChild(TreeItem.create(Icons.file_upload(), "Upload"))
                        .appendChild(TreeItem.create(Icons.file_download(), "Download"))
                        .appendChild(TreeItem.create(Icons.folder_plus(), "New folder"))
                        .appendChild(TreeItem.create(Icons.folder_account(), "Shared"))
                        .appendChild(TreeItem.create(Icons.attachment(), "Attachments"))
                ).appendChild(TreeItem.create(Icons.cloud(), "Cloud")
                        .appendChild(TreeItem.create(Icons.cloud_upload(), "Upload"))
                        .appendChild(TreeItem.create(Icons.cloud_download(), "Download"))
                        .appendChild(TreeItem.create(Icons.cloud_off_outline(), "Offline"))
                        .appendChild(TreeItem.create(Icons.cloud_question(), "Queue"))
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
