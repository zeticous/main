package seedu.taskmanager.model.task;

import java.util.Objects;
import java.util.Optional;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.commons.util.CollectionUtil;
import seedu.taskmanager.model.tag.UniqueTagList;

/**
 * Represents a Task in the task manager. Guarantees: details are present and
 * not null, field values are validated.
 */
public class Task implements ReadOnlyTask {

    private Name name;
    private TaskDate startDate, endDate;
    private UniqueTagList tags;
    private boolean isDone;

    /**
     * Every field must be present and not null.
     */

    public Task(Name name, TaskDate startDate, TaskDate endDate, UniqueTagList tags) {
        assert !CollectionUtil.isAnyNull(name, tags);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tags = new UniqueTagList(tags); // protect internal tags from
                                             // changes in the arg list
    }

    public Task(Name name, UniqueTagList tags) throws IllegalValueException {
        this.name = name;
        this.startDate = new DummyStartTaskDate();
        this.endDate = new DummyEndTaskDate();
        this.tags = new UniqueTagList(tags); // protect internal tags from
                                             // changes in the arg list
    }

    /**
     * Creates task based on optional startDate and endDate
     * 
     * @param name
     * @param startDate
     * @param endDate
     * @param tags
     * @throws IllegalValueException
     */
    public Task(Name name, Optional<TaskDate> startDate, Optional<TaskDate> endDate, UniqueTagList tags)
            throws IllegalValueException {
        this(name, startDate.orElse(new DummyStartTaskDate()), endDate.orElse(new DummyEndTaskDate()), tags);
    }

    /**
     * Creates a copy of the given ReadOnlyTask.
     */
    public Task(ReadOnlyTask source) {
        this.name = source.getName();
        this.startDate = source.getStartDate();
        this.endDate = source.getEndDate();
        this.tags = source.getTags();
    }

    public void setName(Name name) {
        assert name != null;
        this.name = name;
    }

    @Override
    public Name getName() {
        return name;
    }

    @Override
    public TaskDate getStartDate() {
        return startDate;
    }

    @Override
    public TaskDate getEndDate() {
        return endDate;
    }

    public void setStartDate(TaskDate taskDate) {
        this.startDate = taskDate;
    }

    public void setEndDate(TaskDate taskDate) {
        this.endDate = taskDate;
    }

    @Override
    public UniqueTagList getTags() {
        return new UniqueTagList(tags);
    }

    /**
     * Replaces this task's tags with the tags in the argument tag list.
     */
    public void setTags(UniqueTagList replacement) {
        tags.setTags(replacement);
    }

    /**
     * Updates this task with the details of {@code replacement}.
     */
    public void resetData(ReadOnlyTask replacement) {
        assert replacement != null;

        this.setName(replacement.getName());
        this.setStartDate(replacement.getStartDate());
        this.setEndDate(replacement.getEndDate());
        this.setTags(replacement.getTags());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReadOnlyTask // instanceof handles nulls
                        && this.isSameStateAs((ReadOnlyTask) other));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing
        // your own
        return Objects.hash(name, tags);
    }

    @Override
    public String toString() {
        return getAsText();
    }

    @Override
    public boolean isDone() {
        // TODO Auto-generated method stub
        return false;
    }

}
