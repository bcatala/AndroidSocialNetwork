package com.alfredo.android.a21pointsandroid.activity.friendList;

import android.support.v4.app.Fragment;

public class FriendListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FriendListFragment();
    }
}
