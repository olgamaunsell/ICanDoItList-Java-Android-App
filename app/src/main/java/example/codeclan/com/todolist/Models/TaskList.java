package example.codeclan.com.todolist.Models;

import java.util.ArrayList;

/**
 * Created by Olga Maunsell on 27/01/2018.
 */

public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> preExistingList) {
        this.taskList = preExistingList;
    }


    public ArrayList<Task> getList() {
        return new ArrayList<Task>(taskList);
    }


    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(Task task) {
        taskList.remove(task);
    }

    public int getTaskIndex(Task task) {
        return taskList.indexOf(task);
    }

//    public TaskList filterTasks(Method method){
//
//        TaskList filteredTasks = new TaskList();
//
//        for (Task task: this.taskList) {
//            if(!task.method)
//                filteredTasks.addTask(task);
//        }
//        return filteredTasks;
//    }


    public TaskList outstandingTasks() {
        TaskList outstandingTasks = new TaskList();

        for (Task task: this.taskList) {
            if(!task.isComplete())
                outstandingTasks.addTask(task);
            }
        return outstandingTasks;
        }

    public TaskList outstandingPriorityTasks() {

        TaskList priorityTasks = new TaskList();

        for (Task task: this.taskList) {
            if(task.isPriority() && !task.isComplete())
                priorityTasks.addTask(task);
        }
        return priorityTasks;
    }

    public TaskList completedTasks() {
        TaskList completedTasks = new TaskList();

        for (Task task: this.taskList) {
            if(task.isComplete())
                completedTasks.addTask(task);
        }
        return completedTasks;
    }

    public TaskList sortByTaskNameAsc() {
        TaskList sortedTasks = new TaskList();

        return sortedTasks;
    }

//    public TaskList archivedTasks() {
//        TaskList archivedTasks = new TaskList();
//
//        for (Task task: this.taskList) {
//            if(task.isArchived())
//                archivedTasks().addTask(task);
//        }
//        return archivedTasks;
//    }
}


//    public void updateTask(Task task){
//
//        int index = getIndex(Task task);
//        taskList.set(index, task);
//    }


