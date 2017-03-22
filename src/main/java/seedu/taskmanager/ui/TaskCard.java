package seedu.taskmanager.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.taskmanager.model.task.ReadOnlyTask;
import seedu.taskmanager.model.task.TaskUtil;

public class TaskCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label startDate;
    @FXML
    private Label endDate;
    @FXML
    private Label id;

    @FXML
    private FlowPane tags;

    public TaskCard(ReadOnlyTask person, int displayedIndex) {
        super(FXML);
        name.setText(person.getName().fullName);
        taskSelector(person);
        id.setText(displayedIndex + ". ");
        initTags(person);
    }

    /**
     * Prints the task in correct format.
     * @param person
     */
    private void taskSelector(ReadOnlyTask person){
        if(TaskUtil.isFloating(person)){
            startDate.setVisible(false);
            endDate.setVisible(false);

        } else if (TaskUtil.isDeadline(person)){
            startDate.setVisible(false);
            endDate.setText("Due: "+ person.getEndDate().toString());

        } else if (TaskUtil.isEvent(person)){
            startDate.setText("Start: "+ person.getStartDate().toString());
            endDate.setText("End: "+ person.getEndDate().toString());
        }
    }

    private void initTags(ReadOnlyTask person) {
        person.getTags().forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }
}
