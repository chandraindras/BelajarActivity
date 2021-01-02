package pens.lab.app.todolistmvp.modul.sign_up;

public class SignUpPresenter implements SignUpContract.Presenter{
    private final SignUpContract.View view;

    public SignUpPresenter(SignUpContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performSignUp(){
        view.redirectToProfile();
    }

    @Override
    public void showUser(final String email, final String password) {
        view.redirectToProfile();
    }
}
