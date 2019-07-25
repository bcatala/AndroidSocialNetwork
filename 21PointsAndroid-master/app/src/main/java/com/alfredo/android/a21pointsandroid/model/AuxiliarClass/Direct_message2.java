package com.alfredo.android.a21pointsandroid.model.AuxiliarClass;

import android.provider.ContactsContract;

import com.alfredo.android.a21pointsandroid.activity.chatroom.Chatroom;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.model.UserProfile2;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Direct_message2 {

    @SerializedName("chatroom")
    @Expose
    private Chatroom chatroom;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("pictureContentType")
    @Expose
    private String pictureContentType;
    @SerializedName("sender")
    @Expose
    private UserProfile sender;
    @SerializedName("recipient")
    @Expose
    private UserProfile2 reciver;
    @SerializedName("url")
    @Expose
    private String url;

    public Direct_message2(String messagee, UserProfile sender, UserProfile2 reciver, int idd) {
        id = 495;
        message = messagee;
        this.sender = sender;
        createdDate = "2019-08-20T10:48:47.255Z";
        url = "";
        picture = "";
        pictureContentType = null;
        this.reciver = reciver;

    }
}