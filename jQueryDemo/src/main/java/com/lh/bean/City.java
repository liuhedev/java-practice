package com.lh.bean;

/**
 * @author liuhe
 * @date 2020/03/17
 */
public class City {
    private static final String TAG = "City";

    private int id;
    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public City() {
    }
}