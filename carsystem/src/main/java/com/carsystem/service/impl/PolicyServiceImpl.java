package com.carsystem.service.impl;

import com.carsystem.dao.PolicyMapper;
import com.carsystem.entity.Policy;
import com.carsystem.service.PolicyService;
import com.carsystem.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/02/27.
 */
@Service
@Transactional
public class PolicyServiceImpl extends AbstractService<Policy> implements PolicyService {
    @Resource
    private PolicyMapper policyMapper;

}
