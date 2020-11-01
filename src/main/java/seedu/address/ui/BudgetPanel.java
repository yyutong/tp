package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.model.expense.Budget;

public class BudgetPanel extends UiPart<Region> {
    private static final String FXML = "BudgetPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(BudgetPanel.class);

    private Budget budget;

    private Logic logic;

    @FXML
    private Label budgetAmount;
    @FXML
    private Label budgetRemaining;

    /**
     * Constructs a BudgetPanel object.
     *
     * @param logic The logic manager.
     */
    public BudgetPanel(Logic logic) {
        super(FXML);

        this.logic = logic;

        this.budget = logic.getExpenseBook().getBudget();

        budgetAmount.setText(String.format("Current budget: %.2f", budget.getValue()));

        budgetRemaining.setText(String.format("Remaining budget: %.2f",
                logic.getExpenseBook().getRemainingBudget().getValue()));
    }

    /**
     * Update the budget statistics shown in the GUI.
     */
    public void update() {
        budgetAmount.setText(String.format("Current budget: %.2f",
                logic.getExpenseBook().getBudget().getValue()));

        budgetRemaining.setText(String.format("Remaining budget: %.2f",
                logic.getExpenseBook().getRemainingBudget().getValue()));
    }

}
