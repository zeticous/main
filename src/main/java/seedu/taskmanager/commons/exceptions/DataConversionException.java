package seedu.taskmanager.commons.exceptions;

/**
 * Represents an error during conversion of data from one format to another
 */
public class DataConversionException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = -8853026629033272111L;

    public DataConversionException(Exception cause) {
        super(cause);
    }

}
