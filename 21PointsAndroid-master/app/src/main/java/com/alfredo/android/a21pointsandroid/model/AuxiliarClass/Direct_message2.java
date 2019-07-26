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

    public Chatroom getChatroom() {
        return chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictureContentType() {
        return pictureContentType;
    }

    public void setPictureContentType(String pictureContentType) {
        this.pictureContentType = pictureContentType;
    }

    public UserProfile getSender() {
        return sender;
    }

    public void setSender(UserProfile sender) {
        this.sender = sender;
    }

    public UserProfile2 getReciver() {
        return reciver;
    }

    public void setReciver(UserProfile2 reciver) {
        this.reciver = reciver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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