# Task Manager - User Guide

By : `Team POTATO`  &nbsp;&nbsp;&nbsp;&nbsp; Since: `Mar 2017`  &nbsp;&nbsp;&nbsp;&nbsp; Licence: `MIT`

---

1. [Quick Start](#quick-start)
2. [Features](#features)
3. [FAQ](#faq)
4. [Command Summary](#command-summary)

## 1. Quick Start

0. Ensure you have Java version `1.8.0_60` or later installed in your Computer.<br>

   > Having any Java 8 version is not enough. <br>
   > This app will not work with earlier versions of Java 8.

1. Download the latest `pota-todo.jar` from the [releases](../../../releases) tab.
2. Copy the file to the folder you want to use as the home folder for your task manager.
3. Double-click the file to start the app. The GUI should appear in a few seconds.
   > <img src="images/Ui.png" width="600">

4. Type the command in the command box and press <kbd>Enter</kbd> to execute it. <br>
   e.g. typing **`help`** and pressing <kbd>Enter</kbd> will open the help window.
5. Some example commands you can try:
   * **`list all`** : lists all tasks
   * **`add`**`add meeting 1/1/2088 1200 1/1/2088 1230`
     creates an event named `meeting` to the task manager.
   * **`delete`**` 3` : deletes the 3rd task shown in the current list
   * **`exit`** : exits the app
6. Refer to the [Features](#features) section below for details of each command.<br>


## 2. Features

> **Command Format**
>
> * Words in `UPPER_CASE` are the parameters.
> * Items in `SQUARE_BRACKETS` are optional.

### 2.1. Viewing help : `help`

Format: `help`

> Help is also shown if you enter an incorrect command e.g. `abcd`

### 2.2. Creating a task: `add`

Add a task which can be an event, a deadline or a floating task<br>

The date expression can be in standard language. For example, formal dates -> 02/28/1979, relaxed dates -> oct 1st, relative dates -> the day before next thursday, and even date alternatives -> next wed or thurs.

Event format: `add <TASK_NAME> [DATE_START_TIME] [DATE_END_TIME]`<br>
Example: <br>
  ->  add event 01/01/2088 1200 01/01/2088 1230   <br> 
    This will add an event named 'event' with [start date and time] in format dd/mm/yyyy 2400  and [end date and time] in format dd/mm/yyyy 2400. <br>
              
              
Deadline format: `add <TASK_NAME> [DATE_DUE_TIME]`<br>
Example: <br>
    ->  add deadline 01/01/2088 1200  <br>
    This will add a deadline named 'deadline' with [date due and time] in format dd/mm/yyyy 2400. <br>
               
               
Floating task format: `add <TASK_NAME>` <br>
Example: <br>
     -> add floating_task <br>
     This command will simply add a floating task named 'floating_task'. <br>
     

### 2.3. Listing tasks : `list`

Shows a list of tasks which can include all tasks or only events or only deadlines or only floating tasks. The tasks can be further shortlisted based on the date of the tasks. An example is given below for further clarification. <br>
Format: 'list < all / floating / events / deadline > [DATE]'  <br>
Example: <br>
   -> list all  <br>
   This command will simply list all the tasks. <br>
   -> list deadline Feb 28 <br>
   This command will list the deadline tasks which have the deadline as 28th February. <br>
   -> list event
   This command will list all the event tasks (with no restriction on the dates of the tasks). <br>

### 2.4. Updating a task : `edit`

Updates an existing task in the task manager.<br>
Event format: `edit  <index> [NEW_TASK_NAME] [NEW_DATE_NEW_START_TIME] [NEW_DATE_NEW_END_TIME]` <br>
Example: <br>
    -> edit 3 new_event 01/01/2088 1200 01/01/2088 1230
    <br>
    This command will edit the task at index number 3 with new name, new start date and time, new end date and time. <br>
    
            
Deadline format: `edit <index> [NEW_TASK_NAME] [NEW_DATE_NEW_DUE_TIME]` <br>
Example: <br>
      -> edit 4 new_deadline 01/01/2088 1200
      <br>
      This command will edit the task at index number 4 with new name, new deadline date and time. <br>
               
Floating task format: `edit <index> [NEW_TASK_NAME]` <br>
Example: <br>
       -> edit 5 new_floating_task 
       <br>
       This command will simply edit the task at index number 5 with new name. <br>

### 2.5. Searching for all tasks containing a name : `find`

Searches for the tasks containing the input name. An example ha been given below for further clarification. <br>
Format: `find <NAME>` <br>
Example: <br>     -> find event 
     <br>
     This command will simply return the tasks with the name 'event' in them.
     

> * The search is case sensitive. e.g `meeting` will not match `Meeting`
> * The order of the keywords does not matter. e.g. `team meeting` will match `meeting team`
> * Only full words will be matched e.g. `meeting` will not match `meetings`
> * Tasks matching at least one keyword will be returned (i.e. `OR` search).
    e.g. `Meeting` will match `Company Meeting`

Example: <br>
       -> find meeting
       <br>
       This command will return `company meeting` but not `date with girlfriend` <br>

### 2.6. Deleting a task : `delete`

Deletes a specified task.<br>
Format: `delete <INDEX>` <br>
Example: <br>
       -> delete 2   <br>
       This command will simply delete the task at index number 2.


### 2.7. Exiting the program : `exit`

Exits the program.<br>
Format: `exit` <br>

### 2.8. Saving the data
Task manager data are saved in the hard disk automatically after any command that changes the data.<br>
There is no need to save manually.

## 3. FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with
       the file that contains the data of your previous task manager folder.

## 4. Command Summary

* **Create an event** : `add <TASK_NAME> [DATE_START_TIME] [DATE_END_TIME]` <br>
  e.g. `add event 1/1/2088 1200 1/1/2088 1230`
 
* **Create a deadline** : `add <TASK_NAME> [DATE_DUE_TIME]` <br>
  e.g. `add homework 1/1/2088 1200`
  
* **Create a floating task** : `add <TASK_NAME>` <br>
  e.g. `add stay_healthy`
  
* **Edit Event format** : `edit  <index> [NEW_TASK_NAME] [NEW_DATE_NEW_START_TIME] [NEW_DATE_NEW_END_TIME]` <br>
            e.g. edit 3 new_event 01/01/2088 1200 01/01/2088 1230
            
* **Edit Deadline format** : `edit <index> [NEW_TASK_NAME] [NEW_DATE_NEW_DUE_TIME]` <br>
               e.g. edit 4 new_deadline 01/01/2088 1200
               
* **Edit Floating task format** : `edit <index> [NEW_TASK_NAME]` <br>
                   e.g. edit 5 new_floating_task
                   
* **Delete** : `delete <INDEX>` <br>
   e.g. `delete 1`

* **Search** : `find <NAME> ` <br>
  e.g. `find meeting` `find NUS` 

* **List** : `list` <br>
  e.g. list all

* **Help** : `help` <br>
  e.g. help

* **Exit** : 'exit' <br>
   e.g. exit
