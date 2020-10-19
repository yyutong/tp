package seedu.address.logic.parser;

import seedu.address.logic.commands.ViewCategoryCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static java.util.Objects.requireNonNull;

public class ViewCategoryCommandParser implements Parser<ViewCategoryCommand>{
    @Override
    public ViewCategoryCommand parse(String args) throws ParseException {
        return new ViewCategoryCommand();
    }
}
