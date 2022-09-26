<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.fastero.service.impl.ReviewService"%>
<%@page import="com.fastero.dao.intf.ReviewDAOIntf"%>
<%@page import="com.fastero.model.ReviewVO"%>
<%@ page import="com.fastero.controller.ReviewController"%>
<%@ page import="com.fastero.service.*"%>

<%
ReviewService reviewSvc = new ReviewService();
List<ReviewVO> list = reviewSvc.getAll();
pageContext.setAttribute("list", list);
%>


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
<%-- <%=request.getContextPath()%> --%>
</head>

<body>
	<table id="#1">
		<h1>評論首頁</h1>
	</table>
	<h2>
		<a href="<%=request.getContextPath()%>/reviewselectAll.jsp">全部評論</a>
	</h2>
	<h2>
		搜尋會員評論</a>
	</h2>
	<li>
		<FORM METHOD="post"
			ACTION="<%=request.getContextPath()%>/controller/review">
			<b>輸入會員編號:</b> <input type="text" id="userid" name="user_id"
				value="${param.user_id}"> <font color=red>${errorMsgs.user_id}</font>
			<input type="hidden" name="action" value="getOne_For_Display">
			<input type="submit" value="送出">
		</FORM>
	</li>
	<h2>新增評論</h2>
	<form action="<%=request.getContextPath()%>/controller/review"
		method="post">
		<table id="#2">
			<label for="userid">輸入會員帳號</label>
			<input type="text" id="userid" name="user_id" value="123">
			<br>
			<label for="storeid">輸入店家名稱</label>
			<input type="text" id="storeid" name="store_id">
			<br>
			<label for="reviewpoint">輸入評價星數</label>
			<input type="text" id="reviewpoint" name="review_point">
			<br>
			<label for="reviewtext">輸入感想</label>
			<input type="text" id="reviewtext" name="review_text">
			<br>
			<input type="submit" value="insert" name="action">
		</table>
	</form>
	<div>${reviewVO}</div>
	<table border="1">
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