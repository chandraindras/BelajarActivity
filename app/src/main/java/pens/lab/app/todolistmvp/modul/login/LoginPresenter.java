package pens.lab.app.todolistmvp.modul.login;

import pens.lab.app.todolistmvp.data.model.User;
import pens.lab.app.todolistmvp.data.source.session.SessionRepository;

public class LoginPresenter implements LoginContract.Presenter{
    private final LoginContract.View view;
    private final SessionRepository sessionRepository;

    public LoginPresenter(LoginContract.View view, SessionRepository sessionRepository) {
        this.view = view;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void start() {
        if(sessionRepository.getSessionData() != null){                                             //new
            view.redirectToDashboard();                                                               //jika sudah login langsung masuk profile
        }
    }

    @Override
    public void performLogin(final String email, final String password){
        //proses login

        //if login success
        User loggedUser = new User(email, "TOKEN123456");                                    //new
        sessionRepository.setSessionData(loggedUser);                                               //new

        //then call redirect to profile
        view.redirectToDashboard();
    }

    @Override
    public void performSignUp(){
        view.redirectToSignUp();
    }

    @Override
    public void performForgetPassword(){
        view.redirectToForgetPassword();
    }

    @Override
    public void performDashboard(){
        view.redirectToDashboard();
    }
}
