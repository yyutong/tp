package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.AddDescriptionCommand;
import seedu.address.logic.commands.AddExpenseCommand;
import seedu.address.logic.commands.SortByAmountCommand;
import seedu.address.model.expense.Expense;
import seedu.address.testutil.ExpenseBuilder;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalExpenses.BOOKS;
import static seedu.address.testutil.TypicalExpenses.MOVIE;

public class SortByAmountCommandParserTest {
    private SortByAmountCommandParser parser = new SortByAmountCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Expense expectedExpense1 = new ExpenseBuilder(BOOKS).build();

        String userInput1 = " descending";

        // whitespace only preamble
        assertParseSuccess(parser, userInput1, new SortByAmountCommand(" descending"));

        Expense expectedExpense2 = new ExpenseBuilder(MOVIE).build();

        String userInput2 = " ascending";

        assertParseSuccess(parser, userInput2, new SortByAmountCommand(" ascending"));

    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, "up", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, AddDescriptionCommand.MESSAGE_USAGE));
    }
}
