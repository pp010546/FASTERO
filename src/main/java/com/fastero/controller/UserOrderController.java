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
import com.fastero.service.impl.OrderMasterServiceIm;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/orders/user/*")
public class UserOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson _gson = new GsonBuilder()
							 .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
							 .enableComplexMapKeySerialization()
							 .serializeNulls()
							 .setDateFormat(DateFormat.DATE_FIELD)
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
		
		if (pathInfo.split("/").length<=2) {
			Integer userId = Integer.parseInt(pathInfo.split("/")[1]);
			out.print(_gson.toJson(service.getAllForUser(userId)));
			return;
		}else {
			Integer userId = Integer.parseInt(pathInfo.split("/")[1]);
			Integer orderId = Integer.parseInt(pathInfo.split("/")[2]);
			
			out.print(_gson.toJson(service.getByIdForUser(orderId, userId)));
		}

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

}
