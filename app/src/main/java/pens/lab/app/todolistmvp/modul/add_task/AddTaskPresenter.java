package pens.lab.app.todolistmvp.modul.add_task;

import pens.lab.app.todolistmvp.data.model.Task;
import pens.lab.app.todolistmvp.data.source.local.TableHandler;
import pens.lab.app.todolistmvp.data.source.session.SessionRepository;

public class AddTaskPresenter implements AddTaskContract.Presenter{
    private final AddTaskContract.View view;
    private final SessionRepository sessionRepository;                                              //new
    private final TableHandler tableHandler;

    public AddTaskPresenter(AddTaskContract.View view, SessionRepository sessionRepository, TableHandler tableHandler) {           //add
        this.view = view;
        this.sessionRepository = sessionRepository;
        this.tableHandler = tableHandler;
    }

    @Override
    public void start() {}

    @Override
    public void saveData(final String title, final String description){
        Task newTask = new Task(title, description);
        //save new task
        tableHandler.create(newTask);

        //then go back to task list
        view.redirectToSuccesAdd();
    }
}
