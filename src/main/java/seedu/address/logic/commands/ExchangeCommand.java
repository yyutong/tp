package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.io.FileNotFoundException;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.CurrencyConverter;
import seedu.address.model.expense.ExchangeRate;

public class ExchangeCommand extends Command {
    public static final String COMMAND_WORD = "exchange";
    public static final String MESSAGE_SUCCESS = "Your expenses is now converted from %s to %s "
            + "at exchange rate %s.\n";
    public static final String MESSAGE_USAGE = "exchange s/CNY";
    public static final String MESSAGE_INVALID_CURRENCY = "Please enter a valid currency!";

    private final Currency toCurrency;

    /**
     * @param toCurrency of the new currency.
     */
    public ExchangeCommand(Currency toCurrency) {
        requireAllNonNull(toCurrency);
        this.toCurrency = toCurrency;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Currency curr = model.getExpenseBookCurrency();
        try {
            CurrencyConverter converter = new CurrencyConverter();
            ExchangeRate exchangeRate = converter.convert(curr, toCurrency);
            model.setExpenseBookCurrency(toCurrency);
            model.expenseBookExchange(exchangeRate);
            return new CommandResult(String.format(MESSAGE_SUCCESS, curr, toCurrency, exchangeRate));
        } catch (FileNotFoundException E) {
            throw new CommandException(CurrencyConverter.FILE_NOT_FOUND);
        }
    }


}
