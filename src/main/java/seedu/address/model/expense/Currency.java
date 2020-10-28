package seedu.address.model.expense;

public class Currency {
    private static final String singaporeDollar = "SGD";

    public final String dollarSign;

    public Currency() {
        this.dollarSign = singaporeDollar;
    }

    public Currency(String dollarSign) {
        this.dollarSign = dollarSign;
    }

    @Override
    public String toString() {
        return dollarSign;
    }

}
