package com.alfredo.android.a21pointsandroid.restapi.callback;

import com.alfredo.android.a21pointsandroid.model.Invitation;

public interface InviteCallBack {
    void onGetInvitation(Invitation body);
    void onFailure(Throwable t);
}
