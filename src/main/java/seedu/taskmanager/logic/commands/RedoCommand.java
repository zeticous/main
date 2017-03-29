package seedu.taskmanager.logic.commands;

import seedu.taskmanager.logic.commands.exceptions.CommandException;

public class RedoCommand extends Command {

    public static final String COMMAND_WORD = "redo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Repeat the command before previous undo commadn\n";
    public static final String MESSAGE_SUCCESS = "Redo successful";
    public static final String MESSAGE_NO_NEW_STATE = "No new state found.";

    @Override
    public CommandResult execute() throws CommandException {
        assert model != null;
        try {
            model.loadNextState();
        } catch (ArrayIndexOutOfBoundsException e) {
            return new CommandResult(MESSAGE_NO_NEW_STATE);
        }

        return new CommandResult(MESSAGE_SUCCESS);
    }

}
