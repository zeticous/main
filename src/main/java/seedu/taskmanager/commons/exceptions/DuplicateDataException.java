
package seedu.taskmanager.commons.exceptions;

/**
 * Signals an error caused by duplicate data where there should be none.
 */
public abstract class DuplicateDataException extends IllegalValueException {
    /**
     *
     */
    private static final long serialVersionUID = 8975376343804862535L;

    public DuplicateDataException(String message) {
        super(message);
    }
}
