package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class SetBudgetCommand extends Command {
    public static final String COMMAND_WORD = "setBudget";
    public static final String MESSAGE_SET_BUDGET_SUCCESS = "Successful! Te budget is now S$ %.2f.\n";
    public static final String MESSAGE_SET_BUDGET_FAIL = "Set Budget failed, please enter a valid budget.\n";

    private final double budget;

    public SetBudgetCommand(double budget) {
        requireAllNonNull(budget);
        this.budget = budget;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        model.setExpenseBookBudget(budget);
        String msg = String.format(MESSAGE_SET_BUDGET_SUCCESS, budget);
        return new CommandResult(msg);
    }
}
