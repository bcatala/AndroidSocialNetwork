package com.alfredo.android.a21pointsandroid.restapi.callback;

import com.alfredo.android.a21pointsandroid.model.User;

import java.util.ArrayList;

public interface UserAPICallBack extends RestAPICallBack {
    void onGetUserInfo(User user);
    void onGetUser(User body);
    void onGetAllUsers(ArrayList<User> body);
}
