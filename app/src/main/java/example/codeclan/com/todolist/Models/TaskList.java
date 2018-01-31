package example.codeclan.com.todolist.Models;

import java.util.ArrayList;

/**
 * Created by Olga Maunsell on 27/01/2018.
 */

public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> preExistingList) {
        taskList = preExistingList;
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

    public int getIndex(Task task) {
        return taskList.indexOf(task);
    }

//    public void updateTask(Task task){
//
//        int index = getIndex(Task task);
//        taskList.set(index, task);
//    }

}
