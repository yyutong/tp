package seedu.address.logic.parser;

import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ViewCategoryLabelsCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class ViewCategoryLabelsCommandParser implements Parser<ViewCategoryLabelsCommand>{
    @Override
    public ViewCategoryLabelsCommand parse(String userInput) throws ParseException {
        return new ViewCategoryLabelsCommand();
    }
}
