package edu.tinzel.Cars.biz;

import java.util.List;

import edu.tinzel.Cars.entity.Stocks;

public interface StocksBiz {
	/**
	 * 查询全部仓库信息
	 * @return
	 * @throws Exception
	 */
	public List<Stocks> QueryAll()throws Exception;
	/**
	 * 根据编号查询单个仓库的详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Stocks QueryById(int id)throws Exception;
	/**
	 * 修改仓库信息
	 * @param sto
	 * @return
	 * @throws Exception
	 */
	public boolean upd(Stocks sto)throws Exception;
	/**
	 * 删除仓库
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean del(int id)throws Exception;
	/**
	 * 新车入库，库存加1
	 * @param sto
	 * @return
	 * @throws Exception
	 */
	public boolean updcar(int id)throws Exception;
	/**
	 * 汽车移库，库存减1
	 * @param sto
	 * @return
	 * @throws Exception
	 */
	public boolean updcarj(int id)throws Exception;
	/**
	 * 添加仓库
	 * @param stock
	 * @return
	 * @throws Exception
	 */
	public boolean addstocks(Stocks stock)throws Exception;
}
