package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.model.expense.Budget;
import seedu.address.model.expense.Expense;

import java.util.logging.Logger;

public class BudgetPanel extends UiPart<Region> {
    private static final String FXML = "BudgetPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(BudgetPanel.class);

    private Budget budget;

    private Logic logic;

    @FXML
    private Label budgetAmount;
    @FXML
    private Label budgetRemaining;
    @FXML
    private Label description;

    /**
     * Creates a {@code ExpenseListPanel} with the given {@code ObservableList}.
     */
    public BudgetPanel(Budget budget) {
        super(FXML);
        this.budget = budget;

        budgetAmount.setText(String.format("Current budget: %.2f", budget.getValue()));

        budgetRemaining.setText(String.format("Remaining budget: %.2f", budget.getValue()));

    }

    public BudgetPanel(Logic logic) {
        super(FXML);

        this.logic = logic;

        this.budget = logic.getExpenseBook().getBudget();

        budgetAmount.setText(String.format("Current budget: %.2f", budget.getValue()));

        budgetRemaining.setText(String.format("Remaining budget: %.2f",
                logic.getExpenseBook().getRemainingBudget().getValue()));
    }

    public void update() {
        budgetAmount.setText(String.format("Current budget: %.2f",
                logic.getExpenseBook().getBudget().getValue()));

        budgetRemaining.setText(String.format("Remaining budget: %.2f",
                logic.getExpenseBook().getRemainingBudget().getValue()));
    }


}
