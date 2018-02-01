package example.codeclan.com.todolist.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import example.codeclan.com.todolist.Models.Task;
import example.codeclan.com.todolist.R;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task_activity);
    }

    public void onAddTask(View view) {

        EditText add_task_name = findViewById(R.id.add_task_name);
        EditText add_task_description = findViewById(R.id.add_task_description);
        CheckBox add_task_priority = findViewById(R.id.add_task_priority);


        String taskName = add_task_name.getText().toString();

        if (taskName.isEmpty()) {

            Toast.makeText(this, "Task name must be entered", Toast.LENGTH_LONG).show();
            return;
        }

        String description = add_task_description.getText().toString();
        Boolean priority = add_task_priority.isChecked();

        Task newTask = new Task(taskName, description, priority);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE );

        String currentlySavedTasks = sharedPref.getString("AllTasks", new ArrayList<Task>().toString());
        Log.d("All tasks", currentlySavedTasks);

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayListToken = new TypeToken<ArrayList<Task>>(){};

        ArrayList<Task> currentTasks = gson.fromJson(currentlySavedTasks, taskArrayListToken.getType());

        currentTasks.add(newTask);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("AllTasks", gson.toJson(currentTasks));
        editor.apply();

        Toast.makeText(this,newTask.getName() + " is added !",  Toast.LENGTH_LONG).show();

    //  Go back to TaskList
        Intent refresh = new Intent(this, TaskListActivity.class);
        startActivity(refresh);
    }

}
