package com.carsystem.service.impl;

import com.carsystem.dao.SuserMapper;
import com.carsystem.entity.Suser;
import com.carsystem.service.SuserService;
import com.carsystem.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/02/27.
 */
@Service
@Transactional
public class SuserServiceImpl extends AbstractService<Suser> implements SuserService {
    @Resource
    private SuserMapper suserMapper;

	@Override
	public Suser login(String s_telnumber, String s_password) {
		// TODO Auto-generated method stub
		return suserMapper.login(s_telnumber, s_password);
	}

}
