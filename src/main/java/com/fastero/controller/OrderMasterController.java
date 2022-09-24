package com.fastero.controller;

import java.io.IOException;
import java.io.PrintWriter;
<<<<<<< HEAD
=======
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Set;
>>>>>>> Philip

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.fastero.service.impl.OrderMasterServiceIm;
import com.google.gson.Gson;

@WebServlet("/orders")
public class OrderMasterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OrderMasterServiceIm service = new OrderMasterServiceIm();
	Gson _gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setHeaders(response);
		PrintWriter out = response.getWriter();

		out.print(_gson.toJson(service.getAll()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setHeaders(response);
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(resp);
	}

	/*
	 * 跨域
	 */
	private void setHeaders(HttpServletResponse response) {
=======
import com.fastero.common.LocalDateTimeAdapter;
import com.fastero.service.impl.OrderMasterServiceIm;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/orders/*")
public class OrderMasterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson _gson = new GsonBuilder()
							 .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
							 .enableComplexMapKeySerialization()
							 .serializeNulls()
							 .setDateFormat(DateFormat.DEFAULT)
//							 .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
							 .setPrettyPrinting()
							 .setVersion(1.0)
							 .create();
	private OrderMasterServiceIm service = new OrderMasterServiceIm();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// CROS
		setHeaders(response);

		String pathInfo = request.getPathInfo();
		PrintWriter out = response.getWriter();
//		String id = request.getParameter("orderId");

//		System.out.println("id: " + id);
//		System.out.println("pathInfo: " + pathInfo);

//		if (id != null) {
//			out.print(_gson.toJson(service.getById(Integer.parseInt(id))));
//			return;
//		} else 
		if (pathInfo != null) {
			String id = pathInfo.split("/")[1];
			out.print(_gson.toJson(service.getById(Integer.parseInt(id))));
			return;
		} else {
			out.print(_gson.toJson(service.getAll()));
		}

	}

	private void setHeaders(HttpServletResponse response) {

>>>>>>> Philip
		response.setContentType("application/json;charset=UTF-8"); // 重要
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

<<<<<<< HEAD
		response.addHeader("Access-Control-Allow-Origin", "*"); // 重要 允許不同連線
=======
		response.addHeader("Access-Control-Allow-Origin", "*"); // 重要
>>>>>>> Philip
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Max-Age", "86400");
	}

}
