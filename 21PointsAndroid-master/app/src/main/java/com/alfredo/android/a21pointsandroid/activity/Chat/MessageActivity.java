package com.alfredo.android.a21pointsandroid.activity.Chat;

import android.support.v4.app.Fragment;

public class MessageActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MessageFragment();
    }
}
