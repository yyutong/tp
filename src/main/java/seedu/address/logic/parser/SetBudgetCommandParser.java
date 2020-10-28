package seedu.address.logic.parser;

import seedu.address.logic.commands.SetBudgetCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expense.Budget;

import static java.util.Objects.requireNonNull;

public class SetBudgetCommandParser implements Parser<SetBudgetCommand> {
    @Override
    public SetBudgetCommand parse(String userInput) throws ParseException {
        requireNonNull(userInput);
        Budget budget = ParserUtil.parseBudget(userInput);
        return new SetBudgetCommand(budget);
    }
}
