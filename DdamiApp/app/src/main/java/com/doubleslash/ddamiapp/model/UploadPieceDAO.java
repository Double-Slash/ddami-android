package com.doubleslash.ddamiapp.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UploadPieceDAO {
    String title;
    String content;
    ArrayList<String> hasField;

    public ArrayList<String> getHshField() {
        return hasField;
    }

    public void setHshField(ArrayList<String> hasField) {
        this.hasField = hasField;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UploadPieceDAO(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public UploadPieceDAO(String title, String content, ArrayList<String> hashField) {
        this.title = title;
        this.content = content;
        this.hasField = hashField;
    }
    public class UploadPieceResponse{
        int state;
        String message;

        public int getState() {
            return state;
        }

        public String getMessage() {
            return message;
        }
    }
}
