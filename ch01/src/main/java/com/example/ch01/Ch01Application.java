package com.example.ch01;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ch01.mapper.studentMapper;
import com.example.ch01.vo.student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com/example/ch01/mapper")
public class Ch01Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Ch01Application.class, args);
        studentMapper bean = run.getBean(studentMapper.class);


        Page<student> studentPage = bean.selectPage(new Page<>(1, 3), new QueryWrapper<>());
        studentPage.getRecords().forEach(System.out::println);


    }

}
