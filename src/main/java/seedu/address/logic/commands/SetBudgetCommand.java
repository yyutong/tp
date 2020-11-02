package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.model.Model;
import seedu.address.model.expense.Budget;

/**
 * Set the budget in the expense book.
 */
public class SetBudgetCommand extends Command {
    public static final String COMMAND_WORD = "setbudget";
    public static final String MESSAGE_SET_BUDGET_SUCCESS = "Successful! The budget is now %s %s.\n";
    public static final String MESSAGE_SET_BUDGET_FAIL = "Set Budget failed, please enter a valid budget.\n";

    private final Budget budget;

    /**
     * Creates an SetBudgetCommand to set the Budget {@code budget}
     */
    public SetBudgetCommand(Budget budget) {
        requireAllNonNull(budget);
        this.budget = budget;
    }

    /**
     * Executes the set budget command.
     * @param model {@code Model} which the command should operate on.
     * @return A command result in which the budget for the expense book being set.
     */
    @Override
    public CommandResult execute(Model model) {
        model.setExpenseBookBudget(budget);
        String msg = String.format(MESSAGE_SET_BUDGET_SUCCESS, budget, model.getExpenseBookCurrency());
        return new CommandResult(msg);
    }
}
