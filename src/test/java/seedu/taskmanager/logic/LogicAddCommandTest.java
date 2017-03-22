package seedu.taskmanager.logic;

import static seedu.taskmanager.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import org.junit.Test;

import seedu.taskmanager.logic.commands.AddCommand;
import seedu.taskmanager.model.tag.Tag;

public class LogicAddCommandTest extends LogicManagerTest {

    @Test
    public void execute_add_invalidArgsFormat() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);
        assertCommandFailure("add", expectedMessage);
        //Check if only startDate is present without endDate
        assertCommandFailure("add Meeting s/1/1/2018", expectedMessage);
//        //Invalid date-time formate
//        assertCommandFailure("add Meeting s/invalid date-time e/invalid date-time", expectedMessage);
//        assertCommandFailure("add Meeting b/invalid date-time", expectedMessage);
    }

    @Test
    public void execute_add_invalidTaskData() {
        assertCommandFailure("add Valid Name t/invalid_-[.tag",
                Tag.MESSAGE_TAG_CONSTRAINTS);

        assertCommandFailure("add Valid Name t/invalid_-[.tag",
                        Tag.MESSAGE_TAG_CONSTRAINTS);
    }


}
