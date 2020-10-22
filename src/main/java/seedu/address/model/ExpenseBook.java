package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.commons.core.index.Index;
import seedu.address.model.expense.Category;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.UniqueExpenseList;

/**
 * Wraps all data at the UniSave level
 * Duplicates are not allowed (by .isSameExpense comparison)
 */
public class ExpenseBook implements ReadOnlyExpenseBook {

    private final UniqueExpenseList expenses;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        expenses = new UniqueExpenseList();
    }

    public ExpenseBook() {}

    /**
     * Creates an ExpenseBook using the Expenses in the {@code toBeCopied}
     */
    public ExpenseBook(ReadOnlyExpenseBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setExpenses(List<Expense> expenses) {
        this.expenses.setExpenses(expenses);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyExpenseBook newData) {
        requireNonNull(newData);

        setExpenses(newData.getExpenseList());
    }
    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasExpense(Expense expense) {
        requireNonNull(expense);
        return expenses.contains(expense);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addExpense(Expense p) {
        expenses.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void setExpense(Expense target, Expense editedExpense) {
        requireNonNull(editedExpense);

        expenses.setExpense(target, editedExpense);
    }

    public void viewExpense(Index index) {
        expenses.view(index);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeExpense(Expense key) {
        expenses.remove(key);
    }

    public void setBudget(double budget) {
        expenses.setBudget(budget);
    }

    public double getBudget() {
        return expenses.getBudget();
    }

    public double getRemainingBudget() {
        return expenses.getRemainingBudget();
    }

    public List<Category> getCategoryLabels() {
        return expenses.getCategoryLabels();
    }

    //// util methods

    @Override
    public String toString() {
        return expenses.asUnmodifiableObservableList().size() + " expenses";
        // TODO: refine later
    }

    @Override
    public ObservableList<Expense> getExpenseList() {
        return expenses.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpenseBook // instanceof handles nulls
                && expenses.equals(((ExpenseBook) other).expenses));
    }

    @Override
    public int hashCode() {
        return expenses.hashCode();
    }


}
