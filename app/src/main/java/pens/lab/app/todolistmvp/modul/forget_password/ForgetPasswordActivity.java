package pens.lab.app.todolistmvp.modul.forget_password;

import android.view.View;

import pens.lab.app.todolistmvp.base.BaseFragmentHolderActivity;

public class ForgetPasswordActivity extends BaseFragmentHolderActivity {
    pens.lab.app.todolistmvp.modul.forget_password.ForgetPasswordFragment forgetPasswordFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();
        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);
        forgetPasswordFragment = new ForgetPasswordFragment();
        setCurrentFragment(forgetPasswordFragment, false);
    }
}
