package pens.lab.app.todolistmvp.modul.edit_task;

import android.view.View;

import pens.lab.app.todolistmvp.base.BaseFragmentHolderActivity;

public class EditTaskActivity extends BaseFragmentHolderActivity {
    EditTaskFragment editTaskFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        editTaskFragment = new EditTaskFragment();
        String id = getIntent().getExtras().getString("TaskId");
        editTaskFragment.setId(id);
        setCurrentFragment(editTaskFragment, false);
    }
}
