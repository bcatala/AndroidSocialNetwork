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
import com.alfredo.android.a21pointsandroid.activity.Chat.MessageListFragment;
import com.alfredo.android.a21pointsandroid.activity.chatroom.Chatroom;
import com.alfredo.android.a21pointsandroid.activity.friendList.FriendFragment;
import com.alfredo.android.a21pointsandroid.activity.friendList.FriendListFragment;
import com.alfredo.android.a21pointsandroid.activity.friendList.SingleFragmentActivity;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_message2;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserData;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.ChatroomAPICallBack;
import com.alfredo.android.a21pointsandroid.restapi.callback.UserAPICallBack;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements UserAPICallBack ,ChatroomAPICallBack {
    private Button GotoMenu;
    private TextView username_id;
    private TextView UsernameField;
    private TextView mEmailField;
    private TextView mAboutme;
    public static int change;
    public static String nomUser;
    public static int cop;

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

                Integer a = FriendListFragment.id;

                change=1;
                ProfileActivity4.idrecipient=LoginActivity.userProfile2.getId().toString();
                ProfileActivity4.idsender=a.toString();
cop=1;
                        RestAPIManager.getInstance().getDirectMessage(getContext());

            }

        });
    }


public ChatroomAPICallBack getContext(){



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
    public void onGetChatrooms(ArrayList<Chatroom> body) {

    }

    @Override
    public void onGetMessages(Chatroom body) {

    }

    @Override
    public void onFailure(Throwable t) {

    }

    @Override
    public void onGetDirectMessage(ArrayList<Direct_message2> messages) {

        int k=0;

        if(cop==1){
            MainMenuActivity.dmessage=(messages);
            Integer a = FriendListFragment.id;
            ProfileActivity4.idsender=LoginActivity.userProfile2.getId().toString();
            ProfileActivity4.idrecipient=a.toString();
            cop=0;
            RestAPIManager.getInstance().getDirectMessage(getContext());

        }else {
            while (k<messages.size()){

                MainMenuActivity.dmessage.add(messages.get(k));
                k++;
            }
            Intent i = new Intent(ProfileActivity.this, MessageListActivity.class);

            startActivity(i);

        }
    }

    @Override
    public void onPostDirectMessage() {

    }
}

