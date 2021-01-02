package pens.lab.app.todolistmvp.modul.succes_edit_task;

import pens.lab.app.todolistmvp.base.BasePresenter;
import pens.lab.app.todolistmvp.base.BaseView;

public interface SuccesEditTaskContract {
    interface View extends BaseView<Presenter> {
        void redirectToProfile();
        void redirectToDashboard();
    }

    interface Presenter extends BasePresenter {
        void performLogin();
        void performDashboard();
        void showUser(String email, String password);
    }
}
