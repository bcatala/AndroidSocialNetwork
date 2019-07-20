package com.alfredo.android.a21pointsandroid.activity.friendList;

import android.content.Context;

import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FriendLab {
    private static FriendLab sFriendLab;

    private List<Friend> mFriends;

    public static FriendLab get(Context context) {
        if (sFriendLab == null) {
            sFriendLab = new FriendLab(context);
        }

        return sFriendLab;
    }

    private FriendLab(Context context) {
        mFriends = new ArrayList<>();
        for (int i = 0; i < LoginActivity.myFriends.size(); i++) {
            Friend friend = new Friend();
            friend.setUsername(LoginActivity.myFriends.get(i).getUser().getLogin());
            friend.setEmail(LoginActivity.myFriends.get(i).getUser().getEmail());
            mFriends.add(friend);
        }
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
