package edu.tinzel.Cars.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.tinzel.Cars.dao.TjDao;
import edu.tinzel.Cars.entity.CustTj;
import edu.tinzel.Cars.util.BaseDao;

public class TjDaoImpl extends BaseDao implements TjDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	// 查询客户的地址和人数
	public List<CustTj> queryAll() throws Exception {
		// 创建SQL语句
		String sql = "SELECT customerAdd,COUNT(*) FROM customers GROUP BY customerAdd  ";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<CustTj> list = new ArrayList<CustTj>();
		while (this.rs.next()) {
			list.add(new CustTj(this.rs.getString(1), this.rs
					.getInt(2)));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

}
