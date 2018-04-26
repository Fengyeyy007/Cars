package edu.tinzel.Cars.action;

import java.util.List;

import edu.tinzel.Cars.biz.CarstocBiz;
import edu.tinzel.Cars.biz.CustomerBiz;
import edu.tinzel.Cars.biz.OrdercBiz;
import edu.tinzel.Cars.biz.StocksBiz;
import edu.tinzel.Cars.biz.impl.CarstocBizImpl;
import edu.tinzel.Cars.biz.impl.CustomerBizImpl;
import edu.tinzel.Cars.biz.impl.OrdercBizImpl;
import edu.tinzel.Cars.biz.impl.OrdercBizImpl;
import edu.tinzel.Cars.biz.impl.StocksBizImpl;
import edu.tinzel.Cars.entity.Cars;
import edu.tinzel.Cars.entity.Customers;
import edu.tinzel.Cars.entity.OrderC;
import edu.tinzel.Cars.util.BaseAction;
import edu.tinzel.Cars.util.Pager;

public class OrderAction extends BaseAction {
	private OrderC orderc;
	private String selectn;
	private String values;
	private String tmps;
	private String[] delid;
	private String pagers;
	private CustomerBiz custoBiz=new CustomerBizImpl();
	public String getPagers() {
		return pagers;
	}

	public void setPagers(String pagers) {
		this.pagers = pagers;
	}

	public String getTmps() {
		return tmps;
	}

	public void setTmps(String tmps) {
		this.tmps = tmps;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public String getSelectn() {
		return selectn;
	}

	public void setSelectn(String selectn) {
		this.selectn = selectn;
	}

	public OrderC getOrderc() {
		return orderc;
	}

	public void setOrderc(OrderC orderc) {
		this.orderc = orderc;
	}

	OrdercBiz orderBiz = new OrdercBizImpl();
	CarstocBiz carstBiz=new CarstocBizImpl();
	StocksBiz stBiz=new StocksBizImpl();
	// 查询全部订单信息，跳到订单列表页面
	public String queryAllOrder() throws Exception {
		List<OrderC> list = orderBiz.QueryOrder();
		getRequest().setAttribute("orderlist", list);
		return "SellList";
	}

	// 查询全部订单信息，跳到销售信息页面
	public String queryxs() throws Exception {
		List<OrderC> list = orderBiz.QueryOrder();
		// getRequest().setAttribute("selllist", list);
		// 从界面中获取页码
		int currentPaged = 1;

		// 用户有没有点击改变页码
		if (getPagers() != null && !getPagers().equals("")) {
			currentPaged = Integer.parseInt(getPagers());
		}
		// 1、创建分页类对象
		Pager pager = new Pager();
		// 2、需要分页的文本
		pager.setTopicSelect(list);
		// 3、设置每页显示行数
		pager.setSizePerPage(4);
		// 4、获取最大页数
		int maxPage = pager.getTotalPage();
		// 5、获取当前页
		/* pager.setCurrentPage(currentPaged); */
		if (currentPaged <= maxPage) {
			pager.setCurrentPage(currentPaged);
		} else {
			pager.setCurrentPage(maxPage);
		}
		getRequest().setAttribute("pager", pager);
		return "Listo";
	}

	// 按照条件查询订单信息
	public String querobby() throws Exception {
		if (getSelectn().equals("订单号")) {
			List<OrderC> list = orderBiz.QueryOrderByOid(
					Integer.parseInt(getValues()), orderc.getSellDate());
			getRequest().setAttribute("orderlist", list);
			return "SellList";
		} else if (getSelectn().equals("客户号")) {
			List<OrderC> list = orderBiz.QueryOrderByCuid(
					Integer.parseInt(getValues()), orderc.getSellDate());
			getRequest().setAttribute("orderlist", list);
			return "SellList";
		} else if (getSelectn().equals("车名称")) {
			List<OrderC> list = orderBiz.QueryOrderByCarName(getValues(),
					orderc.getSellDate());
			getRequest().setAttribute("orderlist", list);
			return "SellList";
		} else if (getSelectn().equals("车类型")) {
			List<OrderC> list = orderBiz.QueryOrderByCarType(getValues(),
					orderc.getSellDate());
			getRequest().setAttribute("orderlist", list);
			return "SellList";
		}
		return "";
	}

	public void pager(List list) throws Exception {
		// 从界面中获取页码
		int currentPaged = 1;

		// 用户有没有点击改变页码
		if (getPagers() != null && !getPagers().equals("")) {
			currentPaged = Integer.parseInt(getPagers());
		}
		// 1、创建分页类对象
		Pager pager = new Pager();
		// 2、需要分页的文本
		pager.setTopicSelect(list);
		// 3、设置每页显示行数
		pager.setSizePerPage(4);
		// 4、获取最大页数
		int maxPage = pager.getTotalPage();
		// 5、获取当前页
		/* pager.setCurrentPage(currentPaged); */
		if (currentPaged <= maxPage) {
			pager.setCurrentPage(currentPaged);
		} else {
			pager.setCurrentPage(maxPage);
		}
		getRequest().setAttribute("pager", pager);
	}

	// 按照条件查询销售信息
	public String quersbby() throws Exception {
		if (getSelectn().equals("订单号")) {
			List<OrderC> list = orderBiz.QueryOrderByOid(
					Integer.parseInt(getValues()), orderc.getSellDate());
			// getRequest().setAttribute("selllist", list);
			pager(list);
			return "Listo";
		} else if (getSelectn().equals("客户号")) {
			List<OrderC> list = orderBiz.QueryOrderByCuid(
					Integer.parseInt(getValues()), orderc.getSellDate());
//			getRequest().setAttribute("selllist", list);
			pager(list);
			return "Listo";
		} else if (getSelectn().equals("车名称")) {
			List<OrderC> list = orderBiz.QueryOrderByCarName(getValues(),
					orderc.getSellDate());
//			getRequest().setAttribute("selllist", list);
			pager(list);
			return "Listo";
		} else if (getSelectn().equals("车编号")) {
			List<OrderC> list = orderBiz.QueryOrderByCarid(
					Integer.parseInt(getValues()), orderc.getSellDate());
//			getRequest().setAttribute("selllist", list);
			pager(list);
			return "Listo";
		}
		return "";
	}

	// 根据编号删除订单信息
	public String delCustomers() throws Exception {
		if (getTmps() == null) {
			return queryAllOrder();
		} else {
			delid = getTmps().split(", ");
			for (int i = 0; i < delid.length; i++) {
				orderBiz.delOrderById(Integer.parseInt(delid[i]));
			}
			return queryxs();
		}
	}
	//进入到订单信息页面
	public String zhuan()throws Exception{
		List<Customers> list=custoBiz.CustomersList();
		getRequest().setAttribute("culist", list);
		return "order";
	}
	//提交订单
	public String addOrder()throws Exception{
		orderBiz.addOrders(new OrderC(orderc.getCustomerId(), orderc.getCarId(), orderc.getCarName(), orderc.getCarType(), orderc.getSellPrice(), orderc.getCarToArea(), orderc.getSellDate(), orderc.getState(), orderc.getRemark()));
		Cars cc=carstBiz.queryCarById(orderc.getCarId());
		stBiz.updcarj(cc.getStockId());
		//提交订单后跳到订单列表页面
		return queryAllOrder();
	}
}
