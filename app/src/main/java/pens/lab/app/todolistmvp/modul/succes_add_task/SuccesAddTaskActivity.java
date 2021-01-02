package pens.lab.app.todolistmvp.modul.succes_add_task;

import android.view.View;

import pens.lab.app.todolistmvp.base.BaseFragmentHolderActivity;

public class SuccesAddTaskActivity extends BaseFragmentHolderActivity {
    pens.lab.app.todolistmvp.modul.succes_add_task.SuccesAddTaskFragment succesAddTaskFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();
        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);
        succesAddTaskFragment = new SuccesAddTaskFragment();
        setCurrentFragment(succesAddTaskFragment, false);
    }
}
