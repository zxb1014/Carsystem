package com.carsystem.service;
import com.carsystem.entity.Cuser;

import ch.qos.logback.core.net.LoginAuthenticator;

import com.carsystem.core.Service;


/**
 * Created by CodeGenerator on 2019/02/27.
 */
public interface CuserService extends Service<Cuser> {
	public Cuser login(String c_telnumber,String  c_password);
	public  int exittelnumber(String c_telnumber);
}
