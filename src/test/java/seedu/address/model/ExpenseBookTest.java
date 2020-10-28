package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalExpenses.CLOTHES;
import static seedu.address.testutil.TypicalExpenses.getTypicalExpenseBook;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.expense.Budget;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.Expense;

class ExpenseBookTest {
    private final ExpenseBook expenseBook = new ExpenseBook();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), expenseBook.getExpenseList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> expenseBook.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        ExpenseBook newData = getTypicalExpenseBook();
        expenseBook.resetData(newData);
        assertEquals(newData, expenseBook);
    }
    @Test
    public void hasExpense_nullExpense_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> expenseBook.hasExpense(null));
    }

    @Test
    public void hasExpense_expenseNotInExpenseBook_returnsFalse() {
        assertFalse(expenseBook.hasExpense(CLOTHES));
    }

    @Test
    public void hasExpense_expenseInExpenseBook_returnsFalse() {
        expenseBook.addExpense(CLOTHES);
        assertTrue(expenseBook.hasExpense(CLOTHES));
    }

    @Test
    public void getExpenseList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> expenseBook.getExpenseList().remove(0));
    }

    /**
     * A stub ReadOnlyExpenseBook whose expenses list can violate interface constraints.
     */
    private static class ExpenseBookStub implements ReadOnlyExpenseBook {
        private final ObservableList<Expense> expenses = FXCollections.observableArrayList();

        ExpenseBookStub(Collection<Expense> expenses) {
            this.expenses.setAll(expenses);
        }

        @Override
        public ObservableList<Expense> getExpenseList() {
            return expenses;
        }
        @Override
        public Currency getCurrency() {
            return new Currency("SGD");
        }
        @Override
        public void setBudget(Budget budget) {
        }
        @Override
        public Budget getBudget() {
            return new Budget(1000);
        }
    }
}
