package seedu.address.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Category;
import seedu.address.model.expense.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PieChartWindow extends UiPart<Stage> {

    public static final String MESSAGE = "Statistics is shown on the left";
    public static PieChart PIE_CHART = new PieChart();

    public boolean hasStats = false;

    public Logic logic;

    public ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

    private static final Logger logger = LogsCenter.getLogger(PieChartWindow.class);
    private static final String FXML = "PieChartWindow.fxml";

    @javafx.fxml.FXML
    private Button copyButton;

    @FXML
    private Label statistics;

    /**
     * Creates a new StatisticsWindow.
     *
     * @param root Stage to use as the root of the StatisticsWindow.
     */
    public PieChartWindow(Stage root) {
        super(FXML, root);
        statistics.setText(MESSAGE);
        statistics.setGraphicTextGap(20.0);
        statistics.setGraphic(PIE_CHART);
    }

    /**
     * Creates a new HelpWindow.
     */
    public PieChartWindow() {
        this(new Stage());
    }


    public PieChartWindow(Logic logic) {
        this(new Stage());
        this.logic = logic;
        hasStats = true;
        this.setStats();
    }

    public void setStats() {
        if(hasStats) {

            List<Category> categories = new ArrayList<>();
            double sum = 0;

            for (Expense current : logic.getExpenseBook().getExpenseList()) {
                Category currentCategory = current.getCategory();
                if (!categories.contains(currentCategory)) {
                    categories.add(currentCategory);
                }
                Amount currentAmount = current.getAmount();
                double currentAmountValue = currentAmount.getValue();
                sum = sum + currentAmountValue;
            }

            for (int i = 0; i < categories.size(); i = i + 1) {
                String categoryName = categories.get(i).categoryName;

                double categorySum = 0.0;
                for (Expense current : logic.getExpenseBook().getExpenseList()) {
                    Category currentCategory = current.getCategory();
                    String currentCategoryName = currentCategory.categoryName;
                    if (categoryName.equals(currentCategoryName)) {
                        Amount currentAmount = current.getAmount();
                        double currentAmountValue = currentAmount.getValue();
                        categorySum = categorySum + currentAmountValue;
                    }
                }
                double percentage = categorySum / sum * 100;
                this.list.add(new PieChart.Data(categoryName, percentage));
            }

            PIE_CHART.setData(list);
            PIE_CHART.setLegendSide(Side.LEFT);
            PIE_CHART.setTitle("Statistics of Expense Book");
            PIE_CHART.setClockwise(false);
        }



    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing statistics page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

}
