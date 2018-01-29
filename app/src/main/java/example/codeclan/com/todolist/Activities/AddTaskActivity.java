package example.codeclan.com.todolist.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

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

        Task task = new Task("", "", false);

        task.setName(add_task_name.getText().toString());
        task.setDescription(add_task_description.getText().toString());
        task.setPriority(add_task_priority.isChecked());

        finish();
    }

}
