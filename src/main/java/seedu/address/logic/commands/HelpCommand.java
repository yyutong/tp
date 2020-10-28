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

    public static final String ADDEXPENSECOMMAND = "use ADD to add an expense" + "\n"
            + "Format: add a/AMOUNT c/CATEGORY D/DATE [d/DESCRIPTION], Eg: add a/50 c/ENTERTAINMENT D/1 d/movie" + "\n"
            + "\n";

    public static final String LISTCOMMOND = "use LIST to list all expenses" + "\n"
            + "Format: list , Eg: list" + "\n" + "\n";

    public static final String LISTBYCATEGORYCOMMOND = "use LISTBYCATEGORY to list expenses of a category" + "\n"
            + "Format: listbycategory CATEGORY, Eg: listbycategory entertainment" + "\n" + "\n";

    public static final String DELETECOMMOND = "use DELETE to delete an expense" + "\n"
            + "Format: delete INDEX, Eg: delete 2" + "\n" + "\n";

    public static final String VIEWCOMMOND = "use VIEW to view an expense" + "\n"
            + "Format: view INDEX, Eg: add view 2" + "\n" + "\n";

    public static final String VIEWCATEGORYCOMMOND = "use VIEWCATEGORY to view all the category" + "\n"
            + "Format: viewCategory, Eg: viewCategory" + "\n" + "\n";

    public static final String ADDDESCOMMOND = "use ADDDES to add a description to an expense" + "\n"
            + "Format: addDes INDEX D/DESCRIPTION, Eg: addDes 3 d/movies" + "\n" + "\n";

    public static final String DELETEDESCOMMOND = "use DELETEDES to delete a description to an expense" + "\n"
            + "Format: deleteDes INDEX, Eg: deleteDes 6" + "\n" + "\n";

    public static final String SETBUDGETCOMMOND = "use SETBUDGET to set the budget" + "\n"
            + "Format: setBudget AMOUNT, Eg: setBudget 500.0" + "\n" + "\n";

    public static final String SHOWBUDGETCOMMOND = "use SHOWBUDGET to show the budget" + "\n"
            + "Format: showBudget, Eg: showBudget" + "\n" + "\n";

    public static final String EXITCOMMOND = "use EXIT to exit from the application" + "\n"
            + "Format: exit, Eg: exit" + "\n" + "\n";

    public static final String SHOWSTATISTICCOMMAND = "use SHOWSTATISTIC to show an overview of your expenses" + "\n"
            + "Format: showStatistic, Eg: showStatistic" + "\n" + "\n";

    @Override
    public CommandResult execute(Model model) {
        String message = ADDEXPENSECOMMAND + LISTCOMMOND + LISTBYCATEGORYCOMMOND + VIEWCOMMOND + VIEWCATEGORYCOMMOND
                + ADDDESCOMMOND + DELETECOMMOND + DELETEDESCOMMOND + SETBUDGETCOMMOND + SHOWBUDGETCOMMOND
                + SHOWSTATISTICCOMMAND + EXITCOMMOND;
        return new CommandResult(message, true, false);
    }
}
