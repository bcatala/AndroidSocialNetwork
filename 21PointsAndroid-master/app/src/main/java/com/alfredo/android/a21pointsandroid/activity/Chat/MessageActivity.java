package com.alfredo.android.a21pointsandroid.activity.Chat;

import android.support.v4.app.Fragment;

import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;
import com.alfredo.android.a21pointsandroid.activity.chatroom.Chatroom;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_Message;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;

import java.util.ArrayList;

public class MessageActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MessageFragment();
    }



}
