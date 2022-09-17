<%@page import="com.fastero.model.StoreVO"%>
<%@page import="java.util.List"%>
<%@page import="com.fastero.service.impl.StoreServiceImpl"%>
<%@page import="com.fastero.service.intf.StoreService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>




	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Storepage</title>
	</head>

	<body>
		<table border="1">
			<thead>
				<tr>
					<th>storeID</th>
					<th>storename</th>
					<th>storeaddress</th>
					<th>longitude</th>
					<th>latitude</th>
					<th>storephone</th>
					<th>storeemail</th>
					<th>storeadminaccount</th>
					<th>storeadminpassword</th>
					<th>storeadminphone</th>
					<th>storeadminaddress</th>
					<th>storeimg</th>
					<th>storeintroduction</th>
					<th>storeopenstatus</th>
					<th>storeaccountstatus</th>
					<th>storeadminname</th>
					<th>storeadminID</th>
					<th>storebuildtime</th>
					<th>storeupdtetime</th>
					<th>storecommentnumber</th>
					<th>storetotalstar</th>
					<th>storebusinesstime</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="store" items="${storelist}">
					<tr>
						<td>${storeVO.storeID}</td>
						<td>${storeVO.storename}</td>
						<td>${storeVO.storeaddress}</td>
						<td>${storeVO.longitude}</td>
						<td>${storeVO.latitude}</td>
						<td>${storeVO.storephone}</td>
						<td>${storeVO.storeemail}</td>
						<td>${storeVO.storeadminaccount}</td>
						<td>${storeVO.storeadminpassword}</td>
						<td>${storeVO.storeadminphone}</td>
						<td>${storeVO.storeadminaddress}</td>
						<td>${storeVO.storeimg}</td>
						<td>${storeVO.storeintroduction}</td>
						<td>${storeVO.storeopenstatus}</td>
						<td>${storeVO.storeaccountstatus}</td>
						<td>${storeVO.storeadminname}</td>
						<td>${storeVO.storeadminID}</td>
						<td>${storeVO.storebuildtime}</td>
						<td>${storeVO.storeupdtetime}</td>
						<td>${storeVO.storecommentnumber}</td>
						<td>${storeVO.storetotalstar}</td>
						<td>${storeVO.storebusinesstime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</body>

	</html>