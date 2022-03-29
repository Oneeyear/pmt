package com.yl.pmt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yl.pmt.domain.po.ScorePo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 美术成绩
 *
 * @author pch
 * @date 2021/10/22 9:02 下午
 */
@Mapper
@Repository
public interface ScoreMapper extends BaseMapper<ScorePo> {
}
