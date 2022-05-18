package com.example.ch01.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

@TableName(value = "text")
public class one extends Model<one> {
    @TableId(value = "text_id",type = IdType.ASSIGN_UUID)
    private String textId;
    private String textName;
    private String textAge;

    public String getTextId() {
        return textId;
    }

    public void setTextId(String textId) {
        this.textId = textId;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextAge() {
        return textAge;
    }

    public void setTextAge(String textAge) {
        this.textAge = textAge;
    }

    @Override
    public String toString() {
        return "mYText{" +
                "textId='" + textId + '\'' +
                ", textName='" + textName + '\'' +
                ", textAge='" + textAge + '\'' +
                '}';
    }
}
