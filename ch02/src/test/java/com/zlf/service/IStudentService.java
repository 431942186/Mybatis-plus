package com.zlf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlf.entity.Student;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZLF
 * @since 2022-03-03 04:20:11
 */
public interface IStudentService extends IService<Student> {
    List<Student> Transactional_TEXT();

}
