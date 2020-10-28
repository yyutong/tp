package seedu.address.model.expense;

import java.util.HashMap;

public class Statistics {

    private HashMap<String, Double> statistics;

    public Statistics(HashMap statistics) {
        this.statistics = statistics;
    }

    public HashMap<String, Double> getStatistics() {
        return this.statistics;
    }

}
