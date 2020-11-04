package seedu.address.logic.commands;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_EXPENSES;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Category;
import seedu.address.model.expense.Date;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.Expense;

public class EditCommand extends Command {
    public static final String COMMAND_WORD = "edit";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the expense identified by the index number.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";
    public static final String SUCCESSFUL_MESSAGE = "Expense edited successfully.";

    private final Index index;
    private final Description description;
    private final Amount amount;
    private final Category category;
    private final Date date;
    /**
     * Constructor for a EditCommand.
     */
    public EditCommand (Index index, Amount amount, Category category, Date date, Description description) {
        this.index = index;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    /**
     * Executes the view command.
     * @param model {@code Model} which the command should operate on.
     * @return A command result in which the specific expense requested by the user is shown.
     * @throws CommandException Throws exception if the index is invalid.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Expense> last = model.getFilteredExpenseList();

        if (index.getZeroBased() >= last.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_EXPENSE_DISPLAYED_INDEX);
        }

        Expense expenseToEdit = last.get(index.getZeroBased());
        Amount previousAmount = expenseToEdit.getAmount();
        Category previousCategory = expenseToEdit.getCategory();
        Date previousDate = expenseToEdit.getDate();
        Description previousDescription = expenseToEdit.getDescription();
        if (!this.date.getDate().isEmpty()) {
            previousDate = this.date;
        }
        if (!this.description.isEmpty()) {
            previousDescription = this.description;
        }
        if (!this.category.isEmpty()) {
            previousCategory = this.category;
        }
        if (!this.amount.isEmpty()) {
            previousAmount = amount;
        }
        Expense editedExpense = new Expense(
                previousAmount, previousDate, previousCategory,
                previousDescription);

        model.setExpense(expenseToEdit, editedExpense);
        model.updateFilteredExpenseList(PREDICATE_SHOW_ALL_EXPENSES);
        return new CommandResult(SUCCESSFUL_MESSAGE);
    }
}
