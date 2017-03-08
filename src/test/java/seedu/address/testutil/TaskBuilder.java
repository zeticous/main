package seedu.address.testutil;

import java.text.ParseException;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Task;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;

/**
 *
 */
public class TaskBuilder {

    private TestTask task;

    public TaskBuilder() {
        this.task = new TestTask();
    }

    /**
     * Initializes the TaskBuilder with the data of {@code taskToCopy}.
     */
    public TaskBuilder(TestTask taskToCopy) {
        this.task = new TestTask(taskToCopy);
    }

    public TaskBuilder withName(String name) throws IllegalValueException {
        this.task.setTaskName(name);
        return this;
    }

    public TaskBuilder withTags(String ... tags) throws IllegalValueException {
        task.setTags(new UniqueTagList());
        for (String tag: tags) {
            task.getTags().add(new Tag(tag));
        }
        return this;
    }

    public TaskBuilder withEndDate(String endDate) throws IllegalValueException, ParseException {
        this.task.setEndDate(Task.parseDate(endDate));
        return this;
    }
    
    public TaskBuilder withStartDate(String startDate) throws IllegalValueException, ParseException {
        this.task.setStartDate(Task.parseDate(startDate));
        return this;
    }

    public TestTask build() {
        return this.task;
    }

}
