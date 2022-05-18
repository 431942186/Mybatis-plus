package com.example.ch01;

import com.example.ch01.vo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DeptTests {

//    @Resource
//    StringEncryptor stringEncryptor;
//
//    @Test
//    void Test0() {
//        String root = stringEncryptor.encrypt("root");
//        System.out.println(root);
//        String encrypt = stringEncryptor.encrypt("020910");
//        System.out.println(encrypt);
//        System.out.println(stringEncryptor.decrypt(root));
//    }


    @Test
    void Test01() {
        /**
         * 实体类调用自己的方法进行数据添加
         */
        Dept dept = new Dept();
        dept.setName("销售部门");
        dept.setMobile("010-564-95565");
        dept.setManager("1");
        boolean insert = dept.insert();
        System.out.println(insert ? "成功添加" : "添加失败");
//      ==>  Preparing: INSERT INTO dept ( name, mobile, manager ) VALUES ( ?, ?, ? )
//      ==> Parameters: 销售部门(String), 010-564-95565(String), 1(String)
    }

    @Test
    void Test2() {
        /**
         * 实体类调用自己的方法进行数据更新
         */
        Dept dept = new Dept();
        dept.setId(1L);
        dept.setMobile("010-888-88888");
        boolean b = dept.updateById();
        System.out.println(b ? "更新成功" : "更新失败");
//==>   Preparing: UPDATE dept SET mobile=? WHERE id=?
//==>   Parameters: 010-888-88888(String), 1(Integer)
    }

    @Test
    void Test3() {
        /**
         * 删除操作,即使没有删除数据也返回true
         */
        Dept dept = new Dept();

        boolean b = dept.deleteById(1);
        System.out.println(b ? "更新成功" : "更新失败");
//==>   Preparing: UPDATE dept SET mobile=? WHERE id=?
//==>   Parameters: 010-888-88888(String), 1(Integer)
    }

    @Test
    void Test4() {
        /**
         * 按实体类的主键查询,如果没有该数据,返回值为 Null
         */

        Dept dept = new Dept();
        dept.setId(1L);
        List<Dept> list = dept.selectAll();
        list.forEach(System.out::println);
        Dept dept1 = dept.selectById();
        System.out.println(dept1);
        Dept dept2 = dept.selectById(1);
        System.out.println(dept2);

    }

}
