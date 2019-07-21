package com.alfredo.android.a21pointsandroid.activity.Chat;

import android.content.Context;

import com.alfredo.android.a21pointsandroid.activity.chatroom.ChatroomListFragment;
import com.alfredo.android.a21pointsandroid.activity.chatroom.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessageLab {
    private static MessageLab sMessageLab;

    private List<Message> mMessages;

    public static MessageLab get(Context context) {
        if (sMessageLab == null) {
            sMessageLab = new MessageLab(context);
        }

        return sMessageLab;
    }

    private MessageLab(Context context) {
        mMessages = new ArrayList<>();
        for (int i = 0; i < ChatroomListFragment.allInnerMessages.size(); i++) {
            mMessages.add(ChatroomListFragment.allInnerMessages.get(i));
        }
    }

    public List<Message> getMessages() {
        return mMessages;
    }

    public Message getCrime(UUID id) {
        for (Message message : mMessages) {
            if (message.getId().equals(id)) {
                return message;
            }
        }

        return null;
    }
}
