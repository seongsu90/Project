<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"> 
	</head>
	<body>
		<a href="/photo">
			<input type="image" src="/photo/resources/main.jpg" width="300"/><br/>
		</a>
		<hr/>
		<b>아이디 찾기</b>
		<hr/>
		<form method="post">
			이메일 : <input type="email" name="memail"/>${error}<br/>
			<input type="submit" value="찾기"/>
		</form>
	</body>
</html>