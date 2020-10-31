package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Show the statistic and brief summary of the user's expenses.
 */
public class ShowStatisticCommand extends Command {

    public static final String COMMAND_WORD = "showstatistics";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": show number of expenses by categories in ascending order. \n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_SHOW_STATISTIC_LABELS_SUCCESS = "Here is your expenses summary! \n";
    
    /**
     * Create a fixed length of String.
     * Here we use this command mainly to create a fixed length of empty space to simulate a table.
     * @param string the string to be created.
     * @param length the length of the String created.
     */
    public static String fixedLengthString(String string, int length) {
        return String.format("%1$" + length + "s", string);
    }

    /**
     * Executes the show statistic command.
     * @param model {@code Model} which the command should operate on.
     * @return A command result in which the statistic and brief summary of the expenses shown.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {

        return new CommandResult(MESSAGE_SHOW_STATISTIC_LABELS_SUCCESS,
                false, false, true, true);
    }
}
