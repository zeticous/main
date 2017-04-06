
package seedu.taskmanager.logic.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import seedu.taskmanager.commons.exceptions.IllegalValueException;

public class DateTimeParserTest {

    // In the case that a date string with no explicit time as input
    // test if the startDate parser automatically sets time as 00:00:00
    // while only display date without time
    @Test
    public void parse_startDate_withNoExplicitTime() throws IllegalValueException {
        String toBeParsed = "1/1/2019";
        String expected = "Tue Jan 01 00:00:00 SGT 2019";
        assertEquals(DateTimeUtil.parseStartDateTime(toBeParsed).getTaskDate().toString(), expected);
        expected = "01 January 2019";
        assertEquals(DateTimeUtil.parseStartDateTime(toBeParsed).toString(), expected);
    }

    // In the case that a date string with no explicit time as input
    // test if the endDate parser automatically sets time as 23:59:59
    // while only display date without time
    @Test
    public void parse_endDate_withNoExplicitTime() throws IllegalValueException {
        String toBeParsed = "1/1/2019";
        String expected = "Tue Jan 01 23:59:59 SGT 2019";
        assertEquals(DateTimeUtil.parseEndDateTime(toBeParsed).getTaskDate().toString(), expected);
        expected = "01 January 2019";
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
        String toBeParsed = "1/1/2017 2pm";
        boolean isTimePresent = DateTimeUtil.isTimePresent(toBeParsed);
        assertEquals(isTimePresent, true);
    }

    @Test
    public void test_TimeNotPresent() throws IllegalValueException {
        String toBeParsed = "1/1/2017";
        boolean isTimePresent = DateTimeUtil.isTimePresent(toBeParsed);
        assertEquals(isTimePresent, false);
    }

}
