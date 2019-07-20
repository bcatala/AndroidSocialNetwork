package com.alfredo.android.a21pointsandroid.activity.friendList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alfredo.android.a21pointsandroid.model.User;

public class FriendListActivity extends SingleFragmentActivity {

    static User user;

    @Override
    protected Fragment createFragment() {
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        this.user = (User) bundle.getSerializable("user");

        return new FriendListFragment();
    }
}
