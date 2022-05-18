package com.example.ch01;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ch01.mapper.studentMapper;
import com.example.ch01.vo.student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class studentText {
    @Resource
    studentMapper Mapper;

    @Test
    void paginationInnerInterceptor_Text() {

//        Page<student> result = Mapper.selectPage(new Page<student>(1, 3), new QueryWrapper<student>());
        Page<student> result = Mapper.selectPage(Page.of(1,3), new QueryWrapper<student>());
        result.getRecords().forEach(System.out::println);
        System.out.println("页数 :  " + result.getPages());
        System.out.println("总记录数 :  " + result.getTotal());
        System.out.println("当前页码 :  " + result.getCurrent());
        System.out.println("每页的记录数 :  " + result.getSize());
//==>  Preparing: SELECT id,name,age,email,status FROM student LIMIT ?
//==>  Parameters: 3(Long)

    }

    @Test
    void allEq() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", null);
        hashMap.put("age", 12);
   
        Mapper.selectList(
                new QueryWrapper<student>().allEq(hashMap)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (name IS NULL AND age = ?)
        Mapper.selectList(
                new QueryWrapper<student>().allEq(hashMap, true)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (name IS NULL AND age = ?)
        //==> Parameters: 12(Integer)
        Mapper.selectList(
                new QueryWrapper<student>().allEq(hashMap, false)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (age = ?)
        //==> Parameters: 20(Integer)
    }

    /**
     * 等于 eq
     * 不等于  ne
     */
    @Test
    void eq_ne() {
        Mapper.selectList(
                Wrappers.<student>lambdaUpdate().eq(student::getId, 18)
        );
        Mapper.selectList(
                Wrappers.<student>lambdaUpdate().ne(student::getId, 18)
        );
        Mapper.selectList(
                new QueryWrapper<student>().eq("age", 18)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (age = ?)
        //==> Parameters: 18(Integer)
        Mapper.selectList(
                new QueryWrapper<student>().ne("age", 20)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (age <> ?)
        //==> Parameters: 20(Integer)
    }

    /**
     * 大于等于  ge
     * 大于 gt
     */
    @Test
    void ge_gt() {
        Mapper.selectList(
                new QueryWrapper<student>().ge("age", 20)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (age >= ?)
        //==> Parameters: 20(Integer)
        Mapper.selectList(
                new QueryWrapper<student>().gt("age", 20)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (age > ?)
        //==>  Parameters: 20(Integer)
    }

    /**
     * 小于等于 le
     * 小于 lt
     */
    @Test
    void le_lt() {
        Mapper.selectList(
                new QueryWrapper<student>().le("age", 20)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (age <= ?)
        //==>  Parameters: 20(Integer)
        Mapper.selectList(
                new QueryWrapper<student>().lt("age", 20)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (age < ?)
        //==>  Parameters: 20(Integer)
    }

    /**
     * BETWEEN ? AND ?
     * 在 ? and ? 之间
     * NOT BETWEEN ? AND ?
     * 不在 ? and ? 之间
     */
    @Test
    void between() {
        Mapper.selectList(
                new QueryWrapper<student>().between("age", 10, 20)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (age BETWEEN ? AND ?)
        //==> Parameters: 18(Integer), 20(Integer)
        Mapper.selectList(
                new QueryWrapper<student>().notBetween("age", 18, 20)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (age NOT BETWEEN ? AND ?)
        //==> Parameters: 18(Integer), 20(Integer)
    }

    /**
     * like
     * 等于 %?%
     * notLike
     * 不等于 %?%
     * likeRight
     * ?%
     * likeLeft
     * %?
     */
    @Test
    void like() {
        Mapper.selectList(
                new QueryWrapper<student>().like("name", "张")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (name LIKE ?)
        //==> Parameters: %张%(String)
        Mapper.selectList(
                new QueryWrapper<student>().notLike("name", "张")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (name NOT LIKE ?)
        //==> Parameters: %张%(String)==> Parameters: %张%(String)
        Mapper.selectList(
                new QueryWrapper<student>().likeRight("name", "张")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (name LIKE ?)
        //==> Parameters: 张%(String)
        Mapper.selectList(
                new QueryWrapper<student>().likeLeft("name", "张")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (name LIKE ?)
        //==> Parameters: %张(String)
    }

    /**
     * 字段为 Null 的
     */
    @Test
    void isNull() {
        Mapper.selectList(
                new QueryWrapper<student>().isNull("status")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (status IS NULL)
        Mapper.selectList(
                new QueryWrapper<student>().isNotNull("status")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (status IS NOT NULL)
    }

    /**
     * in
     * 在 (?,?,?,?) 条件中的
     */
    @Test
    void in() {
        Mapper.selectList(
                new QueryWrapper<student>().in("name", "lili", "张三", "金匮")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (name IN (?,?,?))
        //==>  Parameters: lili(String), 张三(String), 金匮(String)
        Mapper.selectList(
                new QueryWrapper<student>().notIn("name", "lili", "张三", "金匮")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (name NOT IN (?,?,?))
        //==>  Parameters: lili(String), 张三(String), 金匮(String)
    }

    /**
     * inSql
     * 子查询
     * xxx字段 in (sql语句)
     */
    @Test
    void inSql() {
        Mapper.selectList(
                new QueryWrapper<student>().inSql("age", "select age from student where id=1")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (age IN (select age from student where id=1))
        //SELECT id, name, age, email, status
        //FROM student
        //WHERE age IN (select age from student where id = 1);
        Mapper.selectList(
                new QueryWrapper<student>().notInSql("age", "select age from student where id=1")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (age NOT IN (select age from student where id=1))
    }

    /**
     * 分组
     */
    @Test
    void groupBy() {
        Mapper.selectList(
                new QueryWrapper<student>()
                        .select("status,count(*) as personNumbers")
                        .groupBy("status")
        );
        //SELECT status, count(*) as personNumbers
        //FROM student
        //GROUP BY status;
    }

    /**
     * asc 升序
     * desc 降序
     */
    @Test
    void orderByAsc() {
        Mapper.selectList(
                new QueryWrapper<student>()
                        .orderByAsc("name", "age")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student ORDER BY name ASC,age ASC
        Mapper.selectList(
                new QueryWrapper<student>().orderByDesc("age")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student ORDER BY age DESC
    }

    /**
     * public Children orderBy(boolean condition,boolean isAsc,R column)
     * condition : true 加到sql语句  ,false 不加到sql语句
     * isAsc : 排序的方式
     * column : 排序的字段
     */
    @Test
    void order() {
        Mapper.selectList(
                new QueryWrapper<student>()
                        .orderBy(true, true, "name")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student ORDER BY name ASC
        Mapper.selectList(
                new QueryWrapper<student>()
                        .orderBy(true, true, "name")
                        .orderBy(true, false, "age")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student ORDER BY name ASC,age DESC
        Mapper.selectList(
                new QueryWrapper<student>()
                        .orderBy(false, true, "name")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student
    }

    @Test
    void or_() {
        Mapper.selectList(
                new QueryWrapper<student>()
                        .eq("name", "张三")
                        .or()
                        .eq("age", 18)
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (name = ? OR age = ?)
        //==>  Parameters: 张三(String), 18(Integer)
    }

    @Test
    void _and() {
        Mapper.selectList(
                new QueryWrapper<student>()
                        .eq("name", "张三")
                        .and(true, i -> i.eq(true, "age", 19))
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (name = ? AND (age = ?))
        //==>  Parameters: 张三(String), 19(Integer)
    }

    /**
     * 后缀添加语句
     */
    @Test
    void last() {
        Mapper.selectList(
                new QueryWrapper<student>()
                        .last("where 1=1 limit 1,3")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student where 1=1 limit 1,3
    }

    /**
     *
     */
    @Test
    void exists() {

        Mapper.selectList(new QueryWrapper<student>()
                .exists("select id from student where age > 18")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (EXISTS (select id from student where age > 18))
// (EXISTS (select id from student where age > 18)) 的条件里有大于18的才会执行查询语句
        Mapper.selectList(new QueryWrapper<student>()
                .notExists("select id from student where age > 99")
        );
        //==>  Preparing: SELECT id,name,age,email,status FROM student WHERE (NOT EXISTS (select id from student where age > 99))
    }


    @Test
    void Text01() {
        student student = new student();
        student.setName("张三");
        student.setStatus(88);
        int i = Mapper.insertStudent(student);
        System.out.println(i);
    }

    @Test
    void Text02() {
        List<student> list = Mapper.selectByName("张三");
    }

    @Test
    void Text03() {
        student student = Mapper.selectStudentById(1);
        System.out.println(student);
    }

    @Test
    void Text04() {
        QueryWrapper<student> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 15);
        queryWrapper.allEq(map);
//==>   Preparing: SELECT id,name,age,email,status FROM student WHERE (name = ? AND age = ?)
//==>   Parameters: 张三(String), 15(Integer)
        List<student> list = Mapper.selectList(queryWrapper);
    }
}
