package seedu.taskmanager.logic;

import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.Test;

import seedu.taskmanager.logic.commands.HelpCommand;
import seedu.taskmanager.model.TaskManager;

public class LogicHelpCommandTest extends LogicManagerTest {

    @Test
    public void execute_help() {
        assertCommandSuccess("help", HelpCommand.SHOWING_HELP_MESSAGE, new TaskManager(), Collections.emptyList());
        assertTrue(helpShown);
    }

}
