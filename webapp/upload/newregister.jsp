<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- 用户注册 -->
		<span style="color: red;">${errorMsg}</span>
		<form action="/newupload" method="post" enctype="multipart/form-data">
			用户名:<input type="text" name="username"><br>
			年龄:<input type="text" name="age"><br>
			头像:<input type="file" name="headImg"><br>
			<input type="submit" value="注册">
		</form>
</body>
</html>