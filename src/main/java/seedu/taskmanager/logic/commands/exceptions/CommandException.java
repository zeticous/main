package seedu.taskmanager.logic.commands.exceptions;

import seedu.taskmanager.logic.commands.Command;

/**
 * Represents an error which occurs during execution of a {@link Command}.
 */
public class CommandException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = -1275525082130303227L;

    public CommandException(String message) {
        super(message);
    }
}
