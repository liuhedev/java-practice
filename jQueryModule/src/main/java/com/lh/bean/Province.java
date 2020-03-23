package com.lh.bean;

/**
 * @author liuhe
 * @date 2020/03/17
 */
public class Province {

    private int id; //省份的编号
    private String name; //名字

    public Province() {
    }

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

    public Province(int id, String name) {
        this.id = id;
        this.name = name;
    }
}