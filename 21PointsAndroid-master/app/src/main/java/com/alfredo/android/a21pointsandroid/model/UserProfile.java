package com.alfredo.android.a21pointsandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfile {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("birthDate")
    @Expose
    private Object birthDate;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("pictureContentType")
    @Expose
    private Object pictureContentType;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("unitSystem")
    @Expose
    private String unitSystem;
    @SerializedName("aboutMe")
    @Expose
    private Object aboutMe;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("showAge")
    @Expose
    private Boolean showAge;
    @SerializedName("banned")
    @Expose
    private Boolean banned;
    @SerializedName("filterPreferences")
    @Expose
    private Object filterPreferences;
    @SerializedName("location")
    @Expose
    private Object location;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("relationship")
    @Expose
    private Object relationship;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("ethnicity")
    @Expose
    private Object ethnicity;
    @SerializedName("sentInvitations")
    @Expose
    private Object sentInvitations;
    @SerializedName("receivedInvitations")
    @Expose
    private Object receivedInvitations;
    @SerializedName("sentBlocks")
    @Expose
    private Object sentBlocks;
    @SerializedName("receivedBlocks")
    @Expose
    private Object receivedBlocks;
    @SerializedName("sentMessages")
    @Expose
    private Object sentMessages;
    @SerializedName("sentDirectMessages")
    @Expose
    private Object sentDirectMessages;
    @SerializedName("receivedDirectMessages")
    @Expose
    private Object receivedDirectMessages;
    @SerializedName("adminChatrooms")
    @Expose
    private Object adminChatrooms;

    public UserProfile(Integer id, String picture, Integer height, Integer weight) {
        this.id = id;
        this.picture = picture;
        this.height = height;
        this.weight = weight;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Object birthDate) {
        this.birthDate = birthDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Object getPictureContentType() {
        return pictureContentType;
    }

    public void setPictureContentType(Object pictureContentType) {
        this.pictureContentType = pictureContentType;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getUnitSystem() {
        return unitSystem;
    }

    public void setUnitSystem(String unitSystem) {
        this.unitSystem = unitSystem;
    }

    public Object getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(Object aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Boolean getShowAge() {
        return showAge;
    }

    public void setShowAge(Boolean showAge) {
        this.showAge = showAge;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public Object getFilterPreferences() {
        return filterPreferences;
    }

    public void setFilterPreferences(Object filterPreferences) {
        this.filterPreferences = filterPreferences;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Object getRelationship() {
        return relationship;
    }

    public void setRelationship(Object relationship) {
        this.relationship = relationship;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Object ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Object getSentInvitations() {
        return sentInvitations;
    }

    public void setSentInvitations(Object sentInvitations) {
        this.sentInvitations = sentInvitations;
    }

    public Object getReceivedInvitations() {
        return receivedInvitations;
    }

    public void setReceivedInvitations(Object receivedInvitations) {
        this.receivedInvitations = receivedInvitations;
    }

    public Object getSentBlocks() {
        return sentBlocks;
    }

    public void setSentBlocks(Object sentBlocks) {
        this.sentBlocks = sentBlocks;
    }

    public Object getReceivedBlocks() {
        return receivedBlocks;
    }

    public void setReceivedBlocks(Object receivedBlocks) {
        this.receivedBlocks = receivedBlocks;
    }

    public Object getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(Object sentMessages) {
        this.sentMessages = sentMessages;
    }

    public Object getSentDirectMessages() {
        return sentDirectMessages;
    }

    public void setSentDirectMessages(Object sentDirectMessages) {
        this.sentDirectMessages = sentDirectMessages;
    }

    public Object getReceivedDirectMessages() {
        return receivedDirectMessages;
    }

    public void setReceivedDirectMessages(Object receivedDirectMessages) {
        this.receivedDirectMessages = receivedDirectMessages;
    }

    public Object getAdminChatrooms() {
        return adminChatrooms;
    }

    public void setAdminChatrooms(Object adminChatrooms) {
        this.adminChatrooms = adminChatrooms;
    }


}