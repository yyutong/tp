package seedu.address.model.expense;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.commons.core.index.Index;
import seedu.address.model.expense.exceptions.ExpenseNotFoundException;

/**
 * A list of expenses that does not allow nulls.
 * Supports a minimal set of list operations.
 */
public class ExpenseList implements Iterable<Expense> {

    private final ObservableList<Expense> internalList = FXCollections.observableArrayList();
    private final ObservableList<Expense> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    private double budget = 0;

    /**
     * Returns true if the list contains an equivalent expense as the given argument.
     */
    public boolean contains(Expense toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameExpense);
    }

    /**
     * Adds a expense to the list.
     * The expense must not already exist in the list.
     */
    public void add(Expense toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
    }

    /**
     * View the detals of a certain expense.
     *
     * @param index The index of the expense to be viewed in the ExpenseBook.
     */
    public void view(Index index) {
        requireAllNonNull(index);
        Expense expense = internalList.get(index.getOneBased());
    }

    /**
     * Replaces the expense {@code target} in the list with {@code editedExpense}.
     * {@code target} must exist in the list.
     * The expense identity of {@code editedExpense} must not be the same as another existing expense in the list.
     */
    public void setExpense(Expense target, Expense editedExpense) {
        requireAllNonNull(target, editedExpense);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new ExpenseNotFoundException();
        }
        internalList.set(index, editedExpense);
    }

    /**
     * Removes the equivalent expense from the list.
     * The expense must exist in the list.
     */
    public void remove(Expense toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new ExpenseNotFoundException();
        }
    }

    /**
     * Replaces the contents of this list with {@code expenses}.
     * {@code expenses} must not be nulls.
     */
    public void setExpenses(List<Expense> expenses) {
        requireAllNonNull(expenses);
        internalList.setAll(expenses);
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBudget() {
        return this.budget;
    }

    public double getRemainingBudget() {
        double used = 0;
        for (int i = 0; i < internalList.size(); i++) {
            used += internalList.get(i).getAmount().getValue();
        }
        return this.budget - used;
    }

    public List<Category> getCategoryLabels() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < internalList.size(); i++) {
            Expense current = internalList.get(i);
            Category currentCategory = current.getCategory();
            if (!categories.contains(currentCategory)) {
                categories.add(currentCategory);
            }
        }
        return categories;
    }
    public int getExpenseSumByCategory(String categoryName) {
        int counter = 0;
        for (int i = 0; i < internalList.size(); i = i + 1) {
            Expense current = internalList.get(i);
            Category currentCategory = current.getCategory();
            String currentCategoryName = currentCategory.categoryName;
            if (currentCategoryName.equals(categoryName)) {
                counter = counter + 1;
            }
        }
        return counter;
    }

    public int getTotalExpense() {
        int sum = internalList.size();
        return sum;
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Expense> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Expense> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpenseList // instanceof handles nulls
                && internalList.equals(((ExpenseList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

}
