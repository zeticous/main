package seedu.taskmanager.model.task;

/**
 * Represents a Task's name in the task manager. Guarantees: immutable; is valid
 * as declared in {@link #isValidName(String)}
 */
public interface TaskDateInterface {

    @Override
    public String toString();

    @Override
    public boolean equals(Object other);

    @Override
    public int hashCode();

}
