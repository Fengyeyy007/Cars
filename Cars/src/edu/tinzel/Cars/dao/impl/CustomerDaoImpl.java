package edu.tinzel.Cars.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.tinzel.Cars.dao.CustomerDao;
import edu.tinzel.Cars.entity.Customers;
import edu.tinzel.Cars.entity.Firms;
import edu.tinzel.Cars.entity.Visits;
import edu.tinzel.Cars.util.BaseDao;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List<Firms> FirmsList() throws Exception {
		// 创建SQL语句
		String sql = "SELECT * FROM firms";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Firms> list = new ArrayList<Firms>();
		// 关闭释放数据库操作资源
		while (this.rs.next()) {
			list.add(new Firms(this.rs.getInt("firmId"), this.rs
					.getString("firmName"), this.rs.getString("firmPerson"),
					this.rs.getString("firmPhone"), this.rs
							.getString("firmZip"), this.rs
							.getString("firmAdds")));
		}
		super.close(rs, ps, con);
		return list;
	}

	@Override
	public List<Customers> CustomersList() throws Exception {
		// 创建SQL语句
		String sql = "SELECT * FROM Customers";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Customers> list = new ArrayList<Customers>();
		while (this.rs.next()) {
			list.add(new Customers(this.rs.getInt("customerId"), this.rs
					.getString("customerName"), this.rs
					.getString("customerGender"), this.rs
					.getString("customerPhone"), this.rs
					.getString("customerCode"), this.rs
					.getString("customerAdd")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	@Override
	public List<Visits> VisitsList() throws Exception {
		// 创建SQL语句
		String sql = "SELECT * FROM visits";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Visits> list = new ArrayList<Visits>();
		while (this.rs.next()) {
			list.add(new Visits(this.rs.getInt("id"), this.rs
					.getString("customerName"), this.rs.getString("visitDate"),
					this.rs.getString("visitEvent"), this.rs
							.getString("visitReCode")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据厂商编号查询厂商详细信息
	public Firms FirmsById(int id) throws Exception {
		// 创建SQL语句
		String sql = "SELECT * FROM firms WHERE firmId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		Firms firm = null;
		if (this.rs.next()) {
			firm = new Firms(this.rs.getInt("firmId"),
					this.rs.getString("firmName"),
					this.rs.getString("firmPerson"),
					this.rs.getString("firmPhone"),
					this.rs.getString("firmZip"), this.rs.getString("firmAdds"));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return firm;
	}

	// 根据客户编号查询客户详细信息
	public Customers CustomerById(int id) throws Exception {
		// 创建SQL语句
		String sql = "SELECT * FROM Customers WHERE customerId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		Customers cust = null;
		if (this.rs.next()) {
			cust = new Customers(this.rs.getInt("customerId"),
					this.rs.getString("customerName"),
					this.rs.getString("customerGender"),
					this.rs.getString("customerPhone"),
					this.rs.getString("customerCode"),
					this.rs.getString("customerAdd"));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return cust;
	}

	// 修改厂商信息
	public boolean updFirms(Firms firm) throws Exception {
		// 创建SQL语句
		String sql = "UPDATE firms SET firmName=?,firmPerson=?,firmPhone=?,firmZip=?,firmAdds=? WHERE firmId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, firm.getFirmName());
		this.ps.setString(2, firm.getFirmPerson());
		this.ps.setString(3, firm.getFirmPhone());
		this.ps.setString(4, firm.getFirmZip());
		this.ps.setString(5, firm.getFirmAdds());
		this.ps.setInt(6, firm.getFirmId());
		// 执行修改操作
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 修改客户信息
	public boolean updCustomers(Customers cost) throws Exception {
		// 创建SQL语句
		String sql = "UPDATE Customers SET customerName=?,customerPhone=?,customerAdd=? WHERE customerId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, cost.getCustomerName());
		this.ps.setString(2, cost.getCustomerPhone());
		this.ps.setString(3, cost.getCustomerAdd());
		this.ps.setInt(4, cost.getCustomerId());
		// 执行修改操作
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 添加厂商信息
	public boolean addFirms(Firms firms) throws Exception {
		// 创建SQL语句
		String sql = "insert into firms(firmName,firmPerson,firmPhone,firmZip,firmAdds) values(?,?,?,?,?)";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, firms.getFirmName());
		this.ps.setString(2, firms.getFirmPerson());
		this.ps.setString(3, firms.getFirmPhone());
		this.ps.setString(4, firms.getFirmZip());
		this.ps.setString(5, firms.getFirmAdds());
		// 执行添加操作
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 添加客户信息
	public boolean addCustomer(Customers customer) throws Exception {
		// 创建SQL语句
		String sql = "INSERT INTO customers(customerName,customerGender,customerPhone,customerCode,customerAdd) SELECT ?,?,?,?,? FROM DUAL  WHERE NOT EXISTS(SELECT * FROM customers WHERE customerCode=?);";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, customer.getCustomerName());
		this.ps.setString(2, customer.getCustomerGender());
		this.ps.setString(3, customer.getCustomerPhone());
		this.ps.setString(4, customer.getCustomerCode());
		this.ps.setString(5, customer.getCustomerAdd());
		this.ps.setString(6, customer.getCustomerCode());
		// 执行添加操作
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 根据编号删除厂商信息
	public boolean delFirms(int id) throws Exception {
		// 创建SQL语句
		String sql = "DELETE FROM firms WHERE firmId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		// 执行删除操作
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 根据编号删除客户信息
	public boolean delCustomers(int id) throws Exception {
		// 创建SQL语句
		String sql = "DELETE FROM customers WHERE customerId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		// 执行删除操作
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 根据编号删除客户回访信息记录
	public boolean delVisit(int id) throws Exception {
		// 创建SQL语句
		String sql = "DELETE FROM visits WHERE id=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		// 执行删除操作
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	// 通过客户姓名和回访时间查询
	public List<Visits> queryByvd(String name, String date) throws Exception {
		// 创建SQL语句
		String sql = "SELECT * FROM visits WHERE customerName=? AND visitDate=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, name);
		this.ps.setString(2, date);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Visits> list = new ArrayList<Visits>();
		while (this.rs.next()) {
			list.add(new Visits(this.rs.getInt("id"), this.rs
					.getString("customerName"), this.rs.getString("visitDate"),
					this.rs.getString("visitEvent"), this.rs
							.getString("visitReCode")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}
}
