package com.yl.pmt.controller;

import com.yl.pmt.domain.dto.ScoreDto;
import com.yl.pmt.domain.vo.ScoreVo;
import com.yl.pmt.result.ResponseData;
import com.yl.pmt.service.IScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 美术成绩
 *
 * @author pch
 * @date 2021/10/22 9:08 下午
 */
@Api(tags = "美术成绩")
@RestController
@RequestMapping("/score")
public class ScoreController extends BaseController {

	@Autowired
	IScoreService scoreService;

	/**
	 * 查询
	 *
	 * @return
	 */
	@ApiOperation(value = "新增用户", notes = "新增用户")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ResponseData query(@Validated ScoreDto dto) {
		ScoreVo vo = scoreService.inquiry(dto);
		return success("成绩查询成功！",vo);
	}


}
