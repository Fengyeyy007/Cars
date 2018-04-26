package edu.tinzel.Cars.biz;

import java.util.List;

import edu.tinzel.Cars.entity.Cars;
import edu.tinzel.Cars.entity.Carstoc;
import edu.tinzel.Cars.entity.CartBy;
import edu.tinzel.Cars.entity.Ccarstocks;
import edu.tinzel.Cars.entity.Stocks;

public interface CarstocBiz {
	/**
	 * 新车入库，添加汽车到仓库
	 * @param carst
	 * @return
	 * @throws Exception
	 */
	public boolean addcars(Carstoc carst)throws Exception;
	/**
	 * 根据仓库名查询仓库Id
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int querystockIdByName(String name)throws Exception;
	/**
	 * 汽车详情，查看汽车详细信息
	 * @return
	 * @throws Exception
	 */
	public List<Carstoc> CrasList()throws Exception;
	/**
	 * 查询所有仓库（仓库列表）
	 * @return
	 * @throws Exception
	 */
	public List<Stocks> stocksList()throws Exception;
	/**
	 * 查询所有汽车的名称（汽车列表）
	 * @return
	 * @throws Exception
	 */
	public List<String> carNameList()throws Exception;
	/**
	 * 查询汽车表中的仓库信息（放有汽车的仓库）
	 * @return
	 * @throws Exception
	 */
	public List<Ccarstocks> stocbList()throws Exception;
	/**
	 * 查询仓库中的所有汽车信息
	 * @return
	 * @throws Exception
	 */
	public List<Carstoc> carstocList()throws Exception;
	/**
	 * 根据条件查询仓库车辆信息
	 * @return
	 * @throws Exception
	 */
	public List<Carstoc> carstocby(CartBy carby)throws Exception;
	/**
	 * 根据汽车id查询汽车详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Cars queryCarById(int id)throws Exception;
	/**
	 * 修改汽车所属仓库(汽车移库)
	 * @param car
	 * @return
	 * @throws Exception
	 */
	public boolean updCar(int carid,int sid)throws Exception;
}
