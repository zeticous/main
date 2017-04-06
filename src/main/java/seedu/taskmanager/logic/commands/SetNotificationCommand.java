
package seedu.taskmanager.logic.commands;

import seedu.taskmanager.logic.commands.exceptions.CommandException;

// @@author A0140538J
/**
 * Sets a preferred duration where PotaTodo will remind the user of expiring tasks within the stipulated duration. User
 * preference is saved upon changing the settings.
 */
public class SetNotificationCommand extends Command {

    public static final String COMMAND_WORD = "set";
    public static final String MESSAGE_SUCCESS = "New notification time has been set.\n"
            + "Please refresh PotaTodo to apply the changes.\n" + "New set duration: %1$s";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sets a visual notification for tasks expiring within the stipulated time.\n" + "Example: "
            + COMMAND_WORD + " 1 week\n" + "This means you will be reminded 1 week in advance for expiring tasks.";

    public String duration;

    public SetNotificationCommand(String duration) {
        this.duration = duration;
    }

    @Override
    public CommandResult execute() throws CommandException {
        model.setNotification(duration);
        return new CommandResult(String.format(MESSAGE_SUCCESS, duration));
    }

    @Override
    public boolean mutatesTaskManager() {
        return false;
    }

}
