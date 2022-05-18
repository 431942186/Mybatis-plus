package com.zlf.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlf.entity.User;
import com.zlf.mapper.UserMapper;
import com.zlf.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 展xx
 * @since 2022-03-14 07:26:13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
