package com.yl.pmt.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.pmt.security.mapper.UserRoleMapper;
import com.yl.pmt.security.pojo.UserRole;
import com.yl.pmt.security.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Description 用户与角色业务实现
 * @Author pch
 * @CreateTime 2020/9/14 15:57
 */
@Service("sysUserRoleService")
public class UserRoleService extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
