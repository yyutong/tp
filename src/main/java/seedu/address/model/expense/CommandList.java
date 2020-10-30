package seedu.address.model.expense;

import java.util.ArrayList;
import java.util.List;

public class CommandList {

    public static final String ADD_EXPENSE = "ADD EXPENSE COMMAND";
    public static final String ADD_EXPENSE_USAGE = "ADD expense";
    public static final String ADD_EXPENSE_FORMAT = "add a/AMOUNT c/CATEGORY D/DATE [d/DESCRIPTION]";
    public static final String ADD_EXPENSE_EXAMPLE = "add a/50 c/ENTERTAINMENT D/1 d/movie";
    public static final String LIST_EXPENSE = "LIST EXPENSE COMMAND";
    public static final String LIST_EXPENSE_USAGE = "LIST all expenses";
    public static final String LIST_EXPENSE_FORMAT = "list";
    public static final String LIST_EXPENSE_EXAMPLE = "list";
    public static final String LIST_BY_CATEGORY = "LIST BY CATEGORY";
    public static final String LIST_BY_CATEGORY_USAGE = "LIST expenses of a category";
    public static final String LIST_BY_CATEGORY_FORMAT = "listbycategory CATEGORY";
    public static final String LIST_BY_CATEGORY_EXAMPLE = "listbycategory entertainment";
    public static final String DELETE = "DELETE";
    public static final String DELETE_USAGE = "delete a specified expense";
    public static final String DELETE_FORMAT = "delete INDEX";
    public static final String DELETE_EXAMPLE = "delete 2";
    public static final String VIEW = "VIEW";
    public static final String VIEW_USAGE = "view a specified expense";
    public static final String VIEW_FORMAT = "view INDEX";
    public static final String VIEW_EXAMPLE = "view 2";
    public static final String VIEW_CATEGORY = "VIEW";
    public static final String VIEW_CATEGORY_USAGE = "view all the categories";
    public static final String VIEW_CATEGORY_FORMAT = "viewCategory";
    public static final String VIEW_CATEGORY_EXAMPLE = "viewCategory";
    public static final String ADD_DESCRIPTION = "VIEW";
    public static final String ADD_DESCRIPTION_USAGE = "add a description to an expense";
    public static final String ADD_DESCRIPTION_FORMAT = "addDes INDEX D/DESCRIPTION";
    public static final String ADD_DESCRIPTION_EXAMPLE = "addDes 3 d/movies";
    public static final String DELETE_DESCRIPTION = "VIEW";
    public static final String DELETE_DESCRIPTION_USAGE = "delete a description of an expense";
    public static final String DELETE_DESCRIPTION_FORMAT = "deleteDes INDEX";
    public static final String DELETE_DESCRIPTION_EXAMPLE = "deleteDes 6";
    public static final String SET_BUDGET = "SET BUDGET";
    public static final String SET_BUDGET_USAGE = "set the budget";
    public static final String SET_BUDGET_FORMAT = "setBudget AMOUNT";
    public static final String SET_BUDGET_EXAMPLE = "setBudget 500.0";
    public static final String SHOW_BUDGET = "SHOW BUDGET";
    public static final String SHOW_BUDGET_USAGE = "show the budget";
    public static final String SHOW_BUDGET_FORMAT = "setBudget AMOUNT";
    public static final String SHOW_BUDGET_EXAMPLE = "setBudget 500.0";
    public static final String EXIT = "EXIT";
    public static final String EXIT_USAGE = "exit from the application";
    public static final String EXIT_FORMAT = "exit";
    public static final String EXIT_EXAMPLE = "exit";
    public static final String SHOW_STATISTIC = "SHOW STATISTIC";
    public static final String SHOW_STATISTIC_USAGE = "show an overview of your expenses";
    public static final String SHOW_STATISTIC_FORMAT = "showStatistic";
    public static final String SHOW_STATISTIC_EXAMPLE = "showStatistic";
    private final String command;
    private final String usage;
    private final String format;
    private final String example;
    protected CommandList(String command, String usage, String format, String example) {
        this.command = command;
        this.usage = usage;
        this.format = format;
        this.example = example;
    }
    public String getCommand() {
        return this.command;
    }
    public String getUsage() {
        return this.usage;
    }
    public String getFormat() {
        return this.format;
    }
    public String getExample() {
        return this.example;
    }
    public static List<CommandList> getCommandList() {
        List<CommandList> list = new ArrayList<>();
        CommandList addCommand = new CommandList(ADD_EXPENSE, ADD_EXPENSE_USAGE,
                ADD_EXPENSE_FORMAT, ADD_EXPENSE_EXAMPLE);
        CommandList listCommand = new CommandList(LIST_EXPENSE, LIST_EXPENSE_USAGE,
                LIST_EXPENSE_FORMAT, LIST_EXPENSE_EXAMPLE);
        CommandList listByCategoryCommand = new CommandList(LIST_BY_CATEGORY, LIST_BY_CATEGORY_USAGE,
                LIST_BY_CATEGORY_FORMAT, LIST_BY_CATEGORY_EXAMPLE);
        CommandList deleteCommand = new CommandList(DELETE, DELETE_USAGE,
                DELETE_FORMAT, DELETE_EXAMPLE);
        CommandList viewCommand = new CommandList(VIEW, VIEW_USAGE,
                VIEW_FORMAT, VIEW_EXAMPLE);
        CommandList viewCategoryCommand = new CommandList(VIEW_CATEGORY, VIEW_CATEGORY_USAGE,
                VIEW_CATEGORY_FORMAT, VIEW_CATEGORY_EXAMPLE);
        CommandList addDesCommand = new CommandList(ADD_DESCRIPTION, ADD_DESCRIPTION_USAGE,
                ADD_DESCRIPTION_FORMAT, ADD_DESCRIPTION_EXAMPLE);
        CommandList deleteDesCommand = new CommandList(DELETE_DESCRIPTION, DELETE_DESCRIPTION_USAGE,
                DELETE_DESCRIPTION_FORMAT, DELETE_DESCRIPTION_EXAMPLE);
        CommandList setBudgeCommand = new CommandList(SET_BUDGET, SET_BUDGET_USAGE,
                SET_BUDGET_FORMAT, SET_BUDGET_EXAMPLE);
        CommandList showBudgeCommand = new CommandList(SHOW_BUDGET, SHOW_BUDGET_USAGE,
                SHOW_BUDGET_FORMAT, SHOW_BUDGET_EXAMPLE);
        CommandList exitCommand = new CommandList(EXIT, EXIT_USAGE,
                EXIT_FORMAT, EXIT_EXAMPLE);
        CommandList showStatisticCommand = new CommandList(SHOW_STATISTIC, SHOW_STATISTIC_USAGE,
                SHOW_STATISTIC_FORMAT, SHOW_STATISTIC_EXAMPLE);
        list.add(addCommand);
        list.add(listCommand);
        list.add(listByCategoryCommand);
        list.add(deleteCommand);
        list.add(viewCommand);
        list.add(viewCategoryCommand);
        list.add(addDesCommand);
        list.add(deleteDesCommand);
        list.add(setBudgeCommand);
        list.add(showBudgeCommand);
        list.add(exitCommand);
        list.add(showStatisticCommand);
        return list;
    }
}
