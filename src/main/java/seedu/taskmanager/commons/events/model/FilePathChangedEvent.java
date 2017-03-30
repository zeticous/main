
package seedu.taskmanager.commons.events.model;

import seedu.taskmanager.commons.events.BaseEvent;

//@@author A0140417R
/** Indicates the filepath of the TaskBook has changed */
public class FilePathChangedEvent extends BaseEvent {

    public final String filePath;

    public FilePathChangedEvent(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "new file path: " + filePath;
    }
}
// @@author
