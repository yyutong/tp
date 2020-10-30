package seedu.address.logic.parser;

import seedu.address.logic.commands.ShowBudgetCommand;

/**
 * Parses input arguments and creates a new ShowBudget object
 */
public class ShowBudgetCommandParser implements Parser<ShowBudgetCommand> {

    @Override
    public ShowBudgetCommand parse(String userInput) {
        return new ShowBudgetCommand();
    }
}
