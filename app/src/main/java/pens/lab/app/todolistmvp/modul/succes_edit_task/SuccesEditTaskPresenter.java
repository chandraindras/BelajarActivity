package pens.lab.app.todolistmvp.modul.succes_edit_task;

public class SuccesEditTaskPresenter implements SuccesEditTaskContract.Presenter{
    private final SuccesEditTaskContract.View view;

    public SuccesEditTaskPresenter(SuccesEditTaskContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performLogin() {
        view.redirectToProfile();
    }

    @Override
    public void performDashboard(){
        view.redirectToDashboard();
    }

    @Override
    public void showUser(final String email, final String password) {
        view.redirectToDashboard();
    }
}
