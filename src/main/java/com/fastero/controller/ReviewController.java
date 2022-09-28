package com.fastero.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.model.ReviewVO;
import com.fastero.service.impl.ReviewService;
//
@WebServlet("/controller/review")
public class ReviewController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { 

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer user_id = Integer.parseInt(req.getParameter("user_id"));
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/reviewselect.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				ReviewService reviewSvc = new ReviewService();
				ReviewVO reviewVO = reviewSvc.getOneReview(user_id);
				if (reviewVO == null) {
					errorMsgs.put("user_id", "查無編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/reviewselect.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("reviewVO", reviewVO); // 資料庫取出的empVO物件,存入req

				String url = "/reviewsearch.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
				if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

					Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
					req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
					Integer review_id = Integer.parseInt(req.getParameter("review_id"));
				
				/***************************2.開始查詢資料****************************************/
				ReviewService reviewSvc = new ReviewService();
				ReviewVO reviewVO = reviewSvc.getOneReviewforupdate(review_id);
												
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String param = "?review_id="  +reviewVO.getReview_id()+
						       "&user_id="  +reviewVO.getUser_id()+
						       "&store_id="    +reviewVO.getStore_id()+
						       "&review_point="+reviewVO.getReview_point()+
						       "&review_text="    +reviewVO.getReview_text();
				String url = "/reviewupdate.jsp"+param;
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				
				Integer review_id = Integer.parseInt(req.getParameter("review_id"));
				Integer user_id = Integer.parseInt(req.getParameter("user_id"));
				Integer store_id = Integer.parseInt(req.getParameter("store_id"));
				Integer review_point = Integer.parseInt(req.getParameter("review_point"));
				String review_text = req.getParameter("review_text"); 
						
				ReviewVO reviewVO = new ReviewVO();
				reviewVO.setReview_id(review_id);
				reviewVO.setUser_id(user_id);
				reviewVO.setStore_id(store_id);
				reviewVO.setReview_point(review_point);
				reviewVO.setReview_text(review_text);
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/reviewupdate.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				ReviewService reviewSev = new ReviewService();
				reviewVO  = reviewSev.updateReview(review_id, user_id, store_id, review_point, review_text);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("reviewVO", reviewVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/reviewsearch.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//			Integer review_id = Integer.valueOf(req.getParameter("review_id").trim());
			Integer user_id = Integer.parseInt(req.getParameter("user_id"));
			Integer store_id = Integer.parseInt(req.getParameter("store_id"));
			Integer review_point = Integer.parseInt(req.getParameter("review_point"));
//			Date  review_time = Date.valueOf(req.getParameter("review_time").trim());
			
			String review_text = req.getParameter("review_text"); 
//			String review_store_response = req.getParameter("review_store_response"); 
			
			
			ReviewVO reviewVO = new ReviewVO();
			reviewVO.setUser_id(user_id);
			reviewVO.setStore_id(store_id);
			reviewVO.setReview_point(review_point);
			reviewVO.setReview_text(review_text);
//			reviewVO.setReview_store_response(review_store_response);
//			reviewVO.setReview_time(review_time);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/reviewselect.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
				/***************************2.開始新增資料***************************************/
				ReviewService reviewSev = new ReviewService();
				reviewVO  = reviewSev.addReview(user_id, store_id, review_point, review_text);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/reviewselect.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { 

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
			Integer review_id = Integer.parseInt(req.getParameter("review_id"));
			
				
				/***************************2.開始刪除資料***************************************/
				ReviewService reviewSev = new ReviewService();
				reviewSev.deleteReview(review_id);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/reviewselectAll.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}


}
