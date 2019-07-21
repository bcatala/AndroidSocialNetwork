package com.alfredo.android.a21pointsandroid.activity.chatroom;

import android.support.v4.app.Fragment;

public class ChatroomActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ChatroomFragment();
    }
}
