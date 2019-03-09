package com.carsystem.dao;

import com.carsystem.core.Mapper;
import com.carsystem.entity.Suser;

public interface SuserMapper extends Mapper<Suser> {
	public Suser login(String s_telnumber, String s_password);
}