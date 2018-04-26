package edu.tinzel.Cars.dao;

import java.util.List;

import edu.tinzel.Cars.entity.Perview;
import edu.tinzel.Cars.entity.Uroleperview;
import edu.tinzel.Cars.entity.Users;

public interface UroleperviewDao {
	/**
	 * 查询用户的角色权限
	 * @return
	 * @throws Exception
	 */
	public List<Uroleperview> queryUrp()throws Exception;
	/**
	 * 根据用户id查询权限，显示树
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Uroleperview> queryTree(int id)throws Exception;
	/**
	 * 根据用户编号查询用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Uroleperview QuerymanageById(int id) throws Exception;
	/**
	 * 修改用户信息（修改姓名账号密码）
	 * @param uro
	 * @return
	 * @throws Exception
	 */
	public boolean upduser(Uroleperview uro)throws Exception;
	/**
	 * 根据角色名查询角色id
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int queryByname(String name)throws Exception;
	/**
	 * 修改用户角色
	 * @param userId
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public boolean updmanarole(int userId,int roleId) throws Exception;
	/**
	 * 查询所有角色信息
	 * @return
	 * @throws Exception
	 */
	public List<Uroleperview> querryAllrole()throws Exception;
	/**
	 * 根据角色编号查询单个角色详细信息
	 * @return
	 * @throws Exception
	 */
	public List<Uroleperview> querryroleById(int id)throws Exception;
	/**
	 * 根据角色编号修改角色信息
	 * @return
	 * @throws Exception
	 */
	public boolean updrole(Uroleperview uro)throws Exception;
	/**
	 * 根据角色id删除其所具有的第一代权限（perId=0）
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delrolepre(int id)throws Exception;
	/**
	 * 根据权限名查询出权限id
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int queryroleByName(String name)throws Exception;
	/**
	 * 根据角色id添加其所具有的第一代权限（perId=0）
	 * @return
	 * @throws Exception
	 */
	public boolean addrolepre(int roleId,int perId)throws Exception;
	/**
	 * 查询全部权限
	 * @return
	 * @throws Exception
	 */
	public List<Perview> QueryAllper()throws Exception;
	/**
	 * 根据权限编号查询单条权限的详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Perview QueryperById(int id)throws Exception;
	/**
	 * 修改权限
	 * @param per      
	 * @return
	 * @throws Exception
	 */
	public boolean updperview(Perview per)throws Exception;
	/**
	 * 根据用户编号删除用户表用户记录
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deluserById(int id)throws Exception;
	/**
	 * 根据用户编号删除用户角色表的记录
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delUroleById(int id)throws Exception;
	/**
	 * 添加用户表信息
	 * @param us
	 * @return
	 * @throws Exception
	 */
	public boolean Adduser(Users us)throws Exception;
	/**
	 * 添加用户角色表
	 * @param uid
	 * @param roid
	 * @return
	 * @throws Exception
	 */
	public boolean Addur(int uid,int roid)throws Exception;
	/**
	 * 根据编号删除角色
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delroleById(int id)throws Exception;
	/**
	 *根据编号删除权限角色表
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delrolepreById(int id)throws Exception;
	/**
	 * 根据Id删除权限
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delpre(int id)throws Exception; 
	/**
	 * 添加权限
	 * @param pre
	 * @return
	 * @throws Exception
	 */
	public boolean addpre(Perview pre)throws Exception;
}
