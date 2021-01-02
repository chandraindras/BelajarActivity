package pens.lab.app.todolistmvp.modul.add_task;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import pens.lab.app.todolistmvp.R;
import pens.lab.app.todolistmvp.base.BaseFragment;
import pens.lab.app.todolistmvp.data.source.local.TaskTableHandler;
import pens.lab.app.todolistmvp.data.source.session.TaskSessionRepository;
import pens.lab.app.todolistmvp.modul.dashboard.DashboardActivity;
import pens.lab.app.todolistmvp.modul.succes_add_task.SuccesAddTaskActivity;

public class AddTaskFragment extends BaseFragment<AddTaskActivity, AddTaskContract.Presenter> implements AddTaskContract.View {

    EditText etTaskTitle;
    EditText etTaskDescription;
    Button btnSave;

    public AddTaskFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_add_task, container, false);
        mPresenter = new AddTaskPresenter(this, new TaskSessionRepository(getActivity()), new TaskTableHandler(getActivity()));
        mPresenter.start();

        etTaskTitle = fragmentView.findViewById(R.id.task_title);
        etTaskDescription = fragmentView.findViewById(R.id.task_des);
        btnSave = fragmentView.findViewById(R.id.save_task);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtSaveClick();
            }
        });

        setTitle("ADD TASK");
        return fragmentView;
    }

    @Override
    public void setPresenter(AddTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToSuccesAdd() {
        Intent intent = new Intent(activity, DashboardActivity.class);
        startActivity(intent);
        activity.finish();
    }
    
    public void setBtSaveClick(){
        String title = etTaskTitle.getText().toString();
        String description = etTaskDescription.getText().toString();
        mPresenter.saveData(title,description);
    }
}
