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

public class EditTaskActivity extends AppCompatActivity {

//    private Task currentTask;
//    private Task updatedTaskToSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_task_activity);

        Intent intent = getIntent();

        EditText edit_task_name = findViewById(R.id.edit_name);
        EditText edit_task_description = findViewById(R.id.edit_description);
        CheckBox edit_task_priority = findViewById(R.id.edit_priority);


        int taskIndex = (int) intent.getSerializableExtra("task_index");

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE );
//        JSON STRING

        String currentlySavedTasks = sharedPref.getString("AllTasks", new ArrayList<Task>().toString());
        Log.d("All tasks", currentlySavedTasks);

//        gson setup

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayListToken = new TypeToken<ArrayList<Task>>(){};

//        USING the JSON string to put into GSON ARRAYLIST
        ArrayList<Task> allTasks = gson.fromJson(currentlySavedTasks, taskArrayListToken.getType());

        Task currentTask = allTasks.get(taskIndex);

        edit_task_name.setText(currentTask.getName());
        edit_task_description.setText(currentTask.getDescription());
        edit_task_priority.setChecked(currentTask.isPriority());

    }

    public void onSaveTask(View view){

//        String currentTaskNameString = currentTask.getName().toString();
//        String editedTaskNameString = editedTask.getName().toString();
//        Log.d("onSaveTaskBeforeEdit", currentTaskNameString );
//        Log.d("onSaveTaskOnSve", editedTaskNameString );
//
        EditText edit_task_name = findViewById(R.id.edit_name);
        EditText edit_task_description = findViewById(R.id.edit_description);
        CheckBox edit_task_priority = findViewById(R.id.edit_priority);

        String taskName = edit_task_name.getText().toString();
        String description = edit_task_description.getText().toString();
        Boolean priority = edit_task_priority.isChecked();

        Task taskToBeSaved = new Task(taskName, description, priority);

//        currentTask.setName(edit_task_name.getText().toString());
//        currentTask.setDescription(edit_task_description.toString());
//        currentTask.setPriority(edit_task_priority.isChecked());

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE );
////        JSON STRING
//
        String currentlySavedTasks = sharedPref.getString("AllTasks", new ArrayList<Task>().toString());
        Log.d("All tasks", currentlySavedTasks);

//        gson setup

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayListToken = new TypeToken<ArrayList<Task>>(){};

//        USING the JSON string to put into GSON ARRAYLIST
        ArrayList<Task> currentTasks = gson.fromJson(currentlySavedTasks, taskArrayListToken.getType());

        Intent intent = getIntent();
        int taskIndex = (int) intent.getSerializableExtra("task_index");


        currentTasks.set(taskIndex, taskToBeSaved);


//        LINES BELOW ARE RESPONSIBLE FOR SAVING THE DATA TO THE JSON STRING
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("AllTasks", gson.toJson(currentTasks));
        editor.apply();

        Toast.makeText(this,taskToBeSaved.getName() + " is updated !",  Toast.LENGTH_LONG).show();
// put a start activity here to go back to tasklistactivity
        Intent refresh = new Intent(this, TaskListActivity.class);
        startActivity(refresh);

    }

    public void onDeleteTask(View view){

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE );
////        JSON STRING
//
        String currentlySavedTasks = sharedPref.getString("AllTasks", new ArrayList<Task>().toString());
        Log.d("All tasks", currentlySavedTasks);

//        gson setup

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayListToken = new TypeToken<ArrayList<Task>>(){};

//        USING the JSON string to put into GSON ARRAYLIST
        ArrayList<Task> currentTasks = gson.fromJson(currentlySavedTasks, taskArrayListToken.getType());

        Intent intent = getIntent();
        int taskIndex = (int) intent.getSerializableExtra("task_index");
        currentTasks.remove(taskIndex);


//        LINES BELOW ARE RESPONSIBLE FOR SAVING THE DATA TO THE JSON STRING
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("AllTasks", gson.toJson(currentTasks));
        editor.apply();

        Toast.makeText(this," Task deleted !",  Toast.LENGTH_LONG).show();
// put a start activity here to go back to tasklistactivity
        Intent refresh = new Intent(this, TaskListActivity.class);
        startActivity(refresh);


    }


//    new methods required:

//    todo onArchiveTask

}
