package seedu.taskmanager.logic.commands;

import seedu.taskmanager.logic.commands.exceptions.CommandException;

public class SetNotificationCommand extends Command {

    public static final String COMMAND_WORD = "set";
    public static final String MESSAGE_SUCCESS = "New notification time has been set.";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sets a visual notification for tasks expiring within the stipulated time.\n"
    + "Example: " + COMMAND_WORD + " 1 week";

    public String duration;

    public SetNotificationCommand(String duration) {
        this.duration = duration;
    }

    @Override
    public CommandResult execute() throws CommandException {
        model.setNotification(duration);
        return new CommandResult(MESSAGE_SUCCESS + " (" + duration + ")");
    }

    @Override
    public boolean mutatesTaskManager() {
        return false;
    }

}
