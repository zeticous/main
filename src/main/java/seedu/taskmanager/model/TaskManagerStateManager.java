package seedu.taskmanager.model;

import java.util.ArrayList;

public class TaskManagerStateManager {
    private ArrayList<TaskManagerState> states;
    private Integer currentStateIndex;
    private static final int FRONT = 0;

    public TaskManagerStateManager(TaskManagerState initState) {
        this.states = new ArrayList<TaskManagerState>();
        this.currentStateIndex = FRONT;
        states.add(initState);
    }

    public void addState(TaskManagerState state) {
        if (currentStateIndex != FRONT) {
            this.states.subList(FRONT, currentStateIndex - 1).clear();
        }
        this.states.add(FRONT, state);
        this.currentStateIndex = FRONT;
    }

    public TaskManagerState getPreviousState() throws IndexOutOfBoundsException {
        currentStateIndex++;
        return states.get(currentStateIndex);
    }

    public TaskManagerState getNextState() throws IndexOutOfBoundsException {
        currentStateIndex--;
        return states.get(currentStateIndex);
    }
}
