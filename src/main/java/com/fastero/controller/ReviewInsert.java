package com.fastero.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.model.ReviewVO;
import com.fastero.service.impl.ReviewService;
import com.google.gson.Gson;

@WebServlet("/review/insert")
public class ReviewInsert extends HttpServlet{
    private static final long serialVersionUID = 1L;
    static Gson gson = new Gson();
//    private ReviewService service = new ReviewService();
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        setHeaders(res);    
        
    } 

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
      setHeaders(res);      
      Gson gson = new Gson();
      ReviewVO vo = gson.fromJson(req.getReader(), ReviewVO.class);
      System.out.println(vo.getUser_id());
      System.out.println(vo.getStore_id());
      System.out.println(vo.getReview_point());
      System.out.println(vo.getReview_text());
      ReviewService service = new ReviewService();
      res.getWriter().print(gson.toJson(service.addReview(vo)));
      
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
    public static <T> T writejson(Class<T> type, HttpServletRequest request) {
        // read post
        try (BufferedReader read = request.getReader()) {
         return gson.fromJson(read.readLine(), type);
        } catch (Exception e) {
         e.printStackTrace();
        }
        return null;
       }
}
