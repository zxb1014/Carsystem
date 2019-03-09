package com.carsystem.dao;

import com.carsystem.core.Mapper;
import com.carsystem.entity.Cuser;

public interface CuserMapper extends Mapper<Cuser> {
	public Cuser login(String c_telnumber,String c_password);
	public  int exittelnumber(String c_telnumber);
}