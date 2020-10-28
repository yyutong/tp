package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.model.Model;

public class SetBudgetCommand extends Command {
    public static final String COMMAND_WORD = "setBudget";
    public static final String MESSAGE_SET_BUDGET_SUCCESS = "Successful! The budget is now %.2f %s.\n";
    public static final String MESSAGE_SET_BUDGET_FAIL = "Set Budget failed, please enter a valid budget.\n";

    private final double budget;

    /**
     * Construct a SetBudget object.
     */
    public SetBudgetCommand(double budget) {
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
