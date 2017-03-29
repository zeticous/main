package seedu.taskmanager.model;

import java.util.ArrayList;

public class TaskManagerStateManager {

    private ArrayList<TaskManagerState> states = new ArrayList<TaskManagerState>();
    private Integer currentStateIndex = 0;

    public TaskManagerStateManager(TaskManagerState initState) {
        states.add(initState);
    }

    public void addState(TaskManagerState state) {
        removeFutureStates();
        this.states.add(state);
        this.currentStateIndex++;
    }

    private void removeFutureStates() {
        while (states.size() - 1 > currentStateIndex) {
            states.remove(states.size() - 1);
        }
    }

    public TaskManagerState getPreviousState() throws IndexOutOfBoundsException {
        currentStateIndex--;
        return states.get(currentStateIndex);
    }

    public TaskManagerState getNextState() throws IndexOutOfBoundsException {
        currentStateIndex++;
        return states.get(currentStateIndex);
    }
}
