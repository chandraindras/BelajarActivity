package pens.lab.app.todolistmvp.modul.succes_add_task;

public class SuccesAddTaskPresenter implements SuccesAddTaskContract.Presenter{
    private final SuccesAddTaskContract.View view;

    public SuccesAddTaskPresenter(SuccesAddTaskContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performDashboard(){
        view.redirectToDashboard();
    }

    @Override
    public void showUser(final String email, final String password) {
        view.redirectToDashboard();
    }
}
