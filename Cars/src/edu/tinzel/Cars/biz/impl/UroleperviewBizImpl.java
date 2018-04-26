package edu.tinzel.Cars.biz.impl;

import java.util.List;

import edu.tinzel.Cars.biz.UroleperviewBiz;
import edu.tinzel.Cars.dao.UroleperviewDao;
import edu.tinzel.Cars.dao.impl.UroleperviewDaoImpl;
import edu.tinzel.Cars.entity.Perview;
import edu.tinzel.Cars.entity.Uroleperview;
import edu.tinzel.Cars.entity.Users;

public class UroleperviewBizImpl implements UroleperviewBiz {
	UroleperviewDao urpDao=new UroleperviewDaoImpl();
	@Override
	//查询用户的角色权限
	public List<Uroleperview> queryUrp() throws Exception {
		
		return this.urpDao.queryUrp();
	}
	//查询用户的权限树
	public List<Uroleperview> queryTree(int id) throws Exception {
		
		return this.urpDao.queryTree(id);
	}
	// 根据用户编号查询用户信息
	public Uroleperview QuerymanageById(int id) throws Exception{
		return this.urpDao.QuerymanageById(id);
		
	}
	// 修改用户信息（修改姓名账号密码）
	public boolean upduser(Uroleperview uro)throws Exception{
		return this.urpDao.upduser(uro);
	}
	// 根据角色名查询角色id
	public int queryByname(String name)throws Exception{
		return this.urpDao.queryByname(name);
	}
	// 修改用户角色
	public boolean updmanarole(int userId,int roleId) throws Exception{
		return this.urpDao.updmanarole(userId, roleId);
	}
	@Override
	//查询所有角色信息
	public List<Uroleperview> querryAllrole() throws Exception {
		
		return this.urpDao.querryAllrole();
	}
	@Override
	// 根据角色编号查询单个角色详细信息
	public List<Uroleperview> querryroleById(int id) throws Exception {
		
		return this.urpDao.querryroleById(id);
	}
	@Override
	// 根据角色编号修改角色信息
	public boolean updrole(Uroleperview uro) throws Exception {
		
		return this.urpDao.updrole(uro);
	}
	@Override
	// 根据角色id删除其所具有的第一代权限（perId=0）
	public boolean delrolepre(int id) throws Exception {
	
		return this.urpDao.delrolepre(id);
	}
	@Override
	// 根据权限名查询出权限id
	public int queryroleByName(String name) throws Exception {
		
		return this.urpDao.queryroleByName(name);
	}
	@Override
	// 根据角色id添加其所具有的第一代权限（perId=0）
	public boolean addrolepre(int roleId, int perId) throws Exception {
		
		return this.urpDao.addrolepre(roleId, perId);
	}
	//查询全部权限
	public List<Perview> QueryAllper()throws Exception{
		return this.urpDao.QueryAllper();
	}
	// 根据权限编号查询单条权限的详细信息
	public Perview QueryperById(int id)throws Exception{
		return this.urpDao.QueryperById(id);
	}
	// 修改权限
	public boolean updperview(Perview per)throws Exception{
		return this.urpDao.updperview(per);
		
	}
	// 根据用户编号删除用户表用户记录
	public boolean deluserById(int id)throws Exception{
		return this.urpDao.deluserById(id);
	}
	// 根据用户编号删除用户角色表的记录
	public boolean delUroleById(int id)throws Exception{
		return this.urpDao.delUroleById(id);
	}
	// 添加用户表信息
	public boolean Adduser(Users us) throws Exception {
		return this.urpDao.Adduser(us);
	}

	// 添加用户角色表
	public boolean Addur(int uid, int roid) throws Exception {
		return this.urpDao.Addur(uid, roid);
	}
	// 根据编号删除角色
	public boolean delroleById(int id) throws Exception {
		return this.urpDao.delroleById(id);
	}

	// 根据编号删除权限角色表
	public boolean delrolepreById(int id) throws Exception {
		return this.urpDao.delrolepreById(id);
	}
	// 根据Id删除权限
	public boolean delpre(int id) throws Exception {
		return this.urpDao.delpre(id);
	}

	// 添加权限
	public boolean addpre(Perview pre) throws Exception {
		return this.urpDao.addpre(pre);
	}
}
