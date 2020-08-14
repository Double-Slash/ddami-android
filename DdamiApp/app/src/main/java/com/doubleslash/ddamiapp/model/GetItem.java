package com.doubleslash.ddamiapp.model;

import java.util.ArrayList;

public class GetItem {
    String image;
    String piece_name;
    String user_univ;
    String piece_price;
    String piece_date;
    String deal_state;
    ArrayList<String> getItemArrayList;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPiece_name() {
        return piece_name;
    }

    public void setPiece_name(String piece_name) {
        this.piece_name = piece_name;
    }

    public String getUser_univ() {
        return user_univ;
    }

    public void setUser_univ(String user_univ) {
        this.user_univ = user_univ;
    }

    public String getPiece_price() {
        return piece_price;
    }

    public void setPiece_price(String piece_price) {
        this.piece_price = piece_price;
    }

    public String getPiece_date() {
        return piece_date;
    }

    public void setPiece_date(String piece_date) {
        this.piece_date = piece_date;
    }

    public String getDeal_state() {
        return deal_state;
    }

    public void setDeal_state(String deal_state) {
        this.deal_state = deal_state;
    }

    public ArrayList<String> getGetItemArrayList() {
        return getItemArrayList;
    }

    public void setGetItemArrayList(ArrayList<String> getItemArrayList) {
        this.getItemArrayList = getItemArrayList;
    }

    public GetItem(String image, String piece_name, String user_univ
    ) {
        this.image = image;
        this.piece_name = piece_name;
        this.user_univ = user_univ;
        this.piece_price = piece_price;
        this.piece_date = piece_date;
        this.deal_state = deal_state;
    }
}
