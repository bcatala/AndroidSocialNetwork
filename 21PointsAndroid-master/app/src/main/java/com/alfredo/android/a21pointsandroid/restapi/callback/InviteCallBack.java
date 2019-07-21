package com.alfredo.android.a21pointsandroid.restapi.callback;

import com.alfredo.android.a21pointsandroid.model.Invitation;

import java.util.ArrayList;

public interface InviteCallBack {
    void onGetInvitation(Invitation body);
    void onReciveInvitations(ArrayList<Invitation> body);
    void onFailure(Throwable t);
}
