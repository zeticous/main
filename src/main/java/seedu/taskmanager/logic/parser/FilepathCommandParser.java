
package seedu.taskmanager.logic.parser;

import static seedu.taskmanager.logic.commands.FilepathCommand.COMMAND_WORD;

import java.io.File;
import java.io.IOException;

import seedu.taskmanager.commons.util.FileUtil;
import seedu.taskmanager.logic.commands.Command;
import seedu.taskmanager.logic.commands.FilepathCommand;
import seedu.taskmanager.logic.commands.IncorrectCommand;

// @@author A0140417R
/**
 * Parses input arguments and creates a new FilepathCommand object
 */
public class FilepathCommandParser {

    public static final String FILE_EXTENSION = ".xml";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Changes the filepath. " + "Parameter: FILEPATH"
            + "Parameter should be a valid file path, ending in .xml."
            + "Examples: potatodo.xml, data\\awesomeness.xml, C:\\data\\taskmanager.xml";

    public static final String MESSAGE_MISSING_EXTENSION =
            "Invalid file path. Please check if your filepath ends with " + FILE_EXTENSION + ".";
    public static final String MESSAGE_CANNOT_WRITE =
            "Unable to write to file. Please check that the filepath is valid, "
                    + " and that you have permission to write to the folder.";
    public static final String MESSAGE_EXCEPTION_ERROR = "File path change request failed due to unhandled exceptions";

    /**
     * Parses the given {@code String} of arguments in the context of the FilepathCommand
     * and returns an FilepathCommand object for execution.
     */
    public Command parse(String args) {
        String trimmedArgs = args.trim();
        if (!trimmedArgs.endsWith(FILE_EXTENSION)) {
            return new IncorrectCommand(MESSAGE_MISSING_EXTENSION + MESSAGE_USAGE);
        }

        if (!canCreateFile(trimmedArgs)) {
            return new IncorrectCommand(MESSAGE_CANNOT_WRITE);
        }
        return new FilepathCommand(trimmedArgs);
    }

    /**
     * Checks if file could be created in the specified path
     * @param path
     * @return true if file can be created, false if otherwise
     */
    private boolean canCreateFile(String path) {
        try {
            fileCreationCheck(path);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * helper to check if a file can be created on the specified path
     * @param path
     * @throws IOException
     *         if unable to access file
     */
    private void fileCreationCheck(String path) throws IOException {
        File file = new File(path);

        // Delete file if exists
        FileUtil.deleteFile(file);

        // Check if file can be created
        FileUtil.createFile(file);
    }
}
