package edu.tinzel.Cars.biz.impl;

import java.util.List;

import edu.tinzel.Cars.biz.StocksBiz;
import edu.tinzel.Cars.dao.StocksDao;
import edu.tinzel.Cars.dao.impl.StocksDaoImpl;
import edu.tinzel.Cars.entity.Stocks;

public class StocksBizImpl implements StocksBiz {
	StocksDao stoDao = new StocksDaoImpl();

	@Override
	// 查询全部仓库信息
	public List<Stocks> QueryAll() throws Exception {

		return this.stoDao.QueryAll();
	}

	@Override
	// 查看单个仓库信息
	public Stocks QueryById(int id) throws Exception {

		return this.stoDao.QueryById(id);
	}

	@Override
	// 修改仓库信息
	public boolean upd(Stocks sto) throws Exception {

		return this.stoDao.upd(sto);
	}

	@Override
	// 删除仓库信息
	public boolean del(int id) throws Exception {

		return this.stoDao.del(id);
	}

	// 新车入库，库存加1
	public boolean updcar(int id) throws Exception {
		return this.stoDao.updcar(id);
	}
	//汽车移库，库存减1
	public boolean updcarj(int id)throws Exception{
		return this.stoDao.updcarj(id);
	}
	// 添加仓库
	public boolean addstocks(Stocks stock) throws Exception {
		return this.stoDao.addstocks(stock);
	}
}
