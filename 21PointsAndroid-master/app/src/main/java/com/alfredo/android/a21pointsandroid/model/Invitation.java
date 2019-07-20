package com.alfredo.android.a21pointsandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Invitation {

    @SerializedName("accepted")
    @Expose
    private Boolean accepted;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("received")
    @Expose
    private subUser received;
    @SerializedName("sent")
    @Expose
    private subUser sent;

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
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

    public subUser getReceived() {
        return received;
    }

    public void setReceived(subUser received) {
        this.received = received;
    }

    public subUser getSent() {
        return sent;
    }

    public void setSent(subUser sent) {
        this.sent = sent;
    }

}