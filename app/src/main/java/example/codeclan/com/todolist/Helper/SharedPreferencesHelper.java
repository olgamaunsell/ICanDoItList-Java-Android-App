package example.codeclan.com.todolist.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import example.codeclan.com.todolist.R;

/**
 * Created by Olga Maunsell on 30/01/2018.
 */

public class SharedPreferencesHelper extends AppCompatActivity {
// todo - question - should this class extend AppCompatActivity ?
    public SharedPreferencesHelper(){}

    public void getSharedPreferences(){
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE );
    }


}
