package edu.tinzel.Cars.biz.impl;

import java.util.List;

import edu.tinzel.Cars.biz.TjBiz;
import edu.tinzel.Cars.dao.TjDao;
import edu.tinzel.Cars.dao.impl.TjDaoImpl;
import edu.tinzel.Cars.entity.CustTj;

public class TjBizImpl implements TjBiz {
	private TjDao tjDao=new TjDaoImpl();
	@Override
	//查询客户地址和相应人数
	public List<CustTj> queryAll() throws Exception {
		
		return this.tjDao.queryAll();
	}

}
