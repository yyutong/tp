package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.expense.Budget;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.Expense;

/**
 * Unmodifiable view of an expense book
 */
public interface ReadOnlyExpenseBook {

    /**
     * Returns an unmodifiable view of the expense list.
     * This list will not contain any duplicate expenses.
     */
    ObservableList<Expense> getExpenseList();

    /**
     * Get the currency of this {@code ExpenseBook}.
     */
    Currency getCurrency();

    /**
     * Set the budget of this {@code ExpenseBook} to the input amount.
     */
    void setBudget(Budget budget);

    /**
     * Get the budget of this {@code ExpenseBook}.
     */
    Budget getBudget();

}
