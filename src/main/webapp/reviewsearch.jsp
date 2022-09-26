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
//ReviewVO reviewVO = (ReviewVO) request.getAttribute("reviewVO");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<tr>
		<td>
			<h2>
				<a href="<%=request.getContextPath()%>/reviewselect.jsp">回評論首頁</a>
			</h2>
		</td>
	</tr>


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

			<tr>
				<td>${reviewVO.review_id}</td>
				<td>${reviewVO.user_id}</td>
				<td>${reviewVO.store_id}</td>
				<td>${reviewVO.review_point}</td>
				<td>${reviewVO.review_text}</td>
				<td>${reviewVO.review_store_response}</td>
				<td>${reviewVO.review_time}</td>
			</tr>
		</tbody>
	</table>

</body>
</html>