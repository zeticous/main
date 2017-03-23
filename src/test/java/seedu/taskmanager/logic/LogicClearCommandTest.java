package seedu.taskmanager.logic;

import java.util.Collections;

import org.junit.Test;

import seedu.taskmanager.logic.commands.ClearCommand;
import seedu.taskmanager.model.TaskManager;

public class LogicClearCommandTest extends LogicManagerTest {

    @Test
    public void execute_clear() throws Exception {
        TestDataHelper helper = new TestDataHelper();
        model.addTask(helper.generateTask(1));
        model.addTask(helper.generateTask(2));
        model.addTask(helper.generateTask(3));

        assertCommandSuccess("clear", ClearCommand.MESSAGE_SUCCESS, new TaskManager(), Collections.emptyList());
    }

}
