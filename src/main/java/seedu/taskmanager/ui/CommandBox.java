
package seedu.taskmanager.ui;

import java.util.ArrayList;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import seedu.taskmanager.commons.core.LogsCenter;
import seedu.taskmanager.commons.events.ui.NewResultAvailableEvent;
import seedu.taskmanager.commons.util.FxViewUtil;
import seedu.taskmanager.logic.Logic;
import seedu.taskmanager.logic.commands.CommandResult;
import seedu.taskmanager.logic.commands.exceptions.CommandException;

public class CommandBox extends UiPart<Region> {
    private final Logger logger = LogsCenter.getLogger(CommandBox.class);
    private static final String FXML = "CommandBox.fxml";
    private static PreviousCommandList prevCommandList;
    public static final String ERROR_STYLE_CLASS = "error";

    private final Logic logic;

    @FXML
    private TextField commandTextField;

    public CommandBox(AnchorPane commandBoxPlaceholder, Logic logic) {
        super(FXML);
        this.logic = logic;
        prevCommandList = new PreviousCommandList();
        addToPlaceholder(commandBoxPlaceholder);
        setUpListener();
    }

    private void addToPlaceholder(AnchorPane placeHolderPane) {
        SplitPane.setResizableWithParent(placeHolderPane, false);
        placeHolderPane.getChildren().add(commandTextField);
        FxViewUtil.applyAnchorBoundaryParameters(getRoot(), 0.0, 0.0, 0.0, 0.0);
        FxViewUtil.applyAnchorBoundaryParameters(commandTextField, 0.0, 0.0, 0.0, 0.0);
    }

    // @@author A0140417R
    /**
     * Sets up listener for up and down key, cycle through previous commands regardless of validity.
     */
    private void setUpListener() {
        commandTextField.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.UP)) {
                    Platform.runLater(() -> {
                        commandTextField.setText(prevCommandList.getPreviousCommand());
                    });
                }

                else if (event.getCode().equals(KeyCode.DOWN)) {
                    Platform.runLater(() -> {
                        commandTextField.setText(prevCommandList.getNextCommand());
                    });
                }
            }
        });
    }
    // @@author A0140417R

    @FXML
    private void handleCommandInputChanged() {
        try {
            prevCommandList.addCommandToList(commandTextField.getText());
            CommandResult commandResult = logic.execute(commandTextField.getText());
            // process result of the command
            setStyleToIndicateCommandSuccess();
            commandTextField.setText("");
            logger.info("Result: " + commandResult.feedbackToUser);
            raise(new NewResultAvailableEvent(commandResult.feedbackToUser));

        } catch (CommandException e) {
            // handle command failure
            setStyleToIndicateCommandFailure();
            logger.info("Invalid command: " + commandTextField.getText());
            raise(new NewResultAvailableEvent(e.getMessage()));
        }
    }

    /**
     * Sets the command box style to indicate a successful command.
     */
    private void setStyleToIndicateCommandSuccess() {
        commandTextField.getStyleClass().remove(ERROR_STYLE_CLASS);
    }

    /**
     * Sets the command box style to indicate a failed command.
     */
    private void setStyleToIndicateCommandFailure() {
        commandTextField.getStyleClass().add(ERROR_STYLE_CLASS);
    }

    // @@author A0140417R
    /**
     * Wrapper class containing a list of previously entered commands and index. Helps to cycle through the commands
     * when up and down is pressed.
     * @author zeticous
     */
    private class PreviousCommandList {
        private int index;
        private ArrayList<String> commandList;

        public PreviousCommandList() {
            commandList = new ArrayList<String>();
            index = 0;
        }

        public void addCommandToList(String validCommand) {
            commandList.add(0, validCommand);
            index = 0;
        }

        public String getPreviousCommand() {
            try {
                return commandList.get(index++);
            } catch (IndexOutOfBoundsException e) {
                // Index is beyond the last element, set index to the last element of the list.
                index = commandList.size() - 1;
                return getPreviousCommand();
            }
        }

        public String getNextCommand() {
            try {
                return commandList.get(index--);
            } catch (IndexOutOfBoundsException e) {
                // Index is below 0, set index to 0 and return the first command in the list.
                index = 0;
                return getNextCommand();
            }
        }
    }

}
