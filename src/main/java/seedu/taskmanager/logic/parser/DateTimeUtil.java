package seedu.taskmanager.logic.parser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.joestelmach.natty.DateGroup;
import com.joestelmach.natty.Parser;

import seedu.taskmanager.commons.exceptions.IllegalValueException;

/**
 * Natty date parser that parses a command with date and time and return a Date object
 */

public class DateTimeUtil {

    public static final String INVALID_DATE_FORMAT = "Date format is not accepted by PotaTodo";
    public static final String EMPTY_STRING = "";

    // Used to store and print date to end user.
    public final static String DATE_STRING_FORMAT = "dd MMMMM yyyy, hh:mm aaa";

    public DateTimeUtil() {
    };

    private static Parser dateTimeParser = new Parser(TimeZone.getDefault());

    public static Date parseDateTime(String date) throws IllegalValueException {
        List<DateGroup> parsedDates = dateTimeParser.parse(date);

        if (parsedDates != null && !parsedDates.isEmpty()) {
            return parsedDates.get(0).getDates().get(0);

        } else {
            throw new IllegalValueException(INVALID_DATE_FORMAT);
        }
    }

    public static String getStringFromDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_STRING_FORMAT);
        return dateFormat.format(date);
    }
}
