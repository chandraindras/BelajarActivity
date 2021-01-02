package pens.lab.app.todolistmvp.modul.edit_task;

import pens.lab.app.todolistmvp.data.model.Task;
import pens.lab.app.todolistmvp.data.source.local.TableHandler;

public class EditTaskPresenter implements EditTaskContract.Presenter{
    private final EditTaskContract.View view;
    private final TableHandler tableHandler;
    Task editedTask;

    public EditTaskPresenter(EditTaskContract.View view, TableHandler tableHandler) {
        this.view = view;
        this.tableHandler = tableHandler;
    }

    @Override
    public void start() {
    }

    @Override
    public void saveData(final String title, final String description){
        editedTask.setTitle(title);
        editedTask.setDescription(description);
        tableHandler.update(editedTask);
        view.redirectToSuccesEdit();
    }

    @Override
    public void loadData(String id) {
        editedTask = (Task) tableHandler.readById(id);
        view.showData(editedTask);
    }

    public void deleteData(){
        tableHandler.delete(editedTask);
        view.redirectToSuccesEdit();
    }
}
