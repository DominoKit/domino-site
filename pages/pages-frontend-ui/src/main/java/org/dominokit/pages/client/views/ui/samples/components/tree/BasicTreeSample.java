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
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class BasicTreeSample extends BaseDominoElement<HTMLDivElement, BasicTreeSample> {
    private DivElement element;

    public static BasicTreeSample create() {
        return new BasicTreeSample();
    }

    public BasicTreeSample() {

        Tree<String> hardwareTree = Tree.<String>create("HARDWARE")
                .addSelectionListener((treeItem, selection) -> DomGlobal.console.info(treeItem.get().getValue()))
                .appendChild(TreeItem.create(Icons.laptop(), "Computer")
                        .addClickListener(evt -> Notification.create("Computer").show()))
                .appendChild(TreeItem.create(Icons.headset(), "Headset")
                        .addClickListener(evt -> Notification.create("Headset").show()))
                .appendChild(TreeItem.create(Icons.keyboard(), "Keyboard")
                        .addClickListener(evt -> Notification.create("Keyboard").show()))
                .appendChild(TreeItem.create(Icons.mouse(), "Mouse")
                        .addClickListener(evt -> Notification.create("Mouse").show()))
                .addSeparator()
                .appendChild(TreeItem.create(Icons.laptop(), "Laptop")
                        .addClickListener(evt -> Notification.create("Laptop").show()))
                .appendChild(TreeItem.create(Icons.cellphone(), "Smart phone")
                        .addClickListener(evt -> Notification.create("Smart phone").show()))
                .appendChild(TreeItem.create(Icons.tablet(), "Tablet")
                        .addClickListener(evt -> Notification.create("Tablet").show()))
                .appendChild(TreeItem.create(Icons.speaker(), "Speaker")
                        .addClickListener(evt -> Notification.create("Speaker").show()));

        Tree<String> filesTree = Tree.<String>create("FILES")
                .setToggleTarget(ToggleTarget.ICON)
                .appendChild(TreeItem.create(Icons.folder(), "Folder")
                        .addClickListener(evt -> Notification.create("Folder").show()))
                .appendChild(TreeItem.create(Icons.folder_open(), "Folder open")
                        .addClickListener(evt -> Notification.create("Folder open").show()))
                .appendChild(TreeItem.create(Icons.file_upload(), "Upload")
                        .addClickListener(evt -> Notification.create("Upload").show()))
                .appendChild(TreeItem.create(Icons.file_download(), "Download")
                        .addClickListener(evt -> Notification.create("Download").show()))
                .appendChild(TreeItem.create(Icons.folder_plus(), "New folder")
                        .addClickListener(evt -> Notification.create("New folder").show()))
                .appendChild(TreeItem.create(Icons.folder_account(), "Shared")
                        .addClickListener(evt -> Notification.create("Shared").show()))
                .appendChild(TreeItem.create(Icons.attachment(), "Attachments")
                        .addClickListener(evt -> Notification.create("Attachments").show()))
                .appendChild(TreeItem.create(Icons.cloud(), "Cloud")
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
