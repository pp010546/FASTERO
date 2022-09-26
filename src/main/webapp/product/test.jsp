<%@page import="com.fastero.service.impl.ProductService"%>
<%@page import="com.fastero.dao.intf.ProductDAOintf"%>
<%@page import="com.fastero.model.ProductVO"%>
<%@ page import="com.fastero.controller.ProductController"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ProductService productSev = new ProductService();
List<ProductVO> list = productSev.getAll();
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="#1">
		<h1>全部商品</h1>
	</table>
	<div>${ProductVO}</div>
	<table border="1">
		<thead>
			<tr>
				<th>商品編號</th>
				<th>店家ID</th>
				<th>商品名稱</th>
				<th>商品介紹</th>
				<th>商品價格</th>
				<th>商品上下架狀態</th>
				<th>商品等待時間</th>
				<th>商品建立時間</th>
				<th>商品更新時間</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ProductVO" items="${list}">
				<tr>
					<td>${ProductVO.productId}</td>
					<td>${ProductVO.storeId}</td>
					<td>${ProductVO.productName}</td>
					<td>${ProductVO.productIntroduction}</td>
					<td>${ProductVO.productPrice}</td>
					<td>${ProductVO.productSatus}</td>
					<td>${ProductVO.productWaitTime}</td>
					<td>${ProductVO.productBuildTime}</td>
					<td>${ProductVO.productUpdateTime}</td>
<!-- 					<td><FORM METHOD="post" -->
<%-- 							ACTION="<%=request.getContextPath()%>/controller/review" --%>
<!-- 							style="margin-bottom: 0px;"> -->
<!-- 							<input type="submit" value="修改"> <input type="hidden" -->
<%-- 								name="review_id" value="${ReviewVO.review_id}"> <input --%>
<!-- 								type="hidden" name="action" value="getOne_For_Update"> -->
<!-- 						</FORM></td> -->

<!-- 					<td> -->
<!-- 						<FORM METHOD="post" -->
<%-- 							ACTION="<%=request.getContextPath()%>/controller/review" --%>
<!-- 							style="margin-bottom: 0px;"> -->
<!-- 							<input type="submit" value="刪除"> <input type="hidden" -->
<%-- 								name="review_id" value="${ReviewVO.review_id}"> <input --%>
<!-- 								type="hidden" name="action" value="delete"> -->
<!-- 						</FORM> -->
<!-- 					</td> -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>