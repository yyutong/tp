package seedu.address.model.expense;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AmountTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Amount(null));
    }

    @Test
    public void constructor_invalidAmount_throwsIllegalArgumentException() {
        String invalidAmount = "-10";
        assertThrows(IllegalArgumentException.class, () -> new Amount(Double.valueOf(invalidAmount)));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> Amount.isValidAmount(null));

        // invalid name
        assertFalse(Amount.isValidAmount(-2.0)); // negative value

        // valid name
        assertTrue(Amount.isValidAmount(0.0)); // zero
        assertTrue(Amount.isValidAmount(123.0)); // double
        assertTrue(Amount.isValidAmount(-0.0)); // zero
    }
}
