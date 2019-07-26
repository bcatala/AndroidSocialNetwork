package com.alfredo.android.a21pointsandroid.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.Chat.MessageListActivity;
import com.alfredo.android.a21pointsandroid.activity.Chat.MessageListFragment;
import com.alfredo.android.a21pointsandroid.activity.chatroom.Chatroom;
import com.alfredo.android.a21pointsandroid.activity.chatroom.ChatroomListActivity;
import com.alfredo.android.a21pointsandroid.activity.friendList.FriendActivity;
import com.alfredo.android.a21pointsandroid.activity.friendList.FriendFragment;
import com.alfredo.android.a21pointsandroid.activity.friendList.FriendListActivity;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_Message;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_message2;
import com.alfredo.android.a21pointsandroid.model.Invitation;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.ChatroomAPICallBack;
import com.alfredo.android.a21pointsandroid.restapi.callback.InviteCallBack;
import com.alfredo.android.a21pointsandroid.restapi.callback.UserAPICallBack;

import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity implements UserAPICallBack, InviteCallBack, ChatroomAPICallBack {

    private String token;
    public static User user;


    private Button mFriendListButton;
    private Button mSearchUserButton;
    private Button mInvitationButton;
    private Button mMessageButton;
    private EditText mIdtoSearchChat;
    private EditText mIdtoSearchProfile;
    private Button mSearchChatButton;
    private Button mSearchProfileButton;


    public static ArrayList<Invitation> receivedInvitations;
    public static ArrayList<Chatroom> allChatrooms;
    public static Chatroom chat;

    public static ArrayList<Direct_message2> dmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        this.token = getIntent().getStringExtra("token");

        RestAPIManager.getInstance().getUserAccount(this, token);

        mFriendListButton = (Button) findViewById(R.id.friends);
        mFriendListButton.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {

                RestAPIManager.getInstance().getDirectMessage(getContextChat());
            }
        });

        mSearchUserButton = (Button) findViewById(R.id.search_user);
        mSearchUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenuActivity.this, SearchUserActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("user", user);
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        mInvitationButton = (Button) findViewById(R.id.invitations);
        mInvitationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RestAPIManager.getInstance().getAllInvitations(getContext());

            }
        });

        mMessageButton = (Button) findViewById(R.id.messages);
        mMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestAPIManager.getInstance().getChatrooms(getContextChat());
            }
        });

        mIdtoSearchChat = (EditText) findViewById(R.id.text_id_chat);
        mSearchChatButton = (Button) findViewById(R.id.search_chatroom);
        mSearchChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mIdtoSearchChat.getText();
                //RestAPIManager.getInstance().getMessages(getContextChat(), Integer.parseInt(mIdtoSearchChat.getText().toString()));
                RestAPIManager.getInstance().getDirectMessage(getContextChat());
            }
        });

        mIdtoSearchProfile = (EditText) findViewById(R.id.text_id_profile);
        mSearchProfileButton = (Button) findViewById(R.id.search_profile);
    }

    public InviteCallBack getContextInvite(){
        return this;
    }

    public void startRandomChat(){
        Intent i = new Intent(MainMenuActivity.this, ChatroomListActivity.class);

        startActivity(i);
    }



    private InviteCallBack getContext() {

        return this;
    }

    private ChatroomAPICallBack getContextChat() {

        return this;
    }
    @Override
    public void onGetUser(User body){
        this.user = body;

        TextView tvUsername = findViewById(R.id.logged_name);
        tvUsername.setText(this.user.getLogin());

       /* Intent i = new Intent(LoginActivity.this, MainMenuActivity.class);

        i.putExtra("login", this.user.getLogin());
        i.putExtra("username", this.user.getFirstName());
        //i.putExtra("user", this.user.convertString());

        startActivity(i);*/
    }

    @Override
    public void onGetUserInfo(User body){

    }

    @Override
    public void onGetInvitation(Invitation body) {

    }

    @Override
    public void onReciveInvitations(ArrayList<Invitation> body) {
        receivedInvitations = body;
        Intent i = new Intent(MainMenuActivity.this, FriendListActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        i.putExtras(bundle);

        startActivity(i);
    }

    @Override
    public void onGetChatrooms(ArrayList<Chatroom> body) {
        allChatrooms = body;
        startRandomChat();

    }

    @Override
    public void onGetMessages(Chatroom body) {
        chat = body;
        Intent i = new Intent(MainMenuActivity.this, MessageListActivity.class);
        startActivity(i);
    }

    @Override
    public void onFailure(Throwable t) {

        Log.d("21Points", "onFailure OK " + t.getMessage());


        new AlertDialog.Builder(this)
                .setTitle("Token Error")
                .setMessage(t.getMessage())

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void onGetDirectMessage(ArrayList<Direct_message2> messages) {
        dmessage = messages;

        RestAPIManager.getInstance().getAllInvitations(getContext());


    }

    @Override
    public void onPostDirectMessage() {

    }

    public MainMenuActivity getContextClass(){
        return this;
    }

    @Override
    public void onGetAllUsers(ArrayList<User> body){

    }

    @Override
    public void onUserFound(User body){

    }

    @Override
    public void onUserProfileFound(UserProfile body){

    }


    @Override
    public void onGetAllUserProfiles(ArrayList<UserProfile> body){

    }

    public  void proba(){

        Intent i = new Intent(MainMenuActivity.this, ProfileActivity.class);

        startActivity(i);


    }


}
