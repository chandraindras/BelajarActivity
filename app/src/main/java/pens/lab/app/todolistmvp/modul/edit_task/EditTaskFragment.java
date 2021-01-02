package pens.lab.app.todolistmvp.modul.edit_task;

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
import pens.lab.app.todolistmvp.data.model.Task;
import pens.lab.app.todolistmvp.data.source.local.TaskTableHandler;
import pens.lab.app.todolistmvp.modul.dashboard.DashboardActivity;
import pens.lab.app.todolistmvp.modul.succes_edit_task.SuccesEditTaskFragment;

public class EditTaskFragment extends BaseFragment<EditTaskActivity, EditTaskContract.Presenter> implements EditTaskContract.View {

    EditText etTaskTitle;
    EditText etTaskDescription;
    Button btnSave;
    Button btnDelete;
    String id;

    public EditTaskFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_edit_task, container, false);
        mPresenter = new EditTaskPresenter(this, new TaskTableHandler(getActivity()));
        mPresenter.start();

        etTaskTitle = fragmentView.findViewById(R.id.edit_title);
        etTaskDescription = fragmentView.findViewById(R.id.edit_des);
        btnSave = fragmentView.findViewById(R.id.save_edit);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtSaveClick();
            }
        });

        etTaskTitle = fragmentView.findViewById(R.id.edit_title);
        etTaskDescription = fragmentView.findViewById(R.id.edit_des);
        btnDelete = fragmentView.findViewById(R.id.delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtDeleteClick();
            }
        });

        setTitle("EDIT TASK");
        mPresenter.loadData(this.id);
        return fragmentView;
    }

    public void setBtSaveClick(){
        String title = etTaskTitle.getText().toString();
        String description = etTaskDescription.getText().toString();
        mPresenter.saveData(title,description);
    }

    public void setBtDeleteClick(){
        mPresenter.deleteData();
    }

    @Override
    public void setPresenter(EditTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToSuccesEdit() {
        Intent intent = new Intent(activity, DashboardActivity.class);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void showData(Task task) {
        this.etTaskTitle.setText(task.getTitle());
        this.etTaskDescription.setText(task.getDescription());
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }
}
