package seedu.address.model.person;
import java.time.LocalDate;

public class Date {

    public final String date;

    /**
     * Constructor for Date.
     * @param date The date of the expenses.
     */
    public Date (String date) {
        this.date = date;
    }

    /**
     * Constructor for Date.
     * when the date is not entered, localdate will be used for the date of expeense
     */
    public Date () {
        LocalDate localdate = LocalDate.now();
        this.date = localdate.toString();
    }

    /**
     * Constructor for Date.
     * @param howManyDayBefore Allow user to type in how many days ago he spent the money.
     */
    public Date (int howManyDayBefore) {
        LocalDate localdate = LocalDate.now();
        LocalDate dayBefore = localdate.minusDays(howManyDayBefore);
        this.date = dayBefore.toString();
    }

    @Override
    public String toString() {
        return this.date;
    }

    @Override
    public int hashCode() {
        return this.date.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date // instanceof handles nulls
                && date.equals(((Date) other).date)); // state check
    }

}
