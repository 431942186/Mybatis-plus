package com.example.ch01.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

//继承 Model 可用实体类自己引用数据库操作
public class Dept extends Model<Dept> {
    //    @TableId(value = "id", type = IdType.AUTO)
    //分布式id 雪花算法
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String mobile;
    private String manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
