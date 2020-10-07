package seedu.address.model.person;

public class Amount {
    public final Double value;

    /**
     * Constructor for default amount with value 0.
     */
    public Amount() {
        this.value = (double) 0;
    }

    public Amount(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Amount: S$ .2f", this.value);
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

}
