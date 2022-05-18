package com.example.ch01;

import com.example.ch01.vo.one;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class oneText {

    /**
     * 根据  数据库表字段 text_id 表名加下划线加字段 可用直接将实体类名定义为 textId
     * text_id  ==   textId
     * 下划线命名法对应驼峰命名
     */
    @Test
    void Text01() {
        one my = new one();
        my.selectAll().forEach(System.out::println);
        my.selectAll().forEach(System.out::println);

    }


}
