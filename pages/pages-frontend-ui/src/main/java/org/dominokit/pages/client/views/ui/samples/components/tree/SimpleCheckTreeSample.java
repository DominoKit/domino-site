package org.dominokit.pages.client.views.ui.samples.components.tree;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.tree.ToggleTarget;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.tree.CheckTree;
import org.dominokit.pro.domino.ui.tree.CheckTreeItem;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class SimpleCheckTreeSample extends BaseDominoElement<HTMLDivElement, SimpleCheckTreeSample> {
    private DivElement element;

    public static SimpleCheckTreeSample create() {
        return new SimpleCheckTreeSample();
    }

    public SimpleCheckTreeSample() {

        CheckTree<String> hardwareTree = CheckTree.<String>create("HARDWARE")
                .addSelectionListener((treeItem, selection) -> DomGlobal.console.info(treeItem.get().getValue()))
                .appendChild(CheckTreeItem.create(Icons.laptop(), "Computer")
                        .addClickListener(evt -> Notification.create("Computer").show()))
                .appendChild(CheckTreeItem.create(Icons.headset(), "Headset")
                        .addClickListener(evt -> Notification.create("Headset").show()))
                .appendChild(CheckTreeItem.create(Icons.keyboard(), "Keyboard")
                        .addClickListener(evt -> Notification.create("Keyboard").show()))
                .appendChild(CheckTreeItem.create(Icons.mouse(), "Mouse")
                        .addClickListener(evt -> Notification.create("Mouse").show()))
                .addSeparator()
                .appendChild(CheckTreeItem.create(Icons.laptop(), "Laptop")
                        .addClickListener(evt -> Notification.create("Laptop").show()))
                .appendChild(CheckTreeItem.create(Icons.cellphone(), "Smart phone")
                        .addClickListener(evt -> Notification.create("Smart phone").show()))
                .appendChild(CheckTreeItem.create(Icons.tablet(), "Tablet")
                        .addClickListener(evt -> Notification.create("Tablet").show()))
                .appendChild(CheckTreeItem.create(Icons.speaker(), "Speaker")
                        .addClickListener(evt -> Notification.create("Speaker").show()));

        CheckTree<String> filesTree = CheckTree.<String>create("FILES")
                .setToggleTarget(ToggleTarget.ICON)
                .appendChild(CheckTreeItem.create(Icons.folder(), "Folder")
                        .addClickListener(evt -> Notification.create("Folder").show()))
                .appendChild(CheckTreeItem.create(Icons.folder_open(), "Folder open")
                        .addClickListener(evt -> Notification.create("Folder open").show()))
                .appendChild(CheckTreeItem.create(Icons.file_upload(), "Upload")
                        .addClickListener(evt -> Notification.create("Upload").show()))
                .appendChild(CheckTreeItem.create(Icons.file_download(), "Download")
                        .addClickListener(evt -> Notification.create("Download").show()))
                .appendChild(CheckTreeItem.create(Icons.folder_plus(), "New folder")
                        .addClickListener(evt -> Notification.create("New folder").show()))
                .appendChild(CheckTreeItem.create(Icons.folder_account(), "Shared")
                        .addClickListener(evt -> Notification.create("Shared").show()))
                .appendChild(CheckTreeItem.create(Icons.attachment(), "Attachments")
                        .addClickListener(evt -> Notification.create("Attachments").show()))
                .appendChild(CheckTreeItem.create(Icons.cloud(), "Cloud")
                        .addClickListener(evt -> Notification.create("Cloud").show()));

        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span6().appendChild(hardwareTree))
                        .appendChild(Column.span6().appendChild(filesTree))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
