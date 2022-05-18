package com.example.ch01;

import com.example.ch01.mapper.UserMapper;
import com.example.ch01.vo.user;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class UserTests {

    @Resource
    private UserMapper userMapper;

    /**
     * user 里的数据类型必须为包装类型,这样可以判断是否为空
     */
    @Test
    void Test01() {
        System.out.println(("----- selectAll method test ------"));
        List<user> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);

    }

    @Test
    void Test02() {
//        数据库表id自动增长  添加后user对象的id属性也会有值
        user u = new user();
        u.setAge(18);
        u.setEmail("@16564.com");
        u.setName("张三");
        int insert = userMapper.insert(u);
        System.out.println(u.getId());
    }

    @Test
    void Test03() {
        user u = new user();
        u.setId(7);
        u.setAge(18);
        u.setEmail("@23333.com");
        u.setName("真●张三");
        int insert = userMapper.updateById(u);
//        Preparing: UPDATE user SET name=?, age=?, email=? WHERE id=?
//        Parameters: 真●张三(String), 18(Integer), @23333.com(String), 7(Integer)
//        ById 是按照user对象的id进行更新,他可以更新所有的非空的属性
    }

    @Test
    void Test04() {
        user u = new user();
        u.setId(7);
        u.setAge(28);
        u.setName("真●张三☺");
        int insert = userMapper.updateById(u);
        //UPDATE user SET name=?, age=? WHERE id=?
        //真●张三☺(String), 28(Integer), 7(Integer)
        //ById 是按照user对象的id进行更新,他可以更新所有的非空的属性
    }

    @Test
    void Test05() {
/**
 * 按主键删除
 */
        user u = new user();
        u.setId(6);
//      int insert = userMapper.deleteById(u);
//      Preparing: DELETE FROM user WHERE id=?
//      Parameters: 6(Integer)
        int insert = userMapper.deleteById(5);
//      Preparing: DELETE FROM user WHERE id=?
//      Parameters: 5(Integer)

    }

    @Test
    void Test06() {
/**
 * 按条件删除
 */
        Map<String, Object> m = new HashMap<>();
        m.put("name", "Sandy");
        m.put("age", "21");
        int insert = userMapper.deleteByMap(m);
//      Preparing: DELETE FROM user WHERE name = ? AND age = ?
//      Parameters: Sandy(String), 21(String)

    }

    @Test
    void Test07() {
/**
 * 按主键删除 批量
 */
        List<Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        /* List<Integer> list = new ArrayList<>();
         list.add(1);
         list.add(2);
         list.add(3);
         list.add(4);*/
        int insert = userMapper.deleteBatchIds(collect);
        System.out.println(insert);
//      Preparing: DELETE FROM user WHERE id IN ( ? , ? , ? , ? )
//      Parameters: 1(Integer), 2(Integer), 3(Integer), 4(Integer)

    }

    @Test
    void Test08() {
/**
 * 按id查询
 * 如果没有该数据 返回值为 Null
 * 默认返回所有字段
 */
        user user = userMapper.selectById(7);
        System.out.println(user);
//      Preparing: SELECT id,name,age,email FROM user WHERE id=?
//      Parameters: 7(Integer)

        if (user == null) {
            System.out.println("没有该数据");
        }


    }

    @Test
    void Test09() {
/**
 * 按id查询 批量查询
 * 返回值是一个list集合
 */
        List<Integer> collect = Stream.of(9, 1, 2, 3, 4, 5, 6, 7).collect(Collectors.toList());
        List<user> users = userMapper.selectBatchIds(collect);
        users.forEach(u -> System.out.println("查询的数据:" + u));
//      Preparing: SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? , ? , ? , ? , ? , ? )
//      Parameters: 9(Integer), 1(Integer), 2(Integer), 3(Integer), 4(Integer), 5(Integer), 6(Integer),
    }

    @Test
    void Test10() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "真●张三");
        map.put("age", "18");
        List<user> users = userMapper.selectByMap(map);
        users.forEach(u -> System.out.println("查询到的数据:" + u));
//==>   Preparing: SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
//==>   Parameters: 真●张三(String), 18(String)
    }


}
