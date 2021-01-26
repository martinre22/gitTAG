package com.example.apploginmvp.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.apploginmvp.Model.User.UserModel;
import com.example.apploginmvp.View.IMainActivityView;
import com.example.apploginmvp.db.UserDB;

public class MainActivityPresenter implements IMainActivityPresenter {

    private Context context;
    private IMainActivityView iMainActivityView;

    //clase userdb/package db
    private UserDB userDB;

    public MainActivityPresenter(Context context, IMainActivityView iMainActivityView) {
        this.context = context;
        this.iMainActivityView = iMainActivityView;
    }


    @Override
    public UserModel return_user(String username, String password) {
        UserModel user = new UserModel();
        user.setUser_name(username);
        user.setPassword(password);
        return user;
    }

    @Override
    public void registrationUserBD(UserModel user) {
        userDB = new UserDB(context);
        userDB.insertUser(user);
        Toast.makeText(context, "registro exitoso", Toast.LENGTH_LONG).show();
    }


}
