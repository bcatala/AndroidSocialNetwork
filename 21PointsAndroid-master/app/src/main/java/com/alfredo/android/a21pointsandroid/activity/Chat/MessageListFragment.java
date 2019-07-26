package com.alfredo.android.a21pointsandroid.activity.Chat;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity;
import com.alfredo.android.a21pointsandroid.activity.chatroom.Chatroom;
import com.alfredo.android.a21pointsandroid.activity.chatroom.ChatroomListFragment;
import com.alfredo.android.a21pointsandroid.activity.friendList.SingleFragmentActivity;
import com.alfredo.android.a21pointsandroid.model.UserProfile;


import java.util.ArrayList;
import java.util.List;

public class MessageListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private MessageAdapter mAdapter;
    public static UserProfile userProfile;
    public static List<Message> mMessages;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_list, container, false);

        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    public void updateUI() {

       // MessageLab messageLab = MessageLab.get(getActivity());
        mMessages =  new ArrayList<>();
         //mMessages = messageLab.getMessages();
        if(LoginActivity.profil2 == 0){

            mMessages =  new ArrayList<>();

        List<Message> mes = new ArrayList<>();
        int j=0;
        int id=0;
        while (j<LoginActivity.AllProfiles.size()){


            if(LoginActivity.AllProfiles.get(j).getUser().getLogin().equals(SingleFragmentActivity.myFriend.getUsername())) {

                id=j;

                userProfile=LoginActivity.AllProfiles.get(j);


            }
            j++;
        }
        if(MainMenuActivity.dmessage.size()!=0 || id!=0) {

            for (int i = 0; i < MainMenuActivity.dmessage.size(); i++) {
                Message m = new Message();

                if(LoginActivity.AllProfiles.get(id).getUser().getLogin().equals(
                        MainMenuActivity.dmessage.get(i).getSender().getUser().getLogin()) && LoginActivity.userProfile2.getUser().getLogin().equals(
                        MainMenuActivity.dmessage.get(i).getReciver().getUser().getLogin())) {

                    m.setMissatge(" TU: "+MainMenuActivity.dmessage.get(i).getMessage());
                    mes.add(m);
                    mMessages.add(m);
                }


                if(LoginActivity.AllProfiles.get(id).getUser().getLogin().equals(
                        MainMenuActivity.dmessage.get(i).getReciver().getUser().getLogin()) && LoginActivity.userProfile2.getUser().getLogin().equals(
                        MainMenuActivity.dmessage.get(i).getSender().getUser().getLogin())) {

                    m.setMissatge("\t\t\t"+LoginActivity.AllProfiles.get(id).getUser().getLogin()+"+: "+MainMenuActivity.dmessage.get(i).getMessage());
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

         }else{

            int id2=0;
            for(int aux=0;aux<MainMenuActivity.allChatrooms.size();aux++){

                if(ChatroomListFragment.a.getId().equals(MainMenuActivity.allChatrooms.get(aux).getId())){

                    id2=aux;

                }



            }

            //if(ChatroomListFragment.a.getMessages().size()!=0){
              // for(int j=0;j<ChatroomListFragment.a.getMessages().size();j++){

                    Message m = new Message();

                    //if(ChatroomListFragment.a.getMessages().get(j).getMessage() != null){
                    m.setMissatge(ChatroomListFragment.a.getTopic());

                    mMessages.add(m);


                //}else{



                    //}
             //  }
                if(mMessages.size()!=0){



                }else{

                    Message m2 = new Message();

                    m2.setMissatge("No te missatges2");
                    mMessages.add(m2);
                }
      //  }else{

        //    Message m = new Message();

        //    m.setMissatge("No te missatg");
         //   mMessages.add(m);

       // }

        }
        mAdapter = new MessageAdapter(mMessages);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    private class MessageHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Message mMessage;

        private TextView mMessageView;

        public MessageHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_message, parent, false));
            itemView.setOnClickListener(this);

            mMessageView = (TextView) itemView.findViewById(R.id.message_chat);
        }

        public void bind(Message message) {
            mMessage = message;
            mMessageView.setText(mMessage.getMissatge());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(),
                    mMessage.getMissatge() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {

        private List<Message> mMessages;

        public MessageAdapter(List<Message> messages) {
            mMessages = messages;
        }

        @Override
        public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new MessageHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(MessageHolder holder, int position) {
            Message message = mMessages.get(position);
            holder.bind(message);
        }

        @Override
        public int getItemCount() {
            return mMessages.size();
        }
    }
}
