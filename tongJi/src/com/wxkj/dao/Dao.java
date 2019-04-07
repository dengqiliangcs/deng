package com.wxkj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.wxkj.entity.DataBean;
import com.wxkj.tools.DBUtils;

public class Dao {

	private Connection connection=null;
	private Statement statement = null;

	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			statement = connection.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<DataBean> getData(String sql){
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			List<DataBean> list = DBUtils.resToList(resultSet);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
