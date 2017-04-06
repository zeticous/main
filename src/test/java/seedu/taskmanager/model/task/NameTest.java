
package seedu.taskmanager.model.task;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NameTest {

    // @@author A0130277L

    @Test
    public void isValidName() {
        // invalid name
        assertFalse(Name.isValidName(""));

        // valid name
        assertTrue(Name.isValidName("meeting"));
        assertTrue(Name.isValidName("meeting with Jon"));
        assertTrue(Name.isValidName("meeting with 2 people"));
        assertTrue(Name.isValidName("to task #3"));
        assertTrue(Name.isValidName("write entry named 'test cases' "));
        assertTrue(Name.isValidName("12345!@#${}"));
        assertTrue(Name.isValidName("                            meeting   "));
    }
}
