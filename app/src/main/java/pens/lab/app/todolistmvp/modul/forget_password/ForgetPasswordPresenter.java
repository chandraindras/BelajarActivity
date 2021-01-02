package pens.lab.app.todolistmvp.modul.forget_password;

import pens.lab.app.todolistmvp.modul.add_task.AddTaskFragment;

public class ForgetPasswordPresenter implements ForgetPasswordContract.Presenter{
    private final ForgetPasswordContract.View view;

    public ForgetPasswordPresenter(ForgetPasswordContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performLogin(){
        view.redirectToLogin();
    }
}
