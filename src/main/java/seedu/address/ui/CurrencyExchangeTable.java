package seedu.address.ui;

import java.util.logging.Logger;

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

public class CurrencyExchangeTable extends UiPart<Stage> {
    public static final String URL = "https://www.xe.com/currency/sgd-singapore-dollar.html";
    public static final String MESSAGE = "You can find some useful currency exchange rates here!\n"
            + "Please refer to this online website for more accurate and in-time exchange rates.\n"
            + "\n" + URL;
    private static final String FXML = "CurrencyExchangeTable.fxml";

    private TableView<CurrencyExchangeRate> tableView = new TableView<>();
    private final Logger logger = LogsCenter.getLogger(CurrencyExchangeTable.class);

    private TableColumn currency = new TableColumn("Currency");
    private TableColumn exchangeRate = new TableColumn("Exchange rate (1.00 USD)");

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
        label.setGraphic(tableView);
        label.setMinWidth(255);
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
        list.addAll(new CurrencyExchangeRate("AED", "3.673005"),
                new CurrencyExchangeRate("AFN", "76.897058"),
                new CurrencyExchangeRate("ALL", "106.399855"),
                new CurrencyExchangeRate("AMD", "493.150079"),
                new CurrencyExchangeRate("ANG", "1.794897"),
                new CurrencyExchangeRate("AOA", "662.941003"),
                new CurrencyExchangeRate("ARS", "78.3152"),
                new CurrencyExchangeRate("AUD", "1.42508"),
                new CurrencyExchangeRate("AWG", "1.8"),
                new CurrencyExchangeRate("AZN", "1.700615"),
                new CurrencyExchangeRate("BAM", "1.670957"),
                new CurrencyExchangeRate("BBD", "2.018907"),
                new CurrencyExchangeRate("BDT", "84.888486"),
                new CurrencyExchangeRate("BGN", "1.673433"),
                new CurrencyExchangeRate("BHD", "0.377075"),
                new CurrencyExchangeRate("BIF", "1940"),
                new CurrencyExchangeRate("BMD", "1"),
                new CurrencyExchangeRate("BND", "1.36626"),
                new CurrencyExchangeRate("BOB", "6.904488"),
                new CurrencyExchangeRate("BRL", "5.765572"),
                new CurrencyExchangeRate("BSD", "0.999927"),
                new CurrencyExchangeRate("BTC", "7.3494475e-5"),
                new CurrencyExchangeRate("BTN", "74.511335"),
                new CurrencyExchangeRate("BWP", "11.467127"),
                new CurrencyExchangeRate("BYN", "2.632181"),
                new CurrencyExchangeRate("BYR", "19600"),
                new CurrencyExchangeRate("BZD", "2.015575"),
                new CurrencyExchangeRate("CAD", "1.334925"),
                new CurrencyExchangeRate("CDF", "1965.999921"),
                new CurrencyExchangeRate("CHF", "0.91611"),
                new CurrencyExchangeRate("CLF", "0.028025"),
                new CurrencyExchangeRate("CLP", "773.295715"),
                new CurrencyExchangeRate("CNY", "6.714987"),
                new CurrencyExchangeRate("COP", "3855.5"),
                new CurrencyExchangeRate("CRC", "606.697224"),
                new CurrencyExchangeRate("CUC", "1"),
                new CurrencyExchangeRate("CUP", "26.5"),
                new CurrencyExchangeRate("CVE", "94.650032"),
                new CurrencyExchangeRate("CZK", "23.445002"),
                new CurrencyExchangeRate("DJF", "178.011679"),
                new CurrencyExchangeRate("DKK", "6.38402"),
                new CurrencyExchangeRate("DOP", "58.529885"),
                new CurrencyExchangeRate("DZD", "128.817921"),
                new CurrencyExchangeRate("EGP", "15.694803"),
                new CurrencyExchangeRate("ERN", "14.999699"),
                new CurrencyExchangeRate("ETB", "37.550172"),
                new CurrencyExchangeRate("EUR", "0.857415"),
                new CurrencyExchangeRate("FJD", "2.144979"),
                new CurrencyExchangeRate("FKP", "0.77446"),
                new CurrencyExchangeRate("GBP", "0.774295"),
                new CurrencyExchangeRate("GEL", "3.2402"),
                new CurrencyExchangeRate("GGP", "0.77446"),
                new CurrencyExchangeRate("GHS", "5.840363"),
                new CurrencyExchangeRate("GIP", "0.77446"),
                new CurrencyExchangeRate("GMD", "51.75996"),
                new CurrencyExchangeRate("GNF", "9750.000196"),
                new CurrencyExchangeRate("GTQ", "7.794376"),
                new CurrencyExchangeRate("GYD", "209.16116"),
                new CurrencyExchangeRate("HKD", "7.75322"),
                new CurrencyExchangeRate("HNL", "24.550079"),
                new CurrencyExchangeRate("HRK", "6.4939"),
                new CurrencyExchangeRate("HTG", "63.214821"),
                new CurrencyExchangeRate("HUF", "315.239845"),
                new CurrencyExchangeRate("IDR", "14774.8"),
                new CurrencyExchangeRate("ILS", "3.42194"),
                new CurrencyExchangeRate("IMP", "0.77446"),
                new CurrencyExchangeRate("INR", "74.40185"),
                new CurrencyExchangeRate("IQD", "1190"),
                new CurrencyExchangeRate("IRR", "42104.999943"),
                new CurrencyExchangeRate("ISK", "141.54015"),
                new CurrencyExchangeRate("JEP", "0.77446"),
                new CurrencyExchangeRate("JMD", "145.768634"),
                new CurrencyExchangeRate("JOD", "0.708996"),
                new CurrencyExchangeRate("JPY", "104.637502"),
                new CurrencyExchangeRate("KES", "108.794649"),
                new CurrencyExchangeRate("KGS", "81.814885"),
                new CurrencyExchangeRate("KHR", "4060.000029"),
                new CurrencyExchangeRate("KMF", "421.874948"),
                new CurrencyExchangeRate("KPW", "900.017837"),
                new CurrencyExchangeRate("KRW", "1132.909655"),
                new CurrencyExchangeRate("KWD", "0.305796"),
                new CurrencyExchangeRate("KYD", "0.833244"),
                new CurrencyExchangeRate("KZT", "433.035752"),
                new CurrencyExchangeRate("LAK", "9260.000155"),
                new CurrencyExchangeRate("LBP", "1519.000112"),
                new CurrencyExchangeRate("LKR", "184.310863"),
                new CurrencyExchangeRate("LRD", "183.550338"),
                new CurrencyExchangeRate("LSL", "16.37979"),
                new CurrencyExchangeRate("LTL", "2.95274"),
                new CurrencyExchangeRate("LVL", "0.60489"),
                new CurrencyExchangeRate("LYD", "1.370072"),
                new CurrencyExchangeRate("MAD", "9.204938"),
                new CurrencyExchangeRate("MDL", "17.037461"),
                new CurrencyExchangeRate("MGA", "3924.999987"),
                new CurrencyExchangeRate("MKD", "52.639897"),
                new CurrencyExchangeRate("MMK", "1286.901071"),
                new CurrencyExchangeRate("MNT", "2863.90923"),
                new CurrencyExchangeRate("MOP", "7.983973"),
                new CurrencyExchangeRate("MRO", "357.000515"),
                new CurrencyExchangeRate("MUR", "39.954881"),
                new CurrencyExchangeRate("MVR", "15.402159"),
                new CurrencyExchangeRate("MWK", "754.999779"),
                new CurrencyExchangeRate("MXN", "21.357698"),
                new CurrencyExchangeRate("MYR", "4.157025"),
                new CurrencyExchangeRate("MZN", "73.159818"),
                new CurrencyExchangeRate("NAD", "16.379828"),
                new CurrencyExchangeRate("NGN", "381.00041"),
                new CurrencyExchangeRate("NIO", "34.698212"),
                new CurrencyExchangeRate("NOK", "9.534803"),
                new CurrencyExchangeRate("NPR", "119.218102"),
                new CurrencyExchangeRate("NZD", "1.513155"),
                new CurrencyExchangeRate("OMR", "0.385054"),
                new CurrencyExchangeRate("PAB", "0.999927"),
                new CurrencyExchangeRate("PEN", "3.611499"),
                new CurrencyExchangeRate("PGK", "3.505004"),
                new CurrencyExchangeRate("PHP", "48.4155"),
                new CurrencyExchangeRate("PKR", "160.703969"),
                new CurrencyExchangeRate("PLN", "3.9623"),
                new CurrencyExchangeRate("PYG", "7021.960982"),
                new CurrencyExchangeRate("QAR", "3.641012"),
                new CurrencyExchangeRate("RON", "4.1788"),
                new CurrencyExchangeRate("RSD", "100.824992"),
                new CurrencyExchangeRate("RUB", "78.975402"),
                new CurrencyExchangeRate("RWF", "970"),
                new CurrencyExchangeRate("SAR", "3.750324"),
                new CurrencyExchangeRate("SBD", "8.101947"),
                new CurrencyExchangeRate("SCR", "19.324765"),
                new CurrencyExchangeRate("SDG", "55.275018"),
                new CurrencyExchangeRate("SEK", "8.92047"),
                new CurrencyExchangeRate("SGD", "1.36745"),
                new CurrencyExchangeRate("SHP", "0.77446"),
                new CurrencyExchangeRate("SLL", "9929.999973"),
                new CurrencyExchangeRate("SOS", "583.000258"),
                new CurrencyExchangeRate("SRD", "14.153991"),
                new CurrencyExchangeRate("STD", "21031.906016"),
                new CurrencyExchangeRate("SVC", "8.749365"),
                new CurrencyExchangeRate("SYP", "512.61336"),
                new CurrencyExchangeRate("SZL", "16.379817"),
                new CurrencyExchangeRate("THB", "31.239631"),
                new CurrencyExchangeRate("TJS", "10.334089"),
                new CurrencyExchangeRate("TMT", "3.5"),
                new CurrencyExchangeRate("TND", "2.776498"),
                new CurrencyExchangeRate("TOP", "2.323499"),
                new CurrencyExchangeRate("TRY", "8.285205"),
                new CurrencyExchangeRate("TTD", "6.798891"),
                new CurrencyExchangeRate("TWD", "28.624983"),
                new CurrencyExchangeRate("TZS", "2318.825008"),
                new CurrencyExchangeRate("UAH", "28.443894"),
                new CurrencyExchangeRate("UGX", "3739.731821"),
                new CurrencyExchangeRate("USD", "1"),
                new CurrencyExchangeRate("UYU", "42.701957"),
                new CurrencyExchangeRate("UZS", "10364.00049"),
                new CurrencyExchangeRate("VEF", "9.987499"),
                new CurrencyExchangeRate("VND", "23180"),
                new CurrencyExchangeRate("VUV", "114.23611"),
                new CurrencyExchangeRate("WST", "2.630378"),
                new CurrencyExchangeRate("XAF", "560.409912"),
                new CurrencyExchangeRate("XAG", "0.042658"),
                new CurrencyExchangeRate("XAU", "0.000535"),
                new CurrencyExchangeRate("XCD", "2.70255"),
                new CurrencyExchangeRate("XDR", "0.707564"),
                new CurrencyExchangeRate("XOF", "554.498872"),
                new CurrencyExchangeRate("XPF", "102.649882"),
                new CurrencyExchangeRate("YER", "250.349783"),
                new CurrencyExchangeRate("ZAR", "16.386983"),
                new CurrencyExchangeRate("ZMK", "9001.201691"),
                new CurrencyExchangeRate("ZMW", "20.554898"),
                new CurrencyExchangeRate("ZWL", "321.999941"));
        tableView.setItems(list);
        tableView.getColumns().addAll(currency, exchangeRate);
    }

    /**
     * Shows the currency exchange rate table window.
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
