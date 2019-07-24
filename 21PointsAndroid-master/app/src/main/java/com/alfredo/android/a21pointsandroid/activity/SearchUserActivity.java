package com.alfredo.android.a21pointsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.model.Invitation;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.model.UserProfile2;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.InviteCallBack;
import com.alfredo.android.a21pointsandroid.restapi.callback.UserAPICallBack;

import java.util.ArrayList;

public class SearchUserActivity extends AppCompatActivity implements UserAPICallBack, InviteCallBack {

    private Button mSearchButton;
    private EditText mSearchBar;
    private TextView mUserFound;
    private String login;
    private Button mInviteButton;
    private User user;
    public static UserProfile2 userProfile2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchuser);


        mSearchButton = (Button) findViewById(R.id.search_button);



        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSearchBar = (EditText) findViewById(R.id.user_to_search);
                String display_name = mSearchBar.getText().toString();
                if ( userProfileFound( display_name ) == -1 ) {
                    Toast.makeText(SearchUserActivity.this, "User not found!",Toast.LENGTH_LONG).show();
                } else {

                    Intent i = new Intent(SearchUserActivity.this, UserProfile2.class);
                    startActivity(i);

                }


                //RestAPIManager.getInstance().searchUser(getContext(), LoginActivity.token, login);
                //RestAPIManager.getInstance().searchAllUserProfiles(getContext(), LoginActivity.token);
            }
        });
    }

    private int userProfileFound(String display_name){
        int found = -1;
        boolean ok = false;

        for ( int i = 0; i < LoginActivity.AllProfiles.size() && !ok; i++ ){
            if ( display_name.equals(LoginActivity.AllProfiles.get(i).getDisplayName()) ){
                found = i;
                ok = true;
            }
        }

        if ( ok ) {

            UserProfile2 user_aux = new UserProfile2(LoginActivity.AllProfiles.get(found).getAboutMe(), LoginActivity.AllProfiles.get(found).getBirthDate(),
                    LoginActivity.AllProfiles.get(found).getDisplayName(),LoginActivity.AllProfiles.get(found).getPicture(),
                    LoginActivity.AllProfiles.get(found).getPictureContentType());

        }
        return found;
    }

    private UserAPICallBack getContext() {
        return this;
    }

    private InviteCallBack getInviteContext(){
        return this;
    }

    private void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void onUserFound(User body){

         this.user = body;

         //mUserFound = (TextView) findViewById(R.id.userFound);
         //mUserFound.setText(body.getLogin());

        /* mInviteButton = (Button) findViewById(R.id.invite_buton);
         mInviteButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 RestAPIManager.getInstance().inviteUser(getInviteContext(), user.getId());
             }
         });*/

    }

    @Override
    public void onFailure(Throwable t){

    }

    @Override
    public void onGetUserInfo(User body){

    }

    @Override
    public void onGetUser(User body){

    }

    @Override
    public void onGetAllUsers(ArrayList<User> body){

    }

    @Override
    public void onUserProfileFound(UserProfile body){


    }

    @Override
    public void onUserProfileFound2(UserProfile2 body) {

    }

    @Override
    public void onGetAllUserProfiles(ArrayList<UserProfile> body){
        for(int i = 0; i < body.size(); i++){
            if(body.get(i).getUser().getLogin().equals(this.login)){

            }
        }
    }

    @Override
    public void onGetInvitation(Invitation invitation){
        mInviteButton.setText("SENT!");
    }

    @Override
    public void onReciveInvitations(ArrayList<Invitation> body) {

    }

}
