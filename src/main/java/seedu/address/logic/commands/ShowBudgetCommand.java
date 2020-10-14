package seedu.address.logic.commands;

import seedu.address.model.Model;

public class ShowBudgetCommand extends Command {

    public static final String COMMAND_WORD = "showBudget";
    public static final String MESSAGE_BUDGET = "Current budget is: S$ %.2f\n";
    public static final String MESSAGE_REMAINING = "Remaining budget is: S$ %.2f\n";
    public static final String MESSAGE_SETNEW = "Your current budget is S$ %.2f, \n"
            + "please set a new budget with command: setBudget AMOUNT\n";

    @Override
    public CommandResult execute(Model model) {
        double budget = model.getExpenseBookBudget();
        if (model.getExpenseBookBudget() <= 0) {
            String setNew = String.format(MESSAGE_SETNEW, budget);
            return new CommandResult(MESSAGE_SETNEW);
        } else {
            String budgetMsg = String.format(MESSAGE_BUDGET, budget);
            String remainingMsg = String.format(MESSAGE_REMAINING, budget);
            return new CommandResult(budgetMsg + remainingMsg);
        }
    }
}
