package seedu.taskmanager.model.util;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.model.TaskManager;
import seedu.taskmanager.model.ReadOnlyTaskManager;
import seedu.taskmanager.model.tag.UniqueTagList;
import seedu.taskmanager.model.task.Name;
import seedu.taskmanager.model.task.Task;
import seedu.taskmanager.model.task.UniqueTaskList.DuplicateTaskException;

public class SampleDataUtil {
    public static Task[] getSampleTasks() {
        try {
            return new Task[] { new Task(new Name("Alex Yeoh"), new UniqueTagList("friends")),
                    new Task(new Name("Bernice Yu"), new UniqueTagList("colleagues", "friends")),
                    new Task(new Name("Charlotte Oliveiro"), new UniqueTagList("neighbours")),
                    new Task(new Name("David Li"), new UniqueTagList("family")),
                    new Task(new Name("Irfan Ibrahim"), new UniqueTagList("classmates")),
                    new Task(new Name("Roy Balakrishnan"), new UniqueTagList("colleagues")) };
        } catch (IllegalValueException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

    public static ReadOnlyTaskManager getSampleTaskManager() {
        try {
            TaskManager sampleAB = new TaskManager();
            for (Task sampleTask : getSampleTasks()) {
                sampleAB.addTask(sampleTask);
            }
            return sampleAB;
        } catch (DuplicateTaskException e) {
            throw new AssertionError("sample data cannot contain duplicate tasks", e);
        }
    }
}
