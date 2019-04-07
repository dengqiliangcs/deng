package com.wxkj.service;

import java.util.List;

import com.wxkj.dao.Dao;
import com.wxkj.entity.DataBean;

public class TongJiService {

	private Dao dao = new Dao(); 
	
	public List<DataBean> getData(){
		String sql="select * from tongJi";
		List<DataBean> list = dao.getData(sql);
		return list;
	}
}
