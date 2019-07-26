package com.alfredo.android.a21pointsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.friendList.FriendLab3;
import com.alfredo.android.a21pointsandroid.activity.friendList.SingleFragmentActivity;
import com.alfredo.android.a21pointsandroid.model.Invitation;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.model.UserProfile2;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.InviteCallBack;
import com.alfredo.android.a21pointsandroid.restapi.callback.ProfileAPICallback;
import com.alfredo.android.a21pointsandroid.restapi.callback.UserAPICallBack;

import java.util.ArrayList;

public class ProfileActivity4 extends AppCompatActivity implements UserAPICallBack, ProfileAPICallback, InviteCallBack {
    private Button GotoMenu;
    private TextView username_id;
    private TextView UsernameField;
    private TextView mEmailField;
    private TextView mBirthDate;
    private TextView mAboutme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile4);

        // String email = getIntent().getStringExtra("email");


        UsernameField = (TextView) findViewById(R.id.friend_username55);

        if ( SingleFragmentActivity.myFriend.getUsername()== null ){
            UsernameField.setText("No information!");
        } else {
            UsernameField.setText(SingleFragmentActivity.myFriend.getUsername());
        }

        mEmailField = (TextView) findViewById(R.id.friend_email22);

        if ( SingleFragmentActivity.myFriend.getEmail() == null ){
            mEmailField.setText("No information");
        } else {
            mEmailField.setText(SingleFragmentActivity.myFriend.getAboutme());
        }

        mAboutme = (TextView) findViewById(R.id.frase_abautme32);
        if ( SingleFragmentActivity.myFriend.getAboutme() == null ){
            mAboutme.setText("No information");
        } else {
            mAboutme.setText(SingleFragmentActivity.myFriend.getAboutme());
        }

        mBirthDate = (TextView) findViewById(R.id.birth_date22);

            mBirthDate.setText("No information");




        //RestAPIManager.getInstance().getUserToken(getIntent().getExtras().getString(a), getIntent().getExtras().getString(b), R.layout.activity_login);
        final CheckBox acceptFriend = findViewById(R.id.checkBox2);


        Button AddFriend2 = (Button) findViewById(R.id.AddFriend23);
        AddFriend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RestAPIManager.getInstance().changeInvitation(FriendLab3.id_accepted,acceptFriend.isChecked(),getContext());
                Toast.makeText(ProfileActivity4.this, "Invitation sended!",Toast.LENGTH_LONG).show();

            }
        });
    }

    public InviteCallBack getContext(){
        return this;
    }

    private InviteCallBack getInviteContext(){
        return this;
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
    public void onGetCurrentProfile(UserProfile2 currentProfile) {

    }

    @Override
    public void onGetInvitation(Invitation body) {

    }

    @Override
    public void onReciveInvitations(ArrayList<Invitation> body) {

    }

    @Override
    public void onFailure(Throwable t) {

    }

    @Override
    public void onChangeStateInvite() {

    }
}