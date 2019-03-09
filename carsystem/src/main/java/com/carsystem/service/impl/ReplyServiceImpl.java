package com.carsystem.service.impl;

import com.carsystem.dao.ReplyMapper;
import com.carsystem.entity.Reply;
import com.carsystem.service.ReplyService;
import com.carsystem.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/02/27.
 */
@Service
@Transactional
public class ReplyServiceImpl extends AbstractService<Reply> implements ReplyService {
    @Resource
    private ReplyMapper replyMapper;

}
