package seedu.address.model.util;

import java.text.ParseException;
import java.util.Set;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Task;
import seedu.address.model.person.Phone;
import seedu.address.model.person.UniqueTaskList.DuplicateTaskException;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;

public class SampleDataUtil {
    public static Task[] getSampleTasks(){
        try {
            return new Task[] {
                new Task("FIX THIS SHIT", "08/03/2017 10:23", "08/03/2017 19:23", new UniqueTagList())
            };
        } catch (ParseException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        try {
            AddressBook sampleAB = new AddressBook();
            for (Task sampleTask : getSampleTasks()) {
                sampleAB.addTask(sampleTask);
            }
            return sampleAB;
        } catch (DuplicateTaskException e) {
            throw new AssertionError("sample data cannot contain duplicate persons", e);
        }
    }
}
