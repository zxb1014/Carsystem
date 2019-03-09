package com.carsystem.controller;
import com.carsystem.core.Result;
import com.carsystem.core.ResultGenerator;
import com.carsystem.entity.History;
import com.carsystem.service.HistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
@RequestMapping("/history")
public class HistoryController {
    @Resource
    private HistoryService historyService;

    @PostMapping("/add")
    public Result add(History history) {
        historyService.save(history);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id) {
        historyService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(History history) {
        historyService.update(history);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam int id) {
        History history = historyService.findById(id);
        return ResultGenerator.genSuccessResult(history);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<History> list = historyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
