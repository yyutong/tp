package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.ExpenseBook;
import seedu.address.model.person.Expense;
import seedu.address.model.person.Person;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class ExpenseBookBuilder {

    private ExpenseBook expenseBook;

    public ExpenseBookBuilder() {
        expenseBook = new ExpenseBook();
    }

    public ExpenseBookBuilder(ExpenseBook expenseBook) {
        this.expenseBook = expenseBook;
    }

    /**
     * Adds a new {@code Person} to the {@code AddressBook} that we are building.
     */
    public ExpenseBookBuilder withExpense(Expense expense) {
        expenseBook.addExpense(expense);
        return this;
    }

    public ExpenseBook build() {
        return expenseBook;
    }
}
