package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class ExchangeCommand extends Command {
    public static final String COMMAND_WORD = "exchange";
    public static final String MESSAGE_SUCCESS = "Your expenses is now exchanged from %s to %s "
            + "at exchange rate %.2f.\n";
    public static final String MESSAGE_USAGE = "exchange s/CNY xr/5.01";

    private final String dollarSign;
    private final double exchangeRate;

    /**
     * @param dollarSign of the new currency.
     * @param exchangeRate from the current currency to new currency.
     */
    public ExchangeCommand(String dollarSign, double exchangeRate) {
        requireAllNonNull(dollarSign, exchangeRate);
        this.dollarSign = dollarSign;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        String curr = model.getExpenseBookCurrency();
        model.setExpenseBookCurrency(dollarSign);
        model.expenseBookExchange(exchangeRate);
        return new CommandResult(String.format(MESSAGE_SUCCESS, curr, dollarSign, exchangeRate));
    }


}
