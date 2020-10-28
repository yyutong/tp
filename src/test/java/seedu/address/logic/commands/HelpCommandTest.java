package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.HelpCommand.ADDDESCOMMOND;
import static seedu.address.logic.commands.HelpCommand.ADDEXPENSECOMMAND;
import static seedu.address.logic.commands.HelpCommand.DELETECOMMOND;
import static seedu.address.logic.commands.HelpCommand.DELETEDESCOMMOND;
import static seedu.address.logic.commands.HelpCommand.EXITCOMMOND;
import static seedu.address.logic.commands.HelpCommand.LISTBYCATEGORYCOMMOND;
import static seedu.address.logic.commands.HelpCommand.LISTCOMMOND;
import static seedu.address.logic.commands.HelpCommand.SETBUDGETCOMMOND;
import static seedu.address.logic.commands.HelpCommand.SHOWBUDGETCOMMOND;
import static seedu.address.logic.commands.HelpCommand.SHOWING_HELP_MESSAGE;
import static seedu.address.logic.commands.HelpCommand.SHOWSTATISTICCOMMAND;
import static seedu.address.logic.commands.HelpCommand.VIEWCATEGORYCOMMOND;
import static seedu.address.logic.commands.HelpCommand.VIEWCOMMOND;

import org.junit.jupiter.api.Test;

import seedu.address.model.ExpenseModelManager;
import seedu.address.model.Model;

public class HelpCommandTest {
    private Model model = new ExpenseModelManager();
    private Model expectedModel = new ExpenseModelManager();

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(ADDEXPENSECOMMAND + LISTCOMMOND
                + LISTBYCATEGORYCOMMOND + VIEWCOMMOND + VIEWCATEGORYCOMMOND
                + ADDDESCOMMOND + DELETECOMMOND + DELETEDESCOMMOND + SETBUDGETCOMMOND + SHOWBUDGETCOMMOND
                + SHOWSTATISTICCOMMAND + EXITCOMMOND, true, false);
        assertCommandSuccess(new HelpCommand(), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_help_failure() {
        CommandResult expectedCommandResult = new CommandResult(SHOWING_HELP_MESSAGE, true, false);
        CommandResult actualCommandResult = new HelpCommand().execute(model);
        assertFalse(expectedCommandResult.equals(actualCommandResult));
    }
}
