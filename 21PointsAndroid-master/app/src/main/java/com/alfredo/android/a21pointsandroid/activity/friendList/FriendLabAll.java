package com.alfredo.android.a21pointsandroid.activity.friendList;

import android.content.Context;

import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FriendLabAll {
    public static FriendLabAll sFriendLab;

    public static List<Friend> mFriends;

    public static FriendLabAll get(Context context) {
        if (sFriendLab == null) {
            sFriendLab = new FriendLabAll(context);
        }

        return sFriendLab;
    }

    private FriendLabAll(Context context) {
        mFriends = new ArrayList<>();
        if (LoginActivity.profil == 1) {
            for (int i = 0; i < LoginActivity.myFriends.size(); i++) {
                Friend friend = new Friend();
                friend.setUsername(LoginActivity.myFriends.get(i).getUser().getLogin());
                friend.setEmail(LoginActivity.myFriends.get(i).getUser().getEmail());
                mFriends.add(friend);
            }

        } else {

            int b= LoginActivity.AllProfiles.size();
            for (int i = 0; i < LoginActivity.AllProfiles.size(); i++) {
                Friend friend = new Friend();
                friend.setUsername(LoginActivity.AllProfiles.get(i).getUser().getLogin());
                friend.setEmail(LoginActivity.AllProfiles.get(i).getUser().getEmail());
                try {


                    friend.setAboutme(LoginActivity.AllProfiles.get(i).getAboutMe().toString());
                } catch (NullPointerException e) {

                    friend.setAboutme("No tinc cap frase");
                }
                mFriends.add(friend);


            }}
    }
    public List<Friend> getFriends() {
        return mFriends;
    }

    public Friend getFriend(UUID id) {
        for (Friend friend : mFriends) {
            if (friend.getId().equals(id)) {
                return friend;
            }
        }

        return null;
    }
}
