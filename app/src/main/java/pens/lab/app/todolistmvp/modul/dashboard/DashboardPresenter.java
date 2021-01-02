package pens.lab.app.todolistmvp.modul.dashboard;

import java.util.ArrayList;

import pens.lab.app.todolistmvp.data.model.Task;
import pens.lab.app.todolistmvp.data.source.local.TableHandler;
import pens.lab.app.todolistmvp.data.source.session.SessionRepository;

public class DashboardPresenter implements DashboardContract.Presenter{
    private final DashboardContract.View view;
    private final SessionRepository sessionRepository;                                              //new
    private final TableHandler tableHandler;

    public DashboardPresenter(DashboardContract.View view, SessionRepository sessionRepository, TableHandler tableHandler) {           //add
        this.view = view;
        this.sessionRepository = sessionRepository;
        this.tableHandler = tableHandler;
    }

    @Override
    public void start() {}

    @Override
    public ArrayList<Task> getDataSet() {
        //get Data from DB
        ArrayList<Task> data = tableHandler.readAll();
        return data;
    }
}
