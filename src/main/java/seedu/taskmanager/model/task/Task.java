
package seedu.taskmanager.model.task;

import java.util.Objects;
import java.util.Optional;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.commons.util.CollectionUtil;
import seedu.taskmanager.model.tag.UniqueTagList;

/**
 * Represents a Task in the task manager. Guarantees: details are present and not null, field values are validated.
 */
public class Task implements ReadOnlyTask {

    private Name name;
    private Optional<TaskDate> startDate, endDate;
    private UniqueTagList tags;
    private boolean isDoneStatus;

    /**
     * Every field must be present and not null.
     */
    // @@author A0140538J
    public Task(Name name, TaskDate startDate, TaskDate endDate, UniqueTagList tags) {
        assert !CollectionUtil.isAnyNull(name, tags);
        this.name = name;
        this.startDate = Optional.ofNullable(startDate);
        this.endDate = Optional.ofNullable(endDate);
        this.tags = new UniqueTagList(tags); // protect internal tags from
                                             // changes in the arg list
        this.isDoneStatus = false;
    }

    public Task(Name name, TaskDate startDate, TaskDate endDate, UniqueTagList tags, boolean status) {
        assert !CollectionUtil.isAnyNull(name, tags);
        this.name = name;
        this.startDate = Optional.ofNullable(startDate);
        this.endDate = Optional.ofNullable(endDate);
        this.tags = new UniqueTagList(tags); // protect internal tags from
                                             // changes in the arg list
        this.isDoneStatus = status;
    }
    // @@author

    public Task(Name name, UniqueTagList tags) throws IllegalValueException {
        this.name = name;
        this.startDate = Optional.empty();
        this.endDate = Optional.empty();
        this.tags = new UniqueTagList(tags); // protect internal tags from
                                             // changes in the arg list
        this.isDoneStatus = false;
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
        this(name, startDate.orElse(null), endDate.orElse(null), tags);
        this.isDoneStatus = false;
    }

    /**
     * Creates a copy of the given ReadOnlyTask.
     */
    public Task(ReadOnlyTask source) {
        this.name = source.getName();
        this.startDate = Optional.ofNullable(source.getStartDate());
        this.endDate = Optional.ofNullable(source.getEndDate());
        this.tags = source.getTags();
        this.isDoneStatus = source.isDone();
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
        return startDate.orElse(null);
    }

    @Override
    public TaskDate getEndDate() {
        return endDate.orElse(null);
    }

    public void setStartDate(TaskDate taskDate) {
        this.startDate = Optional.ofNullable(taskDate);
    }

    public void setEndDate(TaskDate taskDate) {
        this.endDate = Optional.ofNullable(taskDate);
    }

    public void removeStartDate() {
        this.startDate = Optional.empty();
    }

    public void removeEndDate() {
        this.endDate = Optional.empty();
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

    public boolean isValidTask() {
        return isFloating() || isDeadline()
                || (isEvent() && startDate.get().getTaskDate().before(endDate.get().getTaskDate()));
    }
    // @@author

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
        this.setDoneStatus(replacement.isDone());
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

    // @@author A0140538J
    @Override
    public boolean isDone() {
        return isDoneStatus;
    }

    public void setDoneStatus(boolean status) {
        this.isDoneStatus = status;
    }

}
