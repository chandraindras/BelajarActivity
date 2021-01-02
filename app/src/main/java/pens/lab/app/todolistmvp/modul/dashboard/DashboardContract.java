package pens.lab.app.todolistmvp.modul.dashboard;

import java.util.ArrayList;

import pens.lab.app.todolistmvp.base.BasePresenter;
import pens.lab.app.todolistmvp.base.BaseView;
import pens.lab.app.todolistmvp.data.model.Task;

public interface DashboardContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask();
    }

    interface Presenter extends BasePresenter {
        ArrayList<Task> getDataSet();
    }
}
