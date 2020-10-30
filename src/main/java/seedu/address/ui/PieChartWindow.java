package seedu.address.ui;

import java.util.List;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.model.expense.StatisticSummary;
import seedu.address.model.expense.Statistics;


public class PieChartWindow extends UiPart<Stage> {

    public static final String MESSAGE = "Statistics is shown on the left";
    private static final PieChart PIECHART = new PieChart();
    private static final Logger logger = LogsCenter.getLogger(PieChartWindow.class);
    private static final String FXML = "PieChartWindow.fxml";

    private static boolean hasStats = false;

    private Logic logic;

    private ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
    private TableView<StatisticSummary> tableView = new TableView<>();
    private TableColumn category = new TableColumn("Category");
    private TableColumn numberOfExpense = new TableColumn("Number of Expenses");
    private TableColumn percentage = new TableColumn("Percentage");
    private TableColumn totalSpending = new TableColumn("Total Spending");
    private ObservableList<StatisticSummary> list1 = FXCollections.observableArrayList();


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
        statistics.setGraphicTextGap(20.0);
        statistics.setGraphic(PIECHART);
        //statistics.setGraphic(tableView);
    }

    /**
     * Creates a new PieChartWindow.
     */
    public PieChartWindow() {
        this(new Stage());
    }

    /**
     * Constructs a pie chart window object.
     *
     * @param logic Takes in a logic object.
     */
    public PieChartWindow(Logic logic) {
        this(new Stage());
        this.logic = logic;
        hasStats = true;
    }

    public void setStats() {
        if (hasStats) {

            Statistics data = logic.getExpenseBook().getStatistics();

            list = data.getCategoryAmountPercenatgePieCharStatistics();

            PIECHART.setData(list);
            PIECHART.setLegendSide(Side.LEFT);
            PIECHART.setTitle("Statistics of Expense Book");
            PIECHART.setClockwise(false);
            PIECHART.setLabelsVisible(true);

        }

    }


    /**
     * Constructs the exchange rate table.
     */
    public void constructTable() {
        if (hasStats) {
            category.setCellValueFactory(new PropertyValueFactory<>("category"));
            numberOfExpense.setCellValueFactory(new PropertyValueFactory<>("numberOfExpense"));
            percentage.setCellValueFactory(new PropertyValueFactory<>("percentage"));
            totalSpending.setCellValueFactory(new PropertyValueFactory<>("totalSpending"));
            List<StatisticSummary> statisticSummaryList = logic.getExpenseBook().getStatisticTable();
            for (int i = 0; i < statisticSummaryList.size(); i = i + 1) {
                list1.add(statisticSummaryList.get(i));
            }
            tableView.setItems(list1);
            tableView.getColumns().addAll(category, numberOfExpense, percentage, totalSpending);
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
        this.setStats();
        this.constructTable();
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
