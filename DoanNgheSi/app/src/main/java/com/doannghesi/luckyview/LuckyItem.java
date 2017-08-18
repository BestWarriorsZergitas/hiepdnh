package com.doannghesi.luckyview;

/**
 * Created by binhnk on 7/12/2017.
 */

public class LuckyItem {
    private String text;
    private int icon;
    private int color;

    public LuckyItem(String text, int icon, int color) {
        this.text = text;
        this.icon = icon;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
