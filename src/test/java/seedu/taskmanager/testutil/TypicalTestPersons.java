package seedu.taskmanager.testutil;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.logic.parser.DateTimeUtil;
import seedu.taskmanager.model.TaskManager;
import seedu.taskmanager.model.task.Task;
import seedu.taskmanager.model.task.TaskDate;
import seedu.taskmanager.model.task.UniqueTaskList;

/**
 *
 */
public class TypicalTestPersons {

    public TestPerson event1, event2, event3, ddl1, ddl2, ddl3, flt1, flt2, flt3;

    //Sample events
    public String EVENT1_NAME = "Meeting with principal";
    public String EVENT2_NAME = "Meeting with vice-principal";
    public String EVENT3_NAME = "Golf with president";

    public String EVENT1_START_DATE_STRING = "26 March 2017, 10:00 PM";
    public String EVENT1_END_DATE_STRING = "26 March 2017, 11:00 PM";
    public String EVENT2_START_DATE_STRING = "2 May 2018, 8:00 AM";
    public String EVENT2_END_DATE_STRING = "2 May 2018, 10:00 AM";
    public String EVENT3_START_DATE_STRING = "20 Aug 2017, 8:00 PM";
    public String EVENT3_END_DATE_STRING = "20 Aug 2017, 12:00 PM";

    //Sample deadlines
    public String DDL1_NAME = "Save uncle Ben";
    public String DDL2_NAME = "Defeat Joker";
    public String DDL3_NAME = "Finish building time machine";

    public String DDL1_DUE_TIME_STRING = "25 March 2017, 11:00 PM";
    public String DDL2_DUE_TIME_STRING = "26 May 2017, 10:00 AM";
    public String DDL3_DUE_TIME_STRING = "28 July 2017, 9:30 PM";

    //Sample floating tasks
    public String FLT1_NAME = "Maintain six pack abs";
    public String FLT2_NAME = "Stay as the strongest human";
    public String FLT3_NAME = "Sleep before 11 everyday";


    public TypicalTestPersons() {
        try {
            event1 = new PersonBuilder().withName(EVENT1_NAME)
                    .withStartDate(new TaskDate(DateTimeUtil.parseDateTime(EVENT1_START_DATE_STRING)))
                    .withEndDate(new TaskDate(DateTimeUtil.parseDateTime(EVENT1_END_DATE_STRING)))
                    .withTags("important").build();
            event2 = new PersonBuilder().withName(EVENT2_NAME)
                    .withStartDate(new TaskDate(DateTimeUtil.parseDateTime(EVENT2_START_DATE_STRING)))
                    .withEndDate(new TaskDate(DateTimeUtil.parseDateTime(EVENT2_END_DATE_STRING)))
                    .build();

            ddl1 = new PersonBuilder().withName(DDL1_NAME)
                    .withEndDate(new TaskDate(DateTimeUtil.parseDateTime(DDL1_DUE_TIME_STRING)))
                    .withTags("urgent").withTags("dying").build();
            ddl2 = new PersonBuilder().withName(DDL2_NAME)
                    .withEndDate(new TaskDate(DateTimeUtil.parseDateTime(DDL2_DUE_TIME_STRING)))
                    .build();

            flt1 = new PersonBuilder().withName(FLT1_NAME)
                    .withTags("essential").build();
            flt2 = new PersonBuilder().withName(FLT2_NAME)
                    .withTags("easy").build();

           //Manually add only
            event3 = new PersonBuilder().withName(EVENT3_NAME)
                    .withStartDate(new TaskDate(DateTimeUtil.parseDateTime(EVENT3_START_DATE_STRING)))
                    .withEndDate(new TaskDate(DateTimeUtil.parseDateTime(EVENT3_END_DATE_STRING)))
                    .build();
            ddl3 = new PersonBuilder().withName(DDL3_NAME)
                    .withEndDate(new TaskDate(DateTimeUtil.parseDateTime(DDL3_DUE_TIME_STRING)))
                    .build();
            flt3 = new PersonBuilder().withName(FLT3_NAME)
                    .withTags("hard").withTags("daunting").build();

        } catch (IllegalValueException e) {
            e.printStackTrace();
            assert false : "not possible";
        }
    }

    public static void loadAddressBookWithSampleData(TaskManager ab) {
        for (TestPerson person : new TypicalTestPersons().getTypicalPersons()) {
            try {
                ab.addPerson(new Task(person));
            } catch (UniqueTaskList.DuplicatePersonException e) {
                assert false : "not possible";
            }
        }
    }

    public TestPerson[] getTypicalPersons() {
        return new TestPerson[]{event1, event2, ddl1, ddl2, flt1, flt2};
    }

    public TaskManager getTypicalAddressBook() {
        TaskManager ab = new TaskManager();
        loadAddressBookWithSampleData(ab);
        return ab;
    }
}
