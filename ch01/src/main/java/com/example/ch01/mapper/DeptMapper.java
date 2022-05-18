package com.example.ch01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ch01.vo.Dept;

/**
 * 这个mapper是不需要使用但 ,但需要有,mybatis-plus需要这个类来找数据库
 */
public interface DeptMapper extends BaseMapper<Dept> {
}
