package com.alfredo.android.a21pointsandroid.model.AuxiliarClass;

import com.alfredo.android.a21pointsandroid.model.subUser;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Block {

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