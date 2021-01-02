package pens.lab.app.todolistmvp.modul.add_task;

import pens.lab.app.todolistmvp.base.BasePresenter;
import pens.lab.app.todolistmvp.base.BaseView;

public interface AddTaskContract {
    interface View extends BaseView<Presenter> {
        void redirectToSuccesAdd();
    }

    interface Presenter extends BasePresenter {
        void saveData(String title, String description);
    }
}