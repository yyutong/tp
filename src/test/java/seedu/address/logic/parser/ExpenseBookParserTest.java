package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_EXPENSE;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddDescriptionCommand;
import seedu.address.model.expense.Description;
public class ExpenseBookParserTest {

    private final ExpenseBookParser parser = new ExpenseBookParser();

    @Test
    public void parseCommand_description() throws Exception {
        final Description remark = new Description("Some remark.");
        AddDescriptionCommand command = (AddDescriptionCommand) parser.parseCommand(
                AddDescriptionCommand.COMMAND_WORD + " "
                + INDEX_FIRST_EXPENSE.getOneBased() + " " + PREFIX_DESCRIPTION + remark.value);
        assertEquals(new AddDescriptionCommand(INDEX_FIRST_EXPENSE, remark), command);
    }
}
