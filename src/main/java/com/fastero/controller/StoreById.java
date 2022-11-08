package com.fastero.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.service.impl.StoreServiceImpl;
import com.google.gson.Gson;

@WebServlet("/storeById")
public class StoreById extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
    StoreServiceImpl serviceImpl = new StoreServiceImpl();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		setHeaders(res);
		
//		List<Object> list = new ArrayList<Object>();
//		list.add(serviceImpl.selectList());
		
		res.getWriter().print(gson.toJson(serviceImpl.getBystoreId(1)));
	}	
	
	
	private void setHeaders(HttpServletResponse response) {

		response.setContentType("application/json;charset=UTF-8"); // 重要
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		response.addHeader("Access-Control-Allow-Origin", "*"); // 重要
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Max-Age", "86400");
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setHeaders(res);

	}

}
