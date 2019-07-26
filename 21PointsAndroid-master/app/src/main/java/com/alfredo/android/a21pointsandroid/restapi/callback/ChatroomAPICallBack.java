package com.alfredo.android.a21pointsandroid.restapi.callback;

import com.alfredo.android.a21pointsandroid.activity.chatroom.Chatroom;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_Message;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_message2;

import java.util.ArrayList;

public interface ChatroomAPICallBack {
    void onGetChatrooms(ArrayList<Chatroom> body);
    void onGetMessages(Chatroom body);
    void onFailure(Throwable t);
    void onGetDirectMessage(ArrayList<Direct_message2> messages);
    void onPostDirectMessage();
}
