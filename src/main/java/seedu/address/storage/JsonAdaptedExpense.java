package seedu.address.storage;

import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Category;
import seedu.address.model.expense.Date;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.Expense;


/**
 * Jackson-friendly version of {@link Expense}.
 */
class JsonAdaptedExpense {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Expense's %s field is missing!";

    private static final Logger logger = LogsCenter.getLogger(JsonAdaptedExpense.class);
    private final Double amount;
    private final String date;
    private final String category;
    private final String description;

    /**
     * Constructs a {@code JsonAdaptedExpense} with the given expense details.
     */
    @JsonCreator
    public JsonAdaptedExpense(@JsonProperty("amount") String amount, @JsonProperty("date") String date,
                             @JsonProperty("category") String category,
                             @JsonProperty("description") String description) {
        this.amount = Double.valueOf(amount);
        this.date = date;
        this.category = category;
        this.description = description;
    }

    /**
     * Converts a given {@code Expense} into this class for Jackson use.
     */
    public JsonAdaptedExpense(Expense source) {
        //amount = String.format("S$ %.2f", source.getAmount().value);
        amount = source.getAmount().value;
        date = source.getDate().howManyDaysAgo;
        category = source.getCategory().categoryName;
        description = source.getDescription().value;
    }

    /**
     * Converts this Jackson-friendly adapted expense object into the model's {@code Expense} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted expense.
     */
    public Expense toModelType() throws IllegalValueException {
        logger.info("jsonAdaptedExpense in toModelType ");
        logger.info("amount " + amount);


        if (amount == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Amount.class.getSimpleName()));
        }
        final Amount modelAmount = new Amount(amount);
        logger.info("model amount " + amount);

        if (date == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Date.class.getSimpleName()));
        }
        final Date modelDate = new Date(date);
        logger.info("model date " + date);

        if (category == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Category.class.getSimpleName()));
        }
        final Category modelCategory = new Category(category);
        logger.info("model category " + category);

        if (description == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Description.class.getSimpleName()));
        }
        final Description modelDescription = new Description(description);
        logger.info("model description " + description);
        logger.info("converting expense");
        return new Expense(modelAmount, modelDate, modelCategory, modelDescription);
    }

}
