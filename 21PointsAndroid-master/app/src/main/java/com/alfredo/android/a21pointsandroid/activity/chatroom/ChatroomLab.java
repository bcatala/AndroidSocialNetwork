package com.alfredo.android.a21pointsandroid.activity.chatroom;

import android.content.Context;

import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChatroomLab {
    private static ChatroomLab sChatroomLab;

    private List<Chatroom> mChatrooms;

    public static ChatroomLab get(Context context) {
        if (sChatroomLab == null) {
            sChatroomLab = new ChatroomLab(context);
        }

        return sChatroomLab;
    }

    private ChatroomLab(Context context) {
        mChatrooms = new ArrayList<>();
        for (int i = 0; i < MainMenuActivity.allChatrooms.size(); i++) {
            Chatroom chatroom = new Chatroom();
            chatroom = MainMenuActivity.allChatrooms.get(i);
            mChatrooms.add(chatroom);
        }
    }

    public List<Chatroom> getChatrooms() {
        return mChatrooms;
    }

    public Chatroom getCrime(UUID id) {
        for (Chatroom chatroom : mChatrooms) {
            if (chatroom.getId().equals(id)) {
                return chatroom;
            }
        }

        return null;
    }
}
