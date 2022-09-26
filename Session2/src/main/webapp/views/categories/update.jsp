<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cập nhật sản phẩm</h1>
	<form method="post">
		<input type="hidden" name="action" value="edit" />
		<input type="hidden" name="counts" value="${ cat.counts }" />
		<table>
			<tr>
				<th>Mã danh mục</th>
				<td><input type="text" required="required" name="id" value="${ cat.id }" /></td>
			</tr>
			<tr>
				<th>Tên danh mục</th>
				<td><input type="text" required="required" name="name" value="${ cat.catname }" /></td>
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td><button>Lưu</button></td>
			</tr>
		</table>
	</form>
</body>
</html>