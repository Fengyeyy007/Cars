package edu.tinzel.Cars.biz;

import java.util.List;

import edu.tinzel.Cars.entity.CustTj;

public interface TjBiz {
	/**
	 * 根据客户地址分类客户人数
	 * @return
	 * @throws Exception
	 */
	public List<CustTj> queryAll()throws Exception;
}
