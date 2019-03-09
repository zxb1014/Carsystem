package com.carsystem.controller;
import com.carsystem.core.Result;
import com.carsystem.core.ResultGenerator;
import com.carsystem.entity.Suser;
import com.carsystem.service.SuserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/02/27.
*/
@RestController
@RequestMapping("/suser")
public class SuserController {
    @Resource
    private SuserService suserService;

    @PostMapping("/add")
    public Result add(Suser suser) {
        suserService.save(suser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        suserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Suser suser) {
        suserService.update(suser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam int id) {
        Suser suser = suserService.findById(id);
        return ResultGenerator.genSuccessResult(suser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Suser> list = suserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    //车管所员工登录
    @ApiOperation("车管所员工登录")
    @PostMapping("/login")
    public Result login(@RequestParam(value="s_telnumber") String s_telnumber,@RequestParam(value="s_password") String s_password) {
        Suser suser = suserService.login(s_telnumber, s_password);
        if(suser==null)
        	return ResultGenerator.genFailResult("手机号或密码错误！");
        else {
        	Suser suser2=suserService.findBy("sTelnumber", s_telnumber);
        	suser2.setsPassword("");
        	return ResultGenerator.genSuccessResult(suser2);
        }
       
        
    }
}
