package com.alfredo.android.a21pointsandroid.activity.chatroom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.alfredo.android.a21pointsandroid.R;

import static android.widget.CompoundButton.OnCheckedChangeListener;

public class ChatroomFragment extends Fragment {

    private Chatroom mChatroom;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mChatroom = new Chatroom();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chatroom, container, false);

        return v;
    }
}
