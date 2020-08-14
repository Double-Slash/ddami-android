package com.doubleslash.ddamiapp.model;

import java.util.ArrayList;
import java.util.List;

public class UserRoomInfo {
    private String name;
    private String userid;
    private String program;
    private String field;
    private int followerNum;
    private int followingNum;
    private ArrayList<MyroomItem> file;
    private String profileImg;

    public UserRoomInfo(String name, String userid, String program, String field, int followingNum, int followerNum, ArrayList<MyroomItem> file, String profileImg) {
        this.name = name;
        this.userid = userid;
        this.program = program;
        this.field = field;
        this.followerNum = followerNum;
        this.followingNum = followingNum;
        this.file = file;
        this.profileImg = profileImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userid;
    }

    public void setUserId(String userid) {
        this.userid = userid;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getFollower() {
        return followerNum;
    }

    public void setFollower(int followerNum) {
        this.followerNum = followerNum;
    }

    public int getFollowing() {
        return followingNum;
    }

    public void setFollowing(int followingNum) {
        this.followingNum = followingNum;
    }

    public ArrayList<MyroomItem> getFile() {
        return file;
    }

    public void setFile(ArrayList<MyroomItem> file) {
        this.file = file;
    }

    public String getProfile() {
        return profileImg;
    }

    public void setProfile(String profileImg) {
        this.profileImg = profileImg;
    }


}
