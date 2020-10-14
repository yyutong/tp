package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.person.Category;
import seedu.address.model.person.Description;
import seedu.address.model.person.Expense;

import java.util.List;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_EXPENSES;

public class ViewCategoryCommand extends Command {

    public static final String COMMAND_WORD = "viewCategory";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Finds all the category labels used in the ExpenseBokk so far. \n"
            + "Example: " + COMMAND_WORD ;

    public static final String MESSAGE_VIEW_CATEGORY_LABELS_SUCCESS =
            "View all the existing category labels: \n";

    public ViewCategoryCommand() {
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Category> categories = model.getCategoryLabels();
        String message = "";
        for(int i = 0; i < categories.size()-1; i++){
            message = message + categories.get(i).toString() + "\n";
        }
        return new CommandResult(MESSAGE_VIEW_CATEGORY_LABELS_SUCCESS + message);
    }

}
