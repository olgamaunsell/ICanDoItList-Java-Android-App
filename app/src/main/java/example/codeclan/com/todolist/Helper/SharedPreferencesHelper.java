package example.codeclan.com.todolist.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import example.codeclan.com.todolist.Models.Task;
import example.codeclan.com.todolist.R;

/**
 * Created by Olga Maunsell on 30/01/2018.
 */

public class SharedPreferencesHelper extends AppCompatActivity {
// todo - question - should this class extend AppCompatActivity ?
    public SharedPreferencesHelper(){}

    public SharedPreferences getSharedPreferences(){
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE );
        return sharedPref;
    }

    public String getPreferenceString(){

        SharedPreferences sharedPref = getSharedPreferences();

        String currentlySavedTasks = sharedPref.getString("All tasks", new ArrayList<Task>().toString());
        Log.d("All tasks", currentlySavedTasks);

        return currentlySavedTasks;
    }

}
