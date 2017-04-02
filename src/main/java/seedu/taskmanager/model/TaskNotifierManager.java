package seedu.taskmanager.model;

public class TaskNotifierManager implements TaskNotifier {

    public static final String DEFAULT_NOTIFICATION = "3 days";

    public String taskNotifier = DEFAULT_NOTIFICATION;

    public TaskNotifierManager() {
    }

    @Override
    public void setNotification(String duration) {
        this.taskNotifier = duration;
    }

}
