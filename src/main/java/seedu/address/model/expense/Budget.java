package seedu.address.model.expense;

public class Budget {
    private final double budget;

    public Budget() {
        this.budget = 0;
    }

    public Budget(double budget) {
        this.budget = budget;
    }

    /**
     * @param spending of an amount.
     * @return the remaining budget.
     */
    public Budget remaining(double spending) {
        double remaining = this.getValue() - spending;
        return new Budget(remaining);
    }

    /**
     * Exchange the current Budget with a exchangeRate
     * @param exchangeRate of toCurrency.
     * @return new Amount at the given exchangeRate.
     */
    public Budget exchange(ExchangeRate exchangeRate) {
        double value = this.budget * exchangeRate.getRate();
        return new Budget(value);
    }

    public boolean isEmpty() {
        return budget <= 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f", budget);
    }

    public double getValue() {
        return budget;
    }

}
