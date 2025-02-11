package org.dominokit.pages.client.views.ui.samples.components.boards;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.meta.AttributeMeta;
import org.dominokit.pro.domino.ui.boards.*;

import static org.dominokit.domino.ui.style.Color.*;
import static org.dominokit.domino.ui.style.Color.DEEP_PURPLE;
import static org.dominokit.domino.ui.utils.Domino.*;

public class ListsBoardsSample extends BaseDominoElement<HTMLDivElement, ListsBoardsSample> {

    private DivElement element;

    public static ListsBoardsSample create() {
        return new ListsBoardsSample();
    }

    public ListsBoardsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(ListsBoard.<Task, TaskStatus>create(status -> {
                                            BoardList<Task, TaskStatus> column = BoardList.create(status);
                                            column.withCard((c, card) -> {
                                                        card.appendChild(PostfixAddOn.of(Badge.create("0")
                                                                        .addCss(dui_context)
                                                                        .apply(self -> c.applyMeta(AttributeMeta.of("count-badge", 0)
                                                                                .onValueChanged(v -> self.setText(String.valueOf(v)))
                                                                        ))
                                                                )
                                                        );
                                                    })
                                                    .addOnItemAddedListener((target, item) -> {
                                                        target.<AttributeMeta<Integer>>getMeta("count-badge").ifPresent(m -> m.setValue(target.getItems().size()));
                                                    })
                                                    .addOnItemRemovedListener((target, item) -> {
                                                        target.<AttributeMeta<Integer>>getMeta("count-badge").ifPresent(m -> m.setValue(target.getItems().size()));
                                                    });
                                            return column;
                                        }, data -> BoardListItem.create(data)
                                                .withBody((parent, self) -> self
                                                        .setTitle(data.getTitle())
                                                        .setDescription(data.description)
                                                        .appendChild(PostfixAddOn.of(Icons.circle().addCss(dui_fg_context)))
                                                )
                                )
                                .setCssProperty("max-height", "800px")
                                .addDndListener((state, target) -> {
                                    Notification.create(state.getItem().getData() + " was moved from [" + state.getSource().getCategory().getName() + "] to [" + target.getCategory().getName() + "]").show();
                                })
                                .withHeader((board, self) -> {
                                    self
                                            .setTitle("Tasks board")
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()));
                                })
                                .addGroup(TaskStatus.values())
                                .addItem(
                                        Task.create(TaskStatus.New, "Issue #1", "This is the first issue"),
                                        Task.create(TaskStatus.Prospect, "Issue #2", "This is the 2nd issue"),
                                        Task.create(TaskStatus.Lead, "Issue #3", "This is the 3rd issue"),
                                        Task.create(TaskStatus.Contacted, "Issue #4", "This is the 4th issue"),
                                        Task.create(TaskStatus.Lead, "Issue #5", "This is the 5th issue"),
                                        Task.create(TaskStatus.New, "Issue #6", "This is the 6th issue"),
                                        Task.create(TaskStatus.Qualified, "Issue #7", "This is the 7th issue"),
                                        Task.create(TaskStatus.Negotiation, "Issue #8", "This is the 8th issue"),
                                        Task.create(TaskStatus.Customer, "Issue #9", "This is the 9th issue"),
                                        Task.create(TaskStatus.Prospect, "Issue #10", "This is the 10th issue"),
                                        Task.create(TaskStatus.Vendor, "Issue #11", "This is the 11th issue"),
                                        Task.create(TaskStatus.Closed, "Issue #12", "This is the 12th issue")
                                )
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }

    public static class Task implements HasBoardCategory<Task, TaskStatus> {

        private TaskStatus status;
        private String title;
        private String description;

        public Task(TaskStatus status, String title, String description) {
            this.status = status;
            this.title = title;
            this.description = description;
        }

        public static Task create(TaskStatus status, String title, String description) {
            return new Task(status, title, description);
        }

        public IsBoardCategory getStatus() {
            return status;
        }

        public void setStatus(TaskStatus status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public TaskStatus getBoardCategory() {
            return status;
        }

        @Override
        public Task get() {
            return this;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }

    public enum TaskStatus implements IsBoardCategory {
        New(BLUE_GREY, "New"),
        Prospect(CYAN, "Prospect"),
        Lead(INDIGO, "Lead"),
        Contacted(BLUE, "Contacted"),
        Qualified(AMBER, "Qualified"),
        Proposal_Sent(LIME, "Proposal sent"),
        Negotiation(LIGHT_GREEN, "Negotiation"),
        Customer(TEAL, "Customer"),
        Active(GREEN, "Active"),
        Inactive(GREY, "Inactive"),
        Lost(RED, "Lost"),
        Unqualified(YELLOW, "Unqualified"),
        Re_engage(ORANGE, "Re-engage"),
        Churned(BLUE_DARKEN_3, "Churned"),
        On_Hold(BROWN, "On Hold"),
        Closed(PURPLE, "Closed"),
        Partner(DEEP_PURPLE, "Partner"),
        Vendor(DEEP_PURPLE, "Vendor");

        private final Color color;
        private final String description;

        TaskStatus(Color color, String description) {
            this.color = color;
            this.description = description;
        }

        @Override
        public String getName() {
            return this.name();
        }

        @Override
        public Color getColor() {
            return color;
        }

        public String getDescription() {
            return description;
        }
    }
}
