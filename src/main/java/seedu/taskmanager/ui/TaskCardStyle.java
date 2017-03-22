package seedu.taskmanager.ui;

import java.util.HashMap;

/*
* Class for converting task properties to CSS style strings which
* are used to style UI elements.
* 
* PRE-CON: Task properties are of string data type.
*
*/

public class TaskCardStyle {
    private final static String PROPERTY_BACKGROUND = "-fx-background-color";

    private final static PropertyMap cardDoneMap;

    private static TaskCardStyle instance = null;

    static {
        // Card - Done : Background color
        cardDoneMap = new PropertyMap(PROPERTY_BACKGROUND);
        cardDoneMap.addTo("Done", "#DEFFCA");
        cardDoneMap.addTo("Not done", "#FFBDAF");
    }

    private TaskCardStyle() {
    }

    public static TaskCardStyle getInstance() {
        if (instance == null) {
            instance = new TaskCardStyle();
        }
        return instance;
    }

    public String getCardDoneColour(String done) {
        return cardDoneMap.get(done);
    }

    /*
     * Wrapper class for a hash map that maps a task property to CSS Style
     * String. Returns a default value (empty string) if the property does not
     * exist.
     */
    private static class PropertyMap {
        private final String property;
        public final HashMap<String, String> map = new HashMap<String, String>();

        public PropertyMap(String property) {
            this.property = property;
        }

        public void addTo(String key, String value) {
            map.put(key, getStyleString(property, value));
        }

        public String get(String key) {
            if (map.containsKey(key)) {
                return map.get(key);
            }
            return ""; // No property
        }
    }

    /*
     * Converts a CSS property and value into CSS style string format.
     */
    private static String getStyleString(String property, String value) {
        return property + ": " + value + ";";
    }

}
