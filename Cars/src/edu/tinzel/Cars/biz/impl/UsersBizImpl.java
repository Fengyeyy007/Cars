package edu.tinzel.Cars.biz.impl;

import edu.tinzel.Cars.biz.UsersBiz;
import edu.tinzel.Cars.dao.UsersDao;
import edu.tinzel.Cars.dao.impl.UsersDaoImpl;
import edu.tinzel.Cars.entity.Users;

public class UsersBizImpl implements UsersBiz {
	UsersDao usersDao=new UsersDaoImpl();
	@Override
	//用户登录
	public Users login(String loginName, String loginPwd) throws Exception {
		
		return this.usersDao.login(loginName, loginPwd);
	}
	//根据编号查询用户信息
	public Users queryById(int id) throws Exception{
		return this.usersDao.queryById(id);
		
	}
	// 根据用户名查询用户编号
	public int queryByName(String name)throws Exception{
		return this.usersDao.queryByName(name);
	}
}
