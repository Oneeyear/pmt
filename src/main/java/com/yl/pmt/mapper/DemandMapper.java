package com.yl.pmt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yl.pmt.pojo.dto.DemandQueryDto;
import com.yl.pmt.pojo.po.DemandPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 需求持久层
 *
 * @author pch
 * @date 2021/9/15 7:39 下午
 */
@Mapper
@Repository
public interface DemandMapper extends BaseMapper<DemandPo> {

	/**
	 * 删除需求
	 *
	 * @param list
	 */
	void removeDemands(List<Integer> list);

	/**
	 * 查询需求
	 *
	 * @param dto
	 * @return
	 */
	List<DemandPo> selectDemandList(DemandQueryDto dto);

	/**
	 * 更新需求状态
	 *
	 * @param ids
	 * @param status
	 */
	void updateDemandStatus(@Param("ids") List<Integer> ids, @Param("status") String status);
}
