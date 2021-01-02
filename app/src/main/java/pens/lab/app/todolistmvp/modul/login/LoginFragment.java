package pens.lab.app.todolistmvp.modul.login;

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
import pens.lab.app.todolistmvp.modul.sign_up.SignUpActivity;
import pens.lab.app.todolistmvp.modul.dashboard.DashboardActivity;
import pens.lab.app.todolistmvp.modul.forget_password.ForgetPasswordActivity;
import pens.lab.app.todolistmvp.data.source.session.UserSessionRepository;

public class LoginFragment extends BaseFragment<LoginActivity, LoginContract.Presenter> implements LoginContract.View {

    EditText etEmail;
    EditText etPassword;
    Button btnRegister;
    Button btnLogin;
    Button btnForgetPass;

    public LoginFragment() {
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        mPresenter = new LoginPresenter(this, new UserSessionRepository(getActivity()));          //add
        mPresenter.start();

        etEmail = fragmentView.findViewById(R.id.username);
        etPassword = fragmentView.findViewById(R.id.password);

        btnRegister = fragmentView.findViewById(R.id.newuser);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnRegisterClick();
            }
        });

        btnLogin = fragmentView.findViewById(R.id.signin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtLoginClick();;
            }
        });

        btnForgetPass = fragmentView.findViewById(R.id.forgetpass);
        btnForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtForgetPassClick();
            }
        });

        setTitle("SIGN IN");
        return fragmentView;
    }

    public void setBtLoginClick(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        mPresenter.performLogin(email,password);
    }

    public void setBtnRegisterClick(){
        mPresenter.performSignUp();
    }

    public void setBtForgetPassClick(){
        mPresenter.performForgetPassword();
    }

    public void setBtDashboardClick(){
        mPresenter.performDashboard();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

//    @Override
//    public void redirectToProfile() {
//        Intent intent = new Intent(activity, LoginActivity.class);
//        startActivity(intent);
//        activity.finish();
//    }

    @Override
    public void redirectToSignUp() {
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

    @Override
    public void redirectToForgetPassword() {
        Intent intent = new Intent(activity, ForgetPasswordActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
