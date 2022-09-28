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
	<tr>
		<td>
			<h2>
				<a href="<%=request.getContextPath()%>/reviewselect.jsp">回評論首頁</a>
			</h2>
		</td>
	</tr>
	<table id="#1">
		<h1>全部評論</h1>
	</table>
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
					<td><FORM METHOD="post"
							ACTION="<%=request.getContextPath()%>/controller/review"
							style="margin-bottom: 0px;">
							<input type="submit" value="修改"> <input type="hidden"
								name="review_id" value="${ReviewVO.review_id}"> <input
								type="hidden" name="action" value="getOne_For_Update">
						</FORM></td>

					<td>
				<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/controller/review"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="review_id" value="${ReviewVO.review_id}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
					</td>
					</tr>
			</c:forEach>
		</tbody>
	</table>



</body>

</html>