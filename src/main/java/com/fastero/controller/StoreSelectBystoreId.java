package com.fastero.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.service.impl.ProductService;
import com.fastero.service.impl.ReviewService;
import com.fastero.service.impl.StoreServiceImpl;
import com.google.gson.Gson;

@WebServlet("/storesheet")
public class StoreSelectBystoreId extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
//	private Gson gson = new Gson();
//	private StoreServiceImpl serviceImpl = new StoreServiceImpl();
//	private ReviewService service = new ReviewService();
	Gson gson = new Gson();
    StoreServiceImpl serviceImpl = new StoreServiceImpl();
    ProductService sProductService = new ProductService();
    ReviewService service = new ReviewService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		setHeaders(res);		
		
		List<Object> list = new ArrayList<Object>();
		list.add(serviceImpl.getShortStoreList());
		list.add(sProductService.getBystoreId());
		list.add(service.getById());
		
		res.getWriter().print(gson.toJson(list));
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
