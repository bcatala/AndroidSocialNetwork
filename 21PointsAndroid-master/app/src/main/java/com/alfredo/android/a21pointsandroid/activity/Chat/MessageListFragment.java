package com.alfredo.android.a21pointsandroid.activity.Chat;

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
import com.alfredo.android.a21pointsandroid.activity.chatroom.Message;

import java.util.List;

public class MessageListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private MessageAdapter mAdapter;

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

    private void updateUI() {
        MessageLab messageLab = MessageLab.get(getActivity());
        List<Message> messages = messageLab.getMessages();

        mAdapter = new MessageAdapter(messages);
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
            mMessageView.setText(mMessage.getMessage());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(),
                    mMessage.getMessage() + " clicked!", Toast.LENGTH_SHORT)
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
