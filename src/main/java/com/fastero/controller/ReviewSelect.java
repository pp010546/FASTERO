package com.fastero.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.model.ReviewVO;
import com.fastero.service.impl.ReviewService;
import com.google.gson.Gson;

@WebServlet("/reviewselect")
public class ReviewSelect extends HttpServlet{
    private static final long serialVersionUID = 1L;
    Gson gson = new Gson();
    ReviewService service = new ReviewService();
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        setHeaders(res);        
        
        List<Object> list = new ArrayList<Object>();      
        list.add(service.getOneReview());        
        res.getWriter().print(gson.toJson(list));
    }  
//    
//    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        
//        setHeaders(res);
//        Gson gson = new Gson();
//        ReviewVO vo = gson.fromJson(req.getReader(), ReviewVO.class);
//        System.out.println(vo.getUser_id());
//        System.out.println(vo.getStore_id());
//        System.out.println(vo.getReview_point());
//        System.out.println(vo.getReview_text());
//        ReviewService service = new ReviewService();
//        res.getWriter().print(gson.toJson(service.updateReview(vo)));
//        setHeaders(res);
//        int review_id = Integer.parseInt(req.getParameter("review_id"));
//        int user_id = Integer.parseInt(req.getParameter("user_id"));
//        int store_id = Integer.parseInt(req.getParameter("store_id"));
//        int review_point = Integer.parseInt(req.getParameter("review_point"));
//        String review_text = req.getParameter("review_text");
//        
//        System.out.println(review_id);
//        System.out.println(user_id);
//        System.out.println(store_id);
//        System.out.println(review_point);
//        System.out.println(review_text);
//        
//        ReviewService service = new ReviewService();
//        service.updateReview(review_id, user_id, store_id, review_point, review_text);
//        String url = "http://localhost:8080/FASTERO/reviewupdate.html";
//        res.sendRedirect(url);        
//      }
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
