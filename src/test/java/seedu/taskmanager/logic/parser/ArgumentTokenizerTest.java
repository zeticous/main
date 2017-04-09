
package seedu.taskmanager.logic.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import seedu.taskmanager.logic.parser.ArgumentTokenizer.Prefix;

public class ArgumentTokenizerTest {

    private final Prefix slashP = new Prefix("/p");

    @Test
    public void accessors_notTokenizedYet() {
        ArgumentTokenizer tokenizer = new ArgumentTokenizer(slashP);
        assertPreambleAbsent(tokenizer);
        assertArgumentAbsent(tokenizer, slashP);
    }

    @Test
    public void tokenize_emptyArgsString_noValues() {
        ArgumentTokenizer tokenizer = new ArgumentTokenizer(slashP);
        String argsString = "  ";
        tokenizer.tokenize(argsString);
        assertPreambleAbsent(tokenizer);
        assertArgumentAbsent(tokenizer, slashP);
    }

    private void assertPreamblePresent(ArgumentTokenizer argsTokenizer, String expectedPreamble) {
        assertEquals(expectedPreamble, argsTokenizer.getPreamble().get());
    }

    private void assertPreambleAbsent(ArgumentTokenizer argsTokenizer) {
        assertFalse(argsTokenizer.getPreamble().isPresent());
    }

    private void assertArgumentAbsent(ArgumentTokenizer argsTokenizer, Prefix prefix) {
        assertFalse(argsTokenizer.getValue(prefix).isPresent());
    }

    @Test
    public void tokenize_noPrefixes_allTakenAsPreamble() {
        ArgumentTokenizer tokenizer = new ArgumentTokenizer();
        String argsString = "  some random string /t tag with leading and trailing spaces ";
        tokenizer.tokenize(argsString);
        // Same string expected as preamble, but leading/trailing spaces should
        // be trimmed
        assertPreamblePresent(tokenizer, argsString.trim());

    }

    @Test
    public void equalsMethod() {
        Prefix aaa = new Prefix("aaa");

        assertEquals(aaa, aaa);
        assertEquals(aaa, new Prefix("aaa"));

        assertNotEquals(aaa, "aaa");
        assertNotEquals(aaa, new Prefix("aab"));
    }
}
