package example.codeclan.com.todolist.Models;

import java.util.ArrayList;

/**
 * Created by Olga Maunsell on 27/01/2018.
 */

public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<Task>();
//  todo    will remove 2 lines below later, just to view screen with populated tasks
        taskList.add(new Task("Food Shop", "Milk, Bread, Eggs", true));
        taskList.add(new Task("Holiday", "Destinations, check flights, check hotels", false));
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
