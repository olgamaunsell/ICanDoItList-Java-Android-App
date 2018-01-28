package example.codeclan.com.todolist.Models;

import java.util.ArrayList;

import example.codeclan.com.todolist.Enums.RagStatus;

/**
 * Created by Olga Maunsell on 27/01/2018.
 */

public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<Task>();
//  **      will remove 2 lines below later, just to view screen with populated tasks
        taskList.add(new Task("Food Shop", "Milk, Bread, Eggs", true, RagStatus.RED));
        taskList.add(new Task("Holiday", "Destinations, check flights, check hotels", false, RagStatus.RED));
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
}
