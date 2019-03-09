package com.carsystem.service.impl;

import com.carsystem.dao.HistoryMapper;
import com.carsystem.entity.History;
import com.carsystem.service.HistoryService;
import com.carsystem.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/02/27.
 */
@Service
@Transactional
public class HistoryServiceImpl extends AbstractService<History> implements HistoryService {
    @Resource
    private HistoryMapper historyMapper;

}
