package com.yl.pmt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.pmt.domain.dto.ScoreDto;
import com.yl.pmt.domain.po.ScorePo;
import com.yl.pmt.domain.vo.ScoreVo;

/**
 * 美术成绩
 *
 * @author pch
 * @date 2021/10/22 9:04 下午
 */
public interface IScoreService extends IService<ScorePo> {

	/**
	 * 查询成绩
	 *
	 * @param dto
	 * @return
	 */
	ScoreVo inquiry(ScoreDto dto);
}
