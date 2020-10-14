package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.ListExpenseByCategoryCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.CategoryContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class ListExpenseByCategoryCommandParser implements Parser<ListExpenseByCategoryCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListExpenseByCategoryCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListExpenseByCategoryCommand.MESSAGE_USAGE));
        }

        String[] categoryKeywords = trimmedArgs.split("\\s+");

        return new ListExpenseByCategoryCommand(new CategoryContainsKeywordsPredicate(Arrays.asList(categoryKeywords)));
    }

}
