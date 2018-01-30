package example.codeclan.com.todolist;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.todolist.Models.Task;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Olga Maunsell on 27/01/2018.
 */

public class TaskTest {

    Task task;

    @Before

    public void before(){

        task = new Task("Food Shop", "Milk, Bread, Eggs", true);

    }

    @Test

    public void canGetName(){
        assertEquals("Food Shop",task.getName() );
    }


    @Test

    public void canGetDescription(){
        assertEquals("Milk, Bread, Eggs",task.getDescription() );
    }

    @Test

    public void isTaskPriority(){
        assertEquals(true, task.isPriority() );
    }

//    @Test
//
//    public void canGetRagStatus(){
//        assertEquals(RagStatus.RED, task.getRagStatus() );
//    }

    @Test

    public void canSetName(){
        task.setName("Food Shop Tesco");
        assertEquals("Food Shop Tesco", task.getName());
    }

    @Test

    public void canSetDescription(){
        task.setDescription("Milk, Bread, Eggs, Beer");
        assertEquals("Milk, Bread, Eggs, Beer", task.getDescription());
    }

//    @Test
//
//    public void canSetRagStatus(){
//        task.setRagStatus(RagStatus.AMBER);
//        assertEquals(RagStatus.AMBER, task.getRagStatus());
//    }

    @Test

    public void canSetPriority(){
        task.setPriority(false);
        assertEquals(false, task.isPriority());
    }

    @Test

    public void canSetComplete(){
        task.setComplete(true);
        assertEquals(true, task.isComplete());
    }

    @Test

    public void canSetArchived(){
        task.setArchived(true);
        assertEquals(true, task.isArchived());
    }


}
