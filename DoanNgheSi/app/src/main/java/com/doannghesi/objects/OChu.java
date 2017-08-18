package com.doannghesi.objects;

/**
 * Created by Peih Gnaoh on 8/9/2017.
 */

public class OChu {
   private String text ;
    private int position;

    public OChu(String text, int position) {
        this.text = text;
        this.position = position;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
