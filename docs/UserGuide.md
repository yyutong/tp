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
        * [3.3 Listing all expenses in a category : `listbycategory`](#33-listing-all-expenses-in-a-category--listbycategory)
        * [3.4 Deleting an expense: `delete`](#34-deleting-an-expense-delete)
        * [3.5 View an expense : `view`](#35-view-an-expense--view)
        * [3.6 View Category Labels : `viewCategory`](#36-view-category-labels--viewcategory)
        * [3.7 Add a description to an expense : `addDes`](#37-add-a-description-to-an-expense--adddes)
        * [3.8 Delete description of an expense: `deleteDes`](#38-delete-description-of-an-expense-deletedes)
        * [3.9 Set Budget : `setBudget`](#39-set-budget--setbudget)
        * [3.10 Show budget : `showBudget`](#310-show-budget--showbudget)
        * [3.11 Clear data in UniSave : `clear`](#311-clear-data-in-unisave--clear)
        * [3.12 Exiting the program : `exit`](#312-exiting-the-program--exit)
        * [3.13 Saving the data](#313-saving-the-data)
        * [3.14 show the statistic of the expenses: `showStatistic`](#314-show-the-statistic-of-the-expenses-showstatistic)
        * [3.15 Use Help Command to help you find all the commands: `help`](#315-use-help-command-to-help-you-find-all-the-commands-help)
    * [4. FAQ(Frequently Asked Question)](#4-faqfrequently-asked-question)
    * [5. Glossary](#5-glossary)
    * [6. Command Summary](#6-command-summary)


--------------------------------------------------------------------------------------------------------------------
## 1. Overview
UniSave is your desktop finance manager. It is an application that helps you manage your finance by tracking your spending, setting budget for each month, as well as viewing your expenses in various categories. Moreover, UniSave allows tracking expenses in different currencies.

UniSave targets international students in university who tend to incur a large amount of spending, including tuition fees, housing fees, transport and so on. University students are also more familiar with desktop applications and typing.
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

1. Refer to the [3. Features](#3-features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## 3. Features

 * [3.1 Adding an expense: `add`](#31-adding-an-expense-add)
 * [3.2 Listing all expenses : `list`](#32-listing-all-expenses--list)
 * [3.3 Listing all expenses in a category : `listbycategory`](#33-listing-all-expenses-in-a-category--listbycategory)
 * [3.4 Deleting an expense: `delete`](#34-deleting-an-expense-delete)
 * [3.5 View an expense : `view`](#35-view-an-expense--view)
 * [3.6 View Category Labels : `viewCategory`](#36-view-category-labels--viewcategory)
 * [3.7 Add a description to an expense : `addDes`](#37-add-a-description-to-an-expense--adddes)
 * [3.8 Delete description of an expense: `deleteDes`](#38-delete-description-of-an-expense-deletedes)
 * [3.9 Set Budget : `setBudget`](#39-set-budget--setbudget)
 * [3.10 Show budget : `showBudget`](#310-show-budget--showbudget)
 * [3.11 Clear data in UniSave : `clear`](#311-clear-data-in-unisave--clear)
 * [3.12 Exiting the program : `exit`](#312-exiting-the-program--exit)
 * [3.13 Saving the data](#313-saving-the-data)
 * [3.14 show the statistic of the expenses: `showStatistic`](#314-show-the-statistic-of-the-expenses-showstatistic)
 * [3.15 Use Help Command to help you find all the commands: `help`](#315-use-help-command-to-help-you-find-all-the-commands-help)

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add a/AMOUNT`, `AMOUNT` is a parameter which can be used as `add a/100`.

* Items in square brackets are optional.<br>
  e.g `add a/AMOUNT [d/DESCRIPTION]` can be used as `add a/100 d/movie!!` or as `add a/100`.

</div>

### Commands  <a name="commands"></a>

#### 3.1 Adding an expense: `add`

Adds an expense to a category.  Must specify category when adding the expense.

Format: ` add a/AMOUNT c/CATEGORY D/DATE [d/DESCRIPTION]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A date should be a single integer. The date correspond to how many days ago.E.g: 1 refer to you made the expenses one day ago 
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Description for the expense is optional.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The sample categories are FOODBEVERAGE, SHOPPING, ENTERTAINMENT. They can be added individually.
</div>

Examples:
* `add a/100 c/FOODBEVERAGE d/1`
* `add a/50 c/ENTERTAINMENT d/0 D/yayymovie!`

![add](images/addExpenseCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.2 Listing all expenses : `list`

Shows a list of all expenses.

Format: `list`

Examples:
* `list`: list all the expenses in all the categories.

Navigate back to the feature list: [Features](#3-features)



#### 3.3 Listing all expenses in a category : `listbycategory`

Shows a list of all expenses belongs to the category.

Format: `listbycategory CATEGORY`

Examples:
* `listbycategory entertainment`: list all the expenses in entertainment.

Navigate back to the feature list: [Features](#3-features)



![list](images/listCommand.png)

#### 3.4 Deleting an expense: `delete`

Deletes the specified expense from the expense list.

Format: `delete INDEX`

* Deletes the expense at the specified `INDEX`.
* The index refers to the index number shown in the expense list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd expense in the expense list.

![delete](images/deleteExpenseCommand.png)

Navigate back to the feature list: [Features](#3-features)



#### 3.5 View an expense : `view`

View an expense in the expense list.

Format: `view INDEX`


View the expense at the specified INDEX.

The index refers to the index number shown in the displayed expense list.


* The index must be a **positive integer** 1, 2, 3, …​

Examples:
* `view 3` views the `amount, category, date and description` of the third expense displayed in the list.

![view](images/viewCommand.png)

Navigate back to the feature list: [Features](#3-features)


#### 3.6 View Category Labels : `viewCategory`

Show all the category lables used in the UniSave.

Format: `viewCategory`

![viewCategory](images/viewCategoryCommand.png)

#### 3.7 Add a description to an expense : `addDes`

Add a description to an existing expense in the finance book.

Format: `addDes INDEX d/DESCRIPTION`

* Add description field to the expense at the specified `INDEX`. The `INDEX` refers to the index number shown in the displayed expense list. The index **must be a positive integer** 1, 2, 3, …​
* Existing description will be overwrote to the new description.

Examples:
`addDes 3 d/movies` Add the description field `movies` to the 3rd expense.

Navigate back to the feature list: [Features](#3-features)



#### 3.8 Delete description of an expense: `deleteDes`

Delete the description field of an existing expense.

Format: `deleteDes INDEX`

* Deletes the description of the expense at the specified INDEX.
* The `INDEX` refers to the index number shown in the expense list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …​

Examples:
`deleteDes 6` Deletes the description field of the 1st expense.

![deleteDes](images/deleteDesCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.9 Set Budget : `setBudget`

Set the budget for UniSave. Default zero budget. Pop up for input when first launched.

Format: `setBudget AMOUNT`

Example:
`setBudget 500.0`: Set the budget to 500.

![setBudget](images/setBudgetCommand.png)


Navigate back to the feature list: [Features](#3-features)



#### 3.10 Show budget : `showBudget`

Show the budget last set and the remaining budget in the UniSave.

Format: `showBudget`

![showBudget](images/showBudgetCommand.png)


Navigate back to the feature list: [Features](#3-features)



#### 3.11 Clear data in UniSave : `clear`

Clears the data in the program.

Format: `clear`


Navigate back to the feature list: [Features](#3-features)


#### 3.12 Exiting the program : `exit`

Exits the program.

Format: `exit`


Navigate back to the feature list: [Features](#3-features)


#### 3.13 Saving the data

UniSave data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.


Navigate back to the feature list: [Features](#3-features)

#### 3.14 show the statistic of the expenses: `showStatistic`

Show the overview of the expenses, such as the total number of expenses as welll as the total spending.

There are arranging in descending order in which the category that you spent the most will on the first row.

Format: `showStatistic`

Examples: `showStatistic`

![showStatistic](images/showStatisticCommand.png)

Navigate back to the feature list: [Features](#3-features)

#### 3.15 Use Help Command to help you find all the commands: `help`

Help Command serve as a brief guide for you to refer to when you forget certain command or want to check what are the new
features provided by the application.

Format: `help`

Examples: `help`

![Help](images/helpCommand.png)

Navigate back to the feature list: [Features](#3-features)


--------------------------------------------------------------------------------------------------------------------

## 4. FAQ(Frequently Asked Question)

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous UniSave home folder. <br>
**Q**: What should I do if I forget what are the command available?<br>
**A**: You can use `help` command to help you to see the brief summary of the commands available.
--------------------------------------------------------------------------------------------------------------------

## 5. Glossary 

Term | Explanation
--------|------------------
**UniSave** | UniSave refers to the name of the application.
**Expense** | An expense consists of an amount spent in some currency, the date on which you spend the money, a category that you classify this spending into, and an optional description you might want to add so that you can recall the details when you view this spending again later.
**CLI** | A command-line interface (CLI) processes commands to a computer program in the form of lines of text.
**GUI** | The graphical user interface is a form of user interface that allows users to interact with a computer program through graphical icons instead of text-based user interfaces or text navigation.

--------------------------------------------------------------------------------------------------------------------

## 6. Command Summary

Action | Format, Examples
--------|------------------
**Add** | `add a/AMOUNT c/CATEGORY D/DATE [d/DESCRIPTION]` <br> e.g., `add a/100 c/FOODBEVERAGE D/1`
**List** | `list`
**List by category** | `listbycategory CATEGORY` <br> e.g., `listbycategory food`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**View** | `view INDEX`<br> e.g., `view 5`
**View existing category labels** | `viewCategory`
**Add Description** | `addDes INDEX d/DESCRIPTION`<br> e.g., `addDes 2 d/ENTERTAINMENT`
**Delete Description** | `deleteDes INDEX`<br> e.g., `deleteDes 2`
**Set Budget** | `setBudget AMOUNT`<br> e.g., `setBudget 1000`
**Show Budget** | `showBudget` <br> e.g., `showBudget`
**Show Statistic** | `showStatistic`<br> e.g., `showStatistic`
**Help** | `help` <br> e.g., `help`
**Clear** | `clear` <br> e.g., `clear`
**Exit** | `exit` <br> e.g., `exit`





