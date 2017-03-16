package seedu.address.logic.parser;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.joestelmach.natty.DateGroup;
import com.joestelmach.natty.Parser;

/**
 * Natty parser
 */

public class DateTimeParser {

    private static Parser dateParser = new Parser(TimeZone.getDefault());

    public DateTimeParser() {}

    public static Date parseDateTime(String date) {
        
    List<DateGroup> parsedDates = dateParser.parse(date);
    
    if (parsedDates != null && !parsedDates.isEmpty()) {
        return parsedDates.get(0).getDates().get(0);    
    } else {
        return null;    
    }
    }
}
