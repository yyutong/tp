package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    public static final String addExpenseCommand = "use ADD to add an expense" + "\n"
            + "Format: add a/AMOUNT c/CATEGORY D/DATE [d/DESCRIPTION], Eg: add a/50 c/ENTERTAINMENT D/1 d/movie" + "\n"
            + "\n";

    public static final String listCommand = "use LIST to list all expenses" + "\n"
            + "Format: list , Eg: list" + "\n" + "\n";

    public static final String listByCategoryCommand = "use LISTBYCATEGORY to list expenses of a category" + "\n"
            + "Format: listbycategory CATEGORY, Eg: listbycategory entertainment" + "\n" + "\n";

    public static final String deleteCommand = "use DELETE to delete an expense" + "\n"
            + "Format: delete INDEX, Eg: delete 2" + "\n" + "\n";

    public static final String viewCommand = "use VIEW to view an expense" + "\n"
            + "Format: view INDEX, Eg: add view 2" + "\n" + "\n";

    public static final String viewCategoryCommand = "use VIEWCATEGORY to view all the category" + "\n"
            + "Format: viewCategory, Eg: viewCategory" + "\n" + "\n";

    public static final String addDesCommand = "use ADDDES to add a description to an expense" + "\n"
            + "Format: addDes INDEX D/DESCRIPTION, Eg: addDes 3 d/movies" + "\n" + "\n";

    public static final String deleteDesCommand = "use DELETEDES to delete a description to an expense" + "\n"
            + "Format: deleteDes INDEX, Eg: deleteDes 6" + "\n" + "\n";

    public static final String setBudgetCommand = "use SETBUDGET to set the budget" + "\n"
            + "Format: setBudget AMOUNT, Eg: setBudget 500.0" + "\n" + "\n";

    public static final String showBudgetCommand = "use SHOWBUDGET to show the budget" + "\n"
            + "Format: showBudget, Eg: showBudget" + "\n" + "\n";

    public static final String exitCommand = "use EXIT to exit from the application" + "\n"
            + "Format: exit, Eg: exit" + "\n" + "\n";

    @Override
    public CommandResult execute(Model model) {
        String message = addExpenseCommand + listCommand + listByCategoryCommand + viewCommand + viewCategoryCommand
                + addDesCommand + deleteCommand + deleteDesCommand + setBudgetCommand + showBudgetCommand + exitCommand;
        return new CommandResult(message, true, false);
    }
}
