package seedu.address.model.person;

public class TaskUtil {

    public static final String DUMMY_START_DATE = "1/1/1900 00:00";
    public static final String DUMMY_END_DATE = "1/1/2100 00:00";
	
    private static boolean hasStart(ReadOnlyPerson task) {
    	return task.getStartDate().toString() != DUMMY_START_DATE;
    }
    
    private static boolean hasEnd(ReadOnlyPerson task) {
    	return task.getEndDate().toString() != DUMMY_END_DATE;
    }
    
    public static boolean isFloating(ReadOnlyPerson task){
        return (hasStart(task) && hasEnd(task));
    }
    
    public static boolean isDeadline(ReadOnlyPerson task){
        return (hasStart(task) && !hasEnd(task) || !hasStart(task) && hasEnd(task));
    }
    
    public static boolean isEvent(ReadOnlyPerson task){
        return (!hasStart(task) && !hasEnd(task));
    }
}
