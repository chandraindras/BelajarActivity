package pens.lab.app.todolistmvp.modul.succes_add_task;

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

public class SuccesAddTaskFragment extends BaseFragment<SuccesAddTaskActivity, SuccesAddTaskContract.Presenter> implements SuccesAddTaskContract.View {

    Button btnLogin;

    public SuccesAddTaskFragment() {
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_succes_add_task, container, false);
        mPresenter = new pens.lab.app.todolistmvp.modul.succes_add_task.SuccesAddTaskPresenter(this);
        mPresenter.start();

        btnLogin = fragmentView.findViewById(R.id.dashboard);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLoginClick();
            }
        });

        setTitle("SUCCES ADD NEW TASK");
        return fragmentView;
    }

    public void setBtLoginClick(){
        mPresenter.performDashboard();
    }

    @Override
    public void setPresenter(SuccesAddTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToDashboard() {
        Intent intent = new Intent(activity, DashboardActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
