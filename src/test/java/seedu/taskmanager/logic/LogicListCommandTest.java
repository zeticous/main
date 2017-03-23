package seedu.taskmanager.logic;

import java.util.List;

import org.junit.Test;

import seedu.taskmanager.logic.commands.ListCommand;
import seedu.taskmanager.model.TaskManager;
import seedu.taskmanager.model.task.ReadOnlyTask;

public class LogicListCommandTest extends LogicManagerTest {

    @Test
    public void execute_list_showsAllTasks() throws Exception {
        // prepare expectations
        TestDataHelper helper = new TestDataHelper();
        TaskManager expectedAB = helper.generateTaskManager(2);
        List<? extends ReadOnlyTask> expectedList = expectedAB.getTaskList();

        // prepare task manager state
        helper.addToModel(model, 2);

        assertCommandSuccess("list", ListCommand.MESSAGE_SUCCESS, expectedAB, expectedList);
    }

}
