<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Thêm mới danh mục</h1>
	<form method="post">
		<input type="hidden" name="action" value="add" />
		<input type="hidden" name="counts" value="0" />
		<table>
			<tr>
				<th>Mã danh mục</th>
				<td><input type="text" required="required" name="id" /></td>
			</tr>
			<tr>
				<th>Tên danh mục</th>
				<td><input type="text" required="required" name="name" /></td>
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td><button>Thêm</button></td>
			</tr>
		</table>
	</form>
</body>
</html>