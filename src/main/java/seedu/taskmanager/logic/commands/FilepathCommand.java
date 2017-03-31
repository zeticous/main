
package seedu.taskmanager.logic.commands;

import java.io.File;
import java.io.IOException;

import seedu.taskmanager.commons.util.FileUtil;

//@@author A0140417R
/**
 * Changes the file path to the indicated directory
 */
public class FilepathCommand extends Command {

    public static final String COMMAND_WORD = "filepath";

    public static final String[] REQUIRED_PARAMS = {};
    public static final String[] POSSIBLE_PARAMS = {};

    public static final String FILE_EXTENSION = ".xml";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Changes the filepath. " + "Parameter: FILEPATH"
            + "Parameter should be a valid file path, ending in .xml."
            + "Examples: potatodo.xml, data\\awesomeness.xml, C:\\data\\taskmanager.xml";

    public static final String MESSAGE_SUCCESS = "File path changed to %1$s";
    public static final String MESSAGE_MISSING_EXTENSION = "Invalid file path. Please check if your filepath ends with "
            + FILE_EXTENSION + ".";
    public static final String MESSAGE_CANNOT_WRITE = "Unable to write to file. Please check that the filepath is valid, "
            + " and that you have permission to write to the folder.";
    public static final String MESSAGE_EXCEPTION_ERROR = "File path change request failed due to unhandled exceptions";

    private final String filePath;

    public FilepathCommand(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public CommandResult execute() {
        assert model != null;
        assert filePath != null;

        if (!filePath.endsWith(FILE_EXTENSION)) {
            return new CommandResult(MESSAGE_MISSING_EXTENSION + MESSAGE_USAGE);
        }

        if (!canCreateFile(filePath)) {
            return new CommandResult(MESSAGE_CANNOT_WRITE);
        }

        model.changeFilePath(filePath);
        return new CommandResult(String.format(MESSAGE_SUCCESS, filePath));
    }

    /**
     * Checks if file could be created in the specified path
     *
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
     *
     * @param path
     * @throws IOException
     *             if unable to access file
     */
    private void fileCreationCheck(String path) throws IOException {
        File file = new File(path);

        // Delete file if exists
        FileUtil.deleteFile(file);

        // Check if file can be created
        FileUtil.createFile(file);
    }

    @Override
    public boolean mutatesTaskManager() {
        return false;
    }
}
