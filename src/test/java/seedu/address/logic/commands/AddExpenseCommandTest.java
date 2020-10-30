package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.model.expense.Expense;
import seedu.address.testutil.ExpenseBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddExpenseCommand}.
 */
public class AddExpenseCommandTest {

    @Test
    public void equals() {
        ExpenseBuilder aliceAmountAndCategory = new ExpenseBuilder().withAmount(20.0).withCategory("Entertainment");
        Expense alice = aliceAmountAndCategory.withDate("1").withDescription("movie").build();
        ExpenseBuilder bobWithAmount = new ExpenseBuilder().withAmount(50.0);
        ExpenseBuilder bobAmountAndCategory = bobWithAmount.withAmount(50.0).withCategory("Entertainment");
        Expense bob = bobAmountAndCategory.withDate("2").withDescription("hotpot").build();
        AddExpenseCommand addAliceExpenseCommand = new AddExpenseCommand(alice);
        AddExpenseCommand addBobExpenseCommand = new AddExpenseCommand(bob);

        // same object -> returns true
        assertTrue(addAliceExpenseCommand.equals(addAliceExpenseCommand));

        // same values -> returns true
        AddExpenseCommand addAliceExpenseCommandCopy = new AddExpenseCommand(alice);
        assertTrue(addAliceExpenseCommand.equals(addAliceExpenseCommandCopy));

        // different types -> returns false
        assertFalse(addAliceExpenseCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceExpenseCommand.equals(null));

        // different person -> returns false
        assertFalse(addAliceExpenseCommand.equals(addBobExpenseCommand));
    }
}
