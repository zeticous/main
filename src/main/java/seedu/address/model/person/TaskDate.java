package seedu.address.model.person;

import java.util.Date;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class TaskDate {
    public final Date taskDate;
    
    public TaskDate(Date date) throws IllegalValueException {
        this.taskDate = date;
    }

    @Override
    public String toString() {
        if (taskDate == null) {
            return "";
        
        } else {
            return taskDate.toString();
        }
    }

    @Override
    public boolean equals(Object other) {
        
        return other == this // short circuit if same object
                || (other instanceof TaskDate // instanceof handles nulls
                && this.taskDate.equals(((TaskDate) other).taskDate)); // state check
    }

    @Override
    public int hashCode() {
        return taskDate.hashCode();
    }

}
