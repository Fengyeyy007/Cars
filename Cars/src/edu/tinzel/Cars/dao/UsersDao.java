package edu.tinzel.Cars.dao;

import edu.tinzel.Cars.entity.Users;

public interface UsersDao {
	/**
	 * 登录
	 * @param loginName
	 * @param loginPwd
	 * @return
	 * @throws Exception
	 */
	public Users login(String loginName,String loginPwd)throws Exception;
	/**
	 * 根据编号查询用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Users queryById(int id)throws Exception;
	/**
	 * 根据用户名查询用户编号
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int queryByName(String name)throws Exception;
}
