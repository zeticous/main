package seedu.address.model.person;

public class TaskUtil {

    public static final String DUMMY_START_DATE = "1/1/1900 00:00";
    public static final String DUMMY_END_DATE = "1/1/2100 00:00";
	
    public static boolean isFloating(ReadOnlyPerson task){
        return (task.getEndDate()==null);
    }
    
    public static boolean isDeadline(ReadOnlyPerson task){
        return (task.getEndDate()!=null && task.getStartDate()==null );
    }
    
    public static boolean isEvent(ReadOnlyPerson task){
        return (task.getEndDate()!=null && task.getStartDate()!=null);
    }
}
