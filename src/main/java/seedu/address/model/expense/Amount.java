package seedu.address.model.expense;

public class Amount {
    public final Double value;

    public Amount(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("S$ %.2f", this.value);
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
