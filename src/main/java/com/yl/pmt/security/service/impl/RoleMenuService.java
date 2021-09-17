package com.yl.pmt.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.pmt.security.mapper.RoleMenuMapper;
import com.yl.pmt.security.pojo.RoleMenu;
import com.yl.pmt.security.service.IRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * @Description 角色与权限业务实现
 * @Author pch
 * @CreateTime 2020/9/14 15:57
 */
@Service("sysRoleMenuService")
public class RoleMenuService extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
