package seedu.address.logic.parser;

import seedu.address.logic.commands.ViewCategoryCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewCategoryCommand object
 */
public class ViewCategoryCommandParser implements Parser<ViewCategoryCommand> {
    @Override
    public ViewCategoryCommand parse(String args) throws ParseException {
        return new ViewCategoryCommand();
    }
}
