package com.yl.pmt.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.pmt.security.mapper.RoleMapper;
import com.yl.pmt.security.pojo.Role;
import com.yl.pmt.security.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * @Description 角色业务实现
 * @Author pch
 * @CreateTime 2020/9/14 15:57
 */
@Service("sysRoleService")
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
