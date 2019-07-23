package com.alfredo.android.a21pointsandroid.restapi.callback;


import com.alfredo.android.a21pointsandroid.model.UserProfile2;

public interface ProfileAPICallback {

    void onGetCurrentProfile(UserProfile2 currentProfile);
    void onFailure(Throwable t);
}
