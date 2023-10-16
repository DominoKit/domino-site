package org.dominokit.pages.client.views.ui.samples.forms.input;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.upload.DefaultFileUploadDecoration;
import org.dominokit.domino.ui.upload.FileUpload;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class FileUploadSample extends BaseDominoElement<HTMLDivElement, FileUploadSample> {

    private DivElement element;

    public static FileUploadSample create() {
        return new FileUploadSample();
    }

    public FileUploadSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("Manual upload"))
                .appendChild(FileUpload.create()
                        .setDecoration(DefaultFileUploadDecoration.create()
                                .setIcon(Icons.upload().addCss(dui_font_size_24, dui_fg_accent))
                                .setTitle("Drop files here or click to upload.")
                                .setDescription("(This is just a demo upload. Selected files are not actually uploaded)")
                                .addCss(dui_m_b_4)
                        )
                        .setAutoUpload(false)
                        .onAddFile(fileItem -> {
                            fileItem
                                    .addErrorHandler(request -> Notification.create("Failed to upload file").addCss(dui_error).show())
                                    .addRemoveHandler(file -> Notification.create("File removed").addCss(dui_warning).show())
                                    .addBeforeUploadHandler((request, formData) -> Notification.create("Starting file upload").addCss(dui_primary).show())
                                    .addCancelHandler(request -> Notification.create("Starting file upload").addCss(dui_primary).show())
                                    .withOptions((file, options) -> {
                                        options
                                                .setUrl("http://localhost:8080/service/upload");
                                    })
                            ;
                        })
                        .addCss(dui_min_h_32, dui_w_full, dui_m_b_4)
                )
                .appendChild(BlockHeader.create("Auto upload"))
                .appendChild(FileUpload.create()
                        .setDecoration(DefaultFileUploadDecoration.create()
                                .setIcon(Icons.upload().addCss(dui_font_size_24, dui_fg_accent))
                                .setTitle("Drop files here or click to upload.")
                                .setDescription("(This is just a demo upload. Selected files are not actually uploaded)")
                                .addCss(dui_m_b_4)
                        )
                        .setAutoUpload(true)
                        .onAddFile(fileItem -> {
                            fileItem
                                    .addErrorHandler(request -> Notification.create("Failed to upload file").addCss(dui_error).show())
                                    .addRemoveHandler(file -> Notification.create("File removed").addCss(dui_warning).show())
                                    .addBeforeUploadHandler((request, formData) -> Notification.create("Starting file upload").addCss(dui_primary).show())
                                    .addCancelHandler(request -> Notification.create("Starting file upload").addCss(dui_primary).show())
                                    .withOptions((file, options) -> {
                                        options
                                                .setUrl("http://localhost:8080/service/upload");
                                    })
                            ;
                        })
                        .addCss(dui_min_h_32, dui_w_full))
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
