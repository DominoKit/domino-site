package org.dominokit.pages.client.views.ui.samples.components.dnd;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.dnd.DragSource;
import org.dominokit.domino.ui.dnd.Draggable;
import org.dominokit.domino.ui.dnd.DropZone;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class DragAndDropBasicSample extends BaseDominoElement<HTMLDivElement, DragAndDropBasicSample> {


    private DivElement element;

    public static DragAndDropBasicSample create() {
        return new DragAndDropBasicSample();
    }

    public DragAndDropBasicSample() {

        DivElement dropArea = div().addCss(dui_flex, dui_items_center, dui_justify_center, dui_h_72, dui_w_72, dui_red);
        DivElement dragArea = div().addCss(dui_flex, dui_items_center, dui_justify_center, dui_h_72, dui_w_72, dui_yellow);

        DivElement draggableElement = div().addCss(dui_flex, dui_items_center, dui_justify_center, dui_blue, dui_h_24, dui_w_24, dui_m_1)
                .setTextContent("BOX-A");

        DivElement draggableElement1 = div().addCss(dui_flex, dui_items_center, dui_justify_center, dui_blue, dui_h_24, dui_w_24, dui_m_1)
                .setTextContent("BOX-B");

        dragArea
                .appendChild(draggableElement)
                .appendChild(draggableElement1);

        DropZone dropZone = new DropZone();
        dropZone.addDropTarget(dropArea, draggableId -> {
            if (draggableElement.getDominoId().equals(draggableId)) {
                draggableElement.remove();
                dropArea.appendChild(draggableElement);
            } else if (draggableElement1.getDominoId().equals(draggableId)) {
                draggableElement1.remove();
                dropArea.appendChild(draggableElement1);
            }
        });

        DropZone dropZone1 = new DropZone();
        dropZone1.addDropTarget(dragArea, draggableId -> {
            if (draggableElement.getDominoId().equals(draggableId)) {
                draggableElement.remove();
                dragArea.appendChild(draggableElement);
            } else if (draggableElement1.getDominoId().equals(draggableId)) {
                draggableElement1.remove();
                dragArea.appendChild(draggableElement1);
            }
        });

        DragSource dragSource = new DragSource();
        dragSource.addDraggable(Draggable.of(draggableElement));
        dragSource.addDraggable(Draggable.of(draggableElement1));


        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span6(div()
                                .appendChild(div().addCss(dui_flex, dui_flex_col)
                                        .appendChild(div().addCss(dui_font_size_4)
                                                .appendChild(text("Drag zone"))
                                        )
                                        .appendChild(div().appendChild(dragArea))
                                )
                        )
                        .span6(div()
                                .appendChild(div().addCss(dui_flex, dui_flex_col)
                                        .appendChild(div().addCss(dui_font_size_4)
                                                .appendChild(text("Drop zone"))
                                        )
                                        .appendChild(div().appendChild(dropArea)))
                        )
                );

        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
