package com.yl.pmt.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.pmt.security.pojo.Menu;
import com.yl.pmt.security.pojo.Role;
import com.yl.pmt.security.pojo.User;

import java.util.List;

/**
 * @Description 系统用户业务接口
 * @Author pch
 * @CreateTime 2020/6/14 15:57
 */
public interface IUserService extends IService<User>  {

    /**
     * 根据用户名查询实体
     * @Author pch
     * @CreateTime 2020/9/14 16:30
     * @Param  account 用户名
     * @Return User 用户实体
     */
    User selectUserByAccount(String account);

    /**
     * 根据用户ID查询角色集合
     * @Author pch
     * @CreateTime 2020/9/18 18:01
     * @Param  userId 用户ID
     * @Return List<Role> 角色名集合
     */
    List<Role> selectSysRoleByUserCode(String userCode);
    /**
     * 根据用户ID查询权限集合
     * @Author pch
     * @CreateTime 2020/9/18 18:01
     * @Param  userId 用户ID
     * @Return List<Menu> 角色名集合
     */
    List<Menu> selectSysMenuByUserCode(String userCode);

}
