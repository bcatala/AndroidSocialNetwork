package com.alfredo.android.a21pointsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.Chat.MessageListActivity;
import com.alfredo.android.a21pointsandroid.activity.friendList.FriendFragment;
import com.alfredo.android.a21pointsandroid.activity.friendList.SingleFragmentActivity;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserData;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.UserAPICallBack;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements UserAPICallBack {
    private Button GotoMenu;
    private TextView username_id;
    private TextView UsernameField;
    private TextView mEmailField;
    private TextView mAboutme;
    public static int change;
    public static String nomUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button mGotoMenu = (Button) findViewById(R.id.GotoMenu);

       // String email = getIntent().getStringExtra("email");

        UsernameField = (TextView) findViewById(R.id.friend_username);
        UsernameField.setText(SingleFragmentActivity.myFriend.getUsername());
        nomUser=SingleFragmentActivity.myFriend.getUsername();

        mEmailField = (TextView) findViewById(R.id.friend_email);
        mEmailField.setText(SingleFragmentActivity.myFriend.getEmail());

        mAboutme = (TextView) findViewById(R.id.frase_abautme2);
        mAboutme.setText(SingleFragmentActivity.myFriend.getAboutme());

        //RestAPIManager.getInstance().getUserToken(getIntent().getExtras().getString(a), getIntent().getExtras().getString(b), R.layout.activity_login);


        mGotoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                change=1;
                Intent i = new Intent(ProfileActivity.this, MessageListActivity.class);

                startActivity(i);
            }

        });
    }

    @Override
    public void onGetUserInfo(User user) {

    }

    @Override
    public void onGetUser(User body) {

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

