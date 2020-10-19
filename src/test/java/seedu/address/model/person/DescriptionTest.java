package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import seedu.address.model.expense.Description;

class DescriptionTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Description(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidDescription = "";
        assertThrows(IllegalArgumentException.class, () -> new Description(invalidDescription));
    }

//    @Test
//    public void isValidDescription() {
//        // null address
//        assertThrows(NullPointerException.class, () -> Description.isValidDescription(null));
//
//        // invalid addresses
//        assertFalse(Description.isValidDescription("")); // empty string
//        assertFalse(Description.isValidDescription(" ")); // spaces only
//
//        // valid addresses
//        assertTrue(Description.isValidDescription("Movie, together with popcorn"));
//        assertTrue(Description.isValidDescription("-")); // one character
//        assertTrue(Description.isValidDescription("Went out with friends; Watched movie; "
//                + "Had ice cream and tea; Bugis junction")); // long description
//    }
}
