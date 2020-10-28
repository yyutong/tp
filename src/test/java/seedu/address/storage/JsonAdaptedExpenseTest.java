package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedExpense.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalExpenses.CLOTHES;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Date;

public class JsonAdaptedExpenseTest {
    private static final String INVALID_AMOUNT = "-10.0";
    private static final String INVALID_CATEGORY = "FOOD-BEVERAGE";
    private static final String INVALID_DATE_DECIMAL = "1.5";
    private static final String INVALID_DATE_NEGATIVE = "1.5";
    private static final String INVALID_DATE = "2020-09-32";
    private static final String VALID_AMOUNT = String.format("%.2f", CLOTHES.getAmount().value);
    private static final String VALID_CURRENCY = CLOTHES.getCurrency().toString();
    private static final String VALID_CATEGORY = CLOTHES.getCategory().toString();
    private static final String VALID_DATE = CLOTHES.getDate().toString();
    private static final String VALID_DESCRIPTION = CLOTHES.getDescription().toString();

    @Test
    public void toModelType_validExpenseDetails_returnsExpense() throws Exception {
        JsonAdaptedExpense expense = new JsonAdaptedExpense(CLOTHES);
        assertEquals(CLOTHES, expense.toModelType());
    }

    @Test
    public void toModelType_invalidAmount_throwsIllegalValueException() {
        JsonAdaptedExpense expense =
                new JsonAdaptedExpense(INVALID_AMOUNT, VALID_CURRENCY, VALID_DATE, VALID_CATEGORY, VALID_DESCRIPTION);
        String expectedMessage = Amount.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, expense::toModelType);
    }

    @Test
    public void toModelType_nullAmount_throwsIllegalValueException() {
        JsonAdaptedExpense expense =
                new JsonAdaptedExpense(null, VALID_CURRENCY, VALID_DATE, VALID_CATEGORY, VALID_DESCRIPTION);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Amount.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, expense::toModelType);
    }

    @Test
    public void toModelType_invalidDate_throwsIllegalValueException() {
        JsonAdaptedExpense expense =
                new JsonAdaptedExpense(VALID_AMOUNT, VALID_CURRENCY, INVALID_DATE, VALID_CATEGORY, VALID_DESCRIPTION);
        String expectedMessage = Date.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, expense::toModelType);
    }

//    @Test
//    public void toModelType_invalidPhone_throwsIllegalValueException() {
//        JsonAdaptedExpense person =
//                new JsonAdaptedExpense(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_REMARK, VALID_TAGS);
//        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
//        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
//    }
//
//    @Test
//    public void toModelType_nullPhone_throwsIllegalValueException() {
//        JsonAdaptedExpense person =
//                new JsonAdaptedExpense(VALID_NAME, null, VALID_EMAIL, VALID_REMARK, VALID_TAGS);
//        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
//        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
//    }
//
//    @Test
//    public void toModelType_invalidEmail_throwsIllegalValueException() {
//        JsonAdaptedExpense person =
//                new JsonAdaptedExpense(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_REMARK, VALID_TAGS);
//        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
//        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
//    }
//
//    @Test
//    public void toModelType_nullEmail_throwsIllegalValueException() {
//        JsonAdaptedExpense person =
//                new JsonAdaptedExpense(VALID_NAME, VALID_PHONE, null, VALID_REMARK, VALID_TAGS);
//        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
//        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
//    }
//
//    @Test
//    public void toModelType_invalidTags_throwsIllegalValueException() {
//        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
//        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
//        JsonAdaptedExpense person =
//                new JsonAdaptedExpense(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_REMARK, invalidTags);
//        assertThrows(IllegalValueException.class, person::toModelType);
//    }

}
