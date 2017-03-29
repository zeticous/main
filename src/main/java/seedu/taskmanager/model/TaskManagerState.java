package seedu.taskmanager.model;

public class TaskManagerState {
    private final ReadOnlyTaskManager taskManager;
    private final String executedCommand;

    public TaskManagerState(ReadOnlyTaskManager taskManager, String executedCommand) {
        this.taskManager = taskManager;
        this.executedCommand = executedCommand;
    }

    public ReadOnlyTaskManager getTaskManager() {
        return taskManager;
    }

    public String getExecutedCommand() {
        return executedCommand;
    }
}