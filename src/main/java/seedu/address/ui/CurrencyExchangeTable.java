package seedu.address.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.expense.CurrencyExchangeRate;

import java.util.logging.Logger;

public class CurrencyExchangeTable extends UiPart<Stage> {
    public static final String URL = "https://www.xe.com/currency/sgd-singapore-dollar.html";
    public static final String MESSAGE = "You can find some useful currency exchange rates here!\n"
            + "Please refer to this online website for more accurate and in-time exchange rates.\n"
            + "\n" + URL;
    private static final String FXML = "CurrencyExchangeTable.fxml";

    private TableView<CurrencyExchangeRate> tableView = new TableView<>();
    private final Logger logger = LogsCenter.getLogger(CurrencyExchangeTable.class);

    private TableColumn currency = new TableColumn("Currency");
    private TableColumn exchangeRate = new TableColumn("Exchange rate(1.00 SGD)");

    private ObservableList<CurrencyExchangeRate> list = FXCollections.observableArrayList();

    @FXML
    private Button copyButton;

    @javafx.fxml.FXML
    private Label label;

    /**
     * Creates a new CurrencyExchangeTable.
     *
     * @param root Stage to use as the root of the StatisticsWindow.
     */
    public CurrencyExchangeTable(Stage root) {
        super(FXML, root);
        label.setText(MESSAGE);
        label.setGraphicTextGap(20.0);
        label.setGraphic(tableView);
    }

    /**
     * Creates a new HelpWindow.
     */
    public CurrencyExchangeTable() {
        this(new Stage());
    }

    /**
     * Constructs the exchange rate table.
     */
    public void constructTable() {
        currency.setCellValueFactory(new PropertyValueFactory<>("currency"));
        exchangeRate.setCellValueFactory(new PropertyValueFactory<>("exchangeRate"));
        list.addAll(new CurrencyExchangeRate("USD", "0.73227"),
                new CurrencyExchangeRate("MYR", "3.04350"),
                new CurrencyExchangeRate("EUR", "0.62650"),
                new CurrencyExchangeRate("INR", "54.4939"),
                new CurrencyExchangeRate("GBP", "0.56648"),
                new CurrencyExchangeRate("AUD", "1.04204"),
                new CurrencyExchangeRate("JPY", "76.4361"),
                new CurrencyExchangeRate("IDR", "1071.6"),
                new CurrencyExchangeRate("CAD", "0.9779"),
                new CurrencyExchangeRate("RMB", "4.91175"),
                new CurrencyExchangeRate("HKD", "5.67357"),
                new CurrencyExchangeRate("CHF", "0.66938"),
                new CurrencyExchangeRate("RUB", "58.00029"),
                new CurrencyExchangeRate("MXN", "15.66673"));
        tableView.setItems(list);
        tableView.getColumns().addAll(currency, exchangeRate);
    }

    /**
     * Shows the help window.
     *
     * @throws IllegalStateException <ul>
     *                                   <li>
     *                                       if this method is called on a thread other than the JavaFX Application Thread.
     *                                   </li>
     *                                   <li>
     *                                       if this method is called during animation or layout processing.
     *                                   </li>
     *                                   <li>
     *                                       if this method is called on the primary stage.
     *                                   </li>
     *                                   <li>
     *                                       if {@code dialogStage} is already showing.
     *                                   </li>
     *                               </ul>
     */
    public void show() {
        constructTable();
        logger.fine("Showing command currency exchange rates!");
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

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(URL);
        clipboard.setContent(url);
    }

}
