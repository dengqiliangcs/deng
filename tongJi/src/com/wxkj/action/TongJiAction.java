package com.wxkj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxkj.entity.DataBean;
import com.wxkj.service.TongJiService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TongJiAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TongJiService tongJiService = new TongJiService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DataBean> list = tongJiService.getData();
		int x= list.size();
		String[] phones = new String[x];
		long[] upLoads = new long[x];
		long[] downLoads = new long[x];
		long[] totalLoads = new long[x];
		for(int i=0;i<list.size();i++) {
			phones[i] =list.get(i).getPhone().substring(0,5);
			upLoads[i] = list.get(i).getUpLoad();
			downLoads[i] = list.get(i).getDownLoad();
			totalLoads[i] = list.get(i).getTotalLoad();
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("phone", phones);
		jsonObject.put("upload", upLoads);
		jsonObject.put("downLoad", downLoads);
		jsonObject.put("totalLoad", totalLoads);
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
	}
}
