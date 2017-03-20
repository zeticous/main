package seedu.address.testutil;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Name;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;
import seedu.address.model.person.TaskDate;


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
