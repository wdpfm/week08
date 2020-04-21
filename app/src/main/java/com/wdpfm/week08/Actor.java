package com.wdpfm.week08;

import java.io.Serializable;

public class Actor implements Serializable {
    private String name;
    private String info;
    private int img;


    public Actor(String name, int img, String info) {
        this.name = name;
        this.info = info;
        this.img = img;
    }

    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String name) {
        this.info = info;
    }
}
