package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.expense.DescContainsKeywordsPredicate;

/**
 * Finds and lists all expenses in expense book whose description contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class ListExpenseByDescCommand extends Command {

    public static final String COMMAND_WORD = "listbydesc";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all expenses whose description contains any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " movies";

    public static final String MESSAGE_SUCCESS = "Listed all expenses by Description";

    private final DescContainsKeywordsPredicate predicate;

    public ListExpenseByDescCommand(DescContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredExpenseList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_EXPENSES_LISTED_OVERVIEW, model.getFilteredExpenseList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ListExpenseByDescCommand // instanceof handles nulls
                && predicate.equals(((ListExpenseByDescCommand) other).predicate)); // state check
    }
}
