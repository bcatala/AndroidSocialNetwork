package com.alfredo.android.a21pointsandroid.activity.friendList;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;

import java.util.List;

public class FriendListFragment extends Fragment {
    private RecyclerView mFriendRecyclerView;
    private FriendAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);

        mFriendRecyclerView = (RecyclerView) view
                .findViewById(R.id.friend_recycler_view);
        mFriendRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();




        return view;
    }


    private void updateUI() {
         FriendLab friendLab = FriendLab.get(getActivity());
        List<Friend> friends = friendLab.getFriends();

        mAdapter = new FriendAdapter(friends);
        mFriendRecyclerView.setAdapter(mAdapter);
    }

    private class FriendHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Friend mFriend;
       // private Button mButton;

        private TextView mUsernameTextView;
        private TextView mEmailTextView;

        public FriendHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_user, parent, false));
            itemView.setOnClickListener(this);

            mUsernameTextView = (TextView) itemView.findViewById(R.id.friend_username);
            mEmailTextView = (TextView) itemView.findViewById(R.id.friend_email);
        }

        public void bind(Friend friend) {
            mFriend = friend;
            mUsernameTextView.setText(mFriend.getUsername());
            mEmailTextView.setText(mFriend.getEmail());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mFriend.getUsername() + " clicked!", Toast.LENGTH_SHORT).show();
            //mButton = (Button) view.findViewById(R.id.go_profile_user);
        }
    }

    private class FriendAdapter extends RecyclerView.Adapter<FriendHolder> {

        private List<Friend> mFriends;

        public FriendAdapter(List<Friend> friends) {
            mFriends = friends;
        }

        @Override
        public FriendHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new FriendHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(FriendHolder holder, int position) {
            Friend friend = mFriends.get(position);
            holder.bind(friend);
        }

        @Override
        public int getItemCount() {
            return mFriends.size();
        }
    }
}
