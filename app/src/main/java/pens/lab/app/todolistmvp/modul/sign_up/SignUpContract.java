package pens.lab.app.todolistmvp.modul.sign_up;

import pens.lab.app.todolistmvp.base.BasePresenter;
import pens.lab.app.todolistmvp.base.BaseView;

public interface SignUpContract {
    interface View extends BaseView<Presenter> {
        void redirectToProfile();
    }

    interface Presenter extends BasePresenter {
        void performSignUp();
        void showUser(String email, String password);
    }
}
