package com.alfredo.android.a21pointsandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.model.Invitation;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.InviteCallBack;

import java.util.ArrayList;


public class InvitationActivity extends AppCompatActivity implements InviteCallBack {

    private TextView mInvitationCard;
    private Button mPreviousButton, mNextButton;
    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitations);

        //RestAPIManager.getInstance().getAllInvitations(getContext());

        mPreviousButton = (Button) findViewById(R.id.previous_button);
        mNextButton = (Button) findViewById(R.id.next_button);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                if(i > -1){
                    mInvitationCard.setText(MainMenuActivity.receivedInvitations.get(i).getSent().getDisplayName()+ "us vol agregar");
                } else {
                    i += MainMenuActivity.receivedInvitations.size();
                    mInvitationCard.setText(MainMenuActivity.receivedInvitations.get(i).getSent().getDisplayName()+ "us vol agregar");
                }

            }
        });

        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if(i < MainMenuActivity.receivedInvitations.size()){
                    mInvitationCard.setText(MainMenuActivity.receivedInvitations.get(i).getSent().getDisplayName()+ "us vol agregar");
                } else {
                    i -= MainMenuActivity.receivedInvitations.size();
                    mInvitationCard.setText(MainMenuActivity.receivedInvitations.get(i).getSent().getDisplayName()+ "us vol agregar");
                }
            }
        });

        mInvitationCard = (TextView) findViewById(R.id.invitationCard);
        mInvitationCard.setText(MainMenuActivity.receivedInvitations.get(0).getSent().getDisplayName()+ "us vol agregar");
    }

    public InviteCallBack getContext(){
        return this;
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
