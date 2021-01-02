package pens.lab.app.todolistmvp.modul.succes_edit_task;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import pens.lab.app.todolistmvp.R;
import pens.lab.app.todolistmvp.base.BaseFragment;
import pens.lab.app.todolistmvp.modul.dashboard.DashboardActivity;
import pens.lab.app.todolistmvp.modul.sign_up.SignUpActivity;

public class SuccesEditTaskFragment extends BaseFragment<SuccesEditTaskActivity, SuccesEditTaskContract.Presenter> implements SuccesEditTaskContract.View {

    Button btnLogin;

    public SuccesEditTaskFragment() {
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_edit_task, container, false);
        mPresenter = new pens.lab.app.todolistmvp.modul.succes_edit_task.SuccesEditTaskPresenter(this);
        mPresenter.start();

        btnLogin = fragmentView.findViewById(R.id.dashboard);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLoginClick();
            }
        });

        setTitle("SUCCES EDIT TASK");
        return fragmentView;
    }

    public void setBtLoginClick(){
        mPresenter.performDashboard();
    }

    @Override
    public void setPresenter(SuccesEditTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToProfile() {
        Intent intent = new Intent(activity, SignUpActivity.class);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void redirectToDashboard() {
        Intent intent = new Intent(activity, DashboardActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
