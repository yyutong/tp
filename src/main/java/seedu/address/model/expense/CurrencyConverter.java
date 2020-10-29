package seedu.address.model.expense;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class CurrencyConverter {
    public static final String FILE_NOT_FOUND = "Exchange Rate file not found, "
        + "please download 'ExchangeRate-2020-10-28.txt', "
        + "and put it in the same folder with UniSave.Jar file.";
    private HashMap<Currency, ExchangeRate> usdToExchangeRates;

    /**
     * Construct a CurrencyConverter with a HashMap to store all the exchange rates from USD.
     * The data are read from txt file in doc folder, which can be update manually.
     */
    public CurrencyConverter() throws FileNotFoundException {
        usdToExchangeRates = new HashMap<>();
        readExchangeRate();
    }

    /**
     * Calculate the exchange rate from one currency to another, using USD as a base.
     * @param fromCurr the currency being converted.
     * @param toCurr target currency.
     * @return Exchange rate from 'fromCurr' to 'toCurr'.
     */
    public ExchangeRate convert(Currency fromCurr, Currency toCurr) {
        ExchangeRate usdToFrom = usdToExchangeRates.get(fromCurr);
        ExchangeRate usdToTo = usdToExchangeRates.get(toCurr);
        return new ExchangeRate(usdToTo.getRate() / usdToFrom.getRate());
    }

    private void readExchangeRate() throws FileNotFoundException {
        try {
            File dataFile = new File("./ExchangeRate-2020-10-28.txt");
            Scanner sc = new Scanner(dataFile);
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                Currency currency = new Currency(input.substring(0, 3));
                double xr = Double.parseDouble(input.substring(4));
                ExchangeRate exchangeRate = new ExchangeRate(xr);
                usdToExchangeRates.put(currency, exchangeRate);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    public boolean isValidCurrency(Currency currency) {
        return usdToExchangeRates.containsKey(currency);
    }

}



