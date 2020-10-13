package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static java.util.Objects.requireNonNull;
import seedu.address.commons.exceptions.IllegalValueException;

import java.util.Arrays;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.NameContainsKeywordsPredicate;

public class ViewCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewCommand
     * and returns a ViewCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewCommand parse(String args) throws ParseException {
//        String trimmedArgs = args.trim();
        requireNonNull(args);
        try{
            int index = Integer.parseInt(args);
            if (index<=0) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
            }
            return new ViewCommand(Index.fromOneBased(index));
        } catch(IllegalValueException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ViewCommand.MESSAGE_USAGE));
        }
    }
}
