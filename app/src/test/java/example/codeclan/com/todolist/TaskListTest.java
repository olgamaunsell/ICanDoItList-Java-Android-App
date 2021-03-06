package example.codeclan.com.todolist;

import org.junit.Before;
import org.junit.Test;

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
    Task task3;

    @Before

    public void before(){
        taskList = new TaskList();

        task1 = new Task("Holiday", "Destinations, check flights, check hotels", false);
        task3 = new Task("Project", "Planning, code, test", true);
        task3 = new Task("Food Shop", "Milk, Bread, Eggs", true);
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

    @Test

    public void canUpdateTask(){
        taskList.addTask(task1);
        task1.setDescription("Milk, Bread, Eggs, Beer");

        assertEquals("Milk, Bread, Eggs, Beer", taskList.getList().get(taskList.getTaskIndex(task1)).getDescription());

    }


    @Test

    public void canGetOutstandingTasks(){
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        taskList.getList().get(taskList.getTaskIndex(task3)).setComplete(true);

        TaskList outstandingTasks = taskList.outstandingTasks();
        assertEquals(2, outstandingTasks.getList().size() );

    }

    @Test

    public void canGetOutstandingPriorityTasks(){
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        taskList.getList().get(taskList.getTaskIndex(task3)).setComplete(true);

        TaskList priorityTasks = taskList.outstandingPriorityTasks();
        assertEquals(1, priorityTasks.getList().size() );

    }

    @Test

    public void canGetCompletedTasks(){
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        taskList.getList().get(taskList.getTaskIndex(task1)).setComplete(true);
        taskList.getList().get(taskList.getTaskIndex(task2)).setComplete(true);

        TaskList completedTasks = taskList.completedTasks();
        assertEquals(2, completedTasks.getList().size() );

    }

    @Test

    public void canSortTasksByNameAsc(){
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        taskList.sortByTaskNameAsc();


    }

//    @Test
//
//    public void canGetArchivedTasks(){
//        taskList.addTask(task1);
//        taskList.addTask(task2);
//        taskList.addTask(task3);
//
//        taskList.getList().get(taskList.getTaskIndex(task1)).setComplete(true);
//        taskList.getList().get(taskList.getTaskIndex(task3)).setComplete(true);
//        taskList.getList().get(taskList.getTaskIndex(task3)).setArchived(true);
//
//        TaskList archivedTasks = taskList.archivedTasks();
//        assertEquals(1, archivedTasks.getList().size() );
//
//    }
}
