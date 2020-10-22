package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ExpenseTest {
    @Test
    public void isSameExpense() {

        Amount buy_book_expense = new Amount(10.0);
        Category buy_book_category = new Category("study");
        Date buy_book_date = new Date("2");
        Description buy_book_description = new Description("bought book at coop");

        Expense buyBook = new Expense(buy_book_expense, buy_book_date,
                buy_book_category, buy_book_description);

        Amount buy_food_expense = new Amount(10.0);
        Category buy_food_category = new Category("food");
        Date buy_food_date = new Date("2");
        Description buy_food_description = new Description("bought sushi for dinner");

        Expense buyFood = new Expense(buy_food_expense, buy_food_date,
                buy_food_category, buy_food_description);

        assertTrue(buyBook.isSameExpense(buyBook));

        assertTrue(buyFood.isSameExpense(buyFood));

        assertFalse(buyBook.isSameExpense(buyFood));

        assertFalse(buyFood.isSameExpense(buyBook));

        assertFalse(buyFood.isSameExpense(null));

        assertFalse(buyBook.isSameExpense(null));
    }

    @Test
    public void isValidExpense() {
        Amount buy_book_expense = new Amount(10.0);
        Category buy_book_category = new Category("study");
        Description buy_book_description = new Description("bought book at coop");

        assertThrows(NullPointerException.class,
                () -> new Expense(buy_book_expense, null,
                        buy_book_category, buy_book_description));

        Category buy_food_category = new Category("food");
        Date buy_food_date = new Date("2");
        Description buy_food_description = new Description("bought sushi for dinner");

        assertThrows(NullPointerException.class,
                () -> new Expense(null, buy_food_date,
                        buy_food_category, buy_food_description));

        Amount movie_expense = new Amount(10.0);
        Date movie_date = new Date("1");
        Description movie_description = new Description("watch 1917");

        assertThrows(NullPointerException.class,
                () -> new Expense(movie_expense, movie_date, null, movie_description));

        assertThrows(NullPointerException.class,
                () -> new Expense(null, null, null, null));
    }

}
