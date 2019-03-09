package com.carsystem.controller;

import com.carsystem.core.Result;
import com.carsystem.core.ResultGenerator;
import com.carsystem.entity.Apply;
import com.carsystem.service.ApplyService;
import com.carsystem.service.CuserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.entity.Condition;

import com.carsystem.entity.Cuser;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/02/27.
 */
@RestController
@RequestMapping("/apply")
public class ApplyController {
	@Resource
	private ApplyService applyService;
	@Resource
	private CuserService cuserService;

	@PostMapping("/add")
	public Result add(Apply apply) {
		applyService.save(apply);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		applyService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(Apply apply) {
		applyService.update(apply);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam int id) {
		Apply apply = applyService.findById(id);
		return ResultGenerator.genSuccessResult(apply);
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<Apply> list = applyService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	// 查询车主的申请状态
	@PostMapping("/selectState")
	@ApiOperation("查询车主的申请状态")
	@Transactional
	public Result selectState(@RequestParam(value = "c_telnumber") String c_telnumber) {
		Cuser cuser = cuserService.findBy("cTelnumber", c_telnumber);
		Apply apply = applyService.findBy("aFk", cuser.getcId().toString());
		return ResultGenerator.genSuccessResult(apply);
	}

	// 查询车主的申请码
	@PostMapping("/selectApplynumber")
	@ApiOperation("查询车主的申请码")
	@Transactional
	public Result selectApplynumber(@RequestBody Cuser cuser) {
		Cuser cuser2 = cuserService.findBy("cId", cuser.getcId());
		Apply apply = applyService.findBy("aFk", cuser2.getcId().toString());
		return ResultGenerator.genSuccessResult(apply.getaApplynumber());
	}

	// 审批状态修改 并给出申请码
	@PostMapping("/update1")
	@ApiOperation("审批状态修改 并给出申请码")
	public Result update1(@RequestBody Cuser cuser) {
		Apply apply = applyService.findBy("aFk", cuser.getcId().toString());
		apply.setsState("1");
		Condition condition=new Condition(Apply.class);
		condition.createCriteria().andCondition("(a_Applynumber is not null and a_Applynumber !='')");
		List<Apply> findAll = applyService.findByCondition(condition);
		
		int a = (int) ((Math.random() * 9 + 1) * 100000);

		for (Apply c : findAll) {

			if (a == Integer.parseInt(c.getaApplynumber())) {
				a = (int) ((Math.random() * 9 + 1) * 100000);
				continue;
			}
		}
		apply.setaApplynumber(a + "");
		applyService.update(apply);
		return ResultGenerator.genSuccessResult();
	}
}
