package seedu.taskmanager.model;

public class TaskManagerState {
    private final TaskManager taskManager;
    private final String executedCommand;

    public TaskManagerState(TaskManager taskManager, String executedCommand) {
        this.taskManager = taskManager;
        this.executedCommand = executedCommand;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    public String getExecutedCommand() {
        return executedCommand;
    }
}