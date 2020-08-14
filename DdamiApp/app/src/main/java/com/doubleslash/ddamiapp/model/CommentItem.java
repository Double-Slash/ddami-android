package com.doubleslash.ddamiapp.model;

public class CommentItem {

    private String profile;
    private String userId;
    private String content;
    private String date;

    public CommentItem(String profile, String userId, String content, String date) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date= date;
    }


}
