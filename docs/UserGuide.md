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
   * **`create`**`create meeting 1/1/2088 1200 1230`
     creates an event named `meeting` to the task manager.
   * **`delete`**` 3` : deletes the 3rd task shown in the current list
   * **`exit`** : exits the app
6. Refer to the [Features](#features) section below for details of each command.<br>


## 2. Features

> **Command Format**
>
> * Words in `UPPER_CASE` are the parameters.
> * Items in `SQUARE_BRACKETS` are optional.
> * Items with `...` after them can have multiple instances.

### 2.1. Viewing help : `help`

Format: `help`

> Help is also shown if you enter an incorrect command e.g. `abcd`

### 2.2. Creating a task: `create`

Create a task which can be an event, a deadline or a floating task<br>
Event format: `create TASK_NAME DATE START_TIME END_TIME`<br>
Deadline format: `create TASK_NAME DATE DUE_TIME`<br>
Floating task format: `create TASK_NAME`

### 2.3. Listing tasks : `list`
Create a task which can be an event, a deadline or a floating task<br>

Shows a list of tasks which can include all tasks or only events or only deadlines or only floating tasks.<br>
All tasks format: `list all`<br>
Event format: `list events`<br>
Deadline format: `list deadlines`<br>
Floating task format: `list floating tasks`<br>

### 2.4. Updating a task : `update`

Updates an existing task in the task manager.<br>
Event format: `update TASK_NAME NEW_NAME NEW_DATE NEW_START_TIME NEW_END_TIME`
Deadline format: `update TASK_NAME NEW_DATE NEW_NAME NEW_DUE_TIME`
Floating task format: `update TASK_NAME NEW_NAME`

### 2.5. Searching for all tasks containing any keyword/date or by location: `search`

Searches for the tasks containing the input keyword/date/location.<br>
Format: `search KEYWORD/DATE/LOCATION`

> * The search is case sensitive. e.g `meeting` will not match `Meeting`
> * The order of the keywords does not matter. e.g. `team meeting` will match `meeting team`
> * Only full words will be matched e.g. `meeting` will not match `meetings`
> * Tasks matching at least one keyword will be returned (i.e. `OR` search).
    e.g. `Meeting` will match `Company Meeting`

Examples:

* `search meeting`<br>
  Returns `company meeting` but not `date with girlfriend`

### 2.6. Deleting a task : `delete`

Deletes a specified task.<br>
Format: `delete INDEX`

### 2.7. Clearing all tasks : `clear`

Clears all tasks entered.<br>
Format: `clear`

### 2.8. Exiting the program : `exit`

Exits the program.<br>
Format: `exit`

### 2.9. Saving the data

Task manager data are saved in the hard disk automatically after any command that changes the data.<br>
There is no need to save manually.

## 3. FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with
       the file that contains the data of your previous task manager folder.

## 4. Command Summary

* **Create an event** : `create TASK_NAME DATE START_TIME END_TIME` <br>
  e.g. `create meeting 1/1/2088 1200 1230`

* **Create a deadline** : `create TASK_NAME DATE DUE_TIME` <br>
  e.g. `create homework 1/1/2088 1200`

* **Create a floating task** : `create TASK_NAME` <br>
  e.g. `create stay healthy`

* **Clear** : `clear`

* **Delete** : `delete INDEX` <br>
   e.g. `delete 1`

* **Search** : `search KEYWORD/DATE/LOCATION ` <br>
  e.g. `find meeting` `find NUS` `find 1/1/2088`

* **List** : `list` <br>
  e.g.

* **Help** : `help` <br>
  e.g.

