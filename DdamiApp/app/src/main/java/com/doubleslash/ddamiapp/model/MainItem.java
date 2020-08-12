package com.doubleslash.ddamiapp.model;

public class MainItem {
    private String image;
    private String title;
    private String nickname;
    private String thumbnail;
    private int viewCount;
    private int likeCount;

    public MainItem(String image, String title, String nickname, String thumbnail, int viewCount, int likeCount) {
        this.image = image;
        this.title = title;
        this.nickname = nickname;
        this.thumbnail = thumbnail;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
