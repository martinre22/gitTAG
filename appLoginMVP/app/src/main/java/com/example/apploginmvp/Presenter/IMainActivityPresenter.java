package com.example.apploginmvp.Presenter;

import com.example.apploginmvp.Model.User.UserModel;

public interface IMainActivityPresenter {

    UserModel return_user(String username, String password);

    void registrationUserBD(UserModel user);

}
