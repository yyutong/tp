package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.DescriptionCommand;
import seedu.address.logic.commands.ShowBudgetCommand;
import seedu.address.logic.commands.ViewCategoryCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Description;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CATEGORY;

public class ViewCategoryCommandParser implements Parser<ViewCategoryCommand>{
    @Override
    public ViewCategoryCommand parse(String args) throws ParseException {
        return new ViewCategoryCommand();
    }
}
