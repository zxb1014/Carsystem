package com.carsystem.dao;

import com.carsystem.core.Mapper;
import com.carsystem.entity.Muser;

public interface MuserMapper extends Mapper<Muser> {
	public Muser login(String m_telnumber,String m_password);
}