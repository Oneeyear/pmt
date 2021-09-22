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
	 * @param ids
	 * @param modifyUser
	 * @return
	 */
	@Deprecated
	int removeDemands(@Param("ids") List<Integer> ids, @Param("modifyUser") String modifyUser);

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
	@Deprecated
	void updateDemandStatus(@Param("ids") List<Integer> ids, @Param("status") String status);

	/**
	 * 查询用户名下需求数目
	 *
	 * @param userCodes
	 * @return
	 */
	@Deprecated
	Long countDemandByUserCode(@Param("userCodes") List<String> userCodes);
}
