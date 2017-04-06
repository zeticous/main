
package seedu.taskmanager.testutil;

import java.util.Optional;

import seedu.taskmanager.logic.parser.DateTimeUtil;
import seedu.taskmanager.model.tag.UniqueTagList;
import seedu.taskmanager.model.task.Name;
import seedu.taskmanager.model.task.ReadOnlyTask;
import seedu.taskmanager.model.task.TaskDate;

/**
 * A mutable task object. For testing only.
 */
public class TestTask implements ReadOnlyTask {

    private Name name;
    private Optional<TaskDate> startDate = Optional.empty();
    private Optional<TaskDate> endDate = Optional.empty();
    private UniqueTagList tags;
    private boolean isDone;
    private boolean isDueSoon;

    public TestTask() {
        tags = new UniqueTagList();
    }

    /**
     * Creates a copy of {@code taskToCopy}.
     */
    public TestTask(TestTask taskToCopy) {
        this.name = taskToCopy.getName();
        this.tags = taskToCopy.getTags();
        this.startDate = Optional.ofNullable(taskToCopy.getStartDate());
        this.endDate = Optional.ofNullable(taskToCopy.getEndDate());
        this.isDone = false;
        this.isDueSoon = false;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setTags(UniqueTagList tags) {
        this.tags = tags;
    }

    public void setStartDate(TaskDate startDate) {
        this.startDate = Optional.ofNullable(startDate);
    }

    public void setEndDate(TaskDate endDate) {
        this.endDate = Optional.ofNullable(endDate);
    }

    @Override
    public Name getName() {
        return name;
    }

    @Override
    public TaskDate getStartDate() {
        return startDate.orElse(null);
    }

    @Override
    public TaskDate getEndDate() {
        return endDate.orElse(null);
    }

    @Override
    public UniqueTagList getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return getAsText();
    }

    public String getAddCommand() {
        StringBuilder sb = new StringBuilder();
        sb.append("add " + this.getName().fullName + " ");
        if(hasStartDate()){
            sb.append("from " + DateTimeUtil.getStringFromDate(this.getStartDate().getTaskDate())+ " ");
        }
        
        if(hasEndDate()){
            sb.append("to " + DateTimeUtil.getStringFromDate(this.getEndDate().getTaskDate())+ " ");
        }
        this.getTags().asObservableList().stream().forEach(s -> sb.append("t/" + s.tagName + " "));
        return sb.toString();
    }

    @Override
    public boolean isDone() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasStartDate() {
        return startDate.isPresent();
    }

    @Override
    public boolean hasEndDate() {
        return endDate.isPresent();
    }

    @Override
    public boolean isFloating() {
        return !hasStartDate() && !hasEndDate();
    }

    @Override
    public boolean isDeadline() {
        return !hasStartDate() && hasEndDate();
    }

    @Override
    public boolean isEvent() {
        return hasStartDate() && hasEndDate();
    }

    @Override
    public boolean isDueSoon() {
        return false;
    }
}
