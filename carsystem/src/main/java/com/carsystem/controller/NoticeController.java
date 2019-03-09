package com.carsystem.controller;
import com.carsystem.core.Result;
import com.carsystem.core.ResultGenerator;
import com.carsystem.entity.Notice;
import com.carsystem.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.entity.Condition;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/02/27.
*/
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Resource
    private NoticeService noticeService;
    //公告信息的录入
    @PostMapping("/add")
    public Result add(Notice notice) {
        noticeService.save(notice);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        noticeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    //公告信息的修改
    @PostMapping("/update")
    @ApiOperation("修改公告信息")
    public Result update(@RequestBody Notice notice) {
        noticeService.update(notice);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam int id) {
        Notice notice = noticeService.findById(id);
        return ResultGenerator.genSuccessResult(notice);
    }
    //显示公告信息
    @ApiOperation("显示公告信息")
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Notice> list = noticeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/insert")
    @ApiOperation("公告信息的录入")
    public Result insert(@RequestBody Notice notice) {
        noticeService.save(notice);
        return ResultGenerator.genSuccessResult();
    }
   
}
