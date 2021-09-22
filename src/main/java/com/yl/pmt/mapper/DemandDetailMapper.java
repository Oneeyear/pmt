package com.yl.pmt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yl.pmt.pojo.po.DemandDetailPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 需求完成详情
 *
 * @author pch
 * @date 2021/9/22 1:36 下午
 */
@Mapper
@Repository
public interface DemandDetailMapper extends BaseMapper<DemandDetailPo> {

	/**
	 * 移除所有需求详情
	 *
	 * @param ids
	 * @param modifyUser
	 * @return
	 */
	@Deprecated
	int removeDemandDetails(@Param("ids") List<Integer> ids, @Param("modifyUser") String modifyUser);
}
