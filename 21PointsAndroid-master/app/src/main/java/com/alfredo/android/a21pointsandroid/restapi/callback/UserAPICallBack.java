package com.alfredo.android.a21pointsandroid.restapi.callback;

import com.alfredo.android.a21pointsandroid.model.Invitation;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.model.UserProfile2;

import java.util.ArrayList;

public interface UserAPICallBack extends RestAPICallBack {
    void onGetUserInfo(User user);
    void onGetUser(User body);
    void onGetAllUsers(ArrayList<User> body);
    void onUserFound(User body);
    void onUserProfileFound(UserProfile body);
    void onGetAllUserProfiles(ArrayList<UserProfile> body);
}
