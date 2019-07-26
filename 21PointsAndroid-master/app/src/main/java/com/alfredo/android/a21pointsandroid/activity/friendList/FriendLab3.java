package com.alfredo.android.a21pointsandroid.activity.friendList;

import android.content.Context;

import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FriendLab3 {
    public static FriendLab3 sFriendLab;
    public static int id_accepted;

    public static List<Friend> mFriends;

    public static FriendLab3 get(Context context) {
        if (sFriendLab == null) {
            sFriendLab = new FriendLab3(context);
        }

        return sFriendLab;
    }

    private FriendLab3(Context context) {
        mFriends = new ArrayList<>();
        if (LoginActivity.profil == 1) {
            for (int i = 0; i < LoginActivity.myFriends.size(); i++) {
                Friend friend = new Friend();
                friend.setUsername(LoginActivity.myFriends.get(i).getUser().getLogin());
                friend.setEmail(LoginActivity.myFriends.get(i).getUser().getEmail());
                mFriends.add(friend);
            }

        } else {

            if (LoginActivity.profil == 0) {
                int b = LoginActivity.AllProfiles.size();
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


                }

            } else {

                int b = MainMenuActivity.receivedInvitations.size();
                for (int i = 0; i < MainMenuActivity.receivedInvitations.size(); i++) {
                    Friend friend = new Friend();
                    friend.setUsername(MainMenuActivity.receivedInvitations.get(i).getSent().getDisplayName());
                    id_accepted=MainMenuActivity.receivedInvitations.get(i).getSent().getId();
                    friend.setEmail("---------");
                    try {


                        friend.setAboutme("---------");

                    } catch (NullPointerException e) {

                        friend.setAboutme("No tinc cap frase");
                    }
                    mFriends.add(friend);


                }


            }
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