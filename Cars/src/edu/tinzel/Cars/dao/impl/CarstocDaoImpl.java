package edu.tinzel.Cars.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.tinzel.Cars.dao.CarstocDao;
import edu.tinzel.Cars.entity.Cars;
import edu.tinzel.Cars.entity.Carstoc;
import edu.tinzel.Cars.entity.CartBy;
import edu.tinzel.Cars.entity.Ccarstocks;
import edu.tinzel.Cars.entity.Stocks;
import edu.tinzel.Cars.util.BaseDao;

public class CarstocDaoImpl extends BaseDao implements CarstocDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	// 新车入库，汽车添加到仓库
	public boolean addcars(Carstoc carst) throws Exception {
		// 创建SQL语句
		String sql = "insert into cars(carId,carName,carType,engineId,carToArea,createDate,carColor,carFromArea,stockId,intoStockDate,remarks) values(?,?,?,?,?,?,?,?,?,?,?)";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, carst.getCarId());
		this.ps.setString(2, carst.getCarName());
		this.ps.setString(3, carst.getCarType());
		this.ps.setString(4, carst.getEngineId());
		this.ps.setString(5, carst.getCarToArea());
		this.ps.setString(6, carst.getCreateDate());
		this.ps.setString(7, carst.getCarColor());
		this.ps.setString(8, carst.getCarFromArea());
		this.ps.setInt(9, carst.getStockId());
		this.ps.setString(10, carst.getIntoStockDate());
		this.ps.setString(11, carst.getRemarks());
		// 执行查询操作
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	@Override
	// 根据仓库名查询仓库id
	public int querystockIdByName(String name) throws Exception {
		// 创建SQL语句
		String sql = "SELECT stockId FROM stocks WHERE stockName=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, name);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		int id = 0;
		if (this.rs.next()) {
			id = this.rs.getInt("stockId");
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return id;
	}

	// 汽车详情，查看汽车详细信息
	public List<Carstoc> CrasList() throws Exception {
		// 创建SQL语句
		String sql = "SELECT * FROM stocks s,cars c WHERE s.stockId=c.stockId";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Carstoc> list = new ArrayList<Carstoc>();
		while (this.rs.next()) {
			list.add(new Carstoc(this.rs.getInt("carId"), this.rs
					.getString("carName"), this.rs.getString("carType"),
					this.rs.getString("engineId"), this.rs
							.getString("carToArea"), this.rs
							.getString("createDate"), this.rs
							.getString("carColor"), this.rs
							.getString("carFromArea"), this.rs
							.getInt("stockId"), this.rs.getString("stockName"),
					this.rs.getString("intoStockDate"), this.rs
							.getString("remarks"), this.rs.getInt("maxSum"),
					this.rs.getInt("liveSum")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 查询所有仓库（仓库列表）
	public List<Stocks> stocksList() throws Exception {
		// 创建SQL语句
		String sql = "SELECT stockId,stockName FROM stocks";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Stocks> list = new ArrayList<Stocks>();
		while (this.rs.next()) {
			list.add(new Stocks(this.rs.getInt("stockId"), this.rs
					.getString("stockName")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 查询所有汽车的名称（汽车列表）
	public List<String> carNameList() throws Exception {
		// 创建SQL语句
		String sql = "SELECT DISTINCT carName FROM cars";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<String> list = new ArrayList<String>();
		while (this.rs.next()) {
			list.add(this.rs.getString("carName"));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 查询汽车表中的仓库信息（放有汽车的仓库）
	public List<Ccarstocks> stocbList() throws Exception {
		// 创建SQL语句
		String sql = "SELECT DISTINCT s.stockId,s.stockName,s.stockPlace,s.maxSum FROM stocks s,cars c WHERE s.stockId=c.stockId";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Ccarstocks> list = new ArrayList<Ccarstocks>();
		while (this.rs.next()) {
			list.add(new Ccarstocks(this.rs.getInt("stockId"), this.rs
					.getString("stockName"), this.rs.getString("stockPlace"),
					this.rs.getInt("maxSum")));

		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据仓库编号查询仓库中的汽车信息
	public List<Carstoc> carstocList() throws Exception {
		// 创建SQL语句
		String sql = "SELECT s.stockId,s.stockName,s.stockPlace,s.maxSum,c.carName,c.carType,s.liveSum FROM stocks s,cars c WHERE s.stockId=c.stockId";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Carstoc> list = new ArrayList<Carstoc>();
		while (this.rs.next()) {
			list.add(new Carstoc(this.rs.getString("carName"), this.rs
					.getString("carType"), this.rs.getInt("stockId"), this.rs
					.getInt("maxSum"), this.rs.getInt("liveSum")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据条件查询仓库车辆信息
	public List<Carstoc> carstocby(CartBy carby) throws Exception {
		// 创建SQL语句
		String sql = "SELECT s.stockId,s.stockName,s.stockPlace,s.maxSum,c.carName,c.carType,s.liveSum FROM stocks s,cars c WHERE s.stockId=c.stockId AND s.stockName=? AND c.carName=? AND c.carType=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, carby.getStockName());
		this.ps.setString(2, carby.getCarName());
		this.ps.setString(3, carby.getCarType());
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Carstoc> list = new ArrayList<Carstoc>();
		while (this.rs.next()) {
			list.add(new Carstoc(this.rs.getString("carName"), this.rs
					.getString("carType"), this.rs.getString("stockName"),
					this.rs.getInt("maxSum"), this.rs.getInt("liveSum"),
					this.rs.getString("stockPlace")));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	// 根据汽车id查询汽车详细信息
	public Cars queryCarById(int id) throws Exception {
		// 创建SQL语句
		String sql = "SELECT carId,carName,carType,carColor,stockId FROM cars WHERE carId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		this.rs = this.ps.executeQuery();
		Cars car = null;
		if (this.rs.next()) {
			car = new Cars(this.rs.getInt("carId"),
					this.rs.getString("carName"), this.rs.getString("carType"),
					this.rs.getString("carColor"),this.rs.getInt("stockId"));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return car;
	}

	// 修改汽车所属仓库(汽车移库)
	public boolean updCar(int carid, int sid) throws Exception {
		// 创建SQL语句
		String sql = "UPDATE cars SET stockId=? WHERE carId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, sid);
		this.ps.setInt(2, carid);
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}
}
