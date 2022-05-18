package com.zlf;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zlf.entity.Student;
import com.zlf.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class studentText {
    @Resource
    IStudentService service;

    @Test
    void text01() {
//        BaseMapper<Student> baseMapper = service.getBaseMapper();
        //Page<Student> selectPage = baseMapper.selectPage(Page.of(1, 3), Wrappers.query());
        //List<Student> list = service.Transactional_TEXT();


        service.update(
                Wrappers.<Student>lambdaUpdate()
                        .set(Student::getEmail, "www.100.com")
                        .likeRight(Student::getName, "张")
                        .and(i -> i.eq(Student::getStatus, 1)
                        .or(a -> a.eq(Student::getStatus, 2))));

        service.list(Wrappers.<Student>lambdaQuery()
                .eq(Student::getEmail, "www.100.com")
                .likeRight(Student::getName, "张")
                .and(i -> i.eq(Student::getStatus, 1).or().eq(Student::getStatus, 2)));
//        service.page(Page.of(1, 3));
//
//        service.list(Wrappers.<Student>lambdaQuery()
//                .isNull(Student::getName).or().eq( Student::getName, "")
//        );


    }

}
