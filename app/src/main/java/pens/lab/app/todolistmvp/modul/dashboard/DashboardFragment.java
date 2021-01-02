package pens.lab.app.todolistmvp.modul.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pens.lab.app.todolistmvp.R;
import pens.lab.app.todolistmvp.base.BaseFragment;
import pens.lab.app.todolistmvp.data.model.Task;
import pens.lab.app.todolistmvp.data.source.local.TaskTableHandler;
import pens.lab.app.todolistmvp.data.source.session.TaskSessionRepository;
import pens.lab.app.todolistmvp.modul.edit_task.EditTaskActivity;
import pens.lab.app.todolistmvp.modul.add_task.AddTaskActivity;
import pens.lab.app.todolistmvp.utils.RecyclerViewAdapterTodolist;

public class DashboardFragment extends BaseFragment<DashboardActivity, DashboardContract.Presenter> implements DashboardContract.View {
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public DashboardFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mPresenter = new DashboardPresenter(this, new TaskSessionRepository(getActivity()), new TaskTableHandler(getActivity()));
        mPresenter.start();

        mRecyclerView = fragmentView.findViewById(R.id.recyclerViewTodolist);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        final ArrayList<Task> data = mPresenter.getDataSet();
        mAdapter = new RecyclerViewAdapterTodolist(data);
        mRecyclerView.setAdapter(mAdapter);
        setTitle("DASHBOARD");

        ImageView imgAdd = (ImageView) fragmentView.findViewById(R.id.add_task2);
        imgAdd.setClickable(true);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoNewTask();
            }
        });

        ((RecyclerViewAdapterTodolist) mAdapter).setOnItemClickListener(new RecyclerViewAdapterTodolist.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                String id = data.get(position).getId();
                editTask(id);
            }
        });
        return fragmentView;
    }

    @Override
    public void setPresenter(DashboardContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void gotoNewTask() {
        Intent intent = new Intent(activity, AddTaskActivity.class);
        startActivity(intent);
    }

    public void editTask(String id) {
        Intent intent = new Intent(activity, EditTaskActivity.class);
        intent.putExtra("TaskId", id);
        startActivity(intent);
    }
}
