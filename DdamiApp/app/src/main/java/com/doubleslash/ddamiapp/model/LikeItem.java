package com.doubleslash.ddamiapp.model;

import java.util.ArrayList;

public class LikeItem {

    private int num;
    private String image;
    private String title;
    private String profile;
    private String nicname;
    private Boolean heart;
    private ArrayList<String> likelist;

    public LikeItem(String image, String title, String profile, String nicname) {
        this.image = image;
        this.title = title;
        this.profile = profile;
        this.nicname = nicname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNicname() {
        return nicname;
    }

    public void setNicname(String nicname) {
        this.nicname = nicname;
    }

    public Boolean getHeart() {
        return heart;
    }

    public void setHeart(Boolean heart) {
        this.heart = heart;
    }

    public ArrayList<String> getLikelist() {
        return likelist;
    }

    public void setLikelist(ArrayList<String> likelist) {
        this.likelist = likelist;
    }



    @Override
    public String toString() {
        return "ListVO{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", profile='" + profile + '\'' +
                ", nicname='" + nicname + '\'' +
                ", heart='" + heart + '\'' +
                ", likelist=" + likelist +
                '}';
    }
}