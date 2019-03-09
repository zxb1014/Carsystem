package com.carsystem.controller;
import com.carsystem.core.Result;
import com.carsystem.core.ResultGenerator;
import com.carsystem.entity.Muser;
import com.carsystem.service.MuserService;
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
@RequestMapping("/muser")
public class MuserController {
    @Resource
    private MuserService muserService;

    @PostMapping("/add")
    public Result add(Muser muser) {
        muserService.save(muser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        muserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Muser muser) {
        muserService.update(muser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam int id) {
        Muser muser = muserService.findById(id);
        return ResultGenerator.genSuccessResult(muser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Muser> list = muserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    //管理员登录
    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public Result login(@RequestParam(value="m_telnumber") String m_telnumber ,@RequestParam(value="m_password") String m_password) {
        Muser muser = muserService.login(m_telnumber, m_password);
        if(muser==null) {
        	return ResultGenerator.genFailResult("手机号或密码错误！");
        }
        else {
        	Muser muser2=muserService.findBy("mTelnumber", m_telnumber);
        	muser2.setmPassword("");
            return ResultGenerator.genSuccessResult(muser2);

        }
    }
}
