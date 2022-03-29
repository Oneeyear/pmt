package com.yl.pmt.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.pmt.exception.BusinessException;
import com.yl.pmt.mapper.ScoreMapper;
import com.yl.pmt.domain.dto.ScoreDto;
import com.yl.pmt.domain.po.ScorePo;
import com.yl.pmt.domain.vo.ScoreVo;
import com.yl.pmt.service.IScoreService;
import com.yl.pmt.util.EntityConvertUtil;
import org.springframework.stereotype.Service;

/**
 * 美术成绩
 *
 * @author pch
 * @date 2021/10/22 9:05 下午
 */
@Service("scoreService")
public class ScoreService extends ServiceImpl<ScoreMapper, ScorePo> implements IScoreService {

	/**
	 * 查询成绩
	 *
	 * @param dto
	 * @return
	 */
	@Override
	public ScoreVo inquiry(ScoreDto dto) {
		ScorePo po = super.getOne(new LambdaQueryWrapper<ScorePo>()
						.eq(ScorePo::getName, dto.getName()).eq(ScorePo::getCode, dto.getCode()));
		if (po == null) {
			throw new BusinessException("成绩查询失败！");
		}
		ScoreVo vo = (ScoreVo) EntityConvertUtil.convert(po, "Vo");
		return vo;
	}
}
