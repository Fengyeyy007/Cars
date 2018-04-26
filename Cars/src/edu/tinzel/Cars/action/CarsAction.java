package edu.tinzel.Cars.action;

import java.util.List;

import edu.tinzel.Cars.biz.CarstocBiz;
import edu.tinzel.Cars.biz.StocksBiz;
import edu.tinzel.Cars.biz.impl.CarstocBizImpl;
import edu.tinzel.Cars.biz.impl.StocksBizImpl;
import edu.tinzel.Cars.entity.Cars;
import edu.tinzel.Cars.entity.Carstoc;
import edu.tinzel.Cars.entity.Ccarstocks;
import edu.tinzel.Cars.entity.Stocks;
import edu.tinzel.Cars.util.BaseAction;
import edu.tinzel.Cars.util.Pager;
import edu.tinzel.Cars.entity.CartBy;

public class CarsAction extends BaseAction {
	private Carstoc cars;
	private String pagers;
	private String yids;
	private String[] delid;
	private int delstockId;
	
	public int getDelstockId() {
		return delstockId;
	}

	public void setDelstockId(int delstockId) {
		this.delstockId = delstockId;
	}

	public String getYids() {
		return yids;
	}

	public void setYids(String yids) {
		this.yids = yids;
	}

	public String getPagers() {
		return pagers;
	}

	public void setPagers(String pagers) {
		this.pagers = pagers;
	}

	public Carstoc getCars() {
		return cars;
	}

	public void setCars(Carstoc cars) {
		this.cars = cars;
	}

	CarstocBiz carsBiz = new CarstocBizImpl();
	StocksBiz stockBiz = new StocksBizImpl();

	// 跳转到新车入库页面（addcar.jsp）
	public String addCars() throws Exception {
		List<Stocks> list = stockBiz.QueryAll();
		getRequest().setAttribute("stos", list);
		return "addcar";
	}

	// 添加汽车到仓库
	public String addCarss() throws Exception {
		// 根据仓库名查询仓库id
		int i = carsBiz.querystockIdByName(cars.getStockName());
		// 仓库库存加1
		boolean bo1 = stockBiz.updcar(i);
		boolean bo2 = carsBiz.addcars(new Carstoc(cars.getCarId(), cars
				.getCarName(), cars.getCarType(), cars.getEngineId(), cars
				.getCarToArea(), cars.getCreateDate(), cars.getCarColor(), cars
				.getCarFromArea(), i, null, cars.getIntoStockDate(), cars
				.getRemarks()));
		if (bo1 && bo2) {
			// 查看汽车详情
			return CarsList();
		} else {

			return addCars();
		}
	}

	// 查询汽车详情
	public String CarsList() throws Exception {
		List<Carstoc> list = carsBiz.CrasList();
		// getRequest().setAttribute("carslist", list);
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
		return "listcar";
	}

	// 查询有车的仓库车的情况
	public String CarstocList() throws Exception {
		// 汽车名列表
		List<String> list1 = carsBiz.carNameList();
		getRequest().setAttribute("carNamelist", list1);
		// 仓库列表
		List<Stocks> list2 = carsBiz.stocksList();
		getRequest().setAttribute("stockName", list2);
		// 放有汽车的仓库
		List<Ccarstocks> listb = carsBiz.stocbList();
		getRequest().setAttribute("liststo", listb);
		// 查询出仓库中的所有汽车
		List<Carstoc> list = carsBiz.carstocList();
		getRequest().setAttribute("list", list);
		return "stocelist";
	}

	// 根据条件查询仓库车辆信息
	public String CartBy() throws Exception {
		CartBy cart = new CartBy(cars.getStockName(), cars.getCarName(),
				cars.getCarType());
		List<Carstoc> list = carsBiz.carstocby(new CartBy(cars.getStockName(),
				cars.getCarName(), cars.getCarType()));
		getRequest().setAttribute("cartby", list);
		// 汽车名列表
		List<String> list1 = carsBiz.carNameList();
		getRequest().setAttribute("carNamelist", list1);
		// 仓库列表
		List<Stocks> list2 = carsBiz.stocksList();
		getRequest().setAttribute("stockName", list2);
		return "stocelist";
	}

	public String queryCarsByid() throws Exception {
		if (getYids() == null) {
			return CarsList();
		} else {
			delid = getYids().split(", ");
			for (int i = 0; i < delid.length; i++) {
				Cars car = carsBiz.queryCarById(Integer.parseInt(delid[i]));
				List<Stocks> list=stockBiz.QueryAll();
				getRequest().setAttribute("car", car);
				getRequest().setAttribute("stoNlist", list);
				return "Bycar";
			}
			return "Bycar";
		}
	}
	//汽车移库
	public String carsmovesto()throws Exception{
		carsBiz.updCar(cars.getCarId(), cars.getStockId());
		//新仓库库存加1
		stockBiz.updcar(cars.getStockId());
		//旧仓库库存减1
		stockBiz.updcarj(getDelstockId());
		return CarsList();
	}
}