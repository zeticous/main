
package seedu.taskmanager.model.task;

import java.util.Optional;

import seedu.taskmanager.model.tag.UniqueTagList;

/**
 * A read-only immutable interface for a Task in the taskmanager. Implementations should guarantee: details are present
 * and not null, field values are validated.
 */
public interface ReadOnlyTask {

    public static final String NEW_LINE_INDICATOR = "\n";

    Name getName();

    TaskDate getStartDate();

    TaskDate getEndDate();

    boolean hasStartDate();

    boolean hasEndDate();

    boolean isFloating();

    boolean isDeadline();

    boolean isEvent();

    boolean isDone();

    boolean isDueSoon();

    /**
     * The returned TagList is a deep copy of the internal TagList, changes on the returned list will not affect the
     * task's internal tags.
     */
    UniqueTagList getTags();

    /**
     * Returns true if both have the same state. (interfaces cannot override .equals)
     */
    default boolean isSameStateAs(ReadOnlyTask other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                        && other.getName().equals(this.getName())
                        && (Optional.ofNullable(other.getStartDate())).equals(Optional.ofNullable(this.getStartDate()))
                        && (Optional.ofNullable(other.getEndDate())).equals(Optional.ofNullable(this.getEndDate()))
                        && other.getTags().equals(this.getTags())
                );
    }

    // @@author A0140538J
    /**
     * Formats the task as text, showing all contact details.
     */
    default String getAsText() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName()).append(NEW_LINE_INDICATOR);

        if (hasStartDate()) {
            builder.append("Start: ").append(getStartDate()).append(NEW_LINE_INDICATOR);
        }

        if (hasEndDate()) {
            builder.append("End: ").append(getEndDate()).append(NEW_LINE_INDICATOR);
        }

        builder.append("Tags: ");
        getTags().forEach(builder::append);

        return builder.toString();
    }
}
