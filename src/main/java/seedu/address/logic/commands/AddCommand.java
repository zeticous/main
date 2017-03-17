package seedu.address.logic.commands;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.DateTimeParser;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.TaskDate;
import seedu.address.model.person.TaskUtil;
import seedu.address.model.person.UniquePersonList;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;

/**
 * Adds a person to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Parameters: NAME  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " John Doe t/friends t/owesMoney";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    private final Person toAdd;
    
    public static final String EMPTY_STRING = "";

    /**
     * Creates an AddCommand using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public AddCommand(String name, String startDate, String endDate, Set<String> tags)
            throws IllegalValueException {
        
        final Set<Tag> tagSet = new HashSet<>();
        
        if (startDate == EMPTY_STRING) {
        	startDate = TaskUtil.DUMMY_START_DATE;
        }
        
        if (endDate == EMPTY_STRING) {
        	endDate = TaskUtil.DUMMY_END_DATE;
        }
        
        Date start = DateTimeParser.parseDateTime(startDate);
        Date end = DateTimeParser.parseDateTime(endDate);
        
        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }
        this.toAdd = new Person(
                new Name(name),
                new TaskDate(start),
                new TaskDate(end),
                new UniqueTagList(tagSet)
        );
    }

    @Override
    public CommandResult execute() throws CommandException {
        assert model != null;
        try {
            model.addPerson(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (UniquePersonList.DuplicatePersonException e) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

    }

}
