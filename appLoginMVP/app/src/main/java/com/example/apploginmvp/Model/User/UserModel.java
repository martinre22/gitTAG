package com.example.apploginmvp.Model.User;

public class UserModel implements IUser{
    private String user_name;
    private String password;


    public UserModel() {
    }

    public UserModel(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String get_username() {
        return user_name;
    }

    @Override
    public String get_password() {
        return password;
    }

    @Override
    public int check_user_validity(String username, String password) {
        return 0;
    }
}
