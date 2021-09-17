package com.yl.pmt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yl.pmt.pojo.dto.DemandQueryDto;
import com.yl.pmt.pojo.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息
 *
 * @author pch
 * @date 2021/9/16 3:41 下午
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserPo> {

	/**
	 * 删除人员
	 *
	 * @param ids
	 */
	void removeUsers(@Param("ids") List<Integer> ids);

	/**
	 * 查询人员
	 *
	 * @param dto
	 * @return
	 */
	List<UserPo> selectUserList(DemandQueryDto dto);
}
