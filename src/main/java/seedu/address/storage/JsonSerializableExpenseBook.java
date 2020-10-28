package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ExpenseBook;
import seedu.address.model.ReadOnlyExpenseBook;
import seedu.address.model.expense.Budget;
import seedu.address.model.expense.Currency;
import seedu.address.model.expense.Expense;

/**
 * An Immutable ExpenseBook that is serializable to JSON format.
 */
@JsonRootName(value = "expensebook")
class JsonSerializableExpenseBook {
    public static final String MESSAGE_DUPLICATE_EXPENSE = "Expense list contains duplicate expense(s).";
    private static final Logger logger = LogsCenter.getLogger(JsonExpenseBookStorage.class);
    private final List<JsonAdaptedExpense> expenses = new ArrayList<>();
    private final Double budget;
    private final String dollarSign;

    /**
     * Constructs a {@code JsonSerializableExpenseBook} with the given expenses.
     */
    @JsonCreator
    public JsonSerializableExpenseBook(@JsonProperty("expenses") List<JsonAdaptedExpense> expenses,
                                       @JsonProperty("budget") String budget,
                                       @JsonProperty("dollarSign") String dollarSign) {
        this.expenses.addAll(expenses);
        this.budget = Double.valueOf(budget);
        this.dollarSign = dollarSign;
    }

    /**
     * Converts a given {@code ReadOnlyExpenseBook} into this class for Json use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableExpenseBook}.
     */
    public JsonSerializableExpenseBook(ReadOnlyExpenseBook source) {
        expenses.addAll(source.getExpenseList().stream().map(JsonAdaptedExpense::new).collect(Collectors.toList()));
        budget = source.getBudget().getValue();
        logger.info("budget obtained at source.getBudget().getValue() is " + budget);
        dollarSign = source.getCurrency().dollarSign;
    }

    /**
     * Converts this expense book into the model's {@code ExpenseBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public ExpenseBook toModelType() throws IllegalValueException {
        logger.info("converting json adapted expense to model type");
        ExpenseBook expenseBook = new ExpenseBook();
        for (JsonAdaptedExpense jsonAdaptedExpense : expenses) {
            logger.info("jsonAdaptedExpense： " + jsonAdaptedExpense);
            Expense expense = jsonAdaptedExpense.toModelType();
            if (expenseBook.hasExpense(expense)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_EXPENSE);
            }
            expenseBook.addExpense(expense);
        }
        expenseBook.setCurrency(new Currency(dollarSign));
        expenseBook.setBudget(new Budget(budget));
        return expenseBook;
    }

}
