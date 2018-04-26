package edu.tinzel.Cars.action;

import java.util.List;

import edu.tinzel.Cars.biz.CustomerBiz;
import edu.tinzel.Cars.biz.impl.CustomerBizImpl;
import edu.tinzel.Cars.entity.Customers;
import edu.tinzel.Cars.entity.Firms;
import edu.tinzel.Cars.entity.Visits;
import edu.tinzel.Cars.util.BaseAction;

public class CustomerAction extends BaseAction {
	private Customers custo;
	private Firms firms;
	private Visits visit;
	private String tmps;
	private String[] delid;

	public String getTmps() {
		return tmps;
	}

	public void setTmps(String tmps) {
		this.tmps = tmps;
	}

	public Customers getCusto() {
		return custo;
	}

	public void setCusto(Customers custo) {
		this.custo = custo;
	}

	public Firms getFirms() {
		return firms;
	}

	public void setFirms(Firms firms) {
		this.firms = firms;
	}

	public Visits getVisit() {
		return visit;
	}

	public void setVisit(Visits visit) {
		this.visit = visit;
	}

	CustomerBiz custBiz = new CustomerBizImpl();

	// 查询厂商信息
	public String queryFirms() throws Exception {
		List<Firms> list = custBiz.FirmsList();
		getRequest().setAttribute("firlist", list);
		return "firlist";
	}

	// 查询客户信息
	public String queryCust() throws Exception {
		List<Customers> list = custBiz.CustomersList();
		getRequest().setAttribute("customerlist", list);
		return "customerlist";
	}

	// 查询回访信息
	public String queryVisit() throws Exception {
		List<Visits> list = custBiz.VisitsList();
		getRequest().setAttribute("vislist", list);
		return "vislist";
	}

	// 根据厂商编号查询厂商信息
	public String queryFirmsById() throws Exception {
		Firms fir = custBiz.FirmsById(firms.getFirmId());
		getRequest().setAttribute("fir", fir);
		return "updfirm";
	}

	// 根据客户编号查询客户信息
	public String queryCById() throws Exception {
		Customers cus = custBiz.CustomerById(custo.getCustomerId());
		getRequest().setAttribute("cus", cus);
		return "updcust";
	}

	// 修改厂商信息
	public String updFirm() throws Exception {
		custBiz.updFirms(new Firms(firms.getFirmId(), firms.getFirmName(),
				firms.getFirmPerson(), firms.getFirmPhone(),
				firms.getFirmZip(), firms.getFirmAdds()));
		// 调用查询全部厂商信息
		return queryFirms();
	}

	// 修改客户信息
	public String updCust() throws Exception {
		custBiz.updCustomers(new Customers(custo.getCustomerId(), custo
				.getCustomerName(), null, custo.getCustomerPhone(), null, custo
				.getCustomerAdd()));
		// 调用查询全部客户信息
		return queryCust();
	}

	// 添加厂商信息
	public String addFirms() throws Exception {
		boolean bo = custBiz.addFirms(new Firms(firms.getFirmName(), firms
				.getFirmPerson(), firms.getFirmPhone(), firms.getFirmZip(),
				firms.getFirmAdds()));
		if (bo) {
			// 添加成功,调用查询全部厂商方法
			return queryFirms();
		} else {
			// 添加失败，返回添加页面
			return "addfirmsdeaf";
		}
	}

	// 添加客户信息
	public String addCustomers() throws Exception {
		boolean bo = custBiz.addCustomer(new Customers(custo.getCustomerName(),
				custo.getCustomerGender(), custo.getCustomerPhone(), custo
						.getCustomerCode(), custo.getCustomerAdd()));
		if (bo) {
			// 添加成功,调用查询全部客户方法
			return queryCust();
		} else {
			// 添加失败，返回添加页面
			return "addcustomersdeaf";
		}
	}

	// 根据编号删除厂商信息
	public String delFirms() throws Exception {
		if(getTmps()==null){
			return queryFirms();
		}else{
			delid = getTmps().split(", ");
			for (int i = 0; i < delid.length; i++) {
				custBiz.delFirms(Integer.parseInt(delid[i]));
			}
			return queryFirms();
		}
	}

	// 根据编号删除客户信息
	public String delCustomers() throws Exception {
		if(getTmps()==null){
			return queryCust();
		}else{
			delid = getTmps().split(", ");
			for (int i = 0; i < delid.length; i++) {
				custBiz.delCustomers(Integer.parseInt(delid[i]));
			}
			return queryCust();
		}
		
		
	}

	// 根据编号删除客户回访信息记录
	public String delVist() throws Exception {
		if(getTmps()==null){
			return queryVisit();
		}else{
			delid = getTmps().split(", ");
			for (int i = 0; i < delid.length; i++) {
				custBiz.delVisit(Integer.parseInt(delid[i]));
			}
			return queryVisit();
		}
	}
	//根据客户姓名和回访时间查询回访记录
	public String quertvd()throws Exception{
		List<Visits> list=custBiz.queryByvd(visit.getCustomerName(), visit.getVisitDate());
		getRequest().setAttribute("vislist", list);
		return "vislist";
	}
}
