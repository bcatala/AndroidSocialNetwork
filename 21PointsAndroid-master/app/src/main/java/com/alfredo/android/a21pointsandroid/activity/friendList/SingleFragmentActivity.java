package com.alfredo.android.a21pointsandroid.activity.friendList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
<<<<<<< Updated upstream

import com.alfredo.android.a21pointsandroid.R;
=======
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.AuxActivity;
import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.MainMenuActivity;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity2;
import com.alfredo.android.a21pointsandroid.activity.ProfileActivity3;
import com.alfredo.android.a21pointsandroid.activity.SearchUserActivity;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.UserAPICallBack;
>>>>>>> Stashed changes

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
<<<<<<< Updated upstream
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlist_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
=======

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_friendlist_fragment);



         a2=SingleFragmentActivity.this;





            Button messages = (Button) findViewById(R.id.message_button);
        Profile_to_search = (EditText) findViewById(R.id.Profile_to_search);
            messages.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    setLogin(Profile_to_search.getText().toString());
                    Profile_to_search = (EditText) findViewById(R.id.Profile_to_search);
                    LoginActivity.profil = 0;
                    String display_name = Profile_to_search.getText().toString();

                    if ( userProfileFound( display_name ) == -1 ) {
                        Toast.makeText(SingleFragmentActivity.this, "User not found!",Toast.LENGTH_LONG).show();
                    } else {

                    Intent i = new Intent(SingleFragmentActivity.this, ProfileActivity3.class);
                    i.putExtra("login", login);
                    startActivity(i);

                    }

                    //mInviteButton.setText("INVITE");
                    // RestAPIManager.getInstance().searchUser(getContex(), LoginActivity.token, Profile_to_search.getText().toString());
                    //RestAPIManager.getInstance().searchAllUserProfiles(getContext(), LoginActivity.token);
                }

            });

           Button mfriendButton = (Button) findViewById(R.id.corazon_buto);
            mfriendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    LoginActivity.profil = 1;
                    Intent i = new Intent(SingleFragmentActivity.this, AuxActivity.class);
                    i.putExtra("a", 1);


                    startActivity(i);
                }
            });

        Button mPerfil = (Button) findViewById(R.id.perfil_butto);
        mPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(SingleFragmentActivity.this, ProfileActivity2.class);

                startActivity(i);
            }
        });

            Button mallusersButton = (Button) findViewById(R.id.home_butto);
            mallusersButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    LoginActivity.profil = 0;
                    Intent i2 = new Intent(SingleFragmentActivity.this, AuxActivity.class);
                    i2.putExtra("a", 0);


                    startActivity(i2);
                }
            });

            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.fragment_container);

            if (fragment == null) {
                fragment = createFragment();
                fm.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();
            }

    }

    private int userProfileFound(String display_name){
        int found = -1;
        boolean ok = false;

        for ( int i = 0; i < LoginActivity.AllProfiles.size() && !ok; i++ ){
            if ( display_name.equals(LoginActivity.AllProfiles.get(i).getDisplayName()) ){
                found = i;
                ok = true;
            }
        }

        return found;
    }

    public  SingleFragmentActivity a(){

        SingleFragmentActivity a2=SingleFragmentActivity.this;

        return a2;
    }


    private void setLogin(String login) {
        this.login = login;
    }
    private UserAPICallBack getContex() {
        return this;
    }
    @Override
    public void onGetUserInfo(User user) {

    }

    @Override
    public void onGetUser(User body) {
        this.user = body;

        Intent i = new Intent(SingleFragmentActivity.this, LoginActivity.class);

        startActivity(i);
    }

    @Override
    public void onGetAllUsers(ArrayList<User> body) {

    }

    @Override
    public void onUserFound(User body) {

    }

    @Override
    public void onUserProfileFound(UserProfile body) {

    }

    @Override
    public void onGetAllUserProfiles(ArrayList<UserProfile> body) {

    }

    @Override
    public void onFailure(Throwable t) {

>>>>>>> Stashed changes
    }
}
