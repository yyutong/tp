package seedu.address.model.expense;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.HashMap;

public class Statistics {

    private HashMap<String, Double> categoryAmountPercentage;

    //private HashMap<String, Double> categoryNumberPercentage;

    private ArrayList<String> categories;


    public Statistics(HashMap<String, Double>categoryAmountPercentage, ArrayList<String> categories) {
        this.categoryAmountPercentage = categoryAmountPercentage;
        //this.categoryNumberPercentage = categoryNumberPercentage;
        this.categories = categories;
    }

    public HashMap<String, Double> getCategoryAmountPercentage() {
        return this.categoryAmountPercentage;
    }

    public ObservableList<PieChart.Data> getCategoryAmountPercenatgePieCharStatistics() {

        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

        for (String current: categories) {

            double percentage = categoryAmountPercentage.get(current);

            list.add(new PieChart.Data(current, percentage));

        }

        return list;
    }


}
