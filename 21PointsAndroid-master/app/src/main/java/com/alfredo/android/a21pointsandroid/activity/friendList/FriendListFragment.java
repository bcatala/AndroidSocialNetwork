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
import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity;
import com.alfredo.android.a21pointsandroid.activity.SearchChatActivity;
import com.alfredo.android.a21pointsandroid.activity.SearchUserActivity;

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
         if(LoginActivity.profil==1) {
             FriendLab friendLab = FriendLab.get(getActivity());
             List<Friend> friends = friendLab.getFriends();

             mAdapter = new FriendAdapter(friends);
             mFriendRecyclerView.setAdapter(mAdapter);
         }else{
             FriendLabAll friendLab = FriendLabAll.get(getActivity());
             List<Friend> friends = friendLab.getFriends();

             mAdapter = new FriendAdapter(friends);
             mFriendRecyclerView.setAdapter(mAdapter);

         }
    }

    private class FriendHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Friend misFriend;
        public  Button mButton;

        public TextView mUsernameTextView;
        public TextView mEmailTextView;
        public TextView maboutme;

        public FriendHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_user, parent, false));
            itemView.setOnClickListener(this);

            mUsernameTextView = (TextView) itemView.findViewById(R.id.friend_username2);
            mEmailTextView = (TextView) itemView.findViewById(R.id.femail);
            maboutme = (TextView) itemView.findViewById(R.id.frase_abautme3);
            mButton = (Button) itemView.findViewById(R.id.XAT);
        }

        public void bind(Friend friend) {
            misFriend = friend;
            mUsernameTextView.setText(friend.getUsername());

            int a=0;
            mEmailTextView.setText(friend.getEmail());
            maboutme.setText(friend.getAboutme());

        }
        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), misFriend.getUsername() + " clicked!", Toast.LENGTH_SHORT).show();
            //mButton = (Button) view.findViewById(R.id.go_profile_user);
            SingleFragmentActivity.surt=1;
            SingleFragmentActivity.myFriend=misFriend;

            Intent i = new Intent(SingleFragmentActivity.a2, ProfileActivity.class);
            startActivity(i);
            //aqui pica un user




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
