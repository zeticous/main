package seedu.address.logic.commands;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.core.Messages;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.tag.UniqueTagList;
import seedu.address.model.task.Name;
import seedu.address.model.task.FloatingTask;
import seedu.address.model.task.ReadOnlyFloatingTask;
import seedu.address.model.task.UniquePersonList;

/**
 * Edits the details of an existing person in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the person identified "
            + "by the index number used in the last person listing. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) [NAME] [t/TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book.";

    private final int filteredPersonListIndex;
    private final EditPersonDescriptor editPersonDescriptor;

    /**
     * @param filteredPersonListIndex the index of the person in the filtered person list to edit
     * @param editPersonDescriptor details to edit the person with
     */
    public EditCommand(int filteredPersonListIndex, EditPersonDescriptor editPersonDescriptor) {
        assert filteredPersonListIndex > 0;
        assert editPersonDescriptor != null;

        // converts filteredPersonListIndex from one-based to zero-based.
        this.filteredPersonListIndex = filteredPersonListIndex - 1;

        this.editPersonDescriptor = new EditPersonDescriptor(editPersonDescriptor);
    }

    @Override
    public CommandResult execute() throws CommandException {
        List<ReadOnlyFloatingTask> lastShownList = model.getFilteredPersonList();

        if (filteredPersonListIndex >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        ReadOnlyFloatingTask personToEdit = lastShownList.get(filteredPersonListIndex);
        FloatingTask editedPerson = createEditedPerson(personToEdit, editPersonDescriptor);

        try {
            model.updatePerson(filteredPersonListIndex, editedPerson);
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }
        model.updateFilteredListToShowAll();
        return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, personToEdit));
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code editPersonDescriptor}.
     */
    private static FloatingTask createEditedPerson(ReadOnlyFloatingTask personToEdit,
                                             EditPersonDescriptor editPersonDescriptor) {
        assert personToEdit != null;

        Name updatedName = editPersonDescriptor.getName().orElseGet(personToEdit::getName);
        UniqueTagList updatedTags = editPersonDescriptor.getTags().orElseGet(personToEdit::getTags);

        return new FloatingTask(updatedName, updatedTags);
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditPersonDescriptor {
        private Optional<Name> name = Optional.empty();
        private Optional<UniqueTagList> tags = Optional.empty();

        public EditPersonDescriptor() {}

        public EditPersonDescriptor(EditPersonDescriptor toCopy) {
            this.name = toCopy.getName();
            this.tags = toCopy.getTags();
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyPresent(this.name, this.tags);
        }

        public void setName(Optional<Name> name) {
            assert name != null;
            this.name = name;
        }

        public Optional<Name> getName() {
            return name;
        }

        public void setTags(Optional<UniqueTagList> tags) {
            assert tags != null;
            this.tags = tags;
        }

        public Optional<UniqueTagList> getTags() {
            return tags;
        }
    }
}
