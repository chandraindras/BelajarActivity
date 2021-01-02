package pens.lab.app.todolistmvp.modul.succes_add_task;

import pens.lab.app.todolistmvp.base.BasePresenter;
import pens.lab.app.todolistmvp.base.BaseView;

public interface SuccesAddTaskContract {
    interface View extends BaseView<Presenter> {
        void redirectToDashboard();
    }

    interface Presenter extends BasePresenter {
        void performDashboard();
        void showUser(String email, String password);
    }
}
