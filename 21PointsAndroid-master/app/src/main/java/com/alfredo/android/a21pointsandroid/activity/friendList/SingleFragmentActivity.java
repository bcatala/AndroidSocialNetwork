package com.alfredo.android.a21pointsandroid.activity.friendList;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.AuxActivity;
import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity2;
import com.alfredo.android.a21pointsandroid.activity.SearchUserActivity;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.UserAPICallBack;

import java.util.ArrayList;

public abstract class SingleFragmentActivity extends AppCompatActivity implements UserAPICallBack{

    private static  EditText Profile_to_search  ;
    private String login;
    public static User user;
    public static Friend myFriend;
    public static int surt;
    static SingleFragmentActivity a2;

    protected abstract Fragment createFragment();
    public  void proba(){

        Intent i = new Intent(SingleFragmentActivity.this, ProfileActivity.class);

        startActivity(i);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_friendlist_fragment);
            Profile_to_search = (EditText) findViewById(R.id.Profile_to_search);


         a2=SingleFragmentActivity.this;





            Button messages = (Button) findViewById(R.id.message_button);
            messages.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    setLogin(Profile_to_search.getText().toString());
                    LoginActivity.profil = 0;
                    Intent i = new Intent(SingleFragmentActivity.this, ProfileActivity.class);
                    i.putExtra("login", login);

                    startActivity(i);
                    //mInviteButton.setText("INVITE");
                    // RestAPIManager.getInstance().searchUser(getContex(), LoginActivity.token, Profile_to_search.getText().toString());
                    //RestAPIManager.getInstance().searchAllUserProfiles(getContext(), LoginActivity.token);
                }

            });

           Button mfriendButton = (Button) findViewById(R.id.corazon_buto);
            mfriendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    LoginActivity.profil = 1;
                    Intent i = new Intent(SingleFragmentActivity.this, AuxActivity.class);
                    i.putExtra("a", 1);


                    startActivity(i);
                }
            });

        Button mPerfil = (Button) findViewById(R.id.perfil_butto);
        mPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(SingleFragmentActivity.this, ProfileActivity2.class);

                startActivity(i);
            }
        });

            Button mallusersButton = (Button) findViewById(R.id.home_butto);
            mallusersButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    LoginActivity.profil = 0;
                    Intent i2 = new Intent(SingleFragmentActivity.this, AuxActivity.class);
                    i2.putExtra("a", 0);


                    startActivity(i2);
                }
            });

            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.fragment_container);

            if (fragment == null) {
                fragment = createFragment();
                fm.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();
            }

    }

    public  SingleFragmentActivity a(){

        SingleFragmentActivity a2=SingleFragmentActivity.this;

        return a2;
    }


    private void setLogin(String login) {
        this.login = login;
    }
    private UserAPICallBack getContex() {
        return this;
    }
    @Override
    public void onGetUserInfo(User user) {

    }

    @Override
    public void onGetUser(User body) {
        this.user = body;

        Intent i = new Intent(SingleFragmentActivity.this, LoginActivity.class);

        startActivity(i);
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
