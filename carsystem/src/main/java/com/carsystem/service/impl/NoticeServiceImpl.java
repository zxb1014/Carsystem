package com.carsystem.service.impl;

import com.carsystem.dao.NoticeMapper;
import com.carsystem.entity.Notice;
import com.carsystem.service.NoticeService;
import com.carsystem.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/03/08.
 */
@Service
@Transactional
public class NoticeServiceImpl extends AbstractService<Notice> implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

}
