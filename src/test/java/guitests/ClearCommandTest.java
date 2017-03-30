
package guitests;

public class ClearCommandTest extends TaskManagerGuiTest {

    // @Test
    // public void clear() {
    //
    // // verify a non-empty list can be cleared
    // assertTrue(taskListPanel.isListMatching(td.getTypicalTasks()));
    // assertClearCommandSuccess();
    //
    // // verify other commands can work after a clear command
    // commandBox.runCommand(td.ddl3.getAddCommand());
    // assertTrue(taskListPanel.isListMatching(td.ddl3));
    // commandBox.runCommand("delete 1");
    // assertListSize(0);
    //
    // // verify clear command works when the list is empty
    // assertClearCommandSuccess();
    // }

    private void assertClearCommandSuccess() {
        commandBox.runCommand("clear");
        assertListSize(0);
        assertResultMessage("Task manager has been cleared!");
    }
}
