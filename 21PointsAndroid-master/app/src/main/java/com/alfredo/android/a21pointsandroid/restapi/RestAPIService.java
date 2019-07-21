package com.alfredo.android.a21pointsandroid.restapi;

import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.PageConfiguration;
import com.alfredo.android.a21pointsandroid.model.Invitation;
import com.alfredo.android.a21pointsandroid.model.Points;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserData;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.model.UserToken;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestAPIService {

    @POST("/api/authenticate")
    Call<UserToken> requestToken(@Body UserData userData);
    @POST("/api/register")
    Call<Void> register(@Body UserData userData);
    @GET("/api/account")
    Call<User> getUserInfo(@Header("Authorization") String token);
    @GET("/api/account")
    Call<User> getUserAccount(@Header("Authorization") String token);

    @GET("/api/users")
    Call<ArrayList<User>> getAllUsers(@Header("Authorization") String token);
    @GET("/api/my-friends")
    Call<ArrayList<UserProfile>> getFriends(@Header("Authorization") String token);
    @GET("/api/users/{login}")
    Call<User> searchUser(@Path("login") String login, @Header("Authorization") String token);
    @GET("/api/profiles/{id}")
    Call<UserProfile> searchUserProfile(@Path("id") Integer id, @Header("Authorization") String token);

    @GET("/api/profiles")
    Call<ArrayList<UserProfile>> searchAllUserProfiles(@Header("Authorization") String token);
    @POST("/api/invite/{userId}")
    Call<Invitation> inviteUser(@Path("userId") Integer userId, @Header("Authorization") String token);

    @GET("/api/invitations")
    Call<ArrayList<Invitation>> getAllInvitations(@Header("Authorization") String token);
}