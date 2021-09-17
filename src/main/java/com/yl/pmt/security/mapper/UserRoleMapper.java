package com.yl.pmt.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yl.pmt.security.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 用户与角色关系mapper
 * @Author pch
 * @CreateTime 2020/9/14 15:57
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
