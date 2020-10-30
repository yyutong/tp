package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.SetBudgetCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expense.Budget;

/**
 * Parses input arguments and creates a new SetBudgetCommand object
 */
public class SetBudgetCommandParser implements Parser<SetBudgetCommand> {
    @Override
    public SetBudgetCommand parse(String userInput) throws ParseException {
        requireNonNull(userInput);
        Budget budget = ParserUtil.parseBudget(userInput);
        return new SetBudgetCommand(budget);
    }
}
