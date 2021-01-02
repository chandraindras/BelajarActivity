package pens.lab.app.todolistmvp.modul.add_task;

import android.view.View;

import pens.lab.app.todolistmvp.base.BaseFragmentHolderActivity;

public class AddTaskActivity extends BaseFragmentHolderActivity {
    AddTaskFragment addTaskFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        addTaskFragment = new AddTaskFragment();
        setCurrentFragment(addTaskFragment, false);
    }
}
