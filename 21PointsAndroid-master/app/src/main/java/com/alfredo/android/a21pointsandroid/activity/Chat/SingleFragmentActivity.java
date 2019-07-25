package com.alfredo.android.a21pointsandroid.activity.Chat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_fragment);

        TextView UserChat = (TextView) findViewById(R.id.UserChat);
        UserChat.setText("User to chat-  :" + ProfileActivity.nomUser);

      // EditText PostMissatge= (EditText) findViewById(R.id.Profile_to_search2);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
