package edu.tinzel.Cars.dao;

import java.util.List;
import java.util.concurrent.ExecutionException;

import edu.tinzel.Cars.entity.Customers;
import edu.tinzel.Cars.entity.Firms;
import edu.tinzel.Cars.entity.Visits;

public interface CustomerDao {
	/**
	 * 查询厂商信息
	 * @return
	 * @throws Exception
	 */
	public List<Firms> FirmsList()throws Exception;
	/**
	 * 查询客户信息
	 * @return
	 * @throws Exception
	 */
	public List<Customers> CustomersList()throws Exception;
	/**
	 * 查询回访信息
	 * @return
	 * @throws Exception
	 */
	public List<Visits> VisitsList()throws Exception;
	/**
	 * 根据厂商编号查询厂商详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Firms FirmsById(int id) throws Exception;
	/**
	 *  根据客户编号查询客户详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Customers CustomerById(int id) throws Exception ;
	/**
	 * 修改厂商信息
	 * @param firm
	 * @return
	 * @throws Exception
	 */
	public boolean updFirms(Firms firm)throws Exception;
	/**
	 * 修改客户信息
	 * @param cost
	 * @return
	 * @throws Exception
	 */
	public boolean updCustomers(Customers cost)throws Exception;
	/**
	 * 添加厂商信息
	 * @param firms
	 * @return
	 * @throws Exception
	 */
	public boolean addFirms(Firms firms)throws Exception;
	/**
	 * 添加客户信息
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	public boolean addCustomer(Customers customer)throws Exception;
	/**
	 * 根据编号删除厂商信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delFirms(int id)throws Exception;
	/**
	 * 根据编号删除客户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delCustomers(int id)throws Exception;
	/**
	 * 根据编号删除客户回访信息记录
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delVisit(int id)throws Exception;
	/**
	 * 通过客户姓名和回访时间查询
	 * @return
	 * @throws Exception
	 */
	public List<Visits> queryByvd(String name,String date)throws Exception;
}
