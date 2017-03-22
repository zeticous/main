package seedu.taskmanager.model.person;

import static org.junit.Assert.assertTrue;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.model.person.Name;
import seedu.taskmanager.model.person.Person;
import seedu.taskmanager.model.person.TaskDate;
import seedu.taskmanager.model.person.TaskUtil;
import seedu.taskmanager.model.tag.UniqueTagList;

public class TaskUtilTest {
    public void isFloatingTask_floatingTask_returnTrue() throws IllegalValueException{
        Name name = new Name("apple");
        TaskDate start = null;
        TaskDate end = null;
        UniqueTagList tags = null;

        assertTrue(TaskUtil.isFloating(new Person(name,start,end,tags)));
    }
}
