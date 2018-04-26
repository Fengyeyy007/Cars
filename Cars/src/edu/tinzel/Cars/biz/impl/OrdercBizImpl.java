package edu.tinzel.Cars.biz.impl;

import java.util.ArrayList;
import java.util.List;

import edu.tinzel.Cars.biz.OrdercBiz;
import edu.tinzel.Cars.dao.OrdercDao;
import edu.tinzel.Cars.dao.impl.OrdercDaoImpl;
import edu.tinzel.Cars.entity.OrderC;

public class OrdercBizImpl implements OrdercBiz {
	OrdercDao orderDao=new OrdercDaoImpl();
	@Override
	//查询所有订单
	public List<OrderC> QueryOrder() throws Exception {
		
		return this.orderDao.QueryOrder();
	}

	// 根据订单编号和销售日期查询订单信息
	public List<OrderC> QueryOrderByOid(int id,String date) throws Exception {
		return this.orderDao.QueryOrderByOid(id, date);
	}

	// 根据客户编号和销售日期查询订单信息
	public List<OrderC> QueryOrderByCuid(int id,String date) throws Exception {
		return this.orderDao.QueryOrderByCuid(id, date);
	}

	// 根据汽车编号和销售日期查询订单信息
	public List<OrderC> QueryOrderByCarid(int id,String date) throws Exception {
		return this.orderDao.QueryOrderByCarid(id, date);
	}

	// 根据汽车名称和销售日期查询订单信息
	public List<OrderC> QueryOrderByCarName(String carName,String date) throws Exception {
		return this.orderDao.QueryOrderByCarName(carName, date);
	}

	// 根据汽车型号和销售日期查询订单信息
	public List<OrderC> QueryOrderByCarType(String carType,String date) throws Exception {
		return this.orderDao.QueryOrderByCarType(carType, date);
	}
	// 根据编号删除订单
	public boolean delOrderById(int id) throws Exception{
		return this.orderDao.delOrderById(id);
	}
	// 添加订单
	public boolean addOrders(OrderC carorder)throws Exception{
		return this.orderDao.addOrders(carorder);
	}
}
