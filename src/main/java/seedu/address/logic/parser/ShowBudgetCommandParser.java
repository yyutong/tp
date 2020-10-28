package seedu.address.logic.parser;

import seedu.address.logic.commands.ShowBudgetCommand;

public class ShowBudgetCommandParser implements Parser<ShowBudgetCommand> {

    @Override
    public ShowBudgetCommand parse(String userInput) {
        return new ShowBudgetCommand();
    }
}
