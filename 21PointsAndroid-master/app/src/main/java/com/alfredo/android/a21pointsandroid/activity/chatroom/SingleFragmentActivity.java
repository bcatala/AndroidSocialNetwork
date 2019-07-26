package com.alfredo.android.a21pointsandroid.activity.chatroom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.alfredo.android.a21pointsandroid.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public static SingleFragmentActivity a2;

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allchatrooms_fragment);
        a2= SingleFragmentActivity.this;

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_chatroom);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_chatroom, fragment)
                    .commit();
        }
    }
}
