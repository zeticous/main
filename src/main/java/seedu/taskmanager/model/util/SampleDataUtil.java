package seedu.taskmanager.model.util;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.model.AddressBook;
import seedu.taskmanager.model.ReadOnlyAddressBook;
import seedu.taskmanager.model.person.Name;
import seedu.taskmanager.model.person.Person;
import seedu.taskmanager.model.person.UniquePersonList.DuplicatePersonException;
import seedu.taskmanager.model.tag.UniqueTagList;

public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        try {
            return new Person[] {
                new Person(new Name("Alex Yeoh"), new UniqueTagList("friends")),
                new Person(new Name("Bernice Yu"), new UniqueTagList("colleagues", "friends")),
                new Person(new Name("Charlotte Oliveiro"), new UniqueTagList("neighbours")),
                new Person(new Name("David Li"), new UniqueTagList("family")),
                new Person(new Name("Irfan Ibrahim"), new UniqueTagList("classmates")),
                new Person(new Name("Roy Balakrishnan"), new UniqueTagList("colleagues"))
            };
        } catch (IllegalValueException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        try {
            AddressBook sampleAB = new AddressBook();
            for (Person samplePerson : getSamplePersons()) {
                sampleAB.addPerson(samplePerson);
            }
            return sampleAB;
        } catch (DuplicatePersonException e) {
            throw new AssertionError("sample data cannot contain duplicate persons", e);
        }
    }
}
