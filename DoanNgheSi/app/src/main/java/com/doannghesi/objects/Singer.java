package com.doannghesi.objects;

import android.content.Context;
import android.database.Cursor;
import android.util.Base64;

/**
 * Created by Peih Gnaoh on 8/11/2017.
 */

public class Singer {
    private String fullName;
    private String nameAnswer;
    private String hint;
    private int img;


    public Singer(String fullName, String nameAnswer, String hint, int img) {
        this.fullName = fullName;
        this.nameAnswer = nameAnswer;
        this.hint = hint;
        this.img = img;
    }

    public Singer(Cursor cursor, Context context) {
        fullName=cursor.getString(1);
        hint=cursor.getString(2);
        nameAnswer=cursor.getString(3);
        img=cursor.getInt(4);

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNameAnswer() {
        return nameAnswer;
    }

    public void setNameAnswer(String nameAnswer) {
        this.nameAnswer = nameAnswer;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
