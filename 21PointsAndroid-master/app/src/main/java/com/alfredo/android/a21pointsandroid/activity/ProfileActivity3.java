package com.alfredo.android.a21pointsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alfredo.android.a21pointsandroid.R;
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

public class ProfileActivity3 extends AppCompatActivity implements UserAPICallBack, ProfileAPICallback, InviteCallBack {
    private Button GotoMenu;
    private TextView username_id;
    private TextView UsernameField;
    private TextView mEmailField;
    private TextView mBirthDate;
    private TextView mAboutme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        // String email = getIntent().getStringExtra("email");


        UsernameField = (TextView) findViewById(R.id.friend_username);

        if ( SingleFragmentActivity.search_profile.getDisplayName() == null ){
            UsernameField.setText("No information!");
        } else {
            UsernameField.setText(SingleFragmentActivity.search_profile.getDisplayName());
        }

        mEmailField = (TextView) findViewById(R.id.friend_email);

        if ( SingleFragmentActivity.search_profile.getUser().getEmail() == null ){
            mEmailField.setText("No information");
        } else {
            mEmailField.setText(SingleFragmentActivity.search_profile.getUser().getEmail());
        }

        mAboutme = (TextView) findViewById(R.id.frase_abautme2);
        if ( SingleFragmentActivity.search_profile.getAboutMe() == null ){
            mAboutme.setText("No information");
        } else {
            mAboutme.setText(SingleFragmentActivity.search_profile.getAboutMe().toString());
        }

        mBirthDate = (TextView) findViewById(R.id.birth_date);
        if ( SingleFragmentActivity.search_profile.getBirthDate() == null ){
            mBirthDate.setText("No information");
        } else {
            mBirthDate.setText(SingleFragmentActivity.search_profile.getBirthDate().toString());
        }



        //RestAPIManager.getInstance().getUserToken(getIntent().getExtras().getString(a), getIntent().getExtras().getString(b), R.layout.activity_login);

        Button AddFriend = (Button) findViewById(R.id.AddFriend);
        AddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RestAPIManager.getInstance().inviteUser(getInviteContext(), SingleFragmentActivity.search_profile.getUser().getId());
                Toast.makeText(ProfileActivity3.this, "Invitation sended!",Toast.LENGTH_LONG).show();

            }
        });
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
}