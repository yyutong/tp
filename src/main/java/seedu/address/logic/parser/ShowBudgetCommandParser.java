package seedu.address.logic.parser;

import seedu.address.logic.commands.ShowBudgetCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class ShowBudgetCommandParser implements Parser<ShowBudgetCommand> {

    @Override
    public ShowBudgetCommand parse(String userInput) throws ParseException {
        return new ShowBudgetCommand();
    }
}
