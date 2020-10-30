package seedu.address.logic.parser;

import seedu.address.logic.commands.ShowStatisticCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ShowStatisticCommand object
 */
public class ShowStatisticCommandParser implements Parser<ShowStatisticCommand> {
    @Override
    public ShowStatisticCommand parse(String args) throws ParseException {
        return new ShowStatisticCommand();
    }
}
