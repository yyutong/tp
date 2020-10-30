package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.expense.*;

import java.util.List;

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
     * Gets the currency of this {@code ExpenseBook}.
     */
    Currency getCurrency();

    /**
     * Sets the budget of this {@code ExpenseBook} to the input amount.
     */
    void setBudget(Budget budget);

    /**
     * Gets the budget of this {@code ExpenseBook}.
     */
    Budget getBudget();

    /**
     * Gets statistics of the expense book
     */
    Statistics getStatistics();
    /**
     * Updates statistic of the expense book.
     */
    void updateStatistics();
    List<StatisticSummary> getStatisticTable();

}
