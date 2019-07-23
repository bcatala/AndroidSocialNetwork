package com.alfredo.android.a21pointsandroid.model;

import java.io.Serializable;
import java.util.List;

import com.alfredo.android.a21pointsandroid.activity.chatroom.Chatroom;
import com.alfredo.android.a21pointsandroid.activity.chatroom.Location;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Block;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Ethnicity;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Gender;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.MessageSent;
import com.alfredo.android.a21pointsandroid.model.AuxiliarClass.Relationship;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserProfile2 implements Serializable {

    @SerializedName("aboutMe")
    @Expose
    private String aboutMe;
    @SerializedName("adminChatrooms")
    @Expose
    private List<Chatroom> adminChatrooms = null;
    @SerializedName("banned")
    @Expose
    private Boolean banned;
    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("ethnicity")
    @Expose
    private Ethnicity ethnicity;
    @SerializedName("filterPreferences")
    @Expose
    private String filterPreferences;
    @SerializedName("gender")
    @Expose
    private Gender gender;
    @SerializedName("height")
    @Expose
    private float height;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("pictureContentType")
    @Expose
    private String pictureContentType;
    @SerializedName("receivedBlocks")
    @Expose
    private List<Block> receivedBlocks = null;
    @SerializedName("receivedInvitations")
    @Expose
    private List<Invitation> receivedInvitations = null;
    @SerializedName("relationship")
    @Expose
    private Relationship relationship;
    @SerializedName("sentBlocks")
    @Expose
    private List<Block> sentBlocks = null;
    @SerializedName("sentInvitations")
    @Expose
    private List<Invitation> sentInvitations = null;
    @SerializedName("sentMessages")
    @Expose
    private List<MessageSent> sentMessages = null;
    @SerializedName("showAge")
    @Expose
    private Boolean showAge;
    @SerializedName("unitSystem")
    @Expose
    private String unitSystem;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("weight")
    @Expose
    private float weight;


    public UserProfile2(String displayName, Gender gender, String birthday) { this.gender = gender; this.birthDate = birthday; this.displayName = displayName;}

    public UserProfile2(String displayName, User user, int id) { this.id = id; this.user = user; this.displayName = displayName;}

    public UserProfile2(String aboutMe, String birthDate, String displayName, String picture, String pictureContentType) {
        this.aboutMe = aboutMe;
        this.birthDate = birthDate;
        this.displayName = displayName;
        this.picture = picture;
        this.pictureContentType = pictureContentType;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public List<Chatroom> getAdminChatrooms() {
        return adminChatrooms;
    }

    public void setAdminChatrooms(List<Chatroom> adminChatrooms) {
        this.adminChatrooms = adminChatrooms;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getFilterPreferences() {
        return filterPreferences;
    }

    public void setFilterPreferences(String filterPreferences) {
        this.filterPreferences = filterPreferences;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictureContentType() {
        return pictureContentType;
    }

    public void setPictureContentType(String pictureContentType) {
        this.pictureContentType = pictureContentType;
    }

    public List<Block> getReceivedBlocks() {
        return receivedBlocks;
    }

    public void setReceivedBlocks(List<Block> receivedBlocks) {
        this.receivedBlocks = receivedBlocks;
    }

    public List<Invitation> getReceivedInvitations() {
        return receivedInvitations;
    }

    public void setReceivedInvitations(List<Invitation> receivedInvitations) {
        this.receivedInvitations = receivedInvitations;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public List<Block> getSentBlocks() {
        return sentBlocks;
    }

    public void setSentBlocks(List<Block> sentBlocks) {
        this.sentBlocks = sentBlocks;
    }

    public List<Invitation> getSentInvitations() {
        return sentInvitations;
    }

    public void setSentInvitations(List<Invitation> sentInvitations) {
        this.sentInvitations = sentInvitations;
    }

    public List<MessageSent> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<MessageSent> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public Boolean getShowAge() {
        return showAge;
    }

    public void setShowAge(Boolean showAge) {
        this.showAge = showAge;
    }

    public String getUnitSystem() {
        return unitSystem;
    }

    public void setUnitSystem(String unitSystem) {
        this.unitSystem = unitSystem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String convertString() {
        return this.aboutMe + "/" + this.adminChatrooms + "/" + this.banned.toString() + "/" + this.birthDate + "/" +
                this.displayName + "/" + "ignore" + "/" + this.filterPreferences
                + "/" + this.gender + "/" + this.height + "/" + this.id.toString() + "/" + "ignore"
                + "/" + this.picture + "/" + this.pictureContentType + "/" + "ignore" + "/" + "ignore" + "/" + "ignore"
                + "/" + "ignore" + "/" + "ignore" + "/" + "ignore" + "/" + "ignore" + "/" + "ignore" + "/" + "ignore" + "/" + "ignore";
    }

}
