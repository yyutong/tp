package seedu.address.logic.commands;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_EXPENSES;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Description;
import seedu.address.model.person.Expense;



/**
 * Changes the description of an existing expense in the address book.
 */
public class DeleteDescriptionCommand extends Command {

    public static final String COMMAND_WORD = "deleteDes";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes the description of the expense identified "
            + "by the index number used in the last expense listing. "
            + "Existing expense will have empty description.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "d/ [DESCRIPTION]\n"
            + "Example: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "Description command not implemented yet";
    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Description: %2$s";
    public static final String MESSAGE_ADD_DESCRIPTION_SUCCESS = "Added description to Expense: %1$s \n";
    public static final String MESSAGE_DELETE_DESCRIPTION_SUCCESS = "Removed description from Expense: %1$s \n";
    private static final Description EMPTY_DESCRIPTION = new Description("");
    private final Index index;

    /**
     * @param index of the expense in the filtered expense list to edit the description
     */
    public DeleteDescriptionCommand(Index index) {
        requireAllNonNull(index);

        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Expense> lastShownList = model.getFilteredExpenseList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_EXPENSE_DISPLAYED_INDEX);
        }

        Expense expenseToEdit = lastShownList.get(index.getZeroBased());
        assert !expenseToEdit.getDescription().isEmpty() : "Description is already deleted.";

        Expense editedExpense = new Expense(expenseToEdit.getAmount(), expenseToEdit.getDate(),
                expenseToEdit.getCategory(),
                EMPTY_DESCRIPTION);

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
        if (!(other instanceof DeleteDescriptionCommand)) {
            return false;
        }

        // state check
        DeleteDescriptionCommand e = (DeleteDescriptionCommand) other;
        return index.equals(e.index);
    }

    /**
     * Generates a command execution success message based on whether the description is added to or removed from
     * {@code expenseToEdit}.
     */
    private String generateSuccessMessage(Expense expenseToEdit) {
        String message = MESSAGE_DELETE_DESCRIPTION_SUCCESS;
        return String.format(message, expenseToEdit);
    }
}
