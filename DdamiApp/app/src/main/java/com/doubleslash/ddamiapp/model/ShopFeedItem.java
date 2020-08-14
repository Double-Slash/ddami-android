package com.doubleslash.ddamiapp.model;


import java.util.List;

public class ShopFeedItem {

    List<String> mImageArr;
    int state;

    public ShopFeedItem(List<String> mImageArr, int state) {
        this.mImageArr = mImageArr;
        this.state=state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<String> getmImageArr() {
        return mImageArr;
    }

    public void setmImageArr(List<String> mImageArr) {
        this.mImageArr = mImageArr;
    }


}
