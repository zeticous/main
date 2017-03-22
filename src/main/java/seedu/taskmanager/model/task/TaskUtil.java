package seedu.taskmanager.model.task;

public class TaskUtil{
    private static boolean hasStart(ReadOnlyTask task) {
    	return !task.getStartDate().equals(new DummyStartTaskDate());
    }

    private static boolean hasEnd(ReadOnlyTask task) {
    	return !task.getEndDate().equals(new DummyEndTaskDate());
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
