package com.yl.pmt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yl.pmt.pojo.po.DemoPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * demo_mapper
 *
 * @author pch
 * @date 2021/9/14 6:17 下午
 */
@Mapper
@Repository
public interface DemoMapper extends BaseMapper<DemoPo> {

	/**
	 * 通过ID查询姓名
	 *
	 * @param id
	 * @return
	 */
	String queryName(Integer id);

}
