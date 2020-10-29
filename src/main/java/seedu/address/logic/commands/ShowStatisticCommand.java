package seedu.address.logic.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.expense.Category;

/**
 * Show the statistic and brief summary of the user's expenses.
 */
public class ShowStatisticCommand extends Command {

    public static final String COMMAND_WORD = "showStatistic";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": show number of expenses by categories in ascending order. \n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_SHOW_STATISTIC_LABELS_SUCCESS = "Here are the expenses summaries: \n";
    public static final String MESSAGE_SHOW_STATISTIC_HEADING_SUCCESS = "Here are the break down of expenses: \n";
    public static final String HORIZONTAL_LINE = "------------------------------------ \n";
    public static final String HEADING = "Category           Total Expense           Percentage(%)      Total Spending";
    public static final int STRINGSPACE = 38;
    public static final int SPACE = 28;

    /**
     * Create a fixed length of String.
     * Here we use this command mainly to create a fixed length of empty space to simulate a table.
     * @param string the string to be created.
     * @param length the length of the String created.
     */
    public static String fixedLengthString(String string, int length) {
        return String.format("%1$" + length + "s", string);
    }

    /**
     * Executes the show statistic command.
     * @param model {@code Model} which the command should operate on.
     * @return A command result in which the statistic and brief summary of the expenses shown.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        String message = "";
        int sumOfExpenses = model.getTotalExpense();
        double totalExpenseSum = model.getExpenseSum();
        String formattedTotalSum = String.format("%.2f", totalExpenseSum);
        message = message + "You have a total of " + sumOfExpenses + " expenses "
                + "and a total spending of " + formattedTotalSum + ". " + "\n \n";
        message = message + MESSAGE_SHOW_STATISTIC_HEADING_SUCCESS + HORIZONTAL_LINE + HEADING + "\n";
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        List<Category> categories = model.getCategoryLabels();
        for (int i = 0; i < categories.size(); i = i + 1) {
            String currentCategoryName = categories.get(i).categoryName;
            int sum = model.getExpenseSumByCategory(currentCategoryName);
            hashMap.put(currentCategoryName, sum);
        }
        HashMap<String, Double> hashMap3 = model.getExpenseSumCategory();
        HashMap<String, Double> hashMap4 = model.getExpensePercentageCategory();
        Map<String, Integer> hashMap1 = SortShowStatisticCommand.sortByNumberOfExpense(hashMap);
        Map<String, Double> hashMap5 = SortShowStatisticCommand.sortByTotalExpense(hashMap3);
        for (Map.Entry<String, Double> hashMap2 : hashMap5.entrySet()) {
            System.out.println(hashMap2.getKey());
            int categoryLength = (hashMap2.getKey().length()) * 2;
            int howManyMoreSpaceNeeded = STRINGSPACE - categoryLength;
            String category = hashMap2.getKey();
            int numberOfExpense = hashMap.get(category);
            double totalAmount = hashMap3.get(category);
            double percentage = hashMap4.get(category);
            String formattedAmount = String.format("%.2f", totalAmount);
            String formattedPercentage = String.format("%.2f", percentage);
            message = message + category + fixedLengthString(" ", howManyMoreSpaceNeeded) + numberOfExpense
                    + fixedLengthString(" ", SPACE) + formattedPercentage
                    + fixedLengthString(" ", SPACE) + formattedAmount + "\n";

        }

        return new CommandResult(MESSAGE_SHOW_STATISTIC_LABELS_SUCCESS + message,
                false, false, true);
    }
}
