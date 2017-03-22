package seedu.taskmanager.testutil;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.model.person.Name;
import seedu.taskmanager.model.person.TaskDate;
import seedu.taskmanager.model.tag.Tag;
import seedu.taskmanager.model.tag.UniqueTagList;


/**
 *
 */
public class PersonBuilder {

    private TestPerson person;

    public PersonBuilder() {
        this.person = new TestPerson();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(TestPerson personToCopy) {
        this.person = new TestPerson(personToCopy);
    }

    public PersonBuilder withName(String name) throws IllegalValueException {
        this.person.setName(new Name(name));
        return this;
    }

    public PersonBuilder withStartDate(TaskDate startDate) {
        this.person.setStartDate(startDate);
        return this;
    }

    public PersonBuilder withEndDate(TaskDate endDate) {
        this.person.setEndDate(endDate);
        return this;
    }

    public PersonBuilder withTags(String ... tags) throws IllegalValueException {
        person.setTags(new UniqueTagList());
        for (String tag: tags) {
            person.getTags().add(new Tag(tag));
        }
        return this;
    }

    public TestPerson build() {
        return this.person;
    }

}
