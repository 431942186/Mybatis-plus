package com.zlf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlf.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ZLF
 * @since 2022-03-03 04:20:11
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
