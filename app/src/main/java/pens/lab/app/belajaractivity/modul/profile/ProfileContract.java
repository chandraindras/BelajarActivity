package pens.lab.app.belajaractivity.modul.profile;

import pens.lab.app.belajaractivity.base.BasePresenter;
import pens.lab.app.belajaractivity.base.BaseView;

public interface ProfileContract {
    interface View extends BaseView<Presenter> {
        void redirectToProfile();
    }

    interface Presenter extends BasePresenter {
        void performLogin(String email, String password);
        void showUser(String email, String password);
    }
}
