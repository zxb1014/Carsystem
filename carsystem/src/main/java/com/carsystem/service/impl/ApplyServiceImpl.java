package com.carsystem.service.impl;

import com.carsystem.dao.ApplyMapper;
import com.carsystem.entity.Apply;
import com.carsystem.service.ApplyService;
import com.carsystem.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/02/27.
 */
@Service
@Transactional
public class ApplyServiceImpl extends AbstractService<Apply> implements ApplyService {
    @Resource
    private ApplyMapper applyMapper;

}
