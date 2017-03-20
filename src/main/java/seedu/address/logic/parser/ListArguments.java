package seedu.address.logic.parser;

import java.util.ArrayList;

public class ListArguments {
	
	public static final String FLOATING_TASK_STRING = "floating";
	public static final String DEADLINE_STRING = "deadline";
	public static final String EVENT_STRING = "event";
	
	public ArrayList<String> acceptedWords = new ArrayList<String>();
	public boolean isDate = false;
	
	public ListArguments(String arg) {
		
		acceptedWords.add(FLOATING_TASK_STRING);
		acceptedWords.add(DEADLINE_STRING);
		acceptedWords.add(EVENT_STRING);
		
		if (DateTimeUtil.parseDateTime(arg) != null) {
			isDate = true;
		}
	}
	
}
