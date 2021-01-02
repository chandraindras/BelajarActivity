package pens.lab.app.todolistmvp.modul.sign_up;

import android.view.View;

import pens.lab.app.todolistmvp.base.BaseFragmentHolderActivity;

public class SignUpActivity extends BaseFragmentHolderActivity {
    pens.lab.app.todolistmvp.modul.sign_up.SignUpFragment signupFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();
        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);
        signupFragment = new pens.lab.app.todolistmvp.modul.sign_up.SignUpFragment();
        setCurrentFragment(signupFragment, false);
    }
}
