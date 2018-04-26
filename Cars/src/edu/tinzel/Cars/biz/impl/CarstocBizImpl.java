package edu.tinzel.Cars.biz.impl;

import java.util.List;

import edu.tinzel.Cars.biz.CarstocBiz;
import edu.tinzel.Cars.dao.CarstocDao;
import edu.tinzel.Cars.dao.impl.CarstocDaoImpl;
import edu.tinzel.Cars.entity.Cars;
import edu.tinzel.Cars.entity.Carstoc;
import edu.tinzel.Cars.entity.CartBy;
import edu.tinzel.Cars.entity.Ccarstocks;
import edu.tinzel.Cars.entity.Stocks;

public class CarstocBizImpl implements CarstocBiz {
	CarstocDao carDao = new CarstocDaoImpl();

	@Override
	// 新车入库
	public boolean addcars(Carstoc carst) throws Exception {

		return this.carDao.addcars(carst);
	}

	@Override
	// 根据仓库名称查询仓库编号
	public int querystockIdByName(String name) throws Exception {

		return this.carDao.querystockIdByName(name);
	}

	// 汽车详情，查看汽车详细信息
	public List<Carstoc> CrasList() throws Exception {
		return this.carDao.CrasList();
	}

	// 查询所有仓库（仓库列表）
	public List<Stocks> stocksList() throws Exception {
		return this.carDao.stocksList();

	}

	// 查询所有汽车的名称（汽车列表）
	public List<String> carNameList() throws Exception {
		return this.carDao.carNameList();
	}

	// 查询汽车表中的仓库信息（放有汽车的仓库）
	public List<Ccarstocks> stocbList() throws Exception {
		return this.carDao.stocbList();
	}

	// 查询仓库中的所有汽车信息
	public List<Carstoc> carstocList() throws Exception {
		return this.carDao.carstocList();
	}

	// 根据条件查询仓库车辆信息
	public List<Carstoc> carstocby(CartBy carby) throws Exception {
		return this.carDao.carstocby(carby);
	}

	// 根据汽车id查询汽车详细信息
	public Cars queryCarById(int id) throws Exception {
		return this.carDao.queryCarById(id);
	}

	// 修改汽车所属仓库(汽车移库)
	public boolean updCar(int carid, int sid) throws Exception {
		return this.carDao.updCar(carid, sid);
	}
}
