//@@author A0140538J

package seedu.taskmanager.logic.parser;

import java.util.ArrayList;

import seedu.taskmanager.commons.exceptions.IllegalValueException;

public class ListArguments {

    public static final String EMPTY_STRING = "";
    public static final String FLOATING_TASK_STRING = "floating";
    public static final String DEADLINE_STRING = "deadline";
    public static final String EVENT_STRING = "event";
    public static final String DONE_STRING = "done";
    public static final String UNDONE_STRING = "undone";

    public ArrayList<String> acceptedWords = new ArrayList<String>();
    public boolean isDate = true;

    public ListArguments(String arg) {

        acceptedWords.add(EMPTY_STRING);
        acceptedWords.add(FLOATING_TASK_STRING);
        acceptedWords.add(DEADLINE_STRING);
        acceptedWords.add(EVENT_STRING);
        acceptedWords.add(DONE_STRING);
        acceptedWords.add(UNDONE_STRING);

        try {
            DateTimeUtil.parseDateTime(arg);
        } catch (IllegalValueException ive) {
            isDate = false;
        }
    }
}
