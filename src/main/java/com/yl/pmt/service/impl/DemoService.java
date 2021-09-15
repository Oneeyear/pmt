package com.yl.pmt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.pmt.exception.BusinessException;
import com.yl.pmt.mapper.DemoMapper;
import com.yl.pmt.pojo.po.DemoPo;
import com.yl.pmt.pojo.vo.DemoVo;
import com.yl.pmt.service.IDemoService;
import com.yl.pmt.util.EntityConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * demo_service
 *
 * @author pch
 * @date 2021/9/14 6:16 下午
 */
@Service
public class DemoService extends ServiceImpl<DemoMapper, DemoPo> implements IDemoService {

	@Autowired
	DemoMapper demoMapper;

	@Override
	public String getName(Integer id) {
		return demoMapper.queryName(id);
	}

	/**
	 * 新增用户
	 *
	 * @param vo
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addUser(DemoVo vo) {
		Optional.ofNullable(vo).orElseThrow(() -> new BusinessException("数据不能为空！"));
		DemoPo po = (DemoPo) EntityConvertUtil.convert(vo, "Po");
		boolean flag = this.save(po);
		if (!flag) {
			throw new BusinessException("新增失败！");
		}
	}

}
