package seedu.address.model;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.expense.Category;
import seedu.address.model.expense.Expense;

/**
 * The API of the Model component.
 */
public interface Model {

    Predicate<Expense> PREDICATE_SHOW_ALL_EXPENSES = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getExpenseBookFilePath();

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setExpenseBook(ReadOnlyExpenseBook expenseBook);

    /** Returns the AddressBook */
    ReadOnlyExpenseBook getExpenseBook();

    /** Returns the with sample removed */
    ReadOnlyExpenseBook getExpenseBookWithoutSample();

    /**
     * Sets the user prefs' address book file path.
     */
    void setExpenseBookFilePath(Path expenseBookFilePath);

    /**
     * Returns true if the expense exists in the address book.
     */
    boolean hasExpense(Expense expense);

    /**
     * Deletes the given Expense.
     * The Expense must exist in the address book.
     */
    void deleteExpense(Expense targetExpense);
    /**
     * Adds the given expense.
     * {@code person} must not already exist in the address book.
     */
    void addExpense(Expense expense);

    /**
     * Replaces the given expense {@code target} with {@code editedExpense}.
     * {@code target} must exist in the finance manager.
     * The person identity of {@code editedExpense} must not be the same as another existing expense in the finance
     * manager.
     */
    void setExpense(Expense target, Expense editedExpense);


    /** Returns an unmodifiable view of the filtered Expense list */
    ObservableList<Expense> getFilteredExpenseList();


    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredExpenseList(Predicate<Expense> predicate);

    double getExpenseBookBudget();

    double getExpenseBookRemaining();

    void setExpenseBookBudget(double budget);

    List<Category> getCategoryLabels();
    int getExpenseSumByCategory(String categoryName);

    int getTotalExpense();

    void sortByDescendingAmount();

    void sortByAscendingAmount();

    void sortByDescendingTime();

    void sortByAscendingTime();
}
