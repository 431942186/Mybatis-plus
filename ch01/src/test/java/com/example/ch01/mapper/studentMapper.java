package com.example.ch01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ch01.vo.student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface studentMapper extends BaseMapper<student> {
    public int insertStudent(student student);

    public student selectStudentById(@Param("id") Integer id);

    public List<student> selectByName(String name);

}
