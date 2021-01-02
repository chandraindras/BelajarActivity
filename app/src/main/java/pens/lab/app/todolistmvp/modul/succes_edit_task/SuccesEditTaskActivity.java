package pens.lab.app.todolistmvp.modul.succes_edit_task;

import android.view.View;

import pens.lab.app.todolistmvp.base.BaseFragmentHolderActivity;

public class SuccesEditTaskActivity extends BaseFragmentHolderActivity {
    pens.lab.app.todolistmvp.modul.succes_edit_task.SuccesEditTaskFragment succesEditTaskFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();
        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);
        succesEditTaskFragment = new SuccesEditTaskFragment();
        setCurrentFragment(succesEditTaskFragment, false);
    }
}
