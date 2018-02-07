
## ICanDoItList

Goal: Practice what we learned in the Java / Android weeks and research how to persist data.

### MVP
You are required to write an Android app which will allow the user to maintain a task list. The user should be able to enter tasks and display them in a list. The list should only show the bare details of each task. Selecting a task from the list should bring up another screen which shows full details of the task.
Users should also be able to mark tasks as completed.

### Project Extensions

* Allow the user to prioritise tasks
* Allow the user to delete tasks - full CRUD
* Allow the user to filter tasks - outstanding, outstanding priority, completed, all tasks

### Lessons learned

* Due to the time constraints of 1 week I choose to use Shared Preferences to save the user data instead of the setup required of a database.
* I found that when filtering tasks that there were more limitations with using Shared Preferences when selecting a task to be entered. Therefore any additional changes/fixes would be catered better using a database instead.

### Future extensions
* Update to use a database instead of shared preferences
* Allow user to mark task as complete from the main list screen
* Sort task options (A-Z, Priority + A-Z)
* Allow the user to enter a rag status when adding/editing a task to show task progress (RED, AMBER, GREEN).
* Update the styling
* Create shared preferences helper class
