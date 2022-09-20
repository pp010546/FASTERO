<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->
<%@ page import="com.fastero.controller.ReviewController" %>
    <!DOCTYPE html>
    
  
    <html lang="en">


    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <style>
            table#1 {
                background-color: aquamarine;
                width: 200px;
                border: 1px solid aliceblue;
                text-align: center;
            }

            table#2 {
                background-color: hotpink;
                width: 400px;
                height: 500px;
            }
        </style>
    </head>

    <body>
        <table id="#1">
            <h1>新增評論</h1>
        </table>

        <form action="review/controller" method="post">
            <table id="#2">
                <label for="userid">輸入會員帳號</label>
                <input type="text" id="userid">
                <br>
                <label for="storeid">輸入店家名稱</label>
                <input type="text" id="storeid">
                <br>
                <label for="reviewpoint">輸入評價星數</label>
                <input type="text" id="reviewpoint">
                <br>
                <label for="reviewtext">輸入感想</label>
                <input type="text" id="reviewtext">
                <br>
                <input type="submit" value="insert">
            </table>
        </form>
        <div>${reviewVO}</div>
        <table>
            <thead>
                <tr>
                    <th>評論編號</th>
                    <th>會員ID</th>
                    <th>店家ID</th>
                    <th>評價星數</th>
                    <th>評價內容</th>
                    <th>店家回覆</th>
                    <th>評價時間</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ReviewVO" items="${list}">
                    <tr>
                        <td>${ReviewVO.review_id}</td>
                        <td>${ReviewVO.user_id}</td>
                        <td>${ReviewVO.store_id}</td>
                        <td>${ReviewVO.review_point}</td>
                        <td>${ReviewVO.review_text}</td>
                        <td>${ReviewVO.review_store_response}</td>
                        <td>${ReviewVO.review_time}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>



    </body>

    </html>