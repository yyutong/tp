package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.model.expense.Date;

public class DateTest {

    @Test
    public void isValidDate() {
        // invalid Date
        assertFalse(Date.isValidDate(" ")); // spaces only
        assertFalse(Date.isValidDate("phone")); // non-numeric
        assertFalse(Date.isValidDate("9011p041")); // alphabets within digits
        assertFalse(Date.isValidDate("9312 1534")); // spaces within digits

        // valid phone numbers
        assertTrue(Date.isValidDate("1")); // exactly 1 numbers
        assertTrue(Date.isValidDate("93121534"));
        assertTrue(Date.isValidDate("124293842033123")); // long Date numbers
    }
}
