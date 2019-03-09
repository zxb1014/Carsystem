package com.carsystem.controller;

import com.carsystem.core.Result;
import com.carsystem.core.ResultGenerator;
import com.carsystem.entity.Apply;
import com.carsystem.entity.Cuser;
import com.carsystem.entity.History;
import com.carsystem.service.ApplyService;
import com.carsystem.service.CuserService;
import com.carsystem.service.HistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.entity.Condition;

import org.apache.catalina.User;
import org.apache.ibatis.javassist.compiler.ast.NewExpr;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by CodeGenerator on 2019/02/27.
 */
@RestController
@RequestMapping("/cuser")
public class CuserController {
	@Resource
	private CuserService cuserService;
	@Resource
	private ApplyService applyService;
	@Resource
	private HistoryService historyService;

	@PostMapping("/add")
	public Result add(Cuser cuser) {
		cuserService.save(cuser);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam String id) {
		cuserService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(Cuser cuser) {
		cuserService.update(cuser);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	@ApiOperation("根据id显示所有信息")
	public Result detail(@RequestParam int id) {
		Cuser cuser = cuserService.findById(id);
		return ResultGenerator.genSuccessResult(cuser);
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<Cuser> list = cuserService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	// 车主登录
	@PostMapping("/login")
	@ApiOperation("车主登录")
	public Result login(@RequestParam(value = "c_telnumber") String c_telnumber,
			@RequestParam(value = "c_password") String c_password) {
		Cuser cuser = cuserService.login(c_telnumber, c_password);
		if (cuser == null)
			return ResultGenerator.genFailResult("手机号或密码错误！");
		else {
			Cuser cuser2 = cuserService.findBy("cTelnumber", c_telnumber);
			cuser2.setcPassword("");
			return ResultGenerator.genSuccessResult(cuser2);
		}
	}

	// 车主注册
	@PostMapping("/register")
	@ApiOperation("车主注册")
	@Transactional
	public Result register(@RequestParam(value = "c_telnumber") String c_telnumber,
			@RequestParam(value = "c_password") String c_password) {
		int tel = cuserService.exittelnumber(c_telnumber);
		if (tel > 0) {
			return ResultGenerator.genFailResult("手机号已经注册！");
		} else {
			Cuser cuser = new Cuser();
			cuser.setcTelnumber(c_telnumber);
			cuser.setcPassword(c_password);
			cuserService.save(cuser);
			Cuser findBy = cuserService.findBy("cTelnumber", c_telnumber);
			Apply apply = new Apply();
			apply.setaFk(findBy.getcId().toString());
			applyService.save(apply);
			return ResultGenerator.genSuccessResult();
		}
	}

	// 车主信息插入
	@PostMapping("/insert")
	@ApiOperation("车主信息录入")
	public Result insert(@RequestBody Cuser cuser) {
		cuserService.update(cuser);
		Cuser cuser2 = cuserService.findBy("cId", cuser.getcId());
		System.out.println(cuser2);
		Apply apply = applyService.findBy("aFk", cuser2.getcId().toString());
		apply.setcState("1");
		applyService.update(apply);
		return ResultGenerator.genSuccessResult();
	}

	// 增量指标插入
	@PostMapping("/insert1")
	@ApiOperation("修改增量指标信息")
	public Result insert1(@RequestBody Cuser cuser) {
		cuserService.update(cuser);
		return ResultGenerator.genSuccessResult();
	}

	// 车主取消申请，修改申请状态
	@PostMapping("/updateState")
	@ApiOperation("车主取消申请，修改申请状态")
	public Result updateState(@RequestBody Cuser cuser) {
		Apply apply = applyService.findBy("aFk", cuser.getcId().toString());
		apply.setcState("null");
		apply.setaApplynumber("null");
		apply.setsState("null");
		applyService.update(apply);
		return ResultGenerator.genSuccessResult();
	}

	// 车管所人员对信息进行审批
	@PostMapping("/list1")
	@ApiOperation("车管所人员对信息进行审批")
	public Result list1(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		Condition condition = new Condition(Apply.class);
		condition.createCriteria().andCondition("c_state='1'");
		List<Apply> applies = applyService.findByCondition(condition);
		List<Map> maps = new ArrayList<>();
		for (Apply a : applies) {
			Map<String, Object> map = new HashMap<>();
			Cuser cuser = cuserService.findBy("cId", Integer.parseInt(a.getaFk()));
			map.put("cuser", cuser);
			map.put("apply", a);
			maps.add(map);

		}
		PageInfo pageInfo = new PageInfo(maps);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	// 显示通过审核，准备摇号的车主信息
	@PostMapping("/listResult")
	@ApiOperation("显示通过审核，准备摇号的车主信息")
	public Result listResult(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		Condition condition = new Condition(Apply.class);
		condition.createCriteria().andCondition("s_state='1' and (c_result = '' or c_result is null)");
		List<Apply> applies = applyService.findByCondition(condition);
		List<Map> maps = new ArrayList<>();
		for (Apply a : applies) {
			Map<String, Object> map = new HashMap<>();
			Cuser cuser = cuserService.findBy("cId", Integer.parseInt(a.getaFk()));
			map.put("cuser", cuser);
			map.put("apply", a);
			maps.add(map);
		}
		PageInfo pageInfo = new PageInfo(maps);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	// 进行摇号，修改状态，将摇中信息存入历史表
	@PostMapping("/update2")
	public Result update2(@RequestParam int number) {
		Condition condition = new Condition(Apply.class);
		condition.createCriteria().andCondition("s_state='1' and (c_result = '' or c_result is null)");
		List<Apply> applies = applyService.findByCondition(condition);
		List<Integer> size = new ArrayList<Integer>();
		if (number > applies.size()) {
			number = applies.size();
		}
		for (int i = 0; i < number; i++) {
			int index = new Random().nextInt(applies.size());
			if (!size.contains(index)) {
				size.add(index);
			} else {
				number++;
			}
		}
		// 给摇中信息编期号
		List sss = new ArrayList<>();
		Condition condition2 = new Condition(History.class);
		condition2.createCriteria().andCondition("h_number=(select Max(h_number) from history)");
		List<History> histories = historyService.findByCondition(condition2);

		for (int i = 0; i < size.size(); i++) {

			History history = new History();
			history.setaApplynumber(applies.get(size.get(i)).getaApplynumber());
			history.sethFk(applies.get(size.get(i)).getaFk() + "");
			
			if (histories.size() < 1 || histories == null) {
				history.sethNumber("1");
			} else {
				history.sethNumber((Integer.parseInt(histories.get(0).gethNumber())+1)+"");
			}
			historyService.save(history);
			applies.get(size.get(i)).setcResult("1");
			applyService.update(applies.get(size.get(i)));
			sss.add(applies.get(size.get(i)));

		}
		return ResultGenerator.genSuccessResult(sss);
	}
	//显示中签编码
	@PostMapping("/listZq")
	@ApiOperation("显示中签编码")
	public Result listZq(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<History> histories=historyService.findAll();
		List<Map>maps=new ArrayList<>();
		for(History h:histories) {
			Map<String, Object> map=new HashMap<>();
			Cuser cuser=cuserService.findBy("cId", Integer.parseInt(h.gethFk()));
			map.put("histories", h);
			map.put("cuser", cuser);
			maps.add(map);
		}
		
		PageInfo pageInfo = new PageInfo(maps);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
	//根据申请码查询信息-模糊查询
	@PostMapping("/selectbyapplaynumber")
	@ApiOperation("根据aplaynumber查询信息")
	public Result selectbyapplaynumber(@RequestParam String aApplynumber) throws IllegalAccessException {
	
		Condition condition=new Condition(History.class);
		condition.createCriteria().andCondition("a_applynumber='"+aApplynumber+"'");
		List<History> histories = historyService.findByCondition(condition);
		List<Map> maps = new ArrayList<>();
		
		for(History h:histories) {
			Map<String, Object> map =new HashMap<>() ;
			Cuser cuser = cuserService.findById(Integer.parseInt(h.gethFk()));
			map.put("cuser", cuser);
			map.put("history", h);
			maps.add(map);
		}
		
		if(histories.size()==0) {
			return ResultGenerator.genFailResult("您查询的申请码不存在");
		}
		return ResultGenerator.genSuccessResult(maps);
	}
}
