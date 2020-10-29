package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.model.Model;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.ExchangeRate;

/**
 * Exchange the currency for the user.
 */
public class ExchangeCommand extends Command {
    public static final String COMMAND_WORD = "exchange";
    public static final String MESSAGE_SUCCESS = "Your expenses is now converted from %s to %s "
            + "at exchange rate %s.\n";
    public static final String MESSAGE_USAGE = "exchange s/CNY xr/5.01";

    private final Currency dollarSign;
    private final ExchangeRate exchangeRate;

    /**
     * @param dollarSign of the new currency.
     * @param exchangeRate from the current currency to new currency.
     */
    public ExchangeCommand(Currency dollarSign, ExchangeRate exchangeRate) {
        requireAllNonNull(dollarSign, exchangeRate);
        this.dollarSign = dollarSign;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        Currency curr = model.getExpenseBookCurrency();
        model.setExpenseBookCurrency(dollarSign);
        model.expenseBookExchange(exchangeRate);
        return new CommandResult(String.format(MESSAGE_SUCCESS, curr, dollarSign, exchangeRate));
    }


}
