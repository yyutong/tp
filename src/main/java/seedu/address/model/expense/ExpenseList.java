package seedu.address.model.expense;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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

    /**
     * Add up the amount in the {@code expenses}.
     *
     * @return total spending of the expense list.
     */
    public double totalSpending() {
        double spending = 0;
        for (Expense expense : internalList) {
            spending += expense.getAmount().getValue();
        }
        return spending;
    }

    /**
     * Exchange the {@code expenses} to the input currency.
     * @param dollarSign of the new currency.
     * @param exchangeRate from the current currency.
     */
    public void exchange(Currency dollarSign, ExchangeRate exchangeRate) {
        List<Expense> exchangedExpenses = new ArrayList<>();
        for (Expense expense : internalList) {
            exchangedExpenses.add(expense.exchange(dollarSign, exchangeRate));
        }
        setExpenses(exchangedExpenses);
    }

    public List<Category> getCategoryLabels() {
        List<Category> categories = new ArrayList<>();
        for (Expense current : internalList) {
            Category currentCategory = current.getCategory();
            if (!categories.contains(currentCategory)) {
                categories.add(currentCategory);
            }
        }
        return categories;
    }

    public int getExpenseSumByCategory(String categoryName) {
        int counter = 0;
        for (Expense current : internalList) {
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

    public double getExpenseSum() {
        double sum = 0;
        for (Expense current : internalList) {
            Amount currentAmount = current.getAmount();
            double currentAmountValue = currentAmount.getValue();
            sum = sum + currentAmountValue;
        }
        return sum;
    }

    public HashMap<String, Double> getExpenseSumCategory() {
        double sum = 0;
        List<Category> categories = getCategoryLabels();
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        for (int i = 0; i < categories.size(); i = i + 1) {
            String currentCategory = categories.get(i).categoryName;
            double categorySum = getExpenseSumOfCategory(currentCategory);
            hashMap.put(currentCategory, categorySum);
        }
        return hashMap;
    }

    public HashMap<String, Double> getExpensePercentageCategory() {
        double sum = 0;
        List<Category> categories = getCategoryLabels();
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        double totalSum = getExpenseSum();
        for (int i = 0; i < categories.size(); i = i + 1) {
            String currentCategory = categories.get(i).categoryName;
            double categorySum = getExpenseSumOfCategory(currentCategory);
            double percentage = categorySum / totalSum * 100;
            hashMap.put(currentCategory, percentage);
        }
        return hashMap;
    }

    public double getExpenseSumOfCategory(String categoryName) {
        double sum = 0;
        List<Category> categories = getCategoryLabels();
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        for (Expense current : internalList) {
            Category currentCategory = current.getCategory();
            String currentCategoryName = currentCategory.categoryName;
            if (categoryName.equals(currentCategoryName)) {
                Amount currentAmount = current.getAmount();
                double currentAmountValue = currentAmount.getValue();
                sum = sum + currentAmountValue;
            }
        }
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

    /**
     * Sorts the expense list by ascending amount.
     */
    public void sortByAscendingAmount() {
        internalList.sort(Comparator.comparing(expense -> expense.getAmount().value));

    }

    /**
     * Sorts the expense list by descending amount.
     */
    public void sortByDescendingAmount() {
        internalList.sort((expense, other) -> other.getAmount().value.compareTo(expense.getAmount().value));
    }

    /**
     * Sorts the expense list by descending timr.
     */
    public void sortByDescendingTime() {
        internalList.sort((expense, other) -> {
            if (expense.getDate().getLocalDate()
                    .isBefore(other.getDate().getLocalDate())) {
                return 1;
            } else if (expense.getDate().getLocalDate()
                    .isBefore(other.getDate().getLocalDate())) {
                return -1;
            } else {
                return 0;
            }
        });
    }

    /**
     * Sorts the expense list by ascending time.
     */
    public void sortByAscendingTime() {
        internalList.sort((expense, other) -> {
            if (expense.getDate().getLocalDate()
                    .isAfter(other.getDate().getLocalDate())) {
                return 1;
            } else if (expense.getDate().getLocalDate()
                    .isAfter(other.getDate().getLocalDate())) {
                return -1;
            } else {
                return 0;
            }
        });
    }

}
