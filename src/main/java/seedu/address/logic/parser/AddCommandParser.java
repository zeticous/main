package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STARTDATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ENDDATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.IncorrectCommand;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser {
    public static final String EMPTY_STRING = "";
    
    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     */
    public Command parse(String args) {
        ArgumentTokenizer argsTokenizer =
                new ArgumentTokenizer(PREFIX_STARTDATE,PREFIX_ENDDATE,PREFIX_DEADLINE,PREFIX_TAG);
        argsTokenizer.tokenize(args);
        
        String name = argsTokenizer.getPreamble().get();
        if(name == EMPTY_STRING){
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }
        
        try {
            return new AddCommand(
                    getNameFromArgsTokenizer(argsTokenizer),
                    getStartDateFromArgsTokenizer(argsTokenizer),
                    getEndDateFromArgsTokenizer(argsTokenizer),
                    getTagsFromArgsTokenizer(argsTokenizer)
            );
        } catch (NoSuchElementException nsee) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        } catch (IllegalValueException ive) {
            return new IncorrectCommand(ive.getMessage());
        }
    }
    
    private String getNameFromArgsTokenizer(ArgumentTokenizer argsTokenizer){
        return argsTokenizer.getPreamble().get();
    }
    
    private String getStartDateFromArgsTokenizer(ArgumentTokenizer argsTokenizer){
        return argsTokenizer.getValue(PREFIX_STARTDATE).orElse(EMPTY_STRING);
    }
    
    private String getEndDateFromArgsTokenizer(ArgumentTokenizer argsTokenizer){
        return argsTokenizer
                .getValue(PREFIX_ENDDATE)
                .orElse(
                        argsTokenizer
                        .getValue(PREFIX_DEADLINE)
                        .orElse(EMPTY_STRING)
                        );
    }
    
    private Set<String> getTagsFromArgsTokenizer(ArgumentTokenizer argsTokenizer){
        return ParserUtil.toSet(argsTokenizer.getAllValues(PREFIX_TAG));
    }
}
