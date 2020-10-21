package seedu.address.model.person;

import org.junit.jupiter.api.Test;

import static seedu.address.testutil.Assert.assertThrows;

class DescriptionTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Description(null));
    }

}
