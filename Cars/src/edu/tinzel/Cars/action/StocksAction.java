package edu.tinzel.Cars.action;

import java.util.List;

import edu.tinzel.Cars.biz.StocksBiz;
import edu.tinzel.Cars.biz.impl.StocksBizImpl;
import edu.tinzel.Cars.entity.Stocks;
import edu.tinzel.Cars.util.BaseAction;
import edu.tinzel.Cars.util.Pager;

public class StocksAction extends BaseAction {
	private Stocks sto;
	private String pagers;
	private String dels;
	private String[] delid;
	
	public String getPagers() {
		return pagers;
	}

	public void setPagers(String pagers) {
		this.pagers = pagers;
	}

	public String getDels() {
		return dels;
	}

	public void setDels(String dels) {
		this.dels = dels;
	}

	public Stocks getSto() {
		return sto;
	}

	public void setSto(Stocks sto) {
		this.sto = sto;
	}

	StocksBiz stoBiz = new StocksBizImpl();

	// 查询全部仓库
	public String querysto() throws Exception {
		List<Stocks> list = stoBiz.QueryAll();
//		getRequest().setAttribute("stolist", list);
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
		return "querysto";
	}

	// 查询单个仓库详细信息
	public String queryById() throws Exception {
		Stocks stoo = stoBiz.QueryById(sto.getStockId());
		getRequest().setAttribute("isto", stoo);
		return "stoByIds";
	}

	// 修改
	public String upd() throws Exception {
		boolean bo = stoBiz.upd(new Stocks(sto.getStockId(),
				sto.getStockName(), sto.getStockPlace(), sto.getMaxSum(), sto
						.getLiveSum()));
		if (bo) {
			// 修改成功，调用查询全部方法
			return querysto();
		} else {
			// 修改失败，调用查询单个方法
			return queryById();
		}
	}
	//删除仓库
	public String delstock()throws Exception{
		if(getDels()==null){
			return querysto();
		}else{
			delid=getDels().split(", ");
			for(int i=0;i<delid.length;i++){
				stoBiz.del(Integer.parseInt(delid[i]));
			}
			return querysto();
		}
	}
	//添加仓库
	public String addsocks()throws Exception{
		stoBiz.addstocks(new Stocks(sto.getStockName(), sto.getStockPlace(), sto.getMaxSum()));
		return querysto();
	}
}
