package seedu.address.logic.parser;

import seedu.address.logic.commands.SetBudgetCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expense.Budget;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class SetBudgetCommandParser implements Parser<SetBudgetCommand> {
    @Override
    public SetBudgetCommand parse(String userInput) throws ParseException {
        try {
            //needs oop later
            double value = Double.parseDouble(userInput.split(" ")[1]);
            if (value <= 0) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetBudgetCommand.MESSAGE_SET_BUDGET_FAIL));
            }
            Budget budget = new Budget(value);
            return new SetBudgetCommand(budget);
        } catch (Exception pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetBudgetCommand.MESSAGE_SET_BUDGET_FAIL), pe);
        }
    }
}
