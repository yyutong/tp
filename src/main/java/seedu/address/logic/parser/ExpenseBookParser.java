package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddExpenseCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteDescriptionCommand;
import seedu.address.logic.commands.DeleteExpenseCommand;
import seedu.address.logic.commands.AddDescriptionCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListExpenseByCategoryCommand;
import seedu.address.logic.commands.ListExpenseCommand;
import seedu.address.logic.commands.SetBudgetCommand;
import seedu.address.logic.commands.ShowBudgetCommand;
import seedu.address.logic.commands.ViewCategoryCommand;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class ExpenseBookParser {
    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());

        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch (commandWord) {
        case AddExpenseCommand.COMMAND_WORD:
            return new AddExpenseCommandParser().parse(arguments);
        case DeleteExpenseCommand.COMMAND_WORD:
            return new DeleteExpenseCommandParser().parse(arguments);
        case ListExpenseCommand.COMMAND_WORD:
            return new ListExpenseCommand();
        case ViewCommand.COMMAND_WORD:
            return new ViewCommandParser().parse(arguments);
        case ViewCategoryCommand.COMMAND_WORD:
            return new ViewCategoryCommandParser().parse(arguments);
        case AddDescriptionCommand.COMMAND_WORD:
            return new AddDescriptionCommandParser().parse(arguments);
        case DeleteDescriptionCommand.COMMAND_WORD:
            return new DeleteDescriptionCommandParser().parse(arguments);
        case ListExpenseByCategoryCommand.COMMAND_WORD:
            return new ListExpenseByCategoryCommandParser().parse(arguments);
        case ShowBudgetCommand.COMMAND_WORD:
            return new ShowBudgetCommandParser().parse(arguments);
        case SetBudgetCommand.COMMAND_WORD:
            return new SetBudgetCommandParser().parse(arguments);
        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
