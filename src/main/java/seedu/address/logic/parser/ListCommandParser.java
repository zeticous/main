package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.IncorrectCommand;
import seedu.address.logic.commands.ListCommand;

public class ListCommandParser {

	/**
     * Parses the given argument in the context of the ListCommand
     * and returns an ListCommand object for execution.
     */
	public Command parse(String arg) {

		String modifiedArg = arg.trim();

		ListArguments argumentChecker = new ListArguments(modifiedArg);
		if (!(argumentChecker.acceptedWords.contains(modifiedArg)) && argumentChecker.isDate == false) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListCommand.MESSAGE_USAGE));
        }

		return new ListCommand(modifiedArg);
	}
}
