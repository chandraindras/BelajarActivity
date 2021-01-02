package pens.lab.app.todolistmvp.modul.login;

import pens.lab.app.todolistmvp.base.BasePresenter;
import pens.lab.app.todolistmvp.base.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        //void redirectToProfile();
        void redirectToSignUp();
        void redirectToDashboard();
        void redirectToForgetPassword();
    }

    interface Presenter extends BasePresenter {
        void performLogin(String email, String password);
        void performSignUp();
        void performDashboard();
        void performForgetPassword();
    }
}
