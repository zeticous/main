
package guitests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import guitests.guihandles.TaskCardHandle;
import seedu.taskmanager.commons.core.Messages;
import seedu.taskmanager.logic.commands.AddCommand;
import seedu.taskmanager.testutil.TestTask;
import seedu.taskmanager.testutil.TestUtil;
import seedu.taskmanager.logic.commands.AddCommand;

public class AddCommandTest extends TaskManagerGuiTest {

    // @@author A0130277L
    @Test
    public void add() {
        TestTask[] currentList = td.getTypicalTasks();

        // add an event task
        TestTask taskToAdd = td.event3;
        assertAddSuccess(taskToAdd, currentList);
        assertResultMessage(AddCommand.MESSAGE_SUCCESS);
        currentList = TestUtil.addTasksToList(currentList, taskToAdd);

        // add a deadline task
        taskToAdd = td.ddl3;
        assertAddSuccess(taskToAdd, currentList);
        assertResultMessage(AddCommand.MESSAGE_SUCCESS);
        currentList = TestUtil.addTasksToList(currentList, taskToAdd);

        // add a floating task
        taskToAdd = td.flt3;
        assertAddSuccess(taskToAdd, currentList);
        assertResultMessage(AddCommand.MESSAGE_SUCCESS);
        currentList = TestUtil.addTasksToList(currentList, taskToAdd);

        // add duplicate task
        commandBox.runCommand(td.event2.getAddCommand());
        assertResultMessage(AddCommand.MESSAGE_DUPLICATE_TASK);
        assertTrue(taskListPanel.isListMatching(currentList));

        // add to empty list
        commandBox.runCommand("clear");
        assertAddSuccess(td.event1);

        // invalid command
        commandBox.runCommand("adds meeting");
        assertResultMessage(Messages.MESSAGE_UNKNOWN_COMMAND);

        // add conflicting event which is in conflict with event1
        commandBox.runCommand(td.eventConflicting.getAddCommand());
        String expectedResultMessage = AddCommand.MESSAGE_SUCCESS + AddCommand.NEWLINE_STRING
                + AddCommand.MESSAGE_CONFLICT + AddCommand.NEWLINE_STRING
                + td.event1.getAsText() + AddCommand.NEWLINE_STRING;
        assertResultMessage(expectedResultMessage);
    }

    private void assertAddSuccess(TestTask taskToAdd, TestTask... currentList) {
        commandBox.runCommand(taskToAdd.getAddCommand());

        // confirm the new card contains the right data
        TaskCardHandle addedCard = taskListPanel.navigateToTask(taskToAdd.getName().fullName);
        assertMatching(taskToAdd, addedCard);

        // confirm the list now contains all previous tasks plus the new task
        TestTask[] expectedList = TestUtil.addTasksToList(currentList, taskToAdd);
        assertTrue(taskListPanel.isListMatching(expectedList));
    }

}
