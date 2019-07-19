package com.alfredo.android.a21pointsandroid.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.UserAPICallBack;

public class MainMenuActivity extends AppCompatActivity implements UserAPICallBack {

    private String token;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        this.token = getIntent().getStringExtra("token");

        RestAPIManager.getInstance().getUserAccount(this, token);


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
}