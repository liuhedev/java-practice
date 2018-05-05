package com.lh;

/**
 * Created by liuhe on 2018/5/5.
 */
public class Function {

    int var = 10;

    void test1() {
        var = 100;
        System.out.println("test1:var=" + var);
    }

    void test2() {
        System.out.println("test2:var=" + var);
    }
}
