package example.codeclan.com.todolist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import example.codeclan.com.todolist.Models.Task;
import example.codeclan.com.todolist.R;

/**
 * Created by Olga Maunsell on 27/01/2018.
 */

public class TaskListAdapter extends ArrayAdapter<Task> {

    public TaskListAdapter(Context context, ArrayList<Task> taskList) {
        super(context, 0, taskList);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, parent, false);
        }

        Task currentTask = getItem(position);
        ImageView priority = listItemView.findViewById(R.id.priority);
        if(currentTask.isPriority()) {
            priority.setVisibility(View.VISIBLE);
        }
            else {
                priority.setVisibility(View.INVISIBLE);
        }

        TextView name = listItemView.findViewById(R.id.name);
        name.setText(currentTask.getName());

        listItemView.setTag(currentTask);
        return listItemView;

    }
}