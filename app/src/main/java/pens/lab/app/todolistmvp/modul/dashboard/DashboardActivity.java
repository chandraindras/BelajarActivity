package pens.lab.app.todolistmvp.modul.dashboard;

import android.view.View;

import pens.lab.app.todolistmvp.base.BaseFragmentHolderActivity;

public class DashboardActivity extends BaseFragmentHolderActivity {
    DashboardFragment dashboardFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        dashboardFragment = new DashboardFragment();
        setCurrentFragment(dashboardFragment, false);
    }
}
