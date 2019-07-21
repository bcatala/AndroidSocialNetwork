package com.alfredo.android.a21pointsandroid.activity.chatroom;

import java.util.ArrayList;
import java.util.List;

import com.alfredo.android.a21pointsandroid.model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chatroom {

    @SerializedName("admin")
    @Expose
    private User admin;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("messages")
    @Expose
    private ArrayList<Message> messages = null;
    @SerializedName("participants")
    @Expose
    private List<User> participants = null;
    @SerializedName("topic")
    @Expose
    private String topic;

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
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

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}