package com.alfredo.android.a21pointsandroid.activity.Chat;

import com.alfredo.android.a21pointsandroid.model.UserProfile;

import java.util.Date;
import java.util.UUID;

public class Message {

    private UUID mId;
    private String mTitle;
    private String missatge;
    private UserProfile a;
    private Date mDate;
    private boolean mSolved;

    public Message() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getMissatge() {
        return missatge;
    }

    public void setMissatge(String missatge) {
        this.missatge = missatge;
    }

    public UserProfile getA() {
        return a;
    }

    public void setA(UserProfile a) {
        this.a = a;
    }
}
