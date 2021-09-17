package com.yl.pmt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.pmt.exception.BusinessException;
import com.yl.pmt.mapper.DemandMapper;
import com.yl.pmt.mapper.UserMapper;
import com.yl.pmt.pojo.dto.UserDto;
import com.yl.pmt.pojo.po.UserPo;
import com.yl.pmt.service.IUserService;
import com.yl.pmt.util.EntityConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * 用户信息
 *
 * @author pch
 * @date 2021/9/16 3:40 下午
 */
@Service("userService")
public class UserService extends ServiceImpl<UserMapper, UserPo> implements IUserService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	DemandMapper demandMapper;

	/**
	 * 新增用户
	 *
	 * @param dto
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addUser(UserDto dto) {
		// 非空判断
		Optional.ofNullable(dto).orElseThrow(() -> new BusinessException("用户信息不能为空！"));
		UserPo po = (UserPo) EntityConvertUtil.convert(dto, "Po");
		// 姓名重复判断
		String name = Optional.ofNullable(po.getName()).orElseThrow(() -> new BusinessException("用户名不能为空！"));
		QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", name).eq("logic_state", "Y");
		List<UserPo> pos = this.list(queryWrapper);
		if (!CollectionUtils.isEmpty(pos)) {
			throw new BusinessException("用户名已存在！");
		}
		// 保存操作
		po.setCreateTime(new Date());
		po.setModifyTime(new Date());
		boolean flag = this.save(po);
		if (!flag) {
			throw new BusinessException("新增失败！");
		}
	}

	/**
	 * 查询用户
	 *
	 * @return
	 */
	@Override
	public List<UserPo> listUsers() {
		QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("logic_state", "Y");
		return this.list(queryWrapper);
	}

	/**
	 * 删除用户
	 *
	 * @param ids
	 */
	@Override
	public void delUsers(List<Integer> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			throw new BusinessException("传入数据为空！");
		}
		Long count = demandMapper.countDemandByIds(ids);
		if (count > 0) {
			throw new BusinessException("待删除用户中有关联需求，请先删除需求再对人员进行删除！");
		}
		userMapper.removeUsers(ids);
	}
}
