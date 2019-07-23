package com.alfredo.android.a21pointsandroid.activity.friendList;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.UserAPICallBack;

import java.util.ArrayList;

import static android.widget.CompoundButton.*;

public class FriendFragment extends Fragment implements UserAPICallBack {

    private Friend mFriend;
    private TextView mUsernameField;
    private TextView mEmailField;
    private Button messages;
    private String login ;
    private EditText Profile_to_search;
    public static User user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFriend = new Friend();
    }
    private void setLogin(String login) {
        this.login = login;
    }
    private UserAPICallBack getContex() {
        return this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);

        mUsernameField = (TextView) v.findViewById(R.id.friend_username);
        mUsernameField.setText(mFriend.getUsername());

        mEmailField = (TextView) v.findViewById(R.id.friend_email);
        mEmailField.setText(mFriend.getEmail());

        Profile_to_search = (EditText) v.findViewById(R.id.Profile_to_search);

        messages = (Button) v.findViewById(R.id.message_button);
        messages.setOnClickListener(new OnClickListener() {
            @Override

                public void onClick(View v) {
                    setLogin(Profile_to_search.getText().toString());
                    //mInviteButton.setText("INVITE");
                    RestAPIManager.getInstance().searchUser(getContex(), LoginActivity.token, Profile_to_search.getText().toString());
                    //RestAPIManager.getInstance().searchAllUserProfiles(getContext(), LoginActivity.token);
                }

        });


        return v;
    }

    @Override
    public void onGetUserInfo(User user) {

    }

    @Override
    public void onGetUser(User body) {
        this.user = body;

        MainMenuActivity m=new MainMenuActivity();
        m.proba();
    }

    @Override
    public void onGetAllUsers(ArrayList<User> body) {

    }

    @Override
    public void onUserFound(User body) {

    }

    @Override
    public void onUserProfileFound(UserProfile body) {

    }

    @Override
    public void onGetAllUserProfiles(ArrayList<UserProfile> body) {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
