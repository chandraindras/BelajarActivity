package pens.lab.app.todolistmvp.modul.forget_password;

import pens.lab.app.todolistmvp.base.BasePresenter;
import pens.lab.app.todolistmvp.base.BaseView;

public interface ForgetPasswordContract {
    interface View extends BaseView<Presenter> {
        void redirectToLogin();
    }

    interface Presenter extends BasePresenter {
        void performLogin();
    }
}
