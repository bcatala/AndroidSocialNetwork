package com.alfredo.android.a21pointsandroid.activity.friendList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.alfredo.android.a21pointsandroid.R;

import static android.widget.CompoundButton.*;

public class FriendFragment extends Fragment {

    private Friend mFriend;
    private TextView mUsernameField;
    private TextView mEmailField;
    private Button mChatButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFriend = new Friend();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);

        mUsernameField = (TextView) v.findViewById(R.id.friend_username);
        mUsernameField.setText(mFriend.getUsername());

        mEmailField = (TextView) v.findViewById(R.id.friend_email);
        mEmailField.setText(mFriend.getEmail());

        mChatButton = (Button) v.findViewById(R.id.go_chat);
        mChatButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start chatroom activity
            }
        });


        return v;
    }
}
