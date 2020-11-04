package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.ExchangeCommand;
import seedu.address.model.expense.Currency;

public class ExchangeCommandParserTest {
    private ExchangeCommandParser parser = new ExchangeCommandParser();

    @Test
    public void parse_success() {
        assertParseSuccess(parser, " c/cny", new ExchangeCommand(new Currency("CNY")));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        assertParseFailure(parser, "", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, ExchangeCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, " c/oop", ExchangeCommand.MESSAGE_INVALID_CURRENCY);
    }

}
