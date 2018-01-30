package example.codeclan.com.todolist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import example.codeclan.com.todolist.Models.Task;
import example.codeclan.com.todolist.R;

public class EditTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_task_activity);

        Intent intent = getIntent();

        EditText edit_task_name = findViewById(R.id.edit_name);
        EditText edit_task_description = findViewById(R.id.edit_description);
        CheckBox edit_task_priority = findViewById(R.id.edit_priority);


        Task currentTask = (Task) intent.getSerializableExtra("edit_task");

        edit_task_name.setText(currentTask.getName());
        edit_task_description.setText(currentTask.getDescription());
        edit_task_priority.setChecked(currentTask.isComplete());

    }

    public void onSaveTask(View view){
        Log.d("onSaveTask", "on save task" );
    }

//    new methods required:
//    todo onSaveTask
//    todo onDeleteTask
//    todo onArchiveTask

}
