package seedu.address.logic.commands;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Sort the statistic we collected.
 */
public class SortShowStatisticCommand {

    /**
     * Sort the statistics by the total number of expenses in a certain category.
     * @param hashmap The data structure that store the statistic.
     */
    protected static HashMap<String, Integer> sortByNumberOfExpense(HashMap<String, Integer> hashmap) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > listForMap = new LinkedList<Map.Entry<String, Integer> >(hashmap.entrySet());

        // Sort the list
        Collections.sort(listForMap, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> firstValue,
                               Map.Entry<String, Integer> secondValue) {
                return (firstValue.getValue()).compareTo(secondValue.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> tempMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> hm : listForMap) {
            tempMap.put(hm.getKey(), hm.getValue());
        }
        return tempMap;
    }

    /**
     * Sort the statistics by the total expenses in a certain category.
     * @param hashmap The data structure that store the statistic.
     */
    protected static HashMap<String, Double> sortByTotalExpense(HashMap<String, Double> hashmap) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Double> > listForMap = new LinkedList<Map.Entry<String, Double> >(hashmap.entrySet());

        // Sort the list
        Collections.sort(listForMap, new Comparator<Map.Entry<String, Double> >() {
            public int compare(Map.Entry<String, Double> firstValue,
                               Map.Entry<String, Double> secondValue) {
                return (secondValue.getValue()).compareTo(firstValue.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Double> tempMap = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> hm : listForMap) {
            tempMap.put(hm.getKey(), hm.getValue());
        }
        return tempMap;
    }
}
