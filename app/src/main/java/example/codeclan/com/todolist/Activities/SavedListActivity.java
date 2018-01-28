package example.codeclan.com.todolist.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import example.codeclan.com.todolist.Models.Task;
import example.codeclan.com.todolist.R;

public class SavedListActivity extends AppCompatActivity {

    TextView savedTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_list_activity);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE );
//        JSON STRING

        String savedTasks = sharedPref.getString("AllTasks", new ArrayList<Movie>().toString());
        Log.d("All tasks", savedTasks);

//        gson setup

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayListToken = new TypeToken<ArrayList<Task>>(){};

//        USING the JSON string to put into GSON ARRAYLIST
        ArrayList<Task> AllTasks = gson.fromJson(savedTasks, taskArrayListToken.getType());


        Intent intent = getIntent();
        Task selectedTask = (Task) intent.getSerializableExtra("task");

        AllTasks.add(selectedTask);

// STYLING TO OUTPUT MY FAVOURITES TO THE SCREEN
        String taskString = "";
        for(Task task : AllTasks){
            taskString += task.getName() + "-" + task.getDescription() + "\n";
        }

        savedTask = findViewById(R.id.saved);
        savedTask.setText(taskString);

//        LINES BELOW ARE RESPONSIBLE FOR SAVING THE DATA TO THE JSON STRING
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("allTasks", gson.toJson(AllTasks));
        editor.apply();

        Toast.makeText(this,selectedTask.getName() + " is added !",  Toast.LENGTH_LONG).show();

    }
}
