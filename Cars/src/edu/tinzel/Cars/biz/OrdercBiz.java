package edu.tinzel.Cars.biz;

import java.util.List;

import edu.tinzel.Cars.entity.OrderC;

public interface OrdercBiz {
	/**
	 * 查询所有订单信息
	 * @return
	 * @throws Exception
	 */
	public List<OrderC> QueryOrder()throws Exception;
	/**
	 * 根据订单编号和销售日期查询订单信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<OrderC> QueryOrderByOid(int id,String date)throws Exception;
	/**
	 * 根据客户编号和销售日期查询订单信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<OrderC> QueryOrderByCuid(int id,String date)throws Exception;
	/**
	 * 根据汽车编号和销售日期查询订单信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<OrderC> QueryOrderByCarid(int id,String date)throws Exception;
	/**
	 * 根据汽车名称和销售日期查询订单信息
	 * @param carName
	 * @return
	 * @throws Exception
	 */
	public List<OrderC> QueryOrderByCarName(String carName,String date)throws Exception;
	/**
	 * 根据汽车型号和销售日期查询订单信息
	 * @param carType
	 * @return
	 * @throws Exception
	 */
	public List<OrderC> QueryOrderByCarType(String carType,String date)throws Exception;
	/**
	 * 根据编号删除订单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delOrderById(int id) throws Exception;
	/**
	 * 添加订单
	 * @param carorder
	 * @return
	 * @throws Exception
	 */
	public boolean addOrders(OrderC carorder)throws Exception;
}
