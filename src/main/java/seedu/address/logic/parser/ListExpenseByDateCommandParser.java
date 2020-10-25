package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.ListExpenseByCategoryCommand;
import seedu.address.logic.commands.ListExpenseByDateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expense.DateContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new ListExpenseByDateCommand object
 */
public class ListExpenseByDateCommandParser implements Parser<ListExpenseByDateCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ListExpenseByDateCommand
     * and returns a ListExpenseByDateCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListExpenseByDateCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListExpenseByCategoryCommand.MESSAGE_USAGE));
        }
        assert !trimmedArgs.isEmpty();
        String[] categoryKeywords = trimmedArgs.split("\\s+");

        return new ListExpenseByDateCommand(new DateContainsKeywordsPredicate(Arrays.asList(categoryKeywords)));
    }

}
