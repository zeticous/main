
package seedu.taskmanager.logic;

import java.util.Collections;

import org.junit.Test;

import seedu.taskmanager.logic.commands.ExitCommand;
import seedu.taskmanager.model.TaskManager;

public class LogicExitCommandTest extends LogicManagerTest {

    @Test
    public void execute_exit() {
        assertCommandSuccess("exit", ExitCommand.MESSAGE_EXIT_ACKNOWLEDGEMENT, new TaskManager(),
                Collections.emptyList());
    }

}
