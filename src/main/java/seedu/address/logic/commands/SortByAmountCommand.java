package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Sort the expenses by their amount.
 */
public class SortByAmountCommand extends Command {
    public static final String COMMAND_WORD = "sortByAmount";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort all existing expenses by descending  "
            + "or ascending amount.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " ascending";

    public static final String MESSAGE_SUCCESS_DESCENDING = "Expenses sorted by descending amount!";

    public static final String MESSAGE_SUCCESS_ASCENDING = "Expenses sorted by ascending amount!";

    private String order;

    /**
     * Constructs SortByAmount object.
     * @param order The sorting order of this command object.
     */
    public SortByAmountCommand(String order) {
        assert order.equals(" descending") || order.equals(" ascending") : "Please enter a valid order"
                + "(descending or ascending)!";

        this.order = order;
    }

    /**
     * Gets the order of this command object.
     * @return The order of the command object.
     */
    public String getOrder() {
        return order;
    }

    /**
     * Executes the sort by amount command.
     * @param model {@code Model} which the command should operate on.
     * @return A command result in which the message will be shown to users.
     * @throws CommandException Throws exception if the order is not "descending" or "ascending".
     */
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
            throw new CommandException("The sorting order can only be descending or ascending.\n"
                    + "Please specify again!");
        }
    }

    /**
     * Checks if a command objects are equal.
     * @param other Another object.
     * @return Whether the 2 command objects are equal or not.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SortByAmountCommand // instanceof handles nulls
                && order.equals(((SortByAmountCommand) other).order)); // state check
    }
}
