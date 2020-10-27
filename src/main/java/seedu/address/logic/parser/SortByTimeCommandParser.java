package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.SortByAmountCommand;
import seedu.address.logic.commands.SortByTimeCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class SortByTimeCommandParser implements Parser<SortByTimeCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SortByTimeCommand
     * and returns a SortByTimeCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortByTimeCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (args.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortByAmountCommand.MESSAGE_USAGE));
        }
        assert !trimmedArgs.isEmpty();

        return new SortByTimeCommand(args);
    }

}
