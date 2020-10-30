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
        String[] dateKeywords = trimmedArgs.split("\\s+");
        checkValidDate(dateKeywords);

        return new ListExpenseByDateCommand(new DateContainsKeywordsPredicate(Arrays.asList(dateKeywords)));
    }

    // for each input date, check dashes

    /**
     * Loop through all the inputDate in {@code inputDates} and check the date is valid.
     * The validity of date is based on format YYYY-MM-DD. This method is checking for 2 dashes appear in the date.
     * @param inputDates
     * @throws ParseException
     */
    private void checkValidDate(String[] inputDates) throws ParseException {
        // create a new array for dates to not modifying original array
        String[] copyDates = new String[inputDates.length];
        for (int i = 0; i < inputDates.length; i++) {
            copyDates[i] = inputDates[i];
        }

        for (String date: copyDates) {
            String[] splitDateByDash = date.split("-");
            if (splitDateByDash.length != 3) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListExpenseByCategoryCommand.MESSAGE_USAGE));
            }
        }
    }
}
