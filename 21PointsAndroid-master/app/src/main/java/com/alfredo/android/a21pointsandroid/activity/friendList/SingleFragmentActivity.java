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
import android.widget.Toast;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.AuxActivity;
import com.alfredo.android.a21pointsandroid.activity.Chat.MessageListActivity;
import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity2;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity3;
import com.alfredo.android.a21pointsandroid.activity.SearchUserActivity;
import com.alfredo.android.a21pointsandroid.activity.chatroom.Chatroom;
import com.alfredo.android.a21pointsandroid.activity.chatroom.ChatroomListActivity;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_Message;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_message2;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.ChatroomAPICallBack;
import com.alfredo.android.a21pointsandroid.restapi.callback.UserAPICallBack;

import java.util.ArrayList;

public abstract class SingleFragmentActivity extends AppCompatActivity implements UserAPICallBack,ChatroomAPICallBack{

    private static  EditText Profile_to_search  ;
    private String login;
    public static User user;
    public static Friend myFriend;
    public static int surt;
    static SingleFragmentActivity a2;
    public static ArrayList<Chatroom> allChatrooms;
    public static Chatroom chat;
    public static UserProfile search_profile;

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
        LoginActivity.profil2 = 0;




            Button messages = (Button) findViewById(R.id.message_button);
            messages.setOnClickListener(new View.OnClickListener() {
                @Override


                    public void onClick(View v) {

                        setLogin(Profile_to_search.getText().toString());
                        Profile_to_search = (EditText) findViewById(R.id.Profile_to_search);
                        LoginActivity.profil = 0;
                        String display_name = Profile_to_search.getText().toString();

                        if ( userProfileFound( display_name ) == -1 ) {
                            Toast.makeText(SingleFragmentActivity.this, "User not found!",Toast.LENGTH_LONG).show();
                        } else {


                            Intent i = new Intent(SingleFragmentActivity.this, ProfileActivity3.class);

                            startActivity(i);

                        }

                        //mInviteButton.setText("INVITE");
                        // RestAPIManager.getInstance().searchUser(getContex(), LoginActivity.token, Profile_to_search.getText().toString());
                        //RestAPIManager.getInstance().searchAllUserProfiles(getContext(), LoginActivity.token);
                    }


            });


        Button invit_button = (Button) findViewById(R.id.invit_button);
        invit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginActivity.profil = 3;
                Intent i = new Intent(SingleFragmentActivity.this, AuxActivity.class);
                i.putExtra("a", 1);
                LoginActivity.profil2 = 0;

                startActivity(i);
            }
        });

           Button mfriendButton = (Button) findViewById(R.id.corazon_buto);
            mfriendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    LoginActivity.profil = 1;
                    Intent i = new Intent(SingleFragmentActivity.this, AuxActivity.class);
                    i.putExtra("a", 1);
                    LoginActivity.profil2 = 0;

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
                    LoginActivity.profil2 = 0;
                    Intent i2 = new Intent(SingleFragmentActivity.this, AuxActivity.class);
                    i2.putExtra("a", 0);


                    startActivity(i2);
                }
            });


        Button roomButton = (Button) findViewById(R.id.misatge_button);
        roomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginActivity.profil2 = 2;
                RestAPIManager.getInstance().getChatrooms(getContextChat());

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

    private ChatroomAPICallBack getContextChat() {

        return this;
    }

    @Override
    public void onGetUser(User body) {
        this.user = body;

        Intent i = new Intent(SingleFragmentActivity.this, LoginActivity.class);

        startActivity(i);
    }

    @Override
    public void onGetChatrooms(ArrayList<Chatroom> body) {
        MainMenuActivity.allChatrooms = body;
        Intent i = new Intent(SingleFragmentActivity.this, ChatroomListActivity.class);
        startActivity(i);


    }

    @Override
    public void onGetMessages(Chatroom body) {
        chat = body;

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

            this.search_profile = LoginActivity.AllProfiles.get(found);
        }
        return found;
    }


    @Override
    public void onGetAllUserProfiles(ArrayList<UserProfile> body) {

    }

    @Override
    public void onFailure(Throwable t) {

    }

    @Override
    public void onGetDirectMessage(ArrayList<Direct_message2> messages) {

        MainMenuActivity.dmessage=messages;

    }

    @Override
    public void onPostDirectMessage() {

    }

}
