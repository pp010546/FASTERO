package com.fastero.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fastero.common.LocalDateTimeAdapter;
import com.fastero.dao.impl.StoreDAOImpl;
import com.fastero.dao.intf.StoreDAO;
import com.fastero.service.impl.StoreServiceImpl;
import com.fastero.service.impl.UserServiceIm;
import com.fastero.service.intf.StoreService;
import com.fastero.service.intf.UserService;
import com.fastero.vo.StoreVO;
import com.fastero.vo.UserVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/login/stores")
public class StoreLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreService service = new StoreServiceImpl();
	private Gson _gson = new GsonBuilder()
		    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
		    .enableComplexMapKeySerialization()
		    .serializeNulls()
		    .setDateFormat(DateFormat.DEFAULT)
		    .setPrettyPrinting()
		    .setVersion(1.0)
		    .create();
//	private HttpSession session;	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		PrintWriter out = response.getWriter();
		StoreVO vo = _gson.fromJson(request.getReader().readLine(), StoreVO.class);
		out.print(_gson.toJson(service.login(vo.getStoreAdminAccount(), vo.getStoreAdminPassword())));
		
//		//後端session
//		session = request.getSession(false); 	//先預設取用已存在的session
//		if(session == null) { 					//若沒有已存在的session -> 新建一個
//			session = request.getSession();
//		}
//		session.setAttribute("storeInfo", service.g);
//		out.print(_gson.toJson(session));
		
		
		
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
