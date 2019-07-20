package com.alfredo.android.a21pointsandroid.activity.friendList;

import java.util.Date;
import java.util.UUID;

public class Friend {

    private UUID mId;
    private String mUsername;
    private String mEmail;
    private boolean mBlocked;

    public Friend() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public boolean isBlocked() {
        return mBlocked;
    }

    public void setBlocked(boolean blocked) {
        mBlocked = blocked;
    }
}
