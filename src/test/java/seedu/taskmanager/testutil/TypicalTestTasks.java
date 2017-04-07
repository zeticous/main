
package seedu.taskmanager.testutil;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.logic.parser.DateTimeUtil;
import seedu.taskmanager.model.TaskManager;
import seedu.taskmanager.model.task.Task;
import seedu.taskmanager.model.task.UniqueTaskList;

//@@author A0130277L
/**
 * Stores typical testing tasks
 */
public class TypicalTestTasks {

    public static TestTask event1, event2, event3, event4, event5, event6, event7, event8, event9, event10, event11, event12, event13, event14, event15, event16, event17,
    ddl1, ddl2, ddl3, ddl4, ddl5, ddl6, ddl7, ddl8, ddl9, ddl10, ddl11, ddl12, ddl13, ddl14, ddl15, ddl16, ddl17,
    flt1, flt2, flt3, flt4, flt5, flt6, flt7, flt8, flt9, flt10, flt11, flt12, flt13, flt14, flt15, flt16, flt17;

    // Sample events
    public final String EVENT1_NAME = "Meeting with principal";
    public final String EVENT2_NAME = "Meeting with vice principal";
    public final String EVENT3_NAME = "Golf with president";
    public final String EVENT4_NAME = "Golf with vice prisident";
    public final String EVENT5_NAME = "Dinner with cowokers";
    public final String EVENT6_NAME = "Dinner with boss";
    public final String EVENT7_NAME = "Meeting with boss";
    public final String EVENT8_NAME = "Meeting with president";
    public final String EVENT9_NAME = "KTV with coworker";
    public final String EVENT10_NAME = "KTV with boss";
    public final String EVENT11_NAME = "KTV with manager";
    public final String EVENT12_NAME = "Movie with coworker";
    public final String EVENT13_NAME = "Movie with friends";
    public final String EVENT14_NAME = "Movie with boss";
    public final String EVENT15_NAME = "Dinner with friends";
    public final String EVENT16_NAME = "Dinner with president";
    public final String EVENT17_NAME = "Golf with boss";

    public final String EVENT1_START_DATE_STRING = "1 April 2017, 9:00 PM";
    public final String EVENT1_END_DATE_STRING = "1 April 2017, 10:00 PM";
    public final String EVENT2_START_DATE_STRING = "2 April 2017, 9:00 PM";
    public final String EVENT2_END_DATE_STRING = "2 April 2017, 10:00 PM";
    public final String EVENT3_START_DATE_STRING = "3 April 2017, 9:00 PM";
    public final String EVENT3_END_DATE_STRING = "3 April 2017, 10:00 PM";
    public final String EVENT4_START_DATE_STRING = "4 April 2017, 9:00 PM";
    public final String EVENT4_END_DATE_STRING = "4 April 2017, 10:00 PM";
    public final String EVENT5_START_DATE_STRING = "5 April 2017, 9:00 PM";
    public final String EVENT5_END_DATE_STRING = "5 April 2017, 10:00 PM";
    public final String EVENT6_START_DATE_STRING = "6 April 2017, 9:00 PM";
    public final String EVENT6_END_DATE_STRING = "6 April 2017, 10:00 PM";
    public final String EVENT7_START_DATE_STRING = "7 April 2017, 9:00 PM";
    public final String EVENT7_END_DATE_STRING = "7 April 2017, 10:00 PM";
    public final String EVENT8_START_DATE_STRING = "8 April 2017, 9:00 PM";
    public final String EVENT8_END_DATE_STRING = "8 April 2017, 10:00 PM";
    public final String EVENT9_START_DATE_STRING = "9 April 2017, 9:00 PM";
    public final String EVENT9_END_DATE_STRING = "9 April 2017, 10:00 PM";
    public final String EVENT10_START_DATE_STRING = "10 April 2017, 9:00 PM";
    public final String EVENT10_END_DATE_STRING = "10 April 2017, 10:00 PM";
    public final String EVENT11_START_DATE_STRING = "11 April 2017, 9:00 PM";
    public final String EVENT11_END_DATE_STRING = "11 April 2017, 10:00 PM";
    public final String EVENT12_START_DATE_STRING = "12 April 2017, 9:00 PM";
    public final String EVENT12_END_DATE_STRING = "12 April 2017, 10:00 PM";
    public final String EVENT13_START_DATE_STRING = "13 April 2017, 9:00 PM";
    public final String EVENT13_END_DATE_STRING = "13 April 2017, 10:00 PM";
    public final String EVENT14_START_DATE_STRING = "14 April 2017, 9:00 PM";
    public final String EVENT14_END_DATE_STRING = "14 April 2017, 10:00 PM";
    public final String EVENT15_START_DATE_STRING = "15 April 2017, 9:00 PM";
    public final String EVENT15_END_DATE_STRING = "15 April 2017, 10:00 PM";
    public final String EVENT16_START_DATE_STRING = "16 April 2017, 9:00 PM";
    public final String EVENT16_END_DATE_STRING = "16 April 2017, 10:00 PM";
    public final String EVENT17_START_DATE_STRING = "17 April 2017, 9:00 PM";
    public final String EVENT17_END_DATE_STRING = "17 April 2017, 10:00 PM";

    // Sample deadlines
    public final String DDL1_NAME = "Confess to love";
    public final String DDL2_NAME = "Finish project";
    public final String DDL3_NAME = "Finish researches";
    public final String DDL4_NAME = "Ask for career advice";
    public final String DDL5_NAME = "Talk to HR";
    public final String DDL6_NAME = "Consult with management";
    public final String DDL7_NAME = "Consult with cowork";
    public final String DDL8_NAME = "Learn Japanese";
    public final String DDL9_NAME = "Learn Java";
    public final String DDL10_NAME = "Finish presentation slides";
    public final String DDL11_NAME = "Ask for workplace advice";
    public final String DDL12_NAME = "Report to boss on project progress";
    public final String DDL13_NAME = "Write test cases";
    public final String DDL14_NAME = "Finish working on current project";
    public final String DDL15_NAME = "Consult with HR";
    public final String DDL16_NAME = "Consult with manager";
    public final String DDL17_NAME = "Talk to coworker on project";

    public final String DDL1_DUE_TIME_STRING = "25 April 2017, 11:00 PM";
    public final String DDL2_DUE_TIME_STRING = "26 April 2017, 10:00 AM";
    public final String DDL3_DUE_TIME_STRING = "2 April 2017, 9:30 PM";
    public final String DDL4_DUE_TIME_STRING = "3 April 2017, 9:30 PM";
    public final String DDL5_DUE_TIME_STRING = "1 April 2017, 9:30 PM";
    public final String DDL6_DUE_TIME_STRING = "10 April 2017, 9:30 PM";
    public final String DDL7_DUE_TIME_STRING = "11 April 2017, 9:30 PM";
    public final String DDL8_DUE_TIME_STRING = "21 April 2017, 9:30 PM";
    public final String DDL9_DUE_TIME_STRING = "30 April 2017, 9:30 PM";
    public final String DDL10_DUE_TIME_STRING = "29 April 2017, 9:30 PM";
    public final String DDL11_DUE_TIME_STRING = "24 April 2017, 9:30 PM";
    public final String DDL12_DUE_TIME_STRING = "19 April 2017, 9:30 PM";
    public final String DDL13_DUE_TIME_STRING = "8 April 2017, 9:30 PM";
    public final String DDL14_DUE_TIME_STRING = "9 April 2017, 9:30 PM";
    public final String DDL15_DUE_TIME_STRING = "14 April 2017, 9:30 PM";
    public final String DDL16_DUE_TIME_STRING = "1 April 2017, 9:30 PM";
    public final String DDL17_DUE_TIME_STRING = "15 April 2017, 9:30 PM";

    // Sample floating tasks
    public final String FLT1_NAME = "Stay healthy";
    public final String FLT2_NAME = "Stay confident";
    public final String FLT3_NAME = "Sleep before 11 everyday";
    public final String FLT4_NAME = "Stay motivated";
    public final String FLT5_NAME = "Try hard in job";
    public final String FLT6_NAME = "Keep learning";
    public final String FLT7_NAME = "Keep asking questions";
    public final String FLT8_NAME = "Stay fit";
    public final String FLT9_NAME = "Keep reading books";
    public final String FLT10_NAME = "Keep exercising";
    public final String FLT11_NAME = "Stay awake during work";
    public final String FLT12_NAME = "Stay positive";
    public final String FLT13_NAME = "Keep jogging everyday";
    public final String FLT14_NAME = "Keep writing diary";
    public final String FLT15_NAME = "Smile everyday";
    public final String FLT16_NAME = "Sing everyday";
    public final String FLT17_NAME = "Talk to a stranger everyday";


    public TypicalTestTasks() {
        try {
            event1 = new TaskBuilder().withName(EVENT1_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT1_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT1_END_DATE_STRING)).withTags("important").build();
            event2 = new TaskBuilder().withName(EVENT2_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT2_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT2_END_DATE_STRING)).build();
            event3 = new TaskBuilder().withName(EVENT3_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT3_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT3_END_DATE_STRING)).build();
            event4 = new TaskBuilder().withName(EVENT4_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT4_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT4_END_DATE_STRING)).build();
            event5 = new TaskBuilder().withName(EVENT5_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT5_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT5_END_DATE_STRING)).build();
            event6 = new TaskBuilder().withName(EVENT6_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT6_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT6_END_DATE_STRING)).build();
            event7 = new TaskBuilder().withName(EVENT7_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT7_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT7_END_DATE_STRING)).build();
            event8 = new TaskBuilder().withName(EVENT8_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT8_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT8_END_DATE_STRING)).build();
            event9 = new TaskBuilder().withName(EVENT9_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT9_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT9_END_DATE_STRING)).build();
            event10 = new TaskBuilder().withName(EVENT10_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT10_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT10_END_DATE_STRING)).build();
            event11 = new TaskBuilder().withName(EVENT11_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT11_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT11_END_DATE_STRING)).build();
            event12 = new TaskBuilder().withName(EVENT12_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT12_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT12_END_DATE_STRING)).build();
            event13 = new TaskBuilder().withName(EVENT13_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT13_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT13_END_DATE_STRING)).build();
            event14 = new TaskBuilder().withName(EVENT14_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT14_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT14_END_DATE_STRING)).build();
            event15 = new TaskBuilder().withName(EVENT15_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT15_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT15_END_DATE_STRING)).build();
            event16 = new TaskBuilder().withName(EVENT16_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT16_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT16_END_DATE_STRING)).build();

            ddl1 = new TaskBuilder().withName(DDL1_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL1_DUE_TIME_STRING)).withTags("urgent")
                    .withTags("important").build();
            ddl2 = new TaskBuilder().withName(DDL2_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL2_DUE_TIME_STRING)).build();
            ddl3 = new TaskBuilder().withName(DDL3_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL3_DUE_TIME_STRING)).build();
            ddl4 = new TaskBuilder().withName(DDL4_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL4_DUE_TIME_STRING)).build();
            ddl5 = new TaskBuilder().withName(DDL5_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL5_DUE_TIME_STRING)).build();
            ddl6 = new TaskBuilder().withName(DDL6_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL6_DUE_TIME_STRING)).build();
            ddl7 = new TaskBuilder().withName(DDL7_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL7_DUE_TIME_STRING)).build();
            ddl8 = new TaskBuilder().withName(DDL8_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL8_DUE_TIME_STRING)).build();
            ddl9 = new TaskBuilder().withName(DDL9_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL9_DUE_TIME_STRING)).build();
            ddl10 = new TaskBuilder().withName(DDL10_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL10_DUE_TIME_STRING)).build();
            ddl11 = new TaskBuilder().withName(DDL11_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL11_DUE_TIME_STRING)).build();
            ddl12 = new TaskBuilder().withName(DDL12_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL12_DUE_TIME_STRING)).build();
            ddl13 = new TaskBuilder().withName(DDL13_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL13_DUE_TIME_STRING)).build();
            ddl14 = new TaskBuilder().withName(DDL14_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL14_DUE_TIME_STRING)).build();
            ddl15 = new TaskBuilder().withName(DDL15_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL15_DUE_TIME_STRING)).build();
            ddl16 = new TaskBuilder().withName(DDL16_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL16_DUE_TIME_STRING)).build();

            flt1 = new TaskBuilder().withName(FLT1_NAME).withTags("essential").build();
            flt2 = new TaskBuilder().withName(FLT2_NAME).withTags("easy").build();
            flt3 = new TaskBuilder().withName(FLT3_NAME).build();
            flt4 = new TaskBuilder().withName(FLT4_NAME).build();
            flt5 = new TaskBuilder().withName(FLT5_NAME).build();
            flt6 = new TaskBuilder().withName(FLT6_NAME).build();
            flt7 = new TaskBuilder().withName(FLT7_NAME).build();
            flt8 = new TaskBuilder().withName(FLT8_NAME).build();
            flt9 = new TaskBuilder().withName(FLT9_NAME).build();
            flt10 = new TaskBuilder().withName(FLT10_NAME).build();
            flt11 = new TaskBuilder().withName(FLT11_NAME).build();
            flt12 = new TaskBuilder().withName(FLT12_NAME).build();
            flt13 = new TaskBuilder().withName(FLT13_NAME).build();
            flt14 = new TaskBuilder().withName(FLT14_NAME).build();
            flt15 = new TaskBuilder().withName(FLT15_NAME).build();
            flt16 = new TaskBuilder().withName(FLT16_NAME).build();



            // Manually add only
            event17 = new TaskBuilder().withName(EVENT17_NAME)
                    .withStartDate(DateTimeUtil.parseStartDateTime(EVENT17_START_DATE_STRING))
                    .withEndDate(DateTimeUtil.parseEndDateTime(EVENT17_END_DATE_STRING)).build();
            ddl17 = new TaskBuilder().withName(DDL3_NAME)
                    .withEndDate(DateTimeUtil.parseEndDateTime(DDL3_DUE_TIME_STRING)).build();
            flt17 = new TaskBuilder().withName(FLT3_NAME).withTags("hard").withTags("daunting").build();

        } catch (IllegalValueException e) {
            e.printStackTrace();
            assert false : "not possible";
        }
    }

    public static void loadTaskManagerWithSampleData(TaskManager ab) {
        for (TestTask task : new TypicalTestTasks().getTypicalTasks()) {
            try {
                ab.addTask(new Task(task));
            } catch (UniqueTaskList.DuplicateTaskException e) {
                assert false : "not possible";
            }
        }
    }

    public TestTask[] getTypicalTasks() {
        return new TestTask[] {
                event1, event2, event3, event4, event5, event6, event7, event8, event9, event10, event11, event12, event13, event14, event15, event16,
                ddl1, ddl2, ddl3, ddl4, ddl5, ddl6, ddl7, ddl8, ddl9, ddl10, ddl11, ddl12, ddl13, ddl14, ddl15, ddl16,
                flt1, flt2, flt3, flt4, flt5, flt6, flt7, flt8, flt9, flt10, flt11, flt12, flt13, flt14, flt15, flt16
        };
    }

    public TaskManager getTypicalTaskManager() {
        TaskManager ab = new TaskManager();
        loadTaskManagerWithSampleData(ab);
        return ab;
    }
}
