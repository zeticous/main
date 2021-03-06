package seedu.address.model.person;

import java.util.Date;

import seedu.address.model.tag.UniqueTagList;

/**
 * A read-only immutable interface for a Task in taskManager
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface ReadOnlyTask {

    String getTaskName();
    Date getStartDate();
    Date getEndDate();
    
    /**
     * The returned TagList is a deep copy of the internal TagList,
     * changes on the returned list will not affect the person's internal tags.
     */
    UniqueTagList getTags();

    /**
     * Returns true if both have the same state. (interfaces cannot override .equals)
     */
    default boolean isSameStateAs(ReadOnlyTask other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                && other.getTaskName().equals(this.getTaskName()) // state checks here onwards
                && other.getStartDate().equals(this.getStartDate())
                && other.getEndDate().equals(this.getEndDate()));
    }

    /**
     * Formats the task as text, showing all contact details.
     */
    default String getAsText() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTaskName())
                .append(" Start: ")
                .append(getStartDate())
                .append(" End: ")
                .append(getEndDate())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
