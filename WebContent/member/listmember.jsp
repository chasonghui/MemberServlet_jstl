<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회행</title>
</head>
<body>
	<h2>회원 조회</h2>
	<div>
		<table border="1">
			<tr>
				<td>id</td>
				<td>pw</td>
				<td>name</td>
				<td>phone</td>
			</tr>
			<c:forEach items="${list}" var="mem">
				<tr>
					<c:choose>
						<c:when test="${id eq mem.id}">
							<td><a href="viewmember.do?id=${mem.id}&pass=${mem.pass}&name=${mem.name}&phone=${mem.phone}">${mem.id}</a></td>
						</c:when>
						<c:otherwise>
							<td>${mem.id}</td>
						</c:otherwise>
					</c:choose>
					<td>${mem.pass}</td>
					<td>${mem.name}</td>
					<td>${mem.phone}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="initpage.do">메인화면</a>
	</div>
</body>
</html>