package seedu.taskmanager.testutil;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.model.TaskManager;
import seedu.taskmanager.model.tag.Tag;
import seedu.taskmanager.model.task.Task;
import seedu.taskmanager.model.task.UniqueTaskList;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").withTag("Friend").build();}
 */
public class TaskManagerBuilder {

    private TaskManager addressBook;

    public TaskManagerBuilder(TaskManager addressBook) {
        this.addressBook = addressBook;
    }

    public TaskManagerBuilder withPerson(Task person) throws UniqueTaskList.DuplicatePersonException {
        addressBook.addPerson(person);
        return this;
    }

    public TaskManagerBuilder withTag(String tagName) throws IllegalValueException {
        addressBook.addTag(new Tag(tagName));
        return this;
    }

    public TaskManager build() {
        return addressBook;
    }
}
