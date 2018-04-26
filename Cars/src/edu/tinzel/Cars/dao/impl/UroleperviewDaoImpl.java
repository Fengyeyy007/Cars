package edu.tinzel.Cars.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.tinzel.Cars.dao.UroleperviewDao;
import edu.tinzel.Cars.entity.Perview;
import edu.tinzel.Cars.entity.Uroleperview;
import edu.tinzel.Cars.entity.Users;
import edu.tinzel.Cars.util.BaseDao;

public class UroleperviewDaoImpl extends BaseDao implements UroleperviewDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	// 查询用户的角色权限
	@Override
	public List<Uroleperview> queryUrp() throws Exception {
		// 创建SQL语句
		String sql = "SELECT u.userId,r.roleId,p.perviewId,p.perId,r.roleMark,"
				+ "u.userName,r.roleName,p.perviewName FROM "
				+ "users u,roles r,usersroles ur,perview p,rolesPerview "
				+ "rp WHERE u.userId=ur.userId AND r.roleId=ur.roleId "
				+ "AND r.roleId=rp.roleId AND p.perviewId=rp.perviewId "
				+ "AND p.perId=0 ORDER BY u.userId ASC";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Uroleperview> list = new ArrayList<Uroleperview>();
		while (this.rs.next()) {
			Uroleperview urp = new Uroleperview(this.rs.getInt("userId"),
					this.rs.getInt("roleId"), this.rs.getInt("perviewId"),
					this.rs.getInt("perId"), this.rs.getString("roleMark"),
					this.rs.getString("userName"),
					this.rs.getString("roleName"),
					this.rs.getString("perviewName"));
			list.add(urp);
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	/**
	 * 根据用户id查询权限，显示树
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Uroleperview> queryTree(int id) throws Exception {
		// 创建SQL语句
		String sql = "SELECT u.userId,r.roleId,p.perviewId,p.perId,r.roleMark,u.userName,r.roleName,p.perviewName,p.perviewUrl FROM users u,roles r,usersroles ur,perview p,rolesPerview rp WHERE u.userId=ur.userId AND r.roleId=ur.roleId AND r.roleId=rp.roleId AND p.perviewId=rp.perviewId AND u.userId=? ";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Uroleperview> list = new ArrayList<Uroleperview>();
		while (this.rs.next()) {
			Uroleperview urp = new Uroleperview(this.rs.getInt("userId"),
					this.rs.getInt("roleId"), this.rs.getInt("perviewId"),
					this.rs.getInt("perId"), this.rs.getString("roleMark"),
					this.rs.getString("userName"),
					this.rs.getString("roleName"),
					this.rs.getString("perviewName"),
					this.rs.getString("perviewUrl"));
			list.add(urp);
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据用户编号查询用户信息

	public Uroleperview QuerymanageById(int id) throws Exception {
		// 创建SQL语句
		String sql = "SELECT u.userId,u.loginName,u.loginPwd,u.userName,r.roleId,r.roleName FROM users u,roles r,usersroles ur,perview p,rolesPerview rp WHERE u.userId=ur.userId AND r.roleId=ur.roleId AND r.roleId=rp.roleId AND p.perviewId=rp.perviewId AND u.userId=? ";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		Uroleperview uro = null;
		if (this.rs.next()) {
			uro = new Uroleperview(this.rs.getInt("userId"),
					this.rs.getInt("roleId"), this.rs.getString("userName"),
					this.rs.getString("roleName"),
					this.rs.getString("loginPwd"),
					this.rs.getString("loginName"));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return uro;

	}

	// 修改用户信息（修改姓名账号密码）

	public boolean upduser(Uroleperview uro) throws Exception {
		// 创建SQL语句
		String sql = "UPDATE users SET loginPwd=?,userName=? WHERE userId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, uro.getLoginPwd());
		this.ps.setString(2, uro.getUserName());
		this.ps.setInt(3, uro.getUserId());
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;

	}

	// 根据角色名查询角色id

	public int queryByname(String name) throws Exception {
		// 创建SQL语句
		String sql = "SELECT roleId FROM roles WHERE roleName=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, name);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		int roleId = 0;
		if (this.rs.next()) {
			roleId = this.rs.getInt("roleId");
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return roleId;

	}

	// 修改用户角色

	public boolean updmanarole(int userId, int roleId) throws Exception {
		// 创建SQL语句
		String sql = "UPDATE usersroles SET roleId=? WHERE userId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, roleId);
		this.ps.setInt(2, userId);
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 查询所有角色信息
	public List<Uroleperview> querryAllrole() throws Exception {
		// 创建SQL语句
		String sql = "SELECT r.roleId,r.roleName,r.roleMark,p.perviewId,p.perviewName FROM roles r,perview p,rolesPerview rp WHERE r.roleId=rp.roleId AND p.perviewId=rp.perviewId AND p.perId=0 ORDER BY roleId";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Uroleperview> list = new ArrayList<Uroleperview>();
		while (this.rs.next()) {
			list.add(new Uroleperview(this.rs.getInt("roleId"), this.rs
					.getInt("perviewId"), this.rs.getString("roleMark"),
					this.rs.getString("roleName"), this.rs
							.getString("perviewName")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据角色编号查询单个角色详细信息
	public List<Uroleperview> querryroleById(int id) throws Exception {
		// 创建SQL语句
		String sql = "SELECT r.roleId,r.roleName,r.roleMark,p.perviewId,p.perviewName FROM roles r,perview p,rolesPerview rp WHERE r.roleId=rp.roleId AND p.perviewId=rp.perviewId AND p.perId=0 AND r.roleId=? ORDER BY roleId";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Uroleperview> list = new ArrayList<Uroleperview>();
		while (this.rs.next()) {
			list.add(new Uroleperview(this.rs.getInt("roleId"), this.rs
					.getInt("perviewId"), this.rs.getString("roleMark"),
					this.rs.getString("roleName"), this.rs
							.getString("perviewName")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据角色编号修改角色信息
	public boolean updrole(Uroleperview uro) throws Exception {
		// 创建SQL语句
		String sql = "UPDATE roles SET roleName=?,roleMark=? WHERE roleId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, uro.getRoleName());
		this.ps.setString(2, uro.getRoleMark());
		this.ps.setInt(3, uro.getRoleId());
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 根据角色id删除其所具有的第一代权限（perId=0）
	public boolean delrolepre(int id) throws Exception {
		// 创建SQL语句
		String sql = "DELETE FROM rolesperview WHERE roleId=? AND perviewId<=5";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 根据权限名查询出权限id
	public int queryroleByName(String name) throws Exception {
		// 创建SQL语句
		String sql = "SELECT perviewId FROM perview WHERE perviewName=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, name);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		int perId = 0;
		if (this.rs.next()) {
			perId = this.rs.getInt("perviewId");
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return perId;
	}

	// 根据角色id添加其所具有的第一代权限（perId=0）
	public boolean addrolepre(int roleId, int perId) throws Exception {
		// 创建SQL语句
		String sql = "INSERT INTO rolesPerview(roleId,perviewId) VALUES(?,?)";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, roleId);
		this.ps.setInt(2, perId);
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 查询全部权限
	public List<Perview> QueryAllper() throws Exception {
		// 创建SQL语句
		String sql = "SELECT perviewId,perviewName FROM perview WHERE perId=0";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.rs = this.ps.executeQuery();
		List<Perview> list = new ArrayList<Perview>();
		while (this.rs.next()) {
			list.add(new Perview(this.rs.getInt("perviewId"), this.rs
					.getString("perviewName")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据权限编号查询单条权限的详细信息
	public Perview QueryperById(int id) throws Exception {
		// 创建SQL语句
		String sql = "SELECT perviewId,perviewName FROM perview WHERE perId=0 AND perviewId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		this.rs = this.ps.executeQuery();
		Perview per = null;
		if (this.rs.next()) {
			per = new Perview(this.rs.getInt("perviewId"),
					this.rs.getString("perviewName"));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return per;
	}

	// 修改权限
	public boolean updperview(Perview per) throws Exception {
		// 创建SQL语句
		String sql = "UPDATE perview SET perviewName=? WHERE perviewId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, per.getPerviewName());
		this.ps.setInt(2, per.getPerviewId());
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 根据用户编号删除用户表用户记录
	public boolean deluserById(int id) throws Exception {
		// 创建SQL语句
		String sql = "DELETE FROM users WHERE userId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 根据用户编号删除用户角色表的记录
	public boolean delUroleById(int id) throws Exception {
		// 创建SQL语句
		String sql = "DELETE FROM usersroles WHERE userId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 添加用户表信息
	public boolean Adduser(Users us) throws Exception {
		// 创建SQL语句
		String sql = "INSERT INTO users(loginName,loginPwd,userName) VALUE(?,?,?)";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, us.getLoginName());
		this.ps.setString(2, us.getLoginPwd());
		this.ps.setString(3, us.getUserName());
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 添加用户角色表
	public boolean Addur(int uid, int roid) throws Exception {
		// 创建SQL语句
		String sql = "INSERT INTO usersroles(userId,roleId) VALUE(?,?)";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, uid);
		this.ps.setInt(2, roid);
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 根据编号删除角色
	public boolean delroleById(int id) throws Exception {
		// 创建SQL语句
		String sql = "DELETE FROM roles WHERE roleId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 根据编号删除权限角色表
	public boolean delrolepreById(int id) throws Exception {
		// 创建SQL语句
		String sql = "DELETE FROM rolesperview WHERE roleId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 根据Id删除权限
	public boolean delpre(int id) throws Exception {
		// 创建SQL语句
		String sql = "DELETE FROM perview WHERE perviewId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 添加权限
	public boolean addpre(Perview pre) throws Exception {
		// 创建SQL语句
		String sql = "INSERT INTO perview(perviewName,perId,perviewUrl) VALUES(?,0,'#')";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, pre.getPerviewName());
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}
}
