package com.alfredo.android.a21pointsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.friendList.FriendListActivity;

public class AuxActivity extends AppCompatActivity {


        private Button gotoMenu;
        private String a;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_aux);

            gotoMenu = (Button) findViewById(R.id.GotoMenu2);

            a = getIntent().getStringExtra("a");;



            gotoMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(AuxActivity.this, FriendListActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", MainMenuActivity.user);
                    i.putExtras(bundle);

                    startActivity(i);
                }
            });
        }
    }

