package guitests;

import java.io.File;

import org.junit.Test;

import seedu.taskmanager.logic.commands.FilepathCommand;
import seedu.taskmanager.logic.parser.FilepathCommandParser;

public class FilepathCommandTest extends TaskManagerGuiTest {

    private static final String INVALID_FILEPATH = "invalid path";
    private static final String NO_FILEPATH = "";
    private static final String VALID_FILEPATH = "testfilepath.xml";

    @Test
    public void assertValidCommand() {
        String expectedMessage = String.format(FilepathCommand.MESSAGE_SUCCESS, VALID_FILEPATH);
        commandBox.runCommand(FilepathCommand.COMMAND_WORD + " " + VALID_FILEPATH);
        assertResultMessage(expectedMessage);
        File file = new File(VALID_FILEPATH);
        file.delete();
    }

    @Test
    public void assertInvalidCommand() {
        String expectedMessage = FilepathCommandParser.MESSAGE_MISSING_EXTENSION + FilepathCommandParser.MESSAGE_USAGE;
        commandBox.runCommand(FilepathCommand.COMMAND_WORD + NO_FILEPATH);
        assertResultMessage(expectedMessage);
        commandBox.runCommand(FilepathCommand.COMMAND_WORD + " " + INVALID_FILEPATH);
        assertResultMessage(expectedMessage);
    }

}
