package com.alfredo.android.a21pointsandroid.activity.Chat;

import android.content.Context;

import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity;
import com.alfredo.android.a21pointsandroid.activity.friendList.SingleFragmentActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessageLab {
    private static MessageLab sMessageLab;

    private List<Message> mMessages;

    public static MessageLab get(Context context) {
        if (sMessageLab == null) {
            sMessageLab = new MessageLab(context);
        }


        return sMessageLab;
    }

    private MessageLab(Context context) {
        mMessages = new ArrayList<>();
        List<Message> mes = new ArrayList<>();
        int j=0;
        int id=0;
        while (j<LoginActivity.AllProfiles.size()){


            if(LoginActivity.AllProfiles.get(j).getUser().getLogin().equals(SingleFragmentActivity.myFriend.getUsername())) {

                id=j;




            }
            j++;
        }
        if(MainMenuActivity.dmessage.size()!=0 || id!=0) {

            for (int i = 0; i < MainMenuActivity.dmessage.size(); i++) {
                Message m = new Message();

              if(LoginActivity.AllProfiles.get(id).getUser().getLogin().equals(
                      MainMenuActivity.dmessage.get(i).getSender().getUser().getLogin())) {

                  m.setMissatge(LoginActivity.AllProfiles.get(id).getUser().getLogin()+": "+MainMenuActivity.dmessage.get(i).getMessage());
                  mes.add(m);
                  mMessages.add(m);
              }
                if(LoginActivity.AllProfiles.get(id).getUser().getLogin().equals(
                        MainMenuActivity.dmessage.get(i).getReciver().getUser().getLogin()) && LoginActivity.userProfile2.getUser().getLogin().equals(
                        MainMenuActivity.dmessage.get(i).getSender().getUser().getLogin())) {

                    m.setMissatge("\t\t\tTu"+": "+MainMenuActivity.dmessage.get(i).getMessage());
                    mes.add(m);
                    mMessages.add(m);
                }


            }
            if(mMessages.size()!=0){



            }else{

                Message m2 = new Message();

                m2.setMissatge("No te missatges2");
                mMessages.add(m2);
            }

        }else{

            Message m = new Message();

            m.setMissatge("No te missatges");
            mMessages.add(m);

        }
    }

    public List<Message> getMessages() {
        return mMessages;
    }

    public Message getCrime(UUID id) {
        for (Message message : mMessages) {
            if (message.getId().equals(id)) {
                return message;
            }
        }

        return null;
    }
}
