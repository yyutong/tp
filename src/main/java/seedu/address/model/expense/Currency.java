package seedu.address.model.expense;

public class Currency {
    private static final String singaporeDollar = "SGD";

    public final String currencyCode;

    public Currency() {
        this.currencyCode = singaporeDollar;
    }

    public Currency(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public int hashCode() {
        return currencyCode.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Currency // instanceof handles nulls
            && currencyCode.equals(((Currency) other).currencyCode)); // state check
    }

    @Override
    public String toString() {
        return currencyCode;
    }

}
