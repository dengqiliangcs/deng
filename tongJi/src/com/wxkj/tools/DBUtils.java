package com.wxkj.tools;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxkj.entity.DataBean;

public class DBUtils {

	public static List<DataBean> resToList(ResultSet resultSet){
		
		try {
			List<DataBean> list =new ArrayList<>();
			while(resultSet.next()) {
				String phone=resultSet.getString(1);
				long upLoad=resultSet.getLong(2);
				long downLoad=resultSet.getLong(3);
				long totalLoad=resultSet.getLong(4);
				
				DataBean dataBean =new DataBean();
				dataBean.setDownLoad(downLoad);
				dataBean.setPhone(phone);
				dataBean.setTotalLoad(totalLoad);
				dataBean.setUpLoad(upLoad);
				
				list.add(dataBean);
			}
			return  list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
