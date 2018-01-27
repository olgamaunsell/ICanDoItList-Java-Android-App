package example.codeclan.com.todolist;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.todolist.Enums.RagStatus;
import example.codeclan.com.todolist.Models.Task;
import example.codeclan.com.todolist.Models.TaskList;

import static org.junit.Assert.assertEquals;

/**
 * Created by admin on 27/01/2018.
 */

public class TaskListTest {

    TaskList taskList;
    Task task1;
    Task task2;

    @Before

    public void before(){
        taskList = new TaskList();
        task1 = new Task("Food Shop", "Milk, Bread, Eggs", true, RagStatus.RED);
        task2 = new Task("Holiday", "Destinations, check flights, check hotels", false, RagStatus.RED);
    }

    @Test
    public void taskListStartsEmpty() {
        assertEquals(0, taskList.getList().size());
    }

    @Test
    public void canAddTaskToTaskList () {
        taskList.addTask(task1);
        assertEquals(1, taskList.getList().size());
    }

    @Test
    public void canRemoveTaskFromTaskList () {
        taskList.addTask(task1);
        taskList.addTask(task2);
        int getSizeBefore = taskList.getList().size();

        taskList.removeTask(task1);
        assertEquals(getSizeBefore-1, taskList.getList().size());
    }
}
