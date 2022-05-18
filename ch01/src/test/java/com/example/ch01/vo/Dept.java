package com.example.ch01.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

@TableName(value = "dept")
public class Dept extends Model<Dept> {
    //  @TableId(value = "id", type = IdType.AUTO)
//  数据库ID自增该类型请确保数据库设置了 ID自增 否则无效
//  @TableId(value = "id", type = IdType.ASSIGN_UUID)
//  分配UUID (主键类型为 string) 默认实现类 com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator(UUID.replace("-",""))
    @TableId(value = "id", type = IdType.ASSIGN_ID)
//  分配ID (主键类型为number或string）, 默认实现类 com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator(雪花算法)
    private Long id;
    @TableField("name")
    private String name;
    @TableField(value = "mobile")
    private String mobile;
    private String manager;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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
