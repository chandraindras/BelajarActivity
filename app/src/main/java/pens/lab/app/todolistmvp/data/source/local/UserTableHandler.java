package pens.lab.app.todolistmvp.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import pens.lab.app.todolistmvp.data.model.Task;
import pens.lab.app.todolistmvp.data.model.User;

public class UserTableHandler implements TableHandler<User> {

    @Override
    public void create(User user) {

    }

    @Override
    public User readById(String id) {
        return null;
    }

    @Override
    public ArrayList<User> readAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
