package seedu.taskmanager.model;

import java.util.Date;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.logic.parser.DateTimeUtil;

public class TaskNotifierManager implements TaskNotifier {

    private static final String DEFAULT_NOTIFICATION = "3 days";

    public static String taskNotifier = DEFAULT_NOTIFICATION;
    public static Date dateHelper;

    public TaskNotifierManager() {
        setNotification(taskNotifier);
    }

    @Override
    public void setNotification(String duration) {
        taskNotifier = duration;

        try {
            dateHelper = setDateHelper();
        } catch (IllegalValueException ive) {}

    }

    private Date setDateHelper() throws IllegalValueException {
        return DateTimeUtil.parseDateTime(taskNotifier).getTaskDate();
    }

}
