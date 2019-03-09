package com.carsystem.service;
import com.carsystem.entity.Suser;
import com.carsystem.core.Service;


/**
 * Created by CodeGenerator on 2019/02/27.
 */
public interface SuserService extends Service<Suser> {
	public Suser login(String s_telnumber, String s_password);
}
