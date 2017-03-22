package seedu.taskmanager.model.task;

import java.util.Date;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.logic.parser.DateTimeUtil;

/**
 * Represents a Task's name in the task manager.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public interface TaskDateInterface {

    public String toString();
    public boolean equals(Object other);
    public int hashCode();

}
