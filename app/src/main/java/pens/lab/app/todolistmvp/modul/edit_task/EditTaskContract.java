package pens.lab.app.todolistmvp.modul.edit_task;

import pens.lab.app.todolistmvp.base.BasePresenter;
import pens.lab.app.todolistmvp.base.BaseView;
import pens.lab.app.todolistmvp.data.model.Task;

public interface EditTaskContract {
    interface View extends BaseView<Presenter> {
        void redirectToSuccesEdit();
        void showData(Task task);
        void setId(String id);
    }

    interface Presenter extends BasePresenter {
        void saveData(String title, String description);
        void loadData(String id);
        void deleteData();
    }
}
