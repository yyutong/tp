package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Category;
import seedu.address.model.person.Expense;
import seedu.address.model.person.Person;

/**
 * Represents the in-memory model of the address book data.
 */
public class ExpenseModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final ExpenseBook expenseBook;
    private final UserPrefs userPrefs;
    private final FilteredList<Expense> filteredExpenses;



    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ExpenseModelManager(ReadOnlyExpenseBook expenseBook, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(expenseBook, userPrefs);

        logger.fine("Initializing with expense book: " + expenseBook + " and user prefs " + userPrefs);

        this.expenseBook = new ExpenseBook(expenseBook);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredExpenses = new FilteredList<>(this.expenseBook.getExpenseList());
    }

    public ExpenseModelManager() {
        this(new ExpenseBook(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getExpenseBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setExpenseBookFilePath(addressBookFilePath);
    }

    @Override
    public void setExpenseBook(ReadOnlyExpenseBook expenseBook) {
        this.expenseBook.resetData(expenseBook);
    }

    @Override
    public ReadOnlyExpenseBook getExpenseBook() {
        return expenseBook;
    }

    //=========== AddressBook ================================================================================

    @Override
    public boolean hasExpense(Expense expense) {
        requireNonNull(expense);
        return expenseBook.hasExpense(expense);
    }

    @Override
    public void deleteExpense(Expense targetExpense) {
        expenseBook.removeExpense(targetExpense);
    }
    @Override
    public void addExpense(Expense expense) {
        expenseBook.addExpense(expense);
        updateFilteredExpenseList(PREDICATE_SHOW_ALL_EXPENSES);
    }

    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return null;
    }


    //edited
    @Override
    public void setExpense(Expense target, Expense editedExpense) {
        requireAllNonNull(target, editedExpense);
        expenseBook.setExpense(target, editedExpense);
    }

    //=========== Filtered Expense List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Expense} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Expense> getFilteredExpenseList() {
        return filteredExpenses;
    }

    @Override
    public void updateFilteredPersonList(Predicate<Person> predicate) {

    }
    /**
     * Returns an updated Expense List
     * @param predicate
     */
    @Override
    public void updateFilteredExpenseList(Predicate<Expense> predicate) {
        requireNonNull(predicate);
        filteredExpenses.setPredicate(predicate);
    }

    // end of edit

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ExpenseModelManager)) {
            return false;
        }

        // state check
        ExpenseModelManager other = (ExpenseModelManager) obj;
        return expenseBook.equals(other.expenseBook)
                && userPrefs.equals(other.userPrefs)
                && filteredExpenses.equals(other.filteredExpenses);
    }

    //yuanxing edited
    @Override
    public double getExpenseBookBudget() {
        return expenseBook.getBudget();
    }

    @Override
    public double getExpenseBookRemaining() {
        return expenseBook.getRemainingBudget();
    }

    @Override
    public void setExpenseBookBudget(double budget) {
        expenseBook.setBudget(budget);
    }

    @Override
    public List<Category> getCategoryLabels() {
        return expenseBook.getCategoryLabels();
    }


}
