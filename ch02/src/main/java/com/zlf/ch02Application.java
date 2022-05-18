package com.zlf;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zlf.entity.Student;
import com.zlf.service.IStudentService;
import com.zlf.service.Impl.StudentServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.zlf.mapper")
@EnableTransactionManagement
public class ch02Application {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ch02Application.class, args);
        IStudentService bean = run.getBean(StudentServiceImpl.class);
        /**   BaseMapper<Student> baseMapper = bean.getBaseMapper();
         Page<Student> selectPage = baseMapper.selectPage(
         new Page<>(1, 3), new QueryWrapper<>()
         );
         selectPage.getRecords().forEach(System.out::println);
         */
        bean.list(
                Wrappers.<Student>lambdaQuery()
                        .gt(true, Student::getAge, 17)
        );

        bean.update(Wrappers.<Student>lambdaUpdate()
                .eq(Student::getId, 5)
                .set(true, Student::getAge, 99));
//==>  Preparing: UPDATE student SET age=? WHERE (id = ?)
//==> Parameters: 99(Integer), 5(Integer)
    }

}
