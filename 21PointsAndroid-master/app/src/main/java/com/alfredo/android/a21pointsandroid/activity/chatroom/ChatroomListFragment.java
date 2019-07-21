package com.alfredo.android.a21pointsandroid.activity.chatroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.InvitationActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_Message;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.ChatroomAPICallBack;

import java.util.ArrayList;
import java.util.List;

public class ChatroomListFragment extends Fragment {
    private RecyclerView mChatroomRecyclerView;
    private ChatroomAdapter mAdapter;
    public static ArrayList<Message> allInnerMessages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chatroom_list, container, false);

        mChatroomRecyclerView = (RecyclerView) view
                .findViewById(R.id.chatroom_recycler_view);
        mChatroomRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        ChatroomLab chatroomLab = ChatroomLab.get(getActivity());
        List<Chatroom> chatrooms = chatroomLab.getChatrooms();

        mAdapter = new ChatroomAdapter(chatrooms);
        mChatroomRecyclerView.setAdapter(mAdapter);
    }

    private class ChatroomHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, ChatroomAPICallBack {

        private Chatroom mChatroom;

        private TextView mTitleTextView;
        private TextView mDateTextView;

        public ChatroomHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_chatroom, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.username_chat);
            mDateTextView = (TextView) itemView.findViewById(R.id.date_chat);
        }

        public void bind(Chatroom chatroom) {
            mChatroom = chatroom;
            mTitleTextView.setText(mChatroom.getTopic());
            mDateTextView.setText(mChatroom.getCreatedDate().toString());
        }

        @Override
        public void onClick(View view) {
            RestAPIManager.getInstance().getMessages(getContext(), mChatroom.getId());
            //
        }

        public ChatroomAPICallBack getContext(){
            return this;
        }

        @Override
        public void onGetChatrooms(ArrayList<Chatroom> body) {

        }

        @Override
        public void onGetMessages(Chatroom body) {
            Toast.makeText(getActivity(),
                    mChatroom.getId() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
            //START ACTIVITY CHAT RECYCLER VIEW
            allInnerMessages = body.getMessages();
        }

        public ChatroomListFragment.ChatroomHolder getContextFragment(){
            return this;
        }

        @Override
        public void onFailure(Throwable t) {

        }

        @Override
        public void onGetDirectMessage(ArrayList<Direct_Message> messages) {

        }


    }

    private class ChatroomAdapter extends RecyclerView.Adapter<ChatroomHolder> {

        private List<Chatroom> mChatrooms;

        public ChatroomAdapter(List<Chatroom> chatrooms) {
            mChatrooms = chatrooms;
        }

        @Override
        public ChatroomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ChatroomHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ChatroomHolder holder, int position) {
            Chatroom chatroom = mChatrooms.get(position);
            holder.bind(chatroom);
        }

        @Override
        public int getItemCount() {
            return mChatrooms.size();
        }
    }
}
