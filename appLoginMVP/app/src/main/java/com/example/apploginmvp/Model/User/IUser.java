package com.example.apploginmvp.Model.User;

public interface IUser {

    String get_username();
    String get_password();

    int check_user_validity(String username, String password);
}
