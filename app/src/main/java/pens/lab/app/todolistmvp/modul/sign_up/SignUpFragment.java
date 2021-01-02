package pens.lab.app.todolistmvp.modul.sign_up;

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

public class SignUpFragment extends BaseFragment<SignUpActivity, SignUpContract.Presenter> implements SignUpContract.View {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    Button btnLogin2;

    public SignUpFragment() {
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_sign_up, container, false);
        mPresenter = new pens.lab.app.todolistmvp.modul.sign_up.SignUpPresenter(this);
        mPresenter.start();

        btnLogin = fragmentView.findViewById(R.id.signupbutton);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLoginClick();
            }
        });

        btnLogin2 = fragmentView.findViewById(R.id.olduser);
        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLoginClick2();
            }
        });

        setTitle("SIGN UP");
        return fragmentView;
    }

    public void setBtLoginClick(){
        mPresenter.performSignUp();
    }

    public void setBtLoginClick2(){
        mPresenter.performSignUp();
    }

    @Override
    public void setPresenter(SignUpContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToProfile() {
        Intent intent = new Intent(activity, LoginActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
