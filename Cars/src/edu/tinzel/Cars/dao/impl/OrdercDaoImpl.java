package edu.tinzel.Cars.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.tinzel.Cars.dao.OrdercDao;
import edu.tinzel.Cars.entity.OrderC;
import edu.tinzel.Cars.util.BaseDao;

public class OrdercDaoImpl extends BaseDao implements OrdercDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	// 查询所有的订单信息
	public List<OrderC> QueryOrder() throws Exception {
		// 创建SQL语句
		String sql = "SELECT o.orderId,o.customerId,c.carId,c.carName,c.carType,o.sellPrice,c.carToArea,o.sellDate,o.state FROM orders o,cars c WHERE o.carId=c.carId";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<OrderC> list = new ArrayList<OrderC>();
		while (this.rs.next()) {
			list.add(new OrderC(this.rs.getInt("orderId"), this.rs
					.getInt("customerId"), this.rs.getInt("carId"), this.rs
					.getString("carName"), this.rs.getString("carType"),
					this.rs.getDouble("sellPrice"), this.rs
							.getString("carToArea"), this.rs
							.getString("sellDate"), this.rs.getInt("state")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据订单编号和销售日期查询订单信息
	public List<OrderC> QueryOrderByOid(int id, String date) throws Exception {
		// 创建SQL语句
		String sql = "SELECT o.orderId,o.customerId,c.carId,c.carName,c.carType,o.sellPrice,c.carToArea,o.sellDate,o.state FROM orders o,cars c WHERE o.carId=c.carId AND o.orderId=? AND o.sellDate=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		this.ps.setString(2, date);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<OrderC> list = new ArrayList<OrderC>();
		while (this.rs.next()) {
			list.add(new OrderC(this.rs.getInt("orderId"), this.rs
					.getInt("customerId"), this.rs.getInt("carId"), this.rs
					.getString("carName"), this.rs.getString("carType"),
					this.rs.getDouble("sellPrice"), this.rs
							.getString("carToArea"), this.rs
							.getString("sellDate"), this.rs.getInt("state")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据客户编号和销售日期查询订单信息
	public List<OrderC> QueryOrderByCuid(int id, String date) throws Exception {
		// 创建SQL语句
		String sql = "SELECT o.orderId,o.customerId,c.carId,c.carName,c.carType,o.sellPrice,c.carToArea,o.sellDate,o.state FROM orders o,cars c WHERE o.carId=c.carId AND o.customerId=? AND o.sellDate=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		this.ps.setString(2, date);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<OrderC> list = new ArrayList<OrderC>();
		while (this.rs.next()) {
			list.add(new OrderC(this.rs.getInt("orderId"), this.rs
					.getInt("customerId"), this.rs.getInt("carId"), this.rs
					.getString("carName"), this.rs.getString("carType"),
					this.rs.getDouble("sellPrice"), this.rs
							.getString("carToArea"), this.rs
							.getString("sellDate"), this.rs.getInt("state")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据汽车编号和销售日期查询订单信息
	public List<OrderC> QueryOrderByCarid(int id, String date) throws Exception {
		// 创建SQL语句
		String sql = "SELECT o.orderId,o.customerId,c.carId,c.carName,c.carType,o.sellPrice,c.carToArea,o.sellDate,o.state FROM orders o,cars c WHERE o.carId=c.carId AND c.carId=? AND o.sellDate=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		this.ps.setString(2, date);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<OrderC> list = new ArrayList<OrderC>();
		while (this.rs.next()) {
			list.add(new OrderC(this.rs.getInt("orderId"), this.rs
					.getInt("customerId"), this.rs.getInt("carId"), this.rs
					.getString("carName"), this.rs.getString("carType"),
					this.rs.getDouble("sellPrice"), this.rs
							.getString("carToArea"), this.rs
							.getString("sellDate"), this.rs.getInt("state")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据汽车名称和销售日期查询订单信息
	public List<OrderC> QueryOrderByCarName(String carName, String date)
			throws Exception {
		// 创建SQL语句
		String sql = "SELECT o.orderId,o.customerId,c.carId,c.carName,c.carType,o.sellPrice,c.carToArea,o.sellDate,o.state FROM orders o,cars c WHERE o.carId=c.carId AND c.carName=? AND o.sellDate=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, carName);
		this.ps.setString(2, date);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<OrderC> list = new ArrayList<OrderC>();
		while (this.rs.next()) {
			list.add(new OrderC(this.rs.getInt("orderId"), this.rs
					.getInt("customerId"), this.rs.getInt("carId"), this.rs
					.getString("carName"), this.rs.getString("carType"),
					this.rs.getDouble("sellPrice"), this.rs
							.getString("carToArea"), this.rs
							.getString("sellDate"), this.rs.getInt("state")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据汽车型号和销售日期查询订单信息
	public List<OrderC> QueryOrderByCarType(String carType, String date)
			throws Exception {
		// 创建SQL语句
		String sql = "SELECT o.orderId,o.customerId,c.carId,c.carName,c.carType,o.sellPrice,c.carToArea,o.sellDate,o.state FROM orders o,cars c WHERE o.carId=c.carId AND c.carType=? AND o.sellDate=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, carType);
		this.ps.setString(2, date);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<OrderC> list = new ArrayList<OrderC>();
		while (this.rs.next()) {
			list.add(new OrderC(this.rs.getInt("orderId"), this.rs
					.getInt("customerId"), this.rs.getInt("carId"), this.rs
					.getString("carName"), this.rs.getString("carType"),
					this.rs.getDouble("sellPrice"), this.rs
							.getString("carToArea"), this.rs
							.getString("sellDate"), this.rs.getInt("state")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据编号删除订单
	public boolean delOrderById(int id) throws Exception {
		// 创建SQL语句
		String sql = "DELETE FROM orders WHERE orderId=?";
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

	// 添加订单
	public boolean addOrders(OrderC carorder) throws Exception {
		// 创建SQL语句
		String sql = "INSERT INTO orders(customerId,carId,carType,sellDate,state,sellPrice,carToArea,remark) VALUES(?,?,?,?,?,?,?,?)";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, carorder.getCustomerId());
		this.ps.setInt(2, carorder.getCarId());
		this.ps.setString(3, carorder.getCarType());
		this.ps.setString(4, carorder.getSellDate());
		this.ps.setInt(5, carorder.getState());
		this.ps.setDouble(6, carorder.getSellPrice());
		this.ps.setString(7, carorder.getCarToArea());
		this.ps.setString(8, carorder.getRemark());
		// 执行删除操作
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}
}
