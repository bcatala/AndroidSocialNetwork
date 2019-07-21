package com.alfredo.android.a21pointsandroid.model.AuxiliarClass;

import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Direct_Message {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("pictureContentType")
    @Expose
    private Object pictureContentType;
    @SerializedName("sender")
    @Expose
    private UserProfile sender;
    @SerializedName("recipient")
    @Expose
    private UserProfile recipient;

    /**
     * No args constructor for use in serialization
     */
    public Direct_Message() {
    }

    /**
     * @param sender
     * @param picture
     * @param message
     * @param id
     * @param pictureContentType
     * @param createdDate
     * @param recipient
     * @param url
     */
    public Direct_Message(Integer id, String createdDate, String message, String url, String picture, Object pictureContentType, UserProfile sender, UserProfile recipient) {
        super();
        this.id = id;
        this.createdDate = createdDate;
        this.message = message;
        this.url = url;
        this.picture = picture;
        this.pictureContentType = pictureContentType;
        this.sender = sender;
        this.recipient = recipient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Object getPictureContentType() {
        return pictureContentType;
    }

    public void setPictureContentType(Object pictureContentType) {
        this.pictureContentType = pictureContentType;
    }

    public UserProfile getSender() {
        return sender;
    }

    public void setSender(UserProfile sender) {
        this.sender = sender;
    }

    public UserProfile getRecipient() {
        return recipient;
    }

    public void setRecipient(UserProfile recipient) {
        this.recipient = recipient;
    }
}