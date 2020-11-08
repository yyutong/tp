---
layout: page
title: XIE YAOREN's Project Portfolio Page
---

## Project: Unisave
Unisave is a desktop finance planner app, optimized for use via a Command Line Interface (CLI) while still having
the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

* **Code Contributed**: [[RepoSense Link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=BILLXYR&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=BILLXYR&tabRepo=AY2021S1-CS2103T-W10-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=test-code)]
* **New Features Added**:
    * New Features 1: Added addExpense Command (Pull requests: ([[#72](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/72)]) ([[#52](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/52)])  [[#233](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/233)])
       * What it does: It allows users to add an expense to the current expense book.  
       * Justification:
            * It has a very user-friendly command as it allows user to quickly recording their expenses.
            * With the optional `Date` and `Description` field, it saves a lot of hassles for users.
            * When user do not indicate a specific date of the expenses, it will automatically set to today which make it very convenient for users.
            * Moreover, if the users want to record an expense that happened yesterday, he can simply type in 1 to record that.
       * Highlight: 
            * This feature required an in-depth analysis of design alternatives.
            * The implementation is challenging as it involves a deep understanding various java concepts, such as Optional.
            * This is one of the indispensable and fundamental features as it affects existing commands and commands to be added in the future.
    
    * New Features 2: Added delete Command (Pull requests: [[#78](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/78)])
       * What it does: It allows users to delete an expense that they do not want in the expense book.
       * Justification:
            * This feature improves the product significantly because it allows users to delete a wrongly added expenses or expenses that they do not want.
            * Without this feature, users may find himself overwhelmed with unwanted expenses.
            * This is one of the indispensable and fundamental features.
       * Highlight:
            * This feature required an in-depth analysis of design alternatives.
            * The implementation is challenging as it required changes to existing commands.
            * This is one of the indispensable and fundamental features as it affects existing commands and commands to be added in the future.
       * Credits: This feature was built from the "delete contact" feature in AddressBook Level 3.     
       
    * New Features 3: Added Help Command (Pull requests: ([[#105](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/105)])   [[#246](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/246)])
       * What it does: It allows users to search for a quick summary of the command while they are using it.
       * Justification: 
            * I added in a clear structured table for users to refer.
            * There is also link to complete user guide and if users want to see the complete description of the command, they can copy the link and search them on the browser.
            * This feature improves the product and increase the user experience significantly because it allows users to have a quick view of the command if they forget certain command.
       * Highlight:
            * This feature required an in-depth analysis of design alternatives.
            * This feature requires a significant effort as it requires constant updates of new commands as well as changes to existing command.
       * Credits: This feature was built from the "help" feature in AddressBook Level 3.
       
    * New Features 4: Added Edit Command (Pull requests: [[#233](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/233)])
       * What it does: It allows users to edit an existing expense.
       * Justification: 
            * This feature allows users to modify their current expenses, such as amount, date or description.
            * This feature improves the product and increase the user experience significantly as it allows users to make amendment to current expenses without the need to delete and re-add them.            
            * This saves a lot of effort for users and improves the experiences as it allows users to add first, edit later.
       * Highlight:
            * This feature required an in-depth analysis of design alternatives.
            * This feature requires a significant effort as I need to handle different scenarios, such as added invalid value or invalid followed by valid values.
       * Credits: This feature was built from the "edit" feature in AddressBook Level 3.
       
    * New Features 5: Added showStatistic Command (Pull requests: ([[#126](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/126)])  ([[#147](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/147)])  [[#181](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/181)])
       * What it does: It allows users to have a brief overview of their expense.
       * Justification:
            * This feature includes various information,such as total expenses, percentage of expenses per category
            * The information is sorted in decreasing amount and percentage order which allows users to have a better feel on which areas that up the most.
            * This feature improves the product and increase the user experience significantly as it gives users a better sense of their spending which can help them make better spending decision.
       * Highlight: 
            * This feature required an in-depth analysis of design alternatives.
            * This feature requires a significant effort as it requires a deep understanding of the model and need to extract the valuable and important information stored
            * Moreover, this features also sorted the information collected which provides a better overview for the users.
       

* **Enhancements implemented**:
    * Functional Code:
       * table for show statistic: (Pull requests:  [[#179](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/179)])
           * I summarized all these into a table for users to have a clear overview of their expenses
       * table for help function: (Pull requests: [[#224](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/224)])
           * I restructure the help function to pop up a window that show the tabular summary of the commands.
    * Documentation:
       * User Guide: (Pull requests: [[#150](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/150)])
           * Previously, there is no navigation link for user to navigation through the guide which make it hard for them to refer
           * I incorporated almost all the navigation link to make it easier for users to jump to the section they want to refer
    * Test Code:
       * Wrote additional tests for existing features to increase coverage by at least 5%. (Pull requests: ([[#106](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/106)]) ([[#119](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/119)])  ([[#155](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/155)])   ([[#235](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/235)]))

* **Documentation**:
    * User Guide:
       * Incorporated almost all the navigation link (Pull requests: [[#150](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/150)])
       * Created and maintained the command summary table (Pull requests: [[#246](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/246)])
       * Added documentation for the features `Add Expense`, `Delete`, `Edit`, `Help`, `showstatistic` (Pull requests: ([[#233](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/233)]) ([[#150](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/150)])) 
       
    * Developer Guide:
       * Added implementation details of the `delete` feature (Pull requests: [[#115](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/115)])
       * Added UML diagram for `Delete` feature (Pull requests: [[#115](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/115)])
       * Added use cases for `Add Expense` and `Delete` feature (Pull requests: [[#27](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/27)])
       
* **Contribution to team base tasks**:
   * Updating user/developer docs that are not specific to a feature:
       * Modified the user guide's bugs identified during the PE-dry run such as the typos and confusing features.  (Pull requests: ([[#153](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/153)])  ([[#225](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/225)])  [[#233](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/233)]) 
   * Others:
       * Modified all the CI passing error and checkstyle error in the initial project stage when we transform from addressBook to expenseBook (Pull requests: ([[#90](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/90)])   [[#93](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/93)])
       * Added the missing JavaDoc (Pull requests: [[#170](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/170)]    [[#171](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/171)])
       
* **Review/mentoring contributions**:
   * Help to review and approve the pull requests. (Pull requests: ([[#237](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/237)])  ([[#232](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/232)])   ([[#227](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/227)])  ([[#178](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/178)])  ([[#175](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/175)])   ([[#159](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/159)])   ([[#157](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/157)]))
  
* **Contributions beyond the project team**:
   * Evidence of helping others:
       * Report the bugs i find during PE-dry run ([[Issues](https://github.com/BILLXYR/ped/issues)])
       * Response posted in the forum, such as helping people to debug when he encountered problems when generating the jar ([[Link](https://github.com/nus-cs2103-AY2021S1/forum/issues/221#issuecomment-692491274)])
   * Evidence of technical leadership:
       * Sharing of `Some tips on generating the jar` in forum. ([[Link](https://github.com/nus-cs2103-AY2021S1/forum/issues/225)])

 
