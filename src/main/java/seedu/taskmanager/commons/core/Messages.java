
package seedu.taskmanager.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX = "The task index provided is invalid";
    public static final String MESSAGE_TASKS_LISTED_OVERVIEW = "%1$d tasks listed!";
    // @@author A0140417R
    public static final String MESSAGE_START_AFTER_END = "The start date provided is after end date.";
    public static final String MESSAGE_REPEATED_MARKERS_FOUND = "The command contains markers with repeated intent.\n"
            + "Start Date Markers: from\n" + "End Date Markers: to,by,at";
    // @@author
};
