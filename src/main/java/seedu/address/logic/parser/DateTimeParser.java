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

    public static final String INVALID_DATE_FORMAT = "Date format is not accepted by PotaTodo";
    public static final String EMPTY_STRING = "";
    
    public DateTimeParser(){};
    
    private static Parser dateTimeParser = new Parser(TimeZone.getDefault());
    
    public static Date parseDateTime(String date) throws IllegalValueException{        
        List<DateGroup> dateTimeList = dateTimeParser.parse(date);

      if (parsedDates != null && !parsedDates.isEmpty()) {
        return parsedDates.get(0).getDates().get(0);    
    } else {
        return null;    
    }
    }
}
