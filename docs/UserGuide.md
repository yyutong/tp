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
        * [3.1 Adding an expense: `add`](#31-adding-an-expense-add)
        * [3.2 Listing all expenses : `list`](#32-listing-all-expenses--list)
        * [3.3 Listing all expenses in a category : `filter-c`](#33-listing-all-expenses-in-a-category--filter-c)
        * [3.4 Listing all expenses by date : `filter-t`](#34-listing-all-expenses-by-date--filter-t)
        * [3.5 Listing all expenses by description : `filter-d`](#35-listing-all-expenses-by-description--filter-d)
        * [3.6 Deleting an expense: `delete`](#36-deleting-an-expense-delete)
        * [3.7 View an expense : `view`](#37-view-an-expense--view)
        * [3.8 View Category Labels : `viewcategories`](#38-view-category-labels--viewcategories)
        * [3.9 Add a description to an expense : `add-d`](#39-add-a-description-to-an-expense--add-d)
        * [3.10 Delete description of an expense: `delete-d`](#310-delete-description-of-an-expense-delete-d)
        * [3.11 Set Budget : `setbudget`](#311-set-budget--setbudget)
        * [3.12 Show budget : `showbudget`](#312-show-budget--showbudget)
        * [3.13 Exchange Currency : `exchange`](#313-exchange-currency--exchange)
        * [3.14 Clear data in UniSave : `clear`](#314-clear-data-in-unisave--clear)
        * [3.15 Exiting the program : `exit`](#315-exiting-the-program--exit)
        * [3.16 Saving the data](#316-saving-the-data)
        * [3.17 Show the statistic of the expenses: `showstatistics`](#317-show-the-statistic-of-the-expenses-showstatistics)
        * [3.18 Sort expenses by the amount of each expense: `sort-a`](#318-sort-existing-expenses-by-the-amount-of-expense-sort-a)
        * [3.19 Sort expenses by the date of each expense: `sort-t`](#319-sort-existing-expenses-by-the-date-of-expense-sort-t)
        * [3.20 Use Help Command to help you find all the commands: `help`](#320-use-help-command-to-help-you-find-all-the-commands-help)
        * [3.21 Edit an expense : `edit`](#321-edit-an-expense--edit)
    * [4. FAQ(Frequently Asked Question)](#4-faqfrequently-asked-question)
    * [5. Glossary](#5-glossary)
    * [6. Command Summary](#6-command-summary)


--------------------------------------------------------------------------------------------------------------------
## 1. Overview
UniSave is your desktop finance manager. It is an application that helps you manage your finance by tracking your spending, setting budget for each month, as well as viewing your expenses in various categories. Moreover, UniSave allows tracking expenses in different currencies.

UniSave targets international students in university who tend to incur a large amount of spending, including tuition fees, housing fees, transport and so on. It is catered especially for university students who are more familiar with desktop applications and type fast.
UniSave is available for the Linux, Windows and Mac OS operating systems.



## 2. Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `UniSave.jar` from [here](https://github.com/AY2021S1-CS2103T-W10-1/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your UniSave.

1. Double-click the file to start the app. In a few seconds, you should see a GUI similar to the diagram below. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. If you are not sure what are the command available,
you can type **`help`** You will be able to see a guide to briefly show you how to use the various commands

   Some example commands you can try:

   * **`list`** : Lists all expenses.

   * **`add`**`add a/50 c/ENTERTAINMENT D/1 d/yayymovie!` : Adds an expense 50$ categorised as `ENTERTAINMENT` that you spent yesterday with `yayymovie!` description.

   * **`delete`**`1` : Deletes the first expense shown in the expense list.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#3-features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## 3. Features

 * [3.1 Adding an expense: `add`](#31-adding-an-expense-add)
 * [3.2 Listing all expenses : `list`](#32-listing-all-expenses--list)
 * [3.3 Listing all expenses in a category : `filter-c`](#33-listing-all-expenses-in-a-category--filter-c)
 * [3.4 Listing all expenses by date : `filter-t`](#34-listing-all-expenses-by-date--filter-t)
 * [3.5 Listing all expenses by description : `filter-d`](#35-listing-all-expenses-by-description--filter-d)
 * [3.6 Deleting an expense: `delete`](#36-deleting-an-expense-delete)
 * [3.7 View an expense : `view`](#37-view-an-expense--view)
 * [3.8 View Category Labels : `viewcategories`](#38-view-category-labels--viewcategories)
 * [3.9 Add a description to an expense : `add-d`](#39-add-a-description-to-an-expense--add-d)
 * [3.10 Delete description of an expense: `delete-d`](#310-delete-description-of-an-expense-delete-d)
 * [3.11 Set Budget : `setbudget`](#311-set-budget--setbudget)
 * [3.12 Show budget : `showbudget`](#312-show-budget--showbudget)
 * [3.13 Exchange Currency : `exchange`](#313-exchange-currency--exchange)
 * [3.14 Clear data in UniSave : `clear`](#314-clear-data-in-unisave--clear)
 * [3.15 Exiting the program : `exit`](#315-exiting-the-program--exit)
 * [3.16 Saving the data](#316-saving-the-data)
 * [3.17 Show the statistic of the expenses: `showstatistics`](#317-show-the-statistic-of-the-expenses-showstatistics)
 * [3.18 Sort expenses by the amount of each expense: `sort-a`](#318-sort-existing-expenses-by-the-amount-of-expense-sort-a)
 * [3.19 Sort expenses by the date of each expense: `sort-t`](#319-sort-existing-expenses-by-the-date-of-expense-sort-t)
 * [3.20 Use Help Command to help you find all the commands: `help`](#320-use-help-command-to-help-you-find-all-the-commands-help)
 * [3.21 Edit an expense : `edit`](#321-edit-an-expense--edit)

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add a/AMOUNT`, `AMOUNT` is a parameter which can be used as `add a/100`.

</div>

### Commands  <a name="commands"></a>

#### 3.1 Adding an expense: `add`

Adds an expense, including fields amount, category, date, description, to your expense book. You must specify all fields when adding the expense.

Format: `add a/AMOUNT c/CATEGORY D/DATE d/DESCRIPTION`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Amount and Category are compulsory field while Date and Description are optional. (Note that an amount of an expense should only be positive numbers.)
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A date can be entered in one of these two forms:
i) Enter date as a single integer, corresponding to how many days ago. E.g: 1 means you made the expenses one day ago. (Note that when date is given as a single integer, it should not be less than 0 or greater than 3650)
ii) Enter date as the exact date in YYYY-MM-DD format. E.g: 2020-10-28
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The sample categories are FOODBEVERAGE, SHOPPING, ENTERTAINMENT. Category can be added manually.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The description must not begin with a blank space. E.g: Putting "d/ " and "d/ xx" for the description field would result in invalid format.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You may enter each field in a different order. That means `add a/100 c/FOODBEVERAGE D/1 d/milk tea membership card` gives the 
same result as `add D/1 d/milk tea membership card c/FOODBEVERAGE a/100`.
</div>

Examples:
* `add a/100 c/FOODBEVERAGE D/1 d/milk tea membership card`
* `add a/50 c/ENTERTAINMENT D/2020-09-28 d/yayymovie!`

![add](images/addExpenseCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.2 Listing all expenses : `list`

You can list out all the expenses stored in UniSave.

Format: `list`

Examples:
* `list`: list all the expenses in all the categories.

![list](images/listCommand.png)

Navigate back to the feature list: [Features](#3-features)


#### 3.3 Listing all expenses in a category : `filter-c`

You can specify a category and then list all the expenses that belong to that category.

Format: `filter-c CATEGORY`

Examples:
* `filter-c entertainment`: list all the expenses in entertainment.

![filter-c](images/listByCategoryCommand.png)

Navigate back to the feature list: [Features](#3-features)


#### 3.4 Listing all expenses by date : `filter-t`

You can find all the expenses that are saved on a specific date and list them out.

Format: `filter-t YYYY-MM-DD`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The date format `YYYY-MM-DD` is sensitive and only this format is recognisable for this command.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Multiple date input is allowed.
</div>

Examples:
* `filter-t 2020-05-22`: list all the expenses that are saved on 2020-05-22.

![filter-t](images/listByDateCommand.png)

Navigate back to the feature list: [Features](#3-features)


#### 3.5 Listing all expenses by description : `filter-d`

You can search for keywords in description and list all the expenses which description matches the keywords.

Format: `filter-d DESCRIPTION`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Multiple description input is allowed.
</div>

Examples:
* `filter-d movies`: list all the expenses which description has the keyword 'movies'.

![filter-d](images/listByDescCommand.png)

Navigate back to the feature list: [Features](#3-features)


#### 3.6 Deleting an expense: `delete`

Deletes the specified expense from the expense list.

Format: `delete INDEX`

* Deletes the expense at the specified `INDEX`.
* The index refers to the index number shown in the expense list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd expense in the expense list.

![delete](images/deleteExpenseCommand.png)

Navigate back to the feature list: [Features](#3-features)



#### 3.7 View an expense : `view`

View an expense in the expense list.

Format: `view INDEX`


View the expense at the specified INDEX.

The index refers to the index number shown in the displayed expense list.


* The index must be a **positive integer** 1, 2, 3, …​

Examples:
* `view 3` views the `amount, category, date and description` of the third expense displayed in the list.

![view](images/viewCommand.png)

Navigate back to the feature list: [Features](#3-features)


#### 3.8 View Category Labels : `viewcategories`

Show all the category lables used in the UniSave.

Format: `viewcategories`

![viewCategory](images/viewCategoryCommand.png)

#### 3.9 Add a description to an expense : `add-d`

Add a description to an existing expense in the finance book.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The newly added description will override the existing description of the specified expense.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
If you use `addDes INDEX` or `addDes INDEX d/` without specifying the description field, the existing description will be removed.
</div>

Format: `add-d INDEX d/DESCRIPTION`

* Add description field to the expense at the specified `INDEX`. The `INDEX` refers to the index number shown in the displayed expense list. The index **must be a positive integer** 1, 2, 3, …​
* Existing description will be overwrote to the new description.

Examples:
`add-d 3 d/movies` Add the description field `movies` to the 3rd expense.

Navigate back to the feature list: [Features](#3-features)



#### 3.10 Delete description of an expense: `delete-d`

Delete the description field of an existing expense.

Format: `delete-d INDEX`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The description field of the specified expense will still exist, just that it will be empty.
</div>


* Deletes the description of the expense at the specified INDEX.
* The `INDEX` refers to the index number shown in the expense list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …​

Examples:
`delete-d 6` Deletes the description field of the 1st expense.

![deleteDes](images/deleteDesCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.11 Set Budget : `setbudget`

Set the budget for UniSave. Default budget is 0 SGD.

Format: `setbudget AMOUNT`

Example:
`setbudget 500.0`: Set the budget to 500.

![setBudget](images/setBudgetCommand.png)


Navigate back to the feature list: [Features](#3-features)



#### 3.12 Show budget : `showbudget`

Show the budget last set and the remaining budget in the UniSave.

Format: `showbudget`

![showBudget](images/showBudgetCommand.png)


Navigate back to the feature list: [Features](#3-features)

#### 3.13 Exchange Currency : `exchange`

Convert the currency of UniSave from current currency to the input currency.

Format: `exchange s/CURRENCY_CODE`

Example: `exchange s/CNY`

Before Exchange: 

![exchange_before](images/ExchangeCommand-before.png)

After Exchange: 

![exchange_after](images/ExchangeCommand-after.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.14 Clear data in UniSave : `clear`

Clears the data in the program.

Format: `clear`


Navigate back to the feature list: [Features](#3-features)


#### 3.15 Exiting the program : `exit`

Exits the program.

Format: `exit`


Navigate back to the feature list: [Features](#3-features)


#### 3.16 Saving the data

UniSave data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.


Navigate back to the feature list: [Features](#3-features)

#### 3.17 Show the statistic of the expenses: `showstatistics`

Show the overview of the expenses, such as the total number of expenses as well as the total spending.

There are arranging in descending order in which the category that you spent the most will be on the first row.

Format: `showstatistics`

Examples: `showstatistics`

![showStatistic](images/showStatisticCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.18 Sort existing expenses by the amount of expense: `sort-a`

Show all existing expenses which sre sorted by amount of expense in either descending or ascending order.
Format: `sort-a descending`
        `sort-a ascending`

Examples: `sort-a ascending`

![sort by amount in descending order](images/sortByAmount%20descending.png)

![sort by amount in ascending order](images/sortByAmount%20ascending.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.19 Sort existing expenses by the date of expense: `sort-t`

Show all existing expenses which sre sorted by date of expense in either descending or ascending order.
Format: `sort-t descending`
        `sort-t ascending`

Examples: `sort-t descending`

![sort by time in descending order](images/sortByTime%20descending.png)

![sort by time in ascending order](images/sortByTime%20ascending.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.20 Use Help Command to help you find all the commands: `help`

Help Command serve as a brief guide for you to refer to when you forget certain command or want to check what are the new
features provided by the application.

Format: `help`

Examples: `help`

![Help](images/helpCommandWindow.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.21 Edit an expense : `edit`

Edit an existing expense in the expense book.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The newly added information will override the existing information of the specified expense.
</div>

Format: `edit INDEX [filed to be edited with the correct prefix]`

* Edit a field to the expense at the specified `INDEX`. The `INDEX` refers to the index number shown in the displayed expense list. The index **must be a positive integer** 1, 2, 3, …​
* Existing expense information will be overwrote to the new information.
* prefix for `Amount`: `a/` ; prefix for `Category`: `c/` ; prefix for `Date`: `D/` ; prefix for `Description`: `d/`

Examples:
if you want to change the amount
`edit 1 a/10.2` Change the amount field to 10.2.
![Edit](images/EditCommand.png)

Navigate back to the feature list: [Features](#3-features)


--------------------------------------------------------------------------------------------------------------------

## 4. FAQ(Frequently Asked Question)

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous UniSave home folder. <br>
**Q**: What should I do if I forget what are the command available?<br>
**A**: You can use `help` command to help you to see the brief summary of the commands available or use the summary table below.
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
**Add** | `add a/AMOUNT c/CATEGORY D/DATE [d/DESCRIPTION]` <br> e.g., `add a/100 c/FOODBEVERAGE D/1`
**List** | `list`
**List by category** | `filter-c CATEGORY` <br> e.g., `filter-c food`
**List by date** | `filter-t YYYY-MM-DD` <br> e.g., `filter-t 2020-02-20`
**List by description** | `filter-d DESCRIPTION` <br> e.g., `filter-d movies`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**View** | `view INDEX`<br> e.g., `view 5`
**View existing category labels** | `viewCategory`
**Add Description** | `add-d INDEX d/DESCRIPTION`<br> e.g., `add-d 2 d/ENTERTAINMENT`
**Delete Description** | `delete-d INDEX`<br> e.g., `delete-d 2`
**Set Budget** | `setbudget AMOUNT`<br> e.g., `setbudget 1000`
**Show Budget** | `showbudget` <br> e.g., `showbudget`
**Exchange Currency** | `exchange s/CURRENCY_CODE` <br> e.g., `exchange s/CNY`
**Show Statistic** | `showstatistics`<br> e.g., `showstatistics`
**Help** | `help` <br> e.g., `help`
**Clear** | `clear` <br> e.g., `clear`
**Exit** | `exit` <br> e.g., `exit`
**Edit** | `edit INDEX [field to be edited with the correct prefix]` <br> e.g., `edit 1 a/10.2`
