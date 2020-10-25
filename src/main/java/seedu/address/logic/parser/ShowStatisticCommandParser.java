package seedu.address.logic.parser;

import seedu.address.logic.commands.ShowStatisticCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class ShowStatisticCommandParser implements Parser< ShowStatisticCommand> {
    @Override
    public ShowStatisticCommand parse(String args) throws ParseException {
        return new ShowStatisticCommand();
    }
}
