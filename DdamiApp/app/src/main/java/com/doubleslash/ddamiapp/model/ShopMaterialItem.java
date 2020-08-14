package com.doubleslash.ddamiapp.model;


import java.util.List;

public class ShopMaterialItem {

    List<String> mImageArr;
    //List<String> mHasField;
    String mMaterialTag;
    String mMaterial;
    String mUniv;
    int mPrice;
    int mViews;
    int mLike;

    public ShopMaterialItem(List<String> mImageArr, String materialTag, String mMaterial, String mUniv, int mPrice, int mViews, int mLike) {
        this.mImageArr = mImageArr;
        //this.mHasField = mHasField;
        this.mMaterialTag = materialTag;
        this.mMaterial = mMaterial;
        this.mUniv = mUniv;
        this.mPrice = mPrice;
        this.mViews = mViews;
        this.mLike = mLike;
    }

    public String getMaterialTag() {
        return mMaterialTag;
    }

    public void setMaterialTag(String materialTag) {
        this.mMaterialTag = materialTag;
    }

    public String getmMaterial() {
        return mMaterial;
    }

    public void setmMaterial(String mMaterial) {
        this.mMaterial = mMaterial;
    }
/*
    public List<String> getmHasField() {
        return mHasField;
    }

    public void setmHasField(List<String> mHasField) {
        this.mHasField = mHasField;
    }
*/
    public List<String> getmImageArr() {
        return mImageArr;
    }

    public void setmImageArr(List<String> mImageArr) {
        this.mImageArr = mImageArr;
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
