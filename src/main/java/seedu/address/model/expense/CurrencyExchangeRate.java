package seedu.address.model.expense;

public class CurrencyExchangeRate {

    private final String currency;
    private final String exchangeRate;

    public CurrencyExchangeRate(String currency, String exchangeRate) {
        this.currency = currency;
        this.exchangeRate = exchangeRate;
    }

    public String getCurrency() {
        return currency;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }
}
