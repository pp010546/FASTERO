package com.fastero.controller;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.model.StoreVO;
import com.fastero.service.impl.StoreServiceImpl;
import com.fastero.service.intf.StoreService;
//
@WebServlet("/store/controller")
public class StoreController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StoreService service;
	
	@Override
	public void init() throws ServletException {
		try {
			service = new StoreServiceImpl();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final List<StoreVO> list = service.findAllStores();
		req.setAttribute("storelist", list);
		req.getRequestDispatcher("/store.jsp").forward(req, resp);
	}
}