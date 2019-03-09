package com.carsystem.service.impl;

import com.carsystem.dao.CuserMapper;
import com.carsystem.entity.Cuser;
import com.carsystem.service.CuserService;
import com.carsystem.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/02/27.
 */
@Service
@Transactional
public class CuserServiceImpl extends AbstractService<Cuser> implements CuserService {
    @Resource
    private CuserMapper cuserMapper;

	@Override
	public Cuser login(String c_telnumber, String c_password) {
		// TODO Auto-generated method stub
		return cuserMapper.login(c_telnumber,c_password);
	}

	@Override
	public int exittelnumber(String c_telnumber) {
		// TODO Auto-generated method stub
		return cuserMapper.exittelnumber(c_telnumber);
	}

}
