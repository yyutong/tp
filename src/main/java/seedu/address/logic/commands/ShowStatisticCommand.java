package seedu.address.logic.commands;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.expense.Category;

public class ShowStatisticCommand extends Command {

    public static final String COMMAND_WORD = "showStatistic";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": show number of expenses by categories in ascending order. \n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_SHOW_STATISTIC_LABELS_SUCCESS = "Here are the expenses summaries: \n";
    public static final String MESSAGE_SHOW_STATISTIC_HEADING_SUCCESS = "Here are the break down of expenses: \n";
    public static final String HORIZONTAL_LINE = "---------------------------------- \n";

    /**
     * Sort the HashMap by values.
     *
     */
    // function to sort hashmap by values
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        String message = "";
        int sumOfExpenses = model.getTotalExpense();
        message = message + "You have a total of " + sumOfExpenses + "expenses." + "\n \n";
        message = message + MESSAGE_SHOW_STATISTIC_HEADING_SUCCESS + HORIZONTAL_LINE;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        List<Category> categories = model.getCategoryLabels();
        for (int i = 0; i < categories.size(); i = i + 1) {
            String currentCategoryName = categories.get(i).categoryName;
            int sum = model.getExpenseSumByCategory(currentCategoryName);
            hashMap.put(currentCategoryName, sum);
        }
        Map<String, Integer> hashmap1 = sortByValue(hashMap);

        for (Map.Entry<String, Integer> hashMap2 : hashmap1.entrySet()) {
            message = message + hashMap2.getKey() + " : " + hashMap2.getValue() + " expenses" + "\n";
        }
        return new CommandResult(MESSAGE_SHOW_STATISTIC_LABELS_SUCCESS + message);
    }
}
