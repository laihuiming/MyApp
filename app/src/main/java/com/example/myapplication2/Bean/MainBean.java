package com.example.myapplication2.Bean;

public class MainBean {
    public String title;

    public String path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MainBean(String title) {
        this.title = title;
    }

    public MainBean(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MainBean() {
    }
}
