package com.alfredo.android.a21pointsandroid.activity.Chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity;
import com.alfredo.android.a21pointsandroid.activity.chatroom.Chatroom;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_Message;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_message2;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.ChatroomAPICallBack;

import java.util.ArrayList;

public abstract class SingleFragmentActivity extends AppCompatActivity implements ChatroomAPICallBack {

    protected abstract Fragment createFragment();
   public static EditText PostMissatge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_fragment);

        TextView UserChat = (TextView) findViewById(R.id.UserChat);
        UserChat.setText("User to chat-  :" + ProfileActivity.nomUser);

        PostMissatge= (EditText) findViewById(R.id.Profile_to_search2);

        final Button messages = (Button) findViewById(R.id.enviar_butto);
        messages.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Direct_Message dm = new Direct_Message();
                dm.setMessage(PostMissatge.getText().toString());
                UserProfile a = new UserProfile();
                a.setUser(LoginActivity.userProfile2.getUser());

                dm.setSender(a);
                dm.setRecipient(MessageListFragment.userProfile);
                 /*dm = new Direct_Message(MainMenuActivity.dmessage.get(1).getId()
                         ,MainMenuActivity.dmessage.get(1).getCreatedDate(),
                         MainMenuActivity.dmessage.get(1).getMessage(),
                         MainMenuActivity.dmessage.get(1).getUrl(),
                         MainMenuActivity.dmessage.get(1).getPicture(),
                         MainMenuActivity.dmessage.get(1).getPictureContentType(),
                         ,

                 );*/

                Direct_message2 dm2 = new Direct_message2("agapito contestam",LoginActivity.AllProfiles.get(17),LoginActivity.userProfile2,500);



                RestAPIManager.getInstance().PostDirectMessage(dm2,getApiCall());

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

    private ChatroomAPICallBack getApiCall(){

        return this;
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
    public void onGetDirectMessage(ArrayList<Direct_Message> messages) {

        MainMenuActivity.dmessage=messages;


    }

    @Override
    public void onPostDirectMessage() {

        RestAPIManager.getInstance().getDirectMessage(this);


    }
}
