package com.alfredo.android.a21pointsandroid.restapi.callback;

import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;

import java.util.ArrayList;

public interface MyFriendsAPICallBack {
    void onGetFriends(ArrayList<UserProfile> friends);
    void onFailure(Throwable t);
}
