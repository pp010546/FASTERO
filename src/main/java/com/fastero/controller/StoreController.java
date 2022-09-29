package com.fastero.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.vo.StoreVO;
import com.fastero.vo.UserVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.fastero.common.LocalDateTimeAdapter;
import com.fastero.service.impl.StoreServiceImpl;
import com.fastero.service.intf.StoreService;
//
@WebServlet("/stores")
public class StoreController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StoreServiceImpl service = new StoreServiceImpl();;
	private Gson _gson = new GsonBuilder()
		    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
		    .enableComplexMapKeySerialization()
		    .serializeNulls()
		    .setDateFormat(DateFormat.DEFAULT)
//		    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
		    .setPrettyPrinting()
		    .setVersion(1.0)
		    .create();
	
//	@Override
//	public void init() throws ServletException {
//		try {
//			service = new StoreServiceImpl();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		final List<StoreVO> list = service.findAllStores();
//		req.setAttribute("storelist", list);
//		req.getRequestDispatcher("/store.jsp").forward(req, resp);
//	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		
		PrintWriter out = response.getWriter();
		
		out.print(_gson.toJson(service.findAllStores()));
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		
		PrintWriter out = response.getWriter();
		StoreVO vo = _gson.fromJson(request.getReader().readLine(), StoreVO.class);
		out.print(_gson.toJson(service.register(vo)));
		}
	
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
	}
	
	/*
	 * CROS
	 */
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
}
