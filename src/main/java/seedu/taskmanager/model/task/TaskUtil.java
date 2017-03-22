package seedu.taskmanager.model.task;

import seedu.taskmanager.commons.exceptions.IllegalValueException;

public class TaskUtil{
    private static boolean hasStart(ReadOnlyTask task) {
        try {
            return !task.getStartDate().equals(new DummyStartTaskDate());
        } catch (IllegalValueException e) {
            return false;
        }
    }

    private static boolean hasEnd(ReadOnlyTask task) {
        try {
            return !task.getEndDate().equals(new DummyEndTaskDate());
        } catch (IllegalValueException e) {
            return false;
        }
    }

    public static boolean isFloating(ReadOnlyTask task){
        return (!hasStart(task) && !hasEnd(task));
    }

    public static boolean isDeadline(ReadOnlyTask task){
        return (hasStart(task) && !hasEnd(task) || !hasStart(task) && hasEnd(task));
    }

    public static boolean isEvent(ReadOnlyTask task){
        return (hasStart(task) && hasEnd(task));
    }
}
