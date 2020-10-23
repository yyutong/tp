
package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
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

<<<<<<< HEAD
    public static final String AMOUNT_DESC_BOOKS = " " + PREFIX_AMOUNT + VALID_AMOUNT_BOOKS;
    public static final String AMOUNT_DESC_MOVIE = " " + PREFIX_AMOUNT + VALID_AMOUNT_MOVIE;
    public static final String DATE_DESC_BOOKS = " " + PREFIX_DATE + VALID_DATE_BOOKS;
    public static final String DATE_DESC_MOVIE = " " + PREFIX_DATE + VALID_DATE_MOVIE;
    public static final String CATEGORY_DESC_BOOKS = " " + PREFIX_CATEGORY + VALID_CATEGORY_BOOKS;
    public static final String CATEGORY_DESC_MOVIE = " " + PREFIX_CATEGORY + VALID_CATEGORY_MOVIE;
    public static final String DESCRIPTION_DESC_BOOKS = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_BOOKS;
    public static final String DESCRIPTION_DESC_MOVIE = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_MOVIE;

    public static final String INVALID_AMOUNT_DESC = " " + PREFIX_AMOUNT
            + "-1"; // negative number not allowed in Amount
    public static final String INVALID_DATE_DESC = " " + PREFIX_DATE
            + "-1"; // '-1' negative number not allowed in Date
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";
=======

>>>>>>> upstream/master
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
