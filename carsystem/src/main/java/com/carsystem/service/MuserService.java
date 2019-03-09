package com.carsystem.service;
import com.carsystem.entity.Muser;
import com.carsystem.core.Service;


/**
 * Created by CodeGenerator on 2019/02/27.
 */
public interface MuserService extends Service<Muser> {
	public Muser login(String m_telnumber,String m_password);
}
