package edu.tinzel.Cars.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.tinzel.Cars.dao.StocksDao;
import edu.tinzel.Cars.entity.Stocks;
import edu.tinzel.Cars.util.BaseDao;

public class StocksDaoImpl extends BaseDao implements StocksDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	// 查询全部仓库信息
	@Override
	public List<Stocks> QueryAll() throws Exception {
		// 创建SQL语句
		String sql = "SELECT * FROM stocks";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		List<Stocks> list = new ArrayList<Stocks>();
		while (this.rs.next()) {
			Stocks sto = new Stocks(this.rs.getInt("stockId"),
					this.rs.getString("stockName"),
					this.rs.getString("stockPlace"), this.rs.getInt("maxSum"),
					this.rs.getInt("liveSum"));
			list.add(sto);
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	@Override
	// 根据编号查询单个仓库的详细信息
	public Stocks QueryById(int id) throws Exception {
		// 创建SQL语句
		String sql = "SELECT * FROM stocks WHERE stockId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		// 执行查询操作
		this.rs = this.ps.executeQuery();
		Stocks sto = null;
		if (this.rs.next()) {
			sto = new Stocks(this.rs.getInt("stockId"),
					this.rs.getString("stockName"),
					this.rs.getString("stockPlace"), this.rs.getInt("maxSum"),
					this.rs.getInt("liveSum"));
		}
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return sto;
	}

	@Override
	// 修改仓库信息
	public boolean upd(Stocks sto) throws Exception {
		// 创建SQL语句
		String sql = "UPDATE stocks SET stockName=?,stockPlace=?,maxSum=?,liveSum=? WHERE stockId=?";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, sto.getStockName());
		this.ps.setString(2, sto.getStockPlace());
		this.ps.setInt(3, sto.getMaxSum());
		this.ps.setInt(4, sto.getLiveSum());
		this.ps.setInt(5, sto.getStockId());
		// 执行修改操作
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	@Override
	// 删除仓库
	public boolean del(int id) throws Exception {
		// 创建SQL语句
		String sql = "DELETE FROM stocks WHERE stockId=?";
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

	// 新车入库，库存加1
	public boolean updcar(int id) throws Exception {
		// 创建SQL语句
		String sql = "UPDATE stocks SET liveSum=liveSum+1 WHERE stockId=?";
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
	//汽车移库，库存减1
	public boolean updcarj(int id)throws Exception{
		// 创建SQL语句
				String sql = "UPDATE stocks SET liveSum=liveSum-1 WHERE stockId=?";
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
	// 添加仓库
	public boolean addstocks(Stocks stock) throws Exception {
		// 创建SQL语句
		String sql = "INSERT INTO stocks(stockName,stockPlace,maxSum,liveSum) VALUES(?,?,?,0)";
		// 获取连接对象
		this.con = super.getcon();
		// 创建执行SQL语句对象
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, stock.getStockName());
		this.ps.setString(2, stock.getStockPlace());
		this.ps.setInt(3, stock.getMaxSum());
		boolean bo = this.ps.executeUpdate() > 0 ? true : false;
		// 关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}
}
