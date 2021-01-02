package pens.lab.app.todolistmvp.modul.forget_password;

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
import pens.lab.app.todolistmvp.modul.login.LoginActivity;

public class ForgetPasswordFragment extends BaseFragment<ForgetPasswordActivity, ForgetPasswordContract.Presenter> implements ForgetPasswordContract.View {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;

    public ForgetPasswordFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_forget_password, container, false);
        mPresenter = new pens.lab.app.todolistmvp.modul.forget_password.ForgetPasswordPresenter( this);
        mPresenter.start();

        btnLogin = fragmentView.findViewById(R.id.resetpass);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtLoginClick();
            }
        });

        setTitle("FORGET PASSWORD");
        return fragmentView;
    }

    public void setBtLoginClick(){
        mPresenter.performLogin();
    }

    @Override
    public void setPresenter(ForgetPasswordContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToLogin() {
        Intent intent = new Intent(activity, LoginActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
