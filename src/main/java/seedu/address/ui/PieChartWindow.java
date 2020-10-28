package seedu.address.ui;

import com.sun.glass.ui.Application;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

import java.util.logging.Logger;

public class PieChartWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://se-education.org/addressbook-level3/UserGuide.html";
    public static final String MESSAGE = "Statistics is shown below";
    public static PieChart PIE_CHART = new PieChart();


    private static final Logger logger = LogsCenter.getLogger(PieChartWindow.class);
    private static final String FXML = "StatisticsWindow.fxml";

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
        statistics.setGraphicTextGap(2.0);
        statistics.setGraphic(PIE_CHART);
    }

    /**
     * Creates a new HelpWindow.
     */
    public PieChartWindow() {
        this(new Stage());
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

//    /**
//     * Copies the URL to the user guide to the clipboard.
//     */
//    @FXML
//    private void copyUrl() {
//        final Clipboard clipboard = Clipboard.getSystemClipboard();
//        final ClipboardContent url = new ClipboardContent();
//        url.putString(USERGUIDE_URL);
//        clipboard.setContent(url);
//    }
}
