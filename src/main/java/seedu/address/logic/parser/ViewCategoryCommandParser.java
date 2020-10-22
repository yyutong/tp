package seedu.address.logic.parser;

import seedu.address.logic.commands.ViewCategoryCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class ViewCategoryCommandParser implements Parser<ViewCategoryCommand> {
    @Override
    public ViewCategoryCommand parse(String args) throws ParseException {
        return new ViewCategoryCommand();
    }
}
