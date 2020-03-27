package com.lh.jpa.entity;

import javax.persistence.*;

/**
 * @author liuhe
 * @date 2020/03/26
 */
@Entity(name = "t_sku_auto")
public class Sku {
    private int id;
    private String sku_name;

    private Spu spu;

    //表示多对一关系，optional=false表示外键不能为空
    @ManyToOne(optional = false)

    //这里指定spu_id , 表示生成的是外键名称叫做spu_id
    @JoinColumn(name = "spu_id")
    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }


    @GeneratedValue
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku_name() {
        return sku_name;
    }

    public void setSku_name(String sku_name) {
        this.sku_name = sku_name;
    }
}
