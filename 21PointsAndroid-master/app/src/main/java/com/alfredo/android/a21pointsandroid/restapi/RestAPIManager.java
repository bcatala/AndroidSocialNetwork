package com.alfredo.android.a21pointsandroid.restapi;

import com.alfredo.android.a21pointsandroid.activity.LoginActivity;
import com.alfredo.android.a21pointsandroid.activity.chatroom.Chatroom;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Direct_Message;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.PageConfiguration;
import com.alfredo.android.a21pointsandroid.model.Invitation;
import com.alfredo.android.a21pointsandroid.model.Points;
import com.alfredo.android.a21pointsandroid.model.User;
import com.alfredo.android.a21pointsandroid.model.UserProfile;
import com.alfredo.android.a21pointsandroid.model.UserProfile2;
import com.alfredo.android.a21pointsandroid.restapi.callback.ChatroomAPICallBack;
import com.alfredo.android.a21pointsandroid.restapi.callback.InviteCallBack;
import com.alfredo.android.a21pointsandroid.restapi.callback.MyFriendsAPICallBack;
import com.alfredo.android.a21pointsandroid.restapi.callback.ProfileAPICallback;
import com.alfredo.android.a21pointsandroid.restapi.callback.RegisterAPICallback;
import com.alfredo.android.a21pointsandroid.model.UserData;
import com.alfredo.android.a21pointsandroid.model.UserToken;
import com.alfredo.android.a21pointsandroid.restapi.callback.LoginAPICallBack;
import com.alfredo.android.a21pointsandroid.restapi.callback.PointsAPICallBack;
import com.alfredo.android.a21pointsandroid.restapi.callback.UserAPICallBack;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPIManager {

    //private static final String BASE_URL = "http://" + "your_ip:8080/";
    private static final String BASE_URL = "http://android3.byted.xyz/";
    private static RestAPIManager ourInstance;
    private Retrofit retrofit;
    private RestAPIService restApiService;
    private UserToken userToken;


    public static RestAPIManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new RestAPIManager();
        }
        return ourInstance;
    }

    private RestAPIManager() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        restApiService = retrofit.create(RestAPIService.class);

    }

    public synchronized void getUserToken(String username, String password, final LoginAPICallBack restAPICallBack) {
        UserData userData = new UserData(username, password);
        Call<UserToken> call = restApiService.requestToken(userData);

        call.enqueue(new Callback<UserToken>() {
            @Override
            public void onResponse(Call<UserToken> call, Response<UserToken> response) {

                if (response.isSuccessful()) {
                    userToken = response.body();
                    restAPICallBack.onLoginSuccess(userToken);
                } else {
                    restAPICallBack.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserToken> call, Throwable t) {
                restAPICallBack.onFailure(t);
            }
        });
    }

    public synchronized void register(String username, String email, String password, final RegisterAPICallback registerAPICallback) {
        UserData userData = new UserData(username, email, password);
        Call<Void> call = restApiService.register(userData);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if (response.isSuccessful()) {
                    registerAPICallback.onSuccess();
                } else {
                    registerAPICallback.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                registerAPICallback.onFailure(t);
            }
        });
    }

    public synchronized void getUserAccount(final UserAPICallBack userAPICallBack, String token) {
        User user = new User();
        Call<User> call = restApiService.getUserAccount("Bearer " + token);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()) {
                    userAPICallBack.onGetUser(response.body());

                } else {
                    userAPICallBack.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                userAPICallBack.onFailure(t);
            }
        });
    }

    public synchronized void getCurrentUserProfile(final ProfileAPICallback profileAPICallback, String token) {

        Call<UserProfile2> call = restApiService.getCurrentUserProfile("Bearer " + token);

        call.enqueue(new Callback<UserProfile2>() {
            @Override
            public void onResponse(Call<UserProfile2> call, Response<UserProfile2> response) {
                int a = 1;
                if (response.isSuccessful()) {
                    profileAPICallback.onGetCurrentProfile(response.body());
                } else {
                   profileAPICallback.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserProfile2> call, Throwable t) {
                profileAPICallback.onFailure(t);
            }
        });
    }

    public synchronized void getAllUsers(final UserAPICallBack userAPICallBack, String token){
        Call<ArrayList<User>> call = restApiService.getAllUsers("Bearer " + token);
        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {

                if (response.isSuccessful()) {
                    userAPICallBack.onGetAllUsers(response.body());

                } else {
                    userAPICallBack.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                userAPICallBack.onFailure(t);
            }
        });
    }

    public synchronized void getFriends(final MyFriendsAPICallBack myFriendsAPICallBack, String token){
        Call<ArrayList<UserProfile>> call = restApiService.getFriends("Bearer " + token);
        call.enqueue(new Callback<ArrayList<UserProfile>>() {
            @Override
            public void onResponse(Call<ArrayList<UserProfile>> call, Response<ArrayList<UserProfile>> response) {

                if (response.isSuccessful()) {
                    myFriendsAPICallBack.onGetFriends(response.body());

                } else {
                    myFriendsAPICallBack.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UserProfile>> call, Throwable t) {
                myFriendsAPICallBack.onFailure(t);
            }
        });
    }

    public synchronized void searchUser(final UserAPICallBack userAPICallBack, String token, String login) {

        Call<User> call = restApiService.searchUser(login,"Bearer " + token);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()) {
                    userAPICallBack.onUserFound(response.body());

                } else {
                    userAPICallBack.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                userAPICallBack.onFailure(t);
            }
        });
    }

   /* public synchronized void searchUserProfile(final UserAPICallBack userAPICallBack, String token, Integer id) {

        Call<UserProfile> call = restApiService.searchUserProfile(id,"Bearer " + token);
        call.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {

                if (response.isSuccessful()) {
                    userAPICallBack.onUserProfileFound(response.body());

                } else {
                    userAPICallBack.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {
                userAPICallBack.onFailure(t);
            }
        });
    }*/

    public synchronized void searchAllUserProfiles(final UserAPICallBack usersAPICallBack, String token){
        Call<ArrayList<UserProfile>> call = restApiService.searchAllUserProfiles("Bearer " + token);
        call.enqueue(new Callback<ArrayList<UserProfile>>() {
            @Override
            public void onResponse(Call<ArrayList<UserProfile>> call, Response<ArrayList<UserProfile>> response) {

                if (response.isSuccessful()) {
                    usersAPICallBack.onGetAllUserProfiles(response.body());

                } else {
                    usersAPICallBack.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UserProfile>> call, Throwable t) {
                usersAPICallBack.onFailure(t);
            }
        });
    }

    public synchronized void inviteUser(final InviteCallBack inviteCallBack, int id) {
        Call<Invitation> call = restApiService.inviteUser(id, "Bearer " + LoginActivity.token);

        call.enqueue(new Callback<Invitation>() {
            @Override
            public void onResponse(Call<Invitation> call, Response<Invitation> response) {
                if (response.isSuccessful()) {
                    inviteCallBack.onGetInvitation(response.body());
                } else {
                    System.out.println(response.toString());
                    System.out.println(response.body());
                    inviteCallBack.onFailure((new Throwable("ERROR " + response.code() + ", " + response.raw().message())));
                }
            }

            @Override
            public void onFailure(Call<Invitation> call, Throwable t) {
                inviteCallBack.onFailure(t);
            }
        });
    }

    public synchronized void getAllInvitations(final InviteCallBack inviteCallBack) {
        Call<ArrayList<Invitation>> call = restApiService.getAllInvitations( "Bearer " + LoginActivity.token);

        call.enqueue(new Callback<ArrayList<Invitation>>() {
            @Override
            public void onResponse(Call<ArrayList<Invitation>> call, Response<ArrayList<Invitation>> response) {
                if (response.isSuccessful()) {
                    inviteCallBack.onReciveInvitations(response.body());
                } else {
                    System.out.println(response.toString());
                    System.out.println(response.body());
                    inviteCallBack.onFailure((new Throwable("ERROR " + response.code() + ", " + response.raw().message())));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Invitation>> call, Throwable t) {
                inviteCallBack.onFailure(t);
            }
        });
    }

    public synchronized void getChatrooms(final ChatroomAPICallBack chatroomAPICallBack) {
        Call<ArrayList<Chatroom>> call = restApiService.getChatrooms( "Bearer " + LoginActivity.token);

        call.enqueue(new Callback<ArrayList<Chatroom>>() {
            @Override
            public void onResponse(Call<ArrayList<Chatroom>> call, Response<ArrayList<Chatroom>> response) {
                if (response.isSuccessful()) {
                    chatroomAPICallBack.onGetChatrooms(response.body());
                } else {
                    chatroomAPICallBack.onFailure((new Throwable("ERROR " + response.code() + ", " + response.raw().message())));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Chatroom>> call, Throwable t) {
                chatroomAPICallBack.onFailure(t);
            }
        });
    }

    public synchronized void getMessages(final ChatroomAPICallBack chatroomAPICallBack, int id) {
        Call<Chatroom> call = restApiService.getMessages(id, "Bearer " + LoginActivity.token);

        call.enqueue(new Callback<Chatroom>() {
            @Override
            public void onResponse(Call<Chatroom> call, Response<Chatroom> response) {
                if (response.isSuccessful()) {
                    chatroomAPICallBack.onGetMessages(response.body());
                } else {
                    chatroomAPICallBack.onFailure((new Throwable("ERROR " + response.code() + ", " + response.raw().message())));
                }
            }

            @Override
            public void onFailure(Call<Chatroom> call, Throwable t) {
                chatroomAPICallBack.onFailure(t);
            }
        });
    }

    public synchronized void getDirectMessage(final ChatroomAPICallBack chatroomAPICallBack) {
        Call<ArrayList<Direct_Message>> call = restApiService.getDirectMessage("Bearer " + LoginActivity.token);

        call.enqueue(new Callback<ArrayList<Direct_Message>>() {
            @Override
            public void onResponse(Call<ArrayList<Direct_Message>> call, Response<ArrayList<Direct_Message>> response) {
                if (response.isSuccessful()) {
                    chatroomAPICallBack.onGetDirectMessage(response.body());
                } else {
                    chatroomAPICallBack.onFailure((new Throwable("ERROR " + response.code() + ", " + response.raw().message())));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Direct_Message>> call, Throwable t) {
                chatroomAPICallBack.onFailure(t);
            }
        });
    }
}