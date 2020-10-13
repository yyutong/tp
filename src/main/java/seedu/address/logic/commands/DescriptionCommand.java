package seedu.address.logic.commands;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_EXPENSES;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Expense;
import seedu.address.model.person.Description;


/**
 * Changes the description of an existing expense in the address book.
 */
public class DescriptionCommand extends Command {

    public static final String COMMAND_WORD = "addDes";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the description of the expense identified "
            + "by the index number used in the last expense listing. "
            + "Existing description will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "d/ [DESCRIPTION]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "d/ Movie time.";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "Description command not implemented yet";
    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Description: %2$s";
    public static final String MESSAGE_ADD_DESCRIPTION_SUCCESS = "Added description to Expense: %1$s \n";
    public static final String MESSAGE_DELETE_DESCRIPTION_SUCCESS = "Removed description from Expense: %1$s \n";
    private final Index index;
    private final Description description;

    /**
     * @param index of the expense in the filtered expense list to edit the description
     * @param description of the expense to be updated to
     */
    public DescriptionCommand(Index index, Description description) {
        requireAllNonNull(index, description);

        this.index = index;
        this.description = description;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Expense> lastShownList = model.getFilteredExpenseList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_EXPENSE_DISPLAYED_INDEX);
        }

        Expense expenseToEdit = lastShownList.get(index.getZeroBased());
        Expense editedExpense = new Expense(expenseToEdit.getAmount(), expenseToEdit.getDate(), expenseToEdit.getCategory(),
                description);

        model.setExpense(expenseToEdit, editedExpense);
        model.updateFilteredExpenseList(PREDICATE_SHOW_ALL_EXPENSES);

        return new CommandResult(generateSuccessMessage(editedExpense));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DescriptionCommand)) {
            return false;
        }

        // state check
        DescriptionCommand e = (DescriptionCommand) other;
        return index.equals(e.index)
                && description.equals(e.description);
    }

    /**
     * Generates a command execution success message based on whether the description is added to or removed from
     * {@code expenseToEdit}.
     */
    private String generateSuccessMessage(Expense expenseToEdit) {
        String message = !description.value.isEmpty() ? MESSAGE_ADD_DESCRIPTION_SUCCESS : MESSAGE_DELETE_DESCRIPTION_SUCCESS;
        return String.format(message, expenseToEdit);
    }
}
