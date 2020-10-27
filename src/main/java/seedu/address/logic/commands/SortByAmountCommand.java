package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class SortByAmountCommand extends Command {
    public static final String COMMAND_WORD = "sortByAmount";

    public String order;

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort all existing expenses by descending  "
            + "or ascending amount.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " ascending";

    public static final String MESSAGE_SUCCESS_DESCENDING = "Expenses sorted by descending amount!";

    public static final String MESSAGE_SUCCESS_ASCENDING = "Expenses sorted by ascending amount!";

    public SortByAmountCommand(String order) {
        this.order = order;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (this.order.equals(" ascending")) {
            model.sortByAscendingAmount();
            return new CommandResult(
                    String.format(MESSAGE_SUCCESS_ASCENDING));
        } else if (this.order.equals(" descending")) {
            model.sortByDescendingAmount();
            return new CommandResult(
                    String.format(MESSAGE_SUCCESS_DESCENDING));
        } else {
            throw new CommandException("The sorting order can only be descending or ascending.\n" +
                    "Please specify again!");
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SortByAmountCommand // instanceof handles nulls
                && order.equals(((SortByAmountCommand) other).order)); // state check
    }
}
