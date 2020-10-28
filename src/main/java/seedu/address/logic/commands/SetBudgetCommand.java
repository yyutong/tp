package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.model.Model;
import seedu.address.model.expense.Budget;

public class SetBudgetCommand extends Command {
    public static final String COMMAND_WORD = "setBudget";
    public static final String MESSAGE_SET_BUDGET_SUCCESS = "Successful! The budget is now %s %s.\n";
    public static final String MESSAGE_SET_BUDGET_FAIL = "Set Budget failed, please enter a valid budget.\n";

    private final Budget budget;

    /**
     * Construct a SetBudgetCommand object.
     */
    public SetBudgetCommand(Budget budget) {
        requireAllNonNull(budget);
        this.budget = budget;
    }

    @Override
    public CommandResult execute(Model model) {
        model.setExpenseBookBudget(budget);
        String msg = String.format(MESSAGE_SET_BUDGET_SUCCESS, budget, model.getExpenseBookCurrency());
        return new CommandResult(msg);
    }
}
