package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.SetBudgetCommand;
import seedu.address.model.expense.Budget;

public class SetBudgetCommandParserTest {
    private SetBudgetCommandParser parser = new SetBudgetCommandParser();

    @Test
    public void parse_success() {
        assertParseSuccess(parser, " 100", new SetBudgetCommand(new Budget(100)));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        assertParseFailure(parser, "", SetBudgetCommand.MESSAGE_SET_BUDGET_FAIL);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, " -1", SetBudgetCommand.MESSAGE_SET_BUDGET_FAIL);
    }

}
