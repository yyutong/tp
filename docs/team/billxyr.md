---
layout: page
title: XIE YAOREN's Project Portfolio Page
---

## Project: Unisave
Unisave is a desktop finance planner app, optimized for use via a Command Line Interface (CLI) while still having
the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

* **Code Contributed**: [[RepoSense Link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=BILLXYR&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=BILLXYR&tabRepo=AY2021S1-CS2103T-W10-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=test-code)]
* **Code Contributed**:
    * Implemented the delete function which allows users to delete an unwanted expense record
    * Implemented the version 1.0 AddExpense function which allows users to add an expense
    * Modified the AddExpense function to be more user-friendly by making date and description field optional
    * Implemented the help function which generates a table of command summary for user to refer if needed
    * Implemented showStatistic function which provide an overview of user's expenses for them to refer to.
    * Implemented Edit function which allows users to edit their previous expenses information.
    
* **Enhancements implemented**:
    * Functional Code:
       * AddExpense Function:
           * Previously, our addExpense function force the users to enter at least prefix for date and description
           * I find this not user-friendly, I twist the code to make it optional for user to enter date and description
       * Edit Function:
           * Previously, we do not have an edit function for user to make amendment to their expenses
           * As a result, users have to delete and re-enter the expenses
           * I implemented the edit function to make it easier to adjust the information they entered
       * table for show statistic:
           * The showstatistic includes various information,such as total expenses, percentage of expenses per category
           * There are also sort function that sort the expenses in decreasing order to show the users which categories take up the most
           * I summarized all these into a table for users to have a clear overview of their expenses
       * table for help function:
           * Previously the help function print out the summary which is too messy for users to refer to
           * I restructure the help function to pop up a window that show the tabular summary of the commands.
    * Documentation:
       * User Guide:
           * Previously, there is no navigation link for user to navigation through the guide which make it hard for them to refer
           * I incorporated almost all the navigation link to make it easier for users to jump to the section they want to refer
    * Test Code:
       * Wrote additional tests for existing features to increase coverage 

* **Documentation**:
    * User Guide:
       * Incorporated almost all the navigation link 
       * Created and maintained the command summary table
       * Added documentation for the features `Add Expense`, `Delete`, `Edit`, `Help`, `showstatistic`
       
    * Developer Guide:
       * Added implementation details of the `delete` feature
       * Added UML diagram for `Delete` feature
       * Added use cases for `Add Expense` and `Delete` feature
       
* **Contribution to team base tasks**:
    * Necessary general code enhancements:
       * Renamed the inconsistent user command
       * Improved the help function by including a summary table that make it easier for user to refer
       * Improved the showStatistic function by including a structure table to summarize user's expenses
       * Implemented the edit function to allow user to edit their expenses.
    * Updating user/developer docs that are not specific to a feature:
       * Modified the user guide and incorporate almost all the navigation link for users to refer to
       * Modified the user guide's bugs identified during the PE-dry run such as the typos and confusing features.    
   * Others:
       * Modified all the checkstyle error in the initial project stage when we transform from addressBook to expenseBook
       * Added the missing JavaDoc
       
* **Review/mentoring contributions**:
   * Help to review and approve the pull requests. Provide suggestion in the even of CI failure or checkstyle error.
  
* **Contributions beyond the project team**:
   * Evidence of helping others:
       * Report the bugs i find during PE-dry run
       * Response posted in the forum, such as helping people to debug when he encountered problems when generating the jar
   * Evidence of technical leadership:
       * Sharing of `Some tips on generating the jar` in forum.

 
