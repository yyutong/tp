package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.expense.Budget;
import seedu.address.model.expense.Currency;

/**
 * Show the current available budget.
 */
public class ShowBudgetCommand extends Command {

    public static final String COMMAND_WORD = "showBudget";
    public static final String MESSAGE_BUDGET = "Current budget is: %s %s\n";
    public static final String MESSAGE_REMAINING = "Remaining budget is: %s %s\n";
    public static final String MESSAGE_SETNEW = "Your remaining budget is %s %s, "
            + "seems like you're broke.\n"
            + "Please set a new budget with command: setBudget AMOUNT\n";

    @Override
    public CommandResult execute(Model model) {
        Budget budget = model.getExpenseBookBudget();
        Budget remaining = model.getExpenseBookRemaining();
        Currency currency = model.getExpenseBookCurrency();
        String budgetMsg = String.format(MESSAGE_BUDGET, budget, currency);
        if (model.getExpenseBookRemaining().isEmpty()) {
            String setNew = String.format(MESSAGE_SETNEW, remaining, currency);
            return new CommandResult(budgetMsg + setNew);
        } else {
            String remainingMsg = String.format(MESSAGE_REMAINING, model.getExpenseBookRemaining(), currency);
            return new CommandResult(budgetMsg + remainingMsg);
        }
    }
}
