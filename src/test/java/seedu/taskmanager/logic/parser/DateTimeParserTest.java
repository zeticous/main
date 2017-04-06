
package seedu.taskmanager.logic.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import seedu.taskmanager.logic.parser.DateTimeUtil;
import seedu.taskmanager.model.task.TaskDate;

import org.junit.Test;

import seedu.taskmanager.commons.exceptions.IllegalValueException;

public class DateTimeParserTest {

    // In the case that a date string with no explicit time as input
    // test if the startDate parser automatically sets time as 00:00:00
    // while only display date without time
    @Test
    public void parse_startDate_withNoExplicitTime() throws IllegalValueException {
        String toBeParsed = "1/1/2019";
        String expected = "01 January 2019";
        assertEquals(DateTimeUtil.parseStartDateTime(toBeParsed).toString(), expected);
    }

    // In the case that a date string with no explicit time as input
    // test if the endDate parser automatically sets time as 23:59:59
    // while only display date without time
    @Test
    public void parse_endDate_withNoExplicitTime() throws IllegalValueException {
        String toBeParsed = "1/1/2019";
        String expected = "01 January 2019";
        assertEquals(DateTimeUtil.parseEndDateTime(toBeParsed).toString(), expected);
    }

    @Test
    public void parse_relativeDate() throws IllegalValueException {
        String toBeParsed = "2 weeks after 1/1/2017";
        String expected = "15 January 2017";
        assertEquals(DateTimeUtil.parseStartDateTime(toBeParsed).toString(), expected);
    }

    @Test
    public void test_TimePresent() throws IllegalValueException {
        assertEquals(DateTimeUtil.isTimePresent("1/1/2017 2pm"), true);
        assertEquals(DateTimeUtil.isTimePresent("next monday 2pm"), true);
        assertEquals(DateTimeUtil.isTimePresent("next hour"), true);
        assertEquals(DateTimeUtil.isTimePresent("now"), true);
    }

    @Test
    public void test_TimeNotPresent() throws IllegalValueException {
        assertEquals(DateTimeUtil.isTimePresent("1/1/2017"), false);
        assertEquals(DateTimeUtil.isTimePresent("wednesday"), false);
        assertEquals(DateTimeUtil.isTimePresent("valentines day"), false);
        assertEquals(DateTimeUtil.isTimePresent("next week"), false);
    }

    @Test
    public void parseDate_differentDateFormats_parsedSuccessfully() throws IllegalValueException {
        TaskDate datetime = DateTimeUtil.parseDateTime("1/1/2020 1pm");
        try {
            assertEquals(datetime, DateTimeUtil.parseDateTime("01-01-2020 1300"));
            assertEquals(datetime, DateTimeUtil.parseDateTime("1 Jan 2020 1300"));
            assertEquals(datetime, DateTimeUtil.parseDateTime("1300 01-01-2020"));
            assertEquals(datetime, DateTimeUtil.parseDateTime("1/1/2020 1300"));
            assertEquals(datetime, DateTimeUtil.parseDateTime("1 Jan 2020 1pm"));
            assertEquals(datetime, DateTimeUtil.parseDateTime("first Jan 2020 1pm"));
            assertEquals(datetime, DateTimeUtil.parseDateTime("first day 2020 1300"));
            assertEquals(datetime, DateTimeUtil.parseDateTime("first day 2020 1300"));
        } catch (IllegalValueException e) {
            fail("Unparsable");
        }
    }

}
