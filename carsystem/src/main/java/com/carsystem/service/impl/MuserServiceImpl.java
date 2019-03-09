package com.carsystem.service.impl;

import com.carsystem.dao.MuserMapper;
import com.carsystem.entity.Muser;
import com.carsystem.service.MuserService;
import com.carsystem.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/02/27.
 */
@Service
@Transactional
public class MuserServiceImpl extends AbstractService<Muser> implements MuserService {
    @Resource
    private MuserMapper muserMapper;

	@Override
	public Muser login(String m_telnumber, String m_password) {
		// TODO Auto-generated method stub
		return muserMapper.login(m_telnumber, m_password);
	}

}
