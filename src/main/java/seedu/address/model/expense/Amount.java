package seedu.address.model.expense;

public class Amount {
    public static final String MESSAGE_CONSTRAINTS =
            "Amount should only positive numbers";


    public final Double value;

    /**
     * Default currency is Singapore Dollar.
     * @param value of the amount.
     */
    public Amount(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%.2f ", this.value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Amount // instanceof handles nulls
                && value.equals(((Amount) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public double getValue() {
        return this.value;
    }

}
