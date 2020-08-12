package com.doubleslash.ddamiapp.model;


import java.util.List;

public class ShopWorkItem {

    List<String> mImageArr;
    String mWork;
    String mUniv;
    int mPrice;
    int mViews;
    int mLike;

    public ShopWorkItem(List<String> mImage, String mWork, String mUniv, int mPrice, int mViews, int mLike) {
        this.mImageArr = mImage;
        this.mWork = mWork;
        this.mUniv = mUniv;
        this.mPrice = mPrice;
        this.mViews=mViews;
        this.mLike=mLike;
    }

    public List<String> getmImageArr() {
        return mImageArr;
    }

    public void setmImageArr(List<String> mImageArr) {
        this.mImageArr = mImageArr;
    }

    public String getmWork() {
        return mWork;
    }

    public void setmWork(String mWork) {
        this.mWork = mWork;
    }

    public String getmUniv() {
        return mUniv;
    }

    public void setmUniv(String mUniv) {
        this.mUniv = mUniv;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public int getmViews() {
        return mViews;
    }

    public void setmViews(int mViews) {
        this.mViews = mViews;
    }

    public int getmLike() {
        return mLike;
    }

    public void setmLike(int mLike) {
        this.mLike = mLike;
    }
}
