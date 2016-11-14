<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"> 
	</head>
	<body>
		<b>회원 정보</b>
		<hr/>
			아이디 : ${member.mid}
			<br/>
			
			이름 : ${member.mname}
			<br/>
			
			휴대전화 : ${member.mphone}
			<br/>
			
			생일 : ${member.mbirth}
			<br/>
			
			관심지역 : ${member.mlocation}
			<br/>
			
			적립 포인트 : ${member.point}
			<br/>
			
			<c:if test="${member.MResid=1}">
			보유 Restaurant : ${member.MResid}
			</c:if>
			
			<a href="/ourapp/member/modifyInfo?mid=${login}"><input type="button" value="수정하기"/><br/></a>
	</body>
</html>