package com.alfredo.android.a21pointsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alfredo.android.a21pointsandroid.R;
import com.alfredo.android.a21pointsandroid.activity.friendList.DownloadImageTask;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserData;
import com.alfredo.android.a21pointsandroid.model.UserProfile2;
import com.alfredo.android.a21pointsandroid.restapi.RestAPIManager;
import com.alfredo.android.a21pointsandroid.restapi.callback.ProfileAPICallback;

public class ProfileActivity extends AppCompatActivity implements ProfileAPICallback {
    private Button GotoMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        TextView tvProfile = findViewById(R.id.profile_name);
        tvProfile.setText(getProfile().getDisplayName());

        TextView tvAboutMe = findViewById(R.id.about_me);
        tvAboutMe.setText(getProfile().getAboutMe());

        TextView tvBirthDate = findViewById(R.id.birth_date);
        tvBirthDate.setText(getProfile().getBirthDate());

        TextView tvIdProfile = findViewById(R.id.id_profile);
        tvIdProfile.setText(getProfile().getId().toString());

        /*new DownloadImageTask((ImageView) findViewById(R.id.imageView))
                .execute(getProfile().getPicture());*/

        /*mGotoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, MainActivity.class);
                i.putExtra("username",getIntent().getStringExtra("email"));
                i.putExtra("user", getIntent().getStringExtra("user"));
                startActivity(i);
            }

        });*/
    }

    @Override
    public void onGetCurrentProfile(UserProfile2 currentProfile) {

    }

    public UserProfile2 getProfile(){
        return LoginActivity.userProfile2;
    }

    @Override
    public void onFailure(Throwable t) {

    }
}

