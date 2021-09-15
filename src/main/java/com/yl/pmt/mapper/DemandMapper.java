package com.yl.pmt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yl.pmt.pojo.po.DemandPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 需求持久层
 *
 * @author pch
 * @date 2021/9/15 7:39 下午
 */
@Mapper
@Repository
public interface DemandMapper extends BaseMapper<DemandPo> {

}
