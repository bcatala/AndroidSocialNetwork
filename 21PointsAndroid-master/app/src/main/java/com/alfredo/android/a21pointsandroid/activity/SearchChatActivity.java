package com.alfredo.android.a21pointsandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.alfredo.android.a21pointsandroid.R;

public class SearchChatActivity extends Activity {
    private static int SPASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchrandom);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SearchChatActivity.this, InvitationActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPASH_TIME_OUT);
    }
}
