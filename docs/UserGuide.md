---
layout: page
title: User Guide
---

UniSave is a **desktop app for managing expenses, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI).
If you can type fast, UniSave can get your financial management tasks done faster than traditional GUI apps.
Choose a section from the table of contents below and start using UniSave.

* Table of Contents
    * [1. Overview](#1-overview)
    * [2. Quick start](#2-quick-start)
    * [3. Features](#3-features)
        * [3.1 Clear data: `clear`](#31-clear-data-in-unisave--clear)
        * [3.2 Set budget : `set-b`](#32-set-budget--set-b)
        * [3.3 Add an expense: `add`](#33-add-an-expense-add)
        * [3.4 Edit an expense: `edit`](#34-edit-an-expense--edit)
        * [3.5 Delete an expense: `delete`](#35-delete-an-expense-delete)
        * [3.6 View an expense : `view`](#36-view-an-expense--view)
        * [3.7 View categories : `view-c`](#37-view-categories--view-c)
        * [3.8 Filter expenses](#38-filter-expenses)
            * [3.8.1 Filter by category: `filter-c`](#381-filter-by-category-filter-c)
            * [3.8.2 Filter by date: `filter-t`](#382-filter-by-date--filter-t)
            * [3.8.3 Filter by description: `filter-d`](#383-filter-by-description--filter-d)
        * [3.9 List all expenses : `list`](#39-list-all-expenses--list)
        * [3.10 Sort expenses](#310-sort-the-expenses)
            * [3.10.1 Sort expenses by the amount of each expense: `sort-a`](#3101-sort-expenses-by-the-amount-of-each-expense-sort-a)
            * [3.10.2 Sort expenses by the date of each expense: `sort-t`](#3102-sort-expenses-by-the-date-of-each-expense-sort-t)
        * [3.11 Exchange Currency : `exchange`](#311-exchange-currency--exchange)
        * [3.12 Show Currency Codes: `show-codes`](#312-show-currency-codes-show-codes)
        * [3.13 Show Exchange Rates: `show-rates`](#313-show-exchange-rates-show-rates)
        * [3.14 Show Statistics: `show-stats`](#314-show-statistics-show-stats)
        * [3.15 View help: `help`](#315--view-help-help)
        * [3.16 Exiting the program : `exit`](#316-exit-the-program--exit)
        * [3.17 Saving the data](#317-saving-the-data)
    * [4. FAQ(Frequently Asked Question)](#4-faqfrequently-asked-question)
    * [5. Glossary](#5-glossary)
    * [6. Command Summary](#6-command-summary)


--------------------------------------------------------------------------------------------------------------------
## 1. Overview
UniSave is your desktop finance manager. It is an application that helps you manage your finance by tracking your spending, setting budget for each month, as well as viewing your expenses in various categories. Moreover, UniSave allows tracking expenses in different currencies.

UniSave targets university students who tend to incur a large amount of spending, including tuition fees, housing fees, transport and so on. It is catered especially for students who are more familiar with desktop applications and type fast.
UniSave is available for the Linux, Windows and Mac OS operating systems.

## 2. Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `UniSave.jar` from [here](https://github.com/AY2021S1-CS2103T-W10-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your UniSave.

4. For Windows user, double-click the file to start the app. For MacOS user, open your terminal and set the directory to be the same as UniSave, enter `java -jar UniSave.jar`.
In a few seconds, you should see a GUI similar to the diagram below. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press `Enter` to execute it.<br>

   Some example commands you can try:

   * **`list`** : Lists all expenses.
   
   * **`set-b 1000`** : Set the budget of UniSave to be 1000 SGD (Singapore Dollar is the Default Currency for UniSave).

   * **`add a/50 c/entertainment D/1 d/yayymovie!`** : Adds an expense of `50` SGD under category `entertainment` you spent `1` day ago (i.e. yesterday), with `yayymovie!` description.

   * **`exchange c/cny`** : Change the currency of the whole expense book to Chinese Yuan (CNY is the currency code for Chinese Yuan).
   
   * **`show-stats`** : Show a statistic overview of all your expenses.
   
   * **`delete`**`1` : Deletes the expense with index 1.

   * **`exit`** : Exits the app.

6. Refer to the [Features](#3-features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## 3. Features
* [3.1 Clear data: `clear`](#31-clear-data-in-unisave--clear)
* [3.2 Set budget : `set-b`](#32-set-budget--set-b)
* [3.3 Add an expense: `add`](#33-add-an-expense-add)
* [3.4 Edit an expense: `edit`](#34-edit-an-expense--edit)
* [3.5 Delete an expense: `delete`](#35-delete-an-expense-delete)
* [3.6 View an expense : `view`](#36-view-an-expense--view)
* [3.7 View categories : `view-c`](#37-view-categories--view-c)
* [3.8 Filter expenses](#38-filter-expenses)
    * [3.8.1 Filter by category: `filter-c`](#381-filter-by-category-filter-c)
    * [3.8.2 Filter by date: `filter-t`](#382-filter-by-date--filter-t)
    * [3.8.3 Filter by description: `filter-d`](#383-filter-by-description--filter-d)
* [3.9 List all expenses : `list`](#39-list-all-expenses--list)
* [3.10 Sort expenses](#310-sort-the-expenses)
    * [3.10.1 Sort expenses by the amount of each expense: `sort-a`](#3101-sort-expenses-by-the-amount-of-each-expense-sort-a)
    * [3.10.2 Sort expenses by the date of each expense: `sort-t`](#3102-sort-expenses-by-the-date-of-each-expense-sort-t)
* [3.11 Exchange Currency : `exchange`](#311-exchange-currency--exchange)
* [3.12 Show Currency Codes: `show-codes`](#312-show-currency-codes-show-codes)
* [3.13 Show Exchange Rates: `show-rates`](#313-show-exchange-rates-show-rates)
* [3.14 Show Statistics: `show-stats`](#314-show-statistics-show-stats)
* [3.15 View help: `help`](#315--view-help-help)
* [3.16 Exiting the program : `exit`](#316-exit-the-program--exit)
* [3.17 Saving the data](#317-saving-the-data)

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add a/AMOUNT`, `AMOUNT` is a parameter which can be used as `add a/100`.
  
* Items in square brackets are optional (zero or one instance).<br>
  e.g `a/AMOUNT c/CATEGORY [t/date]` can be used as `a/100 c/shopping` or as `a/100 c/shopping t/2020-10-30`
  
* Parameters can be in any order.<br>
  e.g. if the command specifies `a/AMOUNT C/CATEGORY, c/CATEGORY a/AMOUNT` is also acceptable.

</div>

### Commands  <a name="commands"></a>

#### 3.1 Clear data in UniSave : `clear`

Clear all the data in the program. 

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You can use this command to clear the sample data when you first launch the app, or use it whenever you want to start a new expense book.
</div>

Format: `clear`

Navigate back to the feature list: [Features](#3-features)

#### 3.2 Set budget : `set-b`

Set the budget for UniSave. Default budget is 0 Singapore Dollar (SGD). 
When total spending exceed the budget, UniSave will remind you to set a new budget.

Format: `set-b AMOUNT`

Example:
`set-b 500`: Set the budget to 500.

![setBudget](images/setBudgetCommand.png)

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You can change the Currency with command <b>exchange c/CURRENCY_CODE</b>, 
to see a full list of supported currencies with their currency codes use command <b>show-codes</b>.
</div>

Navigate back to the feature list: [Features](#3-features)

#### 3.3 Add an expense: `add`

Adds an expense.

Format: `add a/AMOUNT c/CATEGORY [t/DATE] [d/description]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Note that an amount of an expense should only be positive numbers.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
If you don't input a date, the default date is today.
If you do, a date can be entered in one of these two forms:
i) Enter date as a single integer, corresponding to number of days ago. E.g: 1 means you made the expenses one day ago. (Note that when date is given as a single integer, it should not be less than 0 or greater than 3650)
ii) Enter date as the exact date in YYYY-MM-DD format. E.g: 2020-10-28
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You may enter each field in a different order. That means `add a/100 c/food t/1 d/milk tea membership card` gives the 
same result as `add t/1 d/milk tea membership card c/food a/100`.
</div>

Examples:
* `add a/100 c/food t/1 d/milk tea membership card`
* `add a/50 c/entertainment t/2020-09-28 d/yayymovie!`

![add](images/addExpenseCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.4 Edit an expense : `edit`

Edit an expense.

Format: `edit INDEX [a/AMOUNT] [c/CATEGORY] [t/DATE] [d/DESCRIPTION]`

* Edits the expense at the specified INDEX.
* The index refers to the index number shown in the expense list.
* The index **must be a positive integer greater than 0**. eg. 1, 2, 3, …
* If no field is provided, no change will be done.

Examples:
* `edit 1 a/10.2`
![Edit](images/EditCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.5 Delete an expense: `delete`

Deletes an expense.

Format: `delete INDEX`

* Deletes the expense at the specified `INDEX`.
* The index refers to the index number shown in the expense list.
* The index **must be a positive integer** 1, 2, 3, …

Examples:
* `list` followed by `delete 2` deletes the 2nd expense in the expense list.

![delete](images/deleteExpenseCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.6 View an expense : `view`

View an expense in the expense list.

Format: `view INDEX`

View the expense at the specified INDEX.

The index refers to the index number shown in the displayed expense list.

* The index must be a **positive integer** 1, 2, 3, …

Examples:
* `view 3` views the `amount, category, date and description` of the third expense displayed in the list.

![view](images/viewCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.7 View categories : `view-c`

Show all existing categories in the expense list. Note that a category is added automatically when you add an expense.

Format: `view-c`

![viewCategory](images/viewCategoryCommand.png)

#### 3.8 Filter Expenses

Filters for specific expense(s) based on the input command.

##### 3.8.1 Filter by category: `filter-c`

Show all the expenses whose category match the specified category.

Format: `filter-c CATEGORY`

Examples:
* `filter-c entertainment`: filter all the expenses under category `entertainment`.

![filter-c](images/listByCategoryCommand.png)

Navigate back to the feature list: [Features](#3-features)

##### 3.8.2 Filter by date : `filter-t`

Show all the expenses whose date match the specified date.

Format: `filter-t YYYY-MM-DD`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The date format `YYYY-MM-DD` is sensitive and only this format is recognizable for this command.
</div>

Examples:
* `filter-t 2020-10-23`: filter all the expenses that are saved on `2020-10-23`.

![filter-t](images/listByDateCommand.png)

Navigate back to the feature list: [Features](#3-features)

##### 3.8.3 Filter by description : `filter-d`

Show all the expenses whose description contains the specified description.

Format: `filter-d DESCRIPTION`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Multiple description input is allowed.
</div>

Examples:
* `filter-d movie`: filter all the expenses which description has the keyword `movie`.

![filter-d](images/listByDescCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.9 List all expenses : `list`

You can list out all the expenses stored in UniSave.

Format: `list`

Examples:
* `list`: list all the expenses in UniSave.

![list](images/listCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.10 Sort the expenses

Sort the expense(s) based on the input command.

##### 3.10.1 Sort expenses by the amount of each expense: `sort-a`
Sort the expenses in specified order.

Format: `sort-a descending`
        `sort-a ascending`

Examples: `sort-a ascending`
Sort the expenses according to amount in ascending order.

![sort by amount in ascending order](images/sortByAmount.png)

Navigate back to the feature list: [Features](#3-features)


##### 3.10.2 Sort expenses by the date of each expense: `sort-t`
Sort the expenses according to date in specified order. 

Format: `sort-t ascending`
        `sort-t descending`

Examples: `sort-t ascending`
Sort the expenses according to date in ascending order (i.e. from past to present.).

![sort by time in descending order](images/sortByTime%20descending.png)

![sort by time in ascending order](images/sortByTime%20ascending.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.11 Exchange Currency : `exchange`
Convert the currency of UniSave from current currency to the input currency of the currency code, note that the currency code is case-insensitive.

Format: `exchange c/CURRENCY_CODE`

Example: `exchange c/CNY`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Use command <b>show-codes</b> to see a full list of currency codes supported by UniSave.
</div>

![exchange_after](images/ExchangeCommand-after.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.12 Show Currency Codes: `show-codes`
Show a full list of supported currencies with their corresponding currency codes.

Format: `show-codes`

![currency_codes](images/CurrencyCodes.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.13 Show Exchange Rates: `show-rates`
Show a full list of exchange rates adapted by UniSave. Note that the exchange rates were updated at 2020-10-31 from currency-layer website, there may be a slight inaccuracy compared to current exchange rates.

Format: `show-rates`

![exchange_rates](images/ExchangeRates.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.14 Show Statistics: `show-stats`
Show a statistic overview of the expenses, such as the total number of expenses as well as the total spending in each category.

There are arranging in descending order in which the category that you spent the most will be on the first row.

Format: `show-stats`

Examples: `show-stats`

![showStatistic](images/showStatisticCommand.png)
![showStatistic_table](images/showStatisticTable.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.15 : View help: `help`

Opens a window with a link that directs you to our user guide.

Format: `help`

Navigate back to the feature list: [Features](#3-features)

#### 3.16 Exit the program : `exit`

Exits the program.

Format: `exit`

Navigate back to the feature list: [Features](#3-features)

#### 3.17 Saving the data

UniSave data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

Navigate back to the feature list: [Features](#3-features)

--------------------------------------------------------------------------------------------------------------------

## 4. FAQ(Frequently Asked Question)
**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous UniSave home folder. <br>
--------------------------------------------------------------------------------------------------------------------

## 5. Glossary 

Term | Explanation
--------|------------------
**UniSave** | UniSave refers to the name of the application.
**Expense** | An expense consists of an amount spent in some currency, the date on which you spend the money, a category that you classify this spending into, and a description so that you can recall the details when you view this spending again later.
**CLI** | A command-line interface (CLI) processes commands to a computer program in the form of lines of text.
**GUI** | The graphical user interface is a form of user interface that allows users to interact with a computer program through graphical icons instead of text-based user interfaces or text navigation.

--------------------------------------------------------------------------------------------------------------------

## 6. Command Summary

Action | Format, Examples
--------|------------------
**Clear data**|`clear`
**Set budget** | `set-b AMOUNT` <br> e.g., `set-b 1000`
**Add** | `add a/AMOUNT c/CATEGORY [t/DATE] [d/DESCRIPTION]` <br> e.g., `add a/100 c/food`
**Edit** | `edit INDEX [a/AMOUNT] [c/CATEGORY] [t/DATE] [d/DESCRIPTION]` <br> e.g., `edit 1 a/12`
**Delete** | `delete INDEX` <br> e.g., `delete 3`
**View** | `view INDEX` <br> e.g., `view 5`
**View categories** | `view-c`
**Filter by category** | `filter-c CATEGORY` <br> e.g., `filter-c food`
**Filter by date** | `filter-t YYYY-MM-DD` <br> e.g., `filter-t 2020-02-20`
**Filter by description** | `filter-d DESCRIPTION` <br> e.g., `filter-d movies`
**List** | `list`
**Sort by amount** | `sort-a ORDER` <br> e.g., `sort-a acsending`
**Sort by date** | `sort-t ORDER` <br> e.g., `sort-t descending`
**Exchange Currency** | `exchange c/CURRENCY_CODE` <br> e.g., `exchange c/CNY`
**Show Currency Codes** | `show-codes`
**Show Exchange Rates** | `show-rates`
**Show Statistic** | `show-stats`
**Help** | `help` <br> e.g., `help`
**Exit** | `exit` <br> e.g., `exit`
