package example.codeclan.com.todolist.Activities;

import android.content.Context;
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

        Task newTask = new Task("", "", false);

        newTask.setName(add_task_name.getText().toString());
        newTask.setDescription(add_task_description.getText().toString());
        newTask.setPriority(add_task_priority.isChecked());


        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE );
//        JSON STRING

        String currentlySavedTasks = sharedPref.getString("AllTasks", new ArrayList<Task>().toString());
        Log.d("All tasks", currentlySavedTasks);

//        gson setup

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayListToken = new TypeToken<ArrayList<Task>>(){};

//        USING the JSON string to put into GSON ARRAYLIST
        ArrayList<Task> currentTasks = gson.fromJson(currentlySavedTasks, taskArrayListToken.getType());

        currentTasks.add(newTask);

//        LINES BELOW ARE RESPONSIBLE FOR SAVING THE DATA TO THE JSON STRING
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("AllTasks", gson.toJson(currentTasks));
        editor.apply();

        Toast.makeText(this,newTask.getName() + " is added !",  Toast.LENGTH_LONG).show();

        finish();
    }

}
