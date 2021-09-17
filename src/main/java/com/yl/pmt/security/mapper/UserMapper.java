package com.yl.pmt.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yl.pmt.security.pojo.Menu;
import com.yl.pmt.security.pojo.Role;
import com.yl.pmt.security.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description 系统用户mapper
 * @Author pch
 * @CreateTime 2020/9/14 15:57
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过用户ID查询角色集合
     * @Author pch
     * @CreateTime 2020/9/18 18:01
     * @Param  userId 用户ID
     * @Return List<Role> 角色名集合
     */
    List<Role> selectSysRoleByUserCode(String userCode);
    /**
     * 通过用户ID查询权限集合
     * @Author pch
     * @CreateTime 2020/9/18 18:01
     * @Param  userId 用户ID
     * @Return List<Menu> 角色名集合
     */
    List<Menu> selectSysMenuByUserCode(String userCode);

}
