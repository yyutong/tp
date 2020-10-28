package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SIGN;

import java.util.stream.Stream;

import seedu.address.logic.commands.ExchangeCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class ExchangeCommandParser implements Parser<ExchangeCommand> {

    @Override
    public ExchangeCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(userInput, PREFIX_SIGN, PREFIX_RATE);

        if (!arePrefixesPresent(argMultimap, PREFIX_SIGN, PREFIX_RATE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ExchangeCommand.MESSAGE_USAGE));
        }
        String dollarSign = ParserUtil.parseCurrency(argMultimap.getValue(PREFIX_SIGN).get());
        double exchangeRate = ParserUtil.parseExchangeRate(argMultimap.getValue(PREFIX_RATE).get());
        return new ExchangeCommand(dollarSign, exchangeRate);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
