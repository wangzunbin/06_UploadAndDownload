<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/filename" method="post" enctype="multipart/form-data">
		<input type="file" name="heading">
		<input type="text" name="文本">
		<input type="submit" value="提交">
	</form>
</body>
</html>