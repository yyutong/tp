
package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ExpenseBook;
import seedu.address.model.Model;
import seedu.address.model.expense.Expense;
import seedu.address.testutil.ExpenseBookBuilder;
import seedu.address.testutil.ExpenseBuilder;

public class CommandTestUtil {
    public static final String INVALID_CATEGORY_1 = "";
    public static final String INVALID_CATEGORY_2 = " ";
    public static final String INVALID_DATE_1 = "-1";
    public static final String INVALID_DATE_2 = "$";
    public static final String INVALID_DATE_3 = "1010";
    public static final Double VALID_AMOUNT_BOOKS = 20.0;
    public static final Double VALID_AMOUNT_MOVIE = 10.0;
    public static final String VALID_DATE_BOOKS = "1";
    public static final String VALID_DATE_MOVIE = "2";
    public static final String VALID_CATEGORY_BOOKS = "study";
    public static final String VALID_CATEGORY_MOVIE = "entertainment";
    public static final String VALID_DESCRIPTION_BOOKS = "Bought textbook";
    public static final String VALID_DESCRIPTION_MOVIE = "Watched 1917 on Tuesday";


    public static final ExpenseBuilder BOOKS;
    public static final ExpenseBuilder MOVIE;

    public static final ExpenseBookBuilder EXPENSE_BOOK;

    static {
        BOOKS = new ExpenseBuilder().withAmount(VALID_AMOUNT_BOOKS)
                .withDate(VALID_DATE_BOOKS).withCategory(VALID_CATEGORY_BOOKS).withDescription(VALID_DESCRIPTION_BOOKS);
        MOVIE = new ExpenseBuilder().withAmount(VALID_AMOUNT_MOVIE)
                .withDate(VALID_DATE_MOVIE).withCategory(VALID_CATEGORY_MOVIE).withDescription(VALID_DESCRIPTION_MOVIE);
        EXPENSE_BOOK = new ExpenseBookBuilder().withExpense(BOOKS.build()).withExpense(MOVIE.build());
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
                                            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
                                            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        ExpenseBook expectedExpenseBook = new ExpenseBook(actualModel.getExpenseBook());
        List<Expense> expectedFilteredList = new ArrayList<>(actualModel.getFilteredExpenseList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedExpenseBook, actualModel.getExpenseBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredExpenseList());
    }

}
