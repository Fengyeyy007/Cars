package edu.tinzel.Cars.biz.impl;

import java.util.List;

import edu.tinzel.Cars.biz.CustomerBiz;
import edu.tinzel.Cars.dao.CustomerDao;
import edu.tinzel.Cars.dao.impl.CustomerDaoImpl;
import edu.tinzel.Cars.entity.Customers;
import edu.tinzel.Cars.entity.Firms;
import edu.tinzel.Cars.entity.Visits;

public class CustomerBizImpl implements CustomerBiz {
	CustomerDao custDao = new CustomerDaoImpl();

	@Override
	// 查询厂商信息
	public List<Firms> FirmsList() throws Exception {

		return this.custDao.FirmsList();
	}

	@Override
	// 查询客户信息
	public List<Customers> CustomersList() throws Exception {

		return this.custDao.CustomersList();
	}

	@Override
	// 查询回访信息
	public List<Visits> VisitsList() throws Exception {

		return this.custDao.VisitsList();
	}

	// 根据厂商编号查询厂商详细信息
	public Firms FirmsById(int id) throws Exception {
		return this.custDao.FirmsById(id);
	}

	// 根据客户编号查询客户详细信息
	public Customers CustomerById(int id) throws Exception {
		return this.custDao.CustomerById(id);
	}

	// 修改厂商信息
	public boolean updFirms(Firms firm) throws Exception {
		return this.custDao.updFirms(firm);
	}

	// 修改客户信息
	public boolean updCustomers(Customers cost) throws Exception {
		return this.custDao.updCustomers(cost);
	}

	@Override
	// 添加厂商信息
	public boolean addFirms(Firms firms) throws Exception {

		return this.custDao.addFirms(firms);
	}

	@Override
	// 添加客户信息
	public boolean addCustomer(Customers customer) throws Exception {

		return this.custDao.addCustomer(customer);
	}

	// 根据编号删除厂商信息
	public boolean delFirms(int id) throws Exception {
		return this.custDao.delFirms(id);
	}

	// 根据编号删除客户信息
	public boolean delCustomers(int id) throws Exception {
		return this.custDao.delCustomers(id);
	}

	// 根据编号删除客户回访信息记录
	public boolean delVisit(int id) throws Exception {
		return this.custDao.delVisit(id);
	}

	// 通过客户姓名和回访时间查询
	public List<Visits> queryByvd(String name,String date) throws Exception {
		return this.custDao.queryByvd(name, date);
	}
}
