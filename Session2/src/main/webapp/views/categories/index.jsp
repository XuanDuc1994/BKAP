<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Quản lý danh mục</h1>
	<p><a href="danh-muc?action=add">Thêm mới</a></p>
	<table border="1" width="100%" cellspacing="0" cellpadding="10">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Action</th>
		</tr>
		<c:forEach var="c" items="${ list }">
			<tr>
				<td>${ c.id }</td>
				<td>${ c.catname }</td>
				<td>
					<a href="danh-muc?action=edit&id=${ c.id }">Update</a> | 
					<a href="danh-muc?action=delete&id=${ c.id }">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>