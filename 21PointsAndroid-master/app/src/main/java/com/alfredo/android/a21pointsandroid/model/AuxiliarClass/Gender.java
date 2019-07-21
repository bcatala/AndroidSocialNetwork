package com.alfredo.android.a21pointsandroid.model.AuxiliarClass;


import java.util.List;

import com.alfredo.android.a21pointsandroid.model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gender {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("users")
    @Expose
    private List<User> users = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Gender(int id, String type) { this.id = id; this.type = type; }

}
