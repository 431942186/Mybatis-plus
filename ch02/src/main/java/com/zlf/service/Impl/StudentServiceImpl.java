package com.zlf.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlf.entity.Student;
import com.zlf.mapper.StudentMapper;
import com.zlf.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ZLF
 * @since 2022-03-03 04:20:11
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Override
    @Transactional
    public List<Student> Transactional_TEXT() {
        List<Student> list = null;
        try {
            list = this.list();
            if (list == null) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            System.err.println("出现事故");
        }
        return list;
    }
}
