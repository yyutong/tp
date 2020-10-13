package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

public class Expense {

    // Identity fields
    private final Amount amount;
    private final Date date;
    private final Category category;
    private final Description description;

    /**
     * Every field must be present and not null.
     */
    public Expense(Amount amount, Date date, Category category, Description description) {
        requireAllNonNull(amount, date, category);
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.description = description;
    }

    public Amount getAmount() {
        return this.amount;
    }

    public Date getDate() {
        return this.date;
    }

    public Category getCategory() {
        return this.category;
    }

    public Description getDescription() {
        return this.description;
    }


    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSameExpense(Expense otherExpense) {
        if (otherExpense == this) {
            return true;
        }

        return otherExpense != null
                && otherExpense.getAmount().equals(this.getAmount())
                && otherExpense.getDate().equals(this.getDate())
                && otherExpense.getCategory().equals(this.getCategory())
                && otherExpense.getDescription().equals(this.getDescription());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Expense)) {
            return false;
        }

        Expense otherExpense = (Expense) other;
        return otherExpense.getAmount().equals(getAmount())
                && otherExpense.getDate().equals(getDate())
                && otherExpense.getCategory().equals(getCategory())
                && otherExpense.getDescription().equals(getDescription());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(amount, date, category, description);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        if (description.isEmpty()) {
            builder.append(" Amount: ")
                    .append(this.getAmount())
                    .append("/n")
                    .append(" Date: ")
                    .append(this.getDate())
                    .append("/n")
                    .append(" Category: ")
                    .append(this.getCategory())
                    .append("/n");
            return builder.toString();
        } else {
            builder.append(" Amount: ")
                    .append(this.getAmount())
                    .append("/n")
                    .append(" Date: ")
                    .append(this.getDate())
                    .append(" Category: ")
                    .append("/n")
                    .append(this.getCategory())
                    .append(" Description: ")
                    .append(this.getDescription())
                    .append("/n");
            return builder.toString();
        }
    }

}
