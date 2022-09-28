<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
	<FORM METHOD="post"
		ACTION="<%=request.getContextPath()%>/controller/review" name="form1">
		<table>
		
			<tr>
			<input name="user_id" value="${param.user_id}">
				<td>會員編號:<font color=red><b>*</b></font></td>
				<td>${param.user_id}</td>
			</tr>
			<tr>
			<input name="store_id" value="${param.store_id}">
				<td>會員編號:<font color=red><b>*</b></font></td>
				<td>${param.store_id}</td>
			</tr>
			<tr>
				<td>星數:</td>
				<td><input type="number" name="review_point" size="45"
					value="${param.review_point}" /></td>
				<td>${errorMsgs.review_point}</td>
			</tr>
			<tr>
				<td>評論內容:</td>
				<td><input name="review_text" type="text" size="45" value="${param.review_text}"/></td>
				<td>${errorMsgs.review_text}</td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="review_id" value="${param.review_id}"> 
			<input type="submit" value="送出修改">
	</FORM>
</body>
</body>
</html>