package com.s.machinetestui;

public class MenuItem {
    String title;
    boolean isChecked;

    public MenuItem() {
    }

    public MenuItem(String title, boolean isChecked) {
        this.title = title;
        this.isChecked = isChecked;
    }

    public MenuItem(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public String getTitle() {
        return title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
