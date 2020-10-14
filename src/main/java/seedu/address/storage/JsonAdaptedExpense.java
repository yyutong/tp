package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Amount;
import seedu.address.model.person.Category;
import seedu.address.model.person.Date;
import seedu.address.model.person.Description;
import seedu.address.model.person.Expense;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;


/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedExpense {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Expense's %s field is missing!";

    private final String amount;
    private final String date;
    private final String category;
    private final String description;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedExpense(@JsonProperty("amount") String amount, @JsonProperty("date") String date,
                             @JsonProperty("category") String category,
                             @JsonProperty("description") String description) {
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.description = description;
    }

    /**
     * Converts a given {@code Expense} into this class for Jackson use.
     */
    public JsonAdaptedExpense(Expense source) {
        amount = source.getAmount().value.toString();
        date = source.getDate().date;
        category = source.getCategory().categoryName;
        description = source.getDescription().value;
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Expense toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();

        if (amount == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Amount.class.getSimpleName()));
        }
        final Amount modelAmount = new Amount(Double.valueOf(amount));

        if (date == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Date.class.getSimpleName()));
        }
        final Date modelDate = new Date(date);

        if (category == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Category.class.getSimpleName()));
        }
        final Category modelCategory = new Category(category);

        if (description == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Description.class.getSimpleName()));
        }
        final Description modelDescription = new Description(description);
        return new Expense(modelAmount, modelDate, modelCategory, modelDescription);
    }

}
