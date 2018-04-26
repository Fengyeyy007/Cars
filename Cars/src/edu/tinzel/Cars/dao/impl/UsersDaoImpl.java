package edu.tinzel.Cars.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.tinzel.Cars.dao.UsersDao;
import edu.tinzel.Cars.entity.Users;
import edu.tinzel.Cars.util.BaseDao;

public class UsersDaoImpl extends BaseDao implements UsersDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	// 登录
	@Override
	public Users login(String loginName, String loginPwd) throws Exception {
		// 创建SQL语句
		String sql = "select * from users where loginName=? and loginPwd=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, loginName);
		this.ps.setString(2, loginPwd);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		Users users = null;
		if (this.rs.next()) {
			users = new Users(this.rs.getInt("userId"),
					this.rs.getString("userName"),
					this.rs.getString("loginName"),
					this.rs.getString("loginPwd"));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return users;
	}

	// 根据编号查询用户信息
	public Users queryById(int id) throws Exception {
		// 创建SQL语句
		String sql = "select * from users where userId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		Users users = null;
		if (this.rs.next()) {
			users = new Users(this.rs.getInt("userId"),
					this.rs.getString("userName"),
					this.rs.getString("loginName"),
					this.rs.getString("loginPwd"));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return users;
	}

	// 根据用户名查询用户编号
	public int queryByName(String name) throws Exception {
		// 创建SQL语句
		String sql = "select userId from users where loginName=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1,name);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		int uid=0;
		if (this.rs.next()) {
			uid=this.rs.getInt("userId");
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return uid;
	}
}
