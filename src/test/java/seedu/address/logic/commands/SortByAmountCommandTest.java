package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SortByAmountCommandTest {
    @Test
    public void equals() {
        SortByAmountCommand sortByAmountCommandDescending =
                new SortByAmountCommand(" descending");

        SortByAmountCommand sortByAmountCommandDescendingCopy =
                new SortByAmountCommand(" descending");

        SortByAmountCommand sortByAmountCommandAscending =
                new SortByAmountCommand(" ascending");

        SortByAmountCommand sortByAmountCommandAscendingCopy =
                new SortByAmountCommand(" ascending");

        // same object -> returns true
        assertTrue(sortByAmountCommandAscending.equals(sortByAmountCommandAscending));

        // same object -> returns true
        assertTrue(sortByAmountCommandDescending.equals(sortByAmountCommandDescending));

        // same values -> returns true
        assertTrue(sortByAmountCommandAscending.equals(sortByAmountCommandAscendingCopy));

        assertTrue(sortByAmountCommandDescending.equals(sortByAmountCommandDescendingCopy));
        // different types -> returns false
        assertFalse(sortByAmountCommandAscending.equals(1));

        // null -> returns false
        assertFalse(sortByAmountCommandDescending.equals(null));

        // different person -> returns false
        assertFalse(sortByAmountCommandAscending.equals(sortByAmountCommandDescending));
    }

}
