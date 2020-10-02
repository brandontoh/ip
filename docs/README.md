# User Guide

## Features 

### Duke manages your tasks

You can add, delete, complete or find any tasks in your list.

Duke supports three types of task: Todo, Deadline and Event

### Duke loads and saves your tasks
Duke automatically saves your current task list and loads it the next time you enter the program.

You would not lose you tasks when you exit the program

## Start program

Navigate to the directory storing ip.jar and enter this command:

    java -jar ip.jar
    
Expected outcome:

    ____________________________________________________________
     ____        _        
    |  _ \ _   _| | _____ 
    | | | | | | | |/ / _ \
    | |_| | |_| |   <  __/
    |____/ \__,_|_|\_\___|
    
    Hello! I'm Duke ☺
    What can I do for you?
    ____________________________________________________________
    Please enter a task:
    
If ? appears instead of ☺, exit the program by entering `bye` and follow these steps:
1. Change font in terminal to NSimSun
2. Enter this command in terminal: `chcp 65001`
3. Run the program again with this command: `java -Dfile.encoding=utf-8 -jar ip.jar`


## Usage

### To add a todo task to the list: **`todo`**
Adds a todo task with description

`todo` followed by `<description>`

Example usage:

    todo Physics Homework
    
Expected outcome:

    Got it. I've added this task:
    1. [T][✗] Physics Homework
    Now you have 1 tasks in the list.
    ____________________________________________________________
    Please enter a task:
    
### To add a deadline task to the list: **`deadline`**
Adds a deadline task with description, and a due date in the format

`deadline` followed by `<description>` then delimiter `/ by` and due date `YYYY-MM-DD`

Example usage:

    deadline Math Tutorial / by 2020-09-28
    
Expected outcome: 

    Got it. I've added this task:
    2. [D][✗] Math Tutorial (by: Sep 28 2020)
    Now you have 2 tasks in the list.
    ____________________________________________________________
    Please enter a task:

### To add an event task to the list: **`event`**
Adds an event task with description and date of event

`event` followed by `<description>` then delimiter `/ at` and date of event `YYYY-MM-DD`

Example usage:

    event Math Workshop / at 2020-08-12
    
Expected outcome:

    Got it. I've added this task:
    3. [E][✗] Math Workshop (at: Aug 12 2020)
    Now you have 3 tasks in the list.
    ____________________________________________________________
    Please enter a task:

### To list out all tasks containing a keyword: **`find`**
List out all tasks that matches the keyword entered

`find` followed by `<keyword>`

Example usage:

    find Math
    
Expected outcome:

    Here are the matching tasks in your list:
    2. [D][✗] Math Tutorial (by: Sep 28 2020)
    3. [E][✗] Math Workshop (at: Aug 12 2020)
    ____________________________________________________________
    Please enter a task:

### To list all tasks:**`list`**
Lists all tasks currently in task

Example usage:

    list
    
Expected outcome:

    Here are the tasks in your list
    1. [T][✗] Physics Homework
    2. [D][✗] Math Tutorial (by: Sep 28 2020)
    3. [E][✗] Math Workshop (at: Aug 12 2020)
    ____________________________________________________________
    Please enter a task:

### To delete a task from the list: **`delete`**
Deletes a task from the list

`delete` followed by `<index>`

Example usage:

    delete 2
    
Expected outcome:

    Noted. I've removed this task: 
    2. [D][✗] Math Tutorial (by: Sep 28 2020)
    Now you have 2 tasks in the list.
    ____________________________________________________________
    Please enter a task:
    
### To mark a task in the list as completed: **`done`**
Marks a task as completed by changing the status icon

`done` followed by `<index>`

Example usage:

    done 1
    
Expected outcome:

    Nice! I've marked this task as done:
    [T][✓] Physics Homework
    ____________________________________________________________
    Please enter a task:

### To exit Duke program: **`bye`**
Exits the program

Example usage:

    bye

Expected outcome:

    Bye. Hope to see you again soon!
    
    Process finished with exit code 0
