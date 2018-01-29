package example.codeclan.com.todolist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import example.codeclan.com.todolist.Adapters.TaskListAdapter;
import example.codeclan.com.todolist.Models.Task;
import example.codeclan.com.todolist.Models.TaskList;
import example.codeclan.com.todolist.R;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list_activity);

        ArrayList<Task> taskList = new TaskList().getList();

        TaskListAdapter taskListAdapter = new TaskListAdapter(this, taskList);

        ListView listView = findViewById(R.id.task_list_view);
        listView.setAdapter(taskListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.task_list_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add_task) {
            addTask();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addTask(){
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }

    public void addTaskStart(View listItem){
        addTask();

    }

    public void getTask(View listItem){
        Task task = (Task) listItem.getTag();
        Log.d(getClass().toString(), task.getName() + " is selected");


//        Intent intent = new Intent(this, MaintainTaskActivity.class);
        Intent intent = new Intent(this, SavedListActivity.class);

        intent.putExtra("task", task);

        startActivity(intent);


    }

    public void onComplete(View listItem){
// todo    -   complete method to update "complete" boolean

        Task selectedTask = (Task) listItem.getTag();

        selectedTask.setComplete(true);
    }

}





