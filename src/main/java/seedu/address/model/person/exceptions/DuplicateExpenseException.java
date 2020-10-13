package seedu.address.model.person.exceptions;

/**
 * Signals that the operation will result in duplicate expenses (expenses are considered duplicates if they have the same
 * identity).
 */
public class DuplicateExpenseException extends RuntimeException {
    public DuplicateExpenseException() {
        super("Operation would result in duplicate expenses");
    }
}
