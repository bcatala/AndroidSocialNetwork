package com.alfredo.android.a21pointsandroid.model.AuxiliarClass;

import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;

import java.util.ArrayList;

public class UserMessage {
    private UserProfile user;
    private ArrayList<String> messages;

    public UserMessage(UserProfile user, ArrayList<String> messages) {
        this.user = user;
        this.messages = messages;
    }

    public UserMessage() {
        this.messages = new ArrayList<>();
    }

    public UserProfile getUser() {
        return user;
    }

    public void addMessage(String dm){
        this.messages.add(dm);
    }

    public void setUsers(UserProfile users) {
        this.user = users;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }
}
