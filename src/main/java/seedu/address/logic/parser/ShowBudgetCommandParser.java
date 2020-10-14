package seedu.address.logic.parser;

import seedu.address.logic.commands.DescriptionCommand;
import seedu.address.logic.commands.ShowBudgetCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Description;

public class ShowBudgetCommandParser implements Parser<ShowBudgetCommand> {

    @Override
    public ShowBudgetCommand parse(String userInput) throws ParseException {
        return new ShowBudgetCommand();
    }
}
