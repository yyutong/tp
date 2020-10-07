package seedu.address.model.person;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;

public class Date {

    public static final String MESSAGE_CONSTRAINTS =
            "Date should only contain numbers, and it should be at least 1 digits long";
    public static final String VALIDATION_REGEX = "\\d{1,}";
    public final String date;

    /**
     * Constructor for Date.
     * @param inputDay Allow user to type in how many days ago he spent the money.
     */
    public Date(String inputDay) {
        checkArgument(isValidDate(inputDay), MESSAGE_CONSTRAINTS);
        LocalDate localdate = LocalDate.now();
        int convertedDay = Integer.parseInt(inputDay);
        LocalDate dayBefore = localdate.minusDays(convertedDay);
        this.date = dayBefore.toString();
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
     * Returns true if a given string is a valid Day.
     */
    public static boolean isValidDate(String test) {
        return test.matches(VALIDATION_REGEX);
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
