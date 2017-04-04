package seedu.taskmanager.logic;

import static seedu.taskmanager.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.List;

import org.junit.Test;

import seedu.taskmanager.commons.core.Messages;
import seedu.taskmanager.logic.commands.MarkCommand;
import seedu.taskmanager.model.TaskManager;
import seedu.taskmanager.model.task.Task;

// @@author A0140538J
public class LogicMarkCommandTest extends LogicManagerTest {

    @Test
    public void execute_mark_blank() throws Exception {
        String invalidCommand = "mark";
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkCommand.MESSAGE_USAGE);
        assertCommandFailure(invalidCommand, expectedMessage);
    }

    @Test
    public void execute_mark_worngArgument() throws Exception {
        String invalidCommand = "mark 1 asdasdasdasdas";
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkCommand.MESSAGE_USAGE);
        assertCommandFailure(invalidCommand, expectedMessage);
    }

    @Test
    public void execute_mark_missingIndex() throws Exception {
        String invalidCommand = "mark done";
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkCommand.MESSAGE_USAGE);
        assertCommandFailure(invalidCommand, expectedMessage);
    }

    @Test
    public void execute_mark_missingStatus() throws Exception {
        String invalidCommand = "mark 2";
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkCommand.MESSAGE_USAGE);
        assertCommandFailure(invalidCommand, expectedMessage);
    }

    @Test
    public void execute_mark_invalidIndex() throws Exception {
        // setup expectations
        TestDataHelper helper = new TestDataHelper();
        Task task1 = helper.meeting();

        // setup starting state
        model.addTask(task1); // task already in internal task manager

        // execute command and verify result
        String expectedMessage = Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX;
        String invalidCommand1 = "mark 2 done";
        assertCommandFailure(invalidCommand1, expectedMessage);
    }

    @Test
    public void execute_mark_undoneAsUndone() throws Exception {
        // setup expectations
        TestDataHelper helper = new TestDataHelper();
        Task task1 = helper.meeting();

        // setup starting state
        model.addTask(task1); // task already in internal task manager

        // execute command and verify result
        String expectedMessage = MarkCommand.MESSAGE_ALREADY_UNDONE;
        String invalidCommand = "mark 1 undone";
        assertCommandFailure(invalidCommand, expectedMessage);
    }

    @Test
    public void execute_mark_doneAsDone() throws Exception {
        // setup expectations
        TestDataHelper helper = new TestDataHelper();
        Task task1 = helper.meeting();
        task1.setDoneStatus(true);

        // setup starting state
        model.addTask(task1); // task already in internal task manager

        // execute command and verify result
        String expectedMessage = MarkCommand.MESSAGE_ALREADY_DONE;
        String invalidCommand = "mark 1 done";
        assertCommandFailure(invalidCommand, expectedMessage);
    }

    @Test
    public void execute_mark_undoneAsDone() throws Exception {
        TestDataHelper helper = new TestDataHelper();
        Task task1 = helper.meeting();
        Task task2 = helper.homework();
        Task doneTask2 = helper.homework();
        doneTask2.setDoneStatus(true);

        List<Task> sampleTasks = helper.generateTaskList(task1, task2);
        TaskManager expectedTM = helper.generateTaskManager(sampleTasks);
        List<Task> expectedList = helper.generateTaskList(task1, doneTask2);
        helper.addToModel(model, sampleTasks);

        String expectedMessage = String.format(MarkCommand.MESSAGE_SUCCESS, task2);
        String validCommand = "mark 2 done";
        assertCommandSuccess(validCommand, expectedMessage, expectedTM, expectedList);
    }

    @Test
    public void execute_mark_doneAsUndone() throws Exception {
        TestDataHelper helper = new TestDataHelper();
        Task task1 = helper.meeting();
        Task task2 = helper.homework();
        Task undoneTask1 = helper.meeting();
        task1.setDoneStatus(true);

        List<Task> sampleTasks = helper.generateTaskList(task1, task2);
        TaskManager expectedTM = helper.generateTaskManager(sampleTasks);
        List<Task> expectedList = helper.generateTaskList(undoneTask1, task2);
        helper.addToModel(model, sampleTasks);

        String expectedMessage = String.format(MarkCommand.MESSAGE_SUCCESS, task1);
        String validCommand = "mark 1 undone";
        assertCommandSuccess(validCommand, expectedMessage, expectedTM, expectedList);
    }

}
