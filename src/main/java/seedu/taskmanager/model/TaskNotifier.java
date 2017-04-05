
package seedu.taskmanager.model;

// @@author A0140538J
public interface TaskNotifier {

    /**
     * Sets a new period in which a task is to be notified to the user.
     */
    void setNotification(String duration);

}
