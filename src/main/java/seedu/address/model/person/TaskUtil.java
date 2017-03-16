package seedu.address.model.person;

public class TaskUtil {
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
