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

import com.fastero.common.LocalDateTimeAdapter;
import com.fastero.service.impl.UserServiceIm;
import com.fastero.service.intf.UserService;
import com.fastero.vo.UserVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/login/users")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserServiceIm();
	private Gson _gson = new GsonBuilder()
		    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
		    .enableComplexMapKeySerialization()
		    .serializeNulls()
		    .setDateFormat(DateFormat.DEFAULT)
//		    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
		    .setPrettyPrinting()
		    .setVersion(1.0)
		    .create();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		PrintWriter out = response.getWriter();
		UserVO vo = _gson.fromJson(request.getReader().readLine(), UserVO.class);
		out.print(_gson.toJson(service.login(vo.getUserAccount(), vo.getUserPassword())));
		
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
