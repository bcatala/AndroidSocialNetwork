package com.alfredo.android.a21pointsandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_Message;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_message2;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.UserMessage;

import java.util.ArrayList;

public class DirectMessagesActivity extends AppCompatActivity {

    private TextView mDirectMessageCard, mUsernameMD;
    private Button mPreviousButton, mNextButton, mPreviousUserButoon, mNextUserButon;
    private int i;
    private int j;


    private ArrayList<Direct_message2> dms;
    private ArrayList<UserMessage> dataStructure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldirect_messages);

        this.dms = MainMenuActivity.dmessage;

        i = 0;
        j = 0;

        mPreviousButton = (Button) findViewById(R.id.previous_button_dm);
        mNextButton = (Button) findViewById(R.id.next_button_dm);

        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j--;
                if(j == -1){
                    j = dms.size()-1;
                    mDirectMessageCard.setText(dms.get(j).getSender().getDisplayName() + ": \n" + dms.get(j).getMessage());
                } else {
                    mDirectMessageCard.setText(dms.get(j).getSender().getDisplayName() + ": \n" + dms.get(j).getMessage());
                }
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j++;
                if(j > MainMenuActivity.dmessage.size()){
                    j = 0;
                    mDirectMessageCard.setText(dms.get(j).getSender().getDisplayName() + ": \n" + dms.get(j).getMessage());
                } else {
                    mDirectMessageCard.setText(dms.get(j).getSender().getDisplayName() + ": \n" + dms.get(j).getMessage());
                }
            }
        });

        mDirectMessageCard = (TextView) findViewById(R.id.directMessage_card);
        mDirectMessageCard.setText(MainMenuActivity.dmessage.get(i).getSender().getDisplayName()+ ": \n" + MainMenuActivity.dmessage.get(i).getMessage());
    }
}
