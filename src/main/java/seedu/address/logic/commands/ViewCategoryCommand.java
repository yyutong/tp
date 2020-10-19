package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.expense.Category;

import java.util.List;

public class ViewCategoryCommand extends Command {

    public static final String COMMAND_WORD = "viewCategory";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Finds all the category labels used in the ExpenseBook so far. \n"
            + "Example: " + COMMAND_WORD ;

    public static final String MESSAGE_VIEW_CATEGORY_LABELS_SUCCESS =
            "View all the existing category labels: \n";

    public ViewCategoryCommand() {
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        String message = "";
        List<Category> categories = model.getCategoryLabels();
        for (int i = 0; i < categories.size(); i++){
            message = message + categories.get(i).categoryName + "\n";
        }
        return new CommandResult(MESSAGE_VIEW_CATEGORY_LABELS_SUCCESS + message);
    }

}
