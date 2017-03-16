package seedu.address.logic.parser;

import java.util.Date;
import java.util.TimeZone;
import java.util.List;

import com.joestelmach.natty.DateGroup;
import com.joestelmach.natty.Parser;

import seedu.address.commons.exceptions.IllegalValueException;

/*
 * A parser that utilized external library (Natty Date by Joe Stelmach)
 * to parse string into Date object.
 * @Throws an exception when there is no or are more than one date-time detected.
 */
public class DateTimeParser {
    public static final String INVALID_DATE_FORMAT = "Date format is not accepted by PotaTodo";
    public static final String EMPTY_STRING = "";
    
    public DateTimeParser (){};
    
    private static Parser dateTimeParser = new Parser(TimeZone.getDefault());
    
    public static Date parseDateTime(String date) throws IllegalValueException{
        
        //Return null if no dates are indicated
        if (date == EMPTY_STRING){
            return null;
        }
        
        List<DateGroup> dateTimeList = dateTimeParser.parse(date);
        
        if( dateTimeList == null || dateTimeList.isEmpty() || dateTimeList.size() > 1){
            throw new IllegalValueException(INVALID_DATE_FORMAT);
            
        } else{
            return dateTimeList.get(0).getDates().get(0);
        }
    }
}