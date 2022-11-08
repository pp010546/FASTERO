package com.fastero.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.bean.ReportVO;
import com.fastero.model.ReviewVO;
import com.fastero.service.impl.ReportServiceImpl;
import com.fastero.service.impl.ReviewService;
import com.google.gson.Gson;

@WebServlet("/report/insert")
public class ReportInsert extends HttpServlet{
    private static final long serialVersionUID = 1L;
    static Gson gson = new Gson();
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        setHeaders(res);    
        
    } 

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
      setHeaders(res);
      
      Gson gson = new Gson();
      ReportVO vo = gson.fromJson(req.getReader(), ReportVO.class);
      System.out.println(vo.getUserId());
      System.out.println(vo.getStoreId());
      System.out.println(vo.getReportText());
      ReportServiceImpl service = new ReportServiceImpl();
      res.getWriter().print(gson.toJson(service.addReportOne(vo)));
      
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
