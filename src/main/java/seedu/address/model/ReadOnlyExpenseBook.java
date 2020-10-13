package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.person.Expense;

/**
 * Unmodifiable view of an expense book
 */
public interface ReadOnlyExpenseBook {

    /**
     * Returns an unmodifiable view of the expense list.
     * This list will not contain any duplicate expenses.
     */
    ObservableList<Expense> getExpenseList();

}