package pens.lab.app.belajaractivity.modul.profile;

public class ProfilePresenter implements ProfileContract.Presenter{
    private final ProfileContract.View view;

    public ProfilePresenter(ProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void showUser(String email, String password) {

    }
}
