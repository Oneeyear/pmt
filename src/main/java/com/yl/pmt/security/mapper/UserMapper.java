package com.yl.pmt.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yl.pmt.security.pojo.Menu;
import com.yl.pmt.security.pojo.Role;
import com.yl.pmt.security.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	 *
	 * @param userCode
	 * @return
	 */
	List<Role> selectSysRoleByUserCode(String userCode);

	/**
	 * 通过用户ID查询权限集合
	 *
	 * @param userCode
	 * @return
	 */
	List<Menu> selectSysMenuByUserCode(String userCode);

	/**
	 * 禁用账户
	 *
	 * @param userCodes
	 * @return
	 */
	@Deprecated
	int removeUsers(@Param("userCodes") List<String> userCodes);
}
