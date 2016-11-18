<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">

		
		
		
		
		
		
		
		
		
		
		
		
	    </script>
	</head>
	<body>
		<b>회원 가입</b>
		<hr/>
		<form method="post">
			아이디 : <input type="text" name="mid" value="${member.mid}"/> ${error}
			<br/>
			
			이름 : <input type="text" name="mname" value="${member.mname}"/>
			<br/>
			
			패스워드 : <input type="password" name="mpassword"/>
			<br/>
			
			휴대전화 : <input type="tel" name="mphone" value="${member.mphone}"/>
			<br/>
			
			생일 : <input type="date" name="mbirth" value="${member.mbirth}"/>
			<br/>
			
			관심지역 :
			<select id="sel1" name="mlocation">
				<option value="서울시">서울시</option>
				<option value="경기도">경기도</option>			
			</select>
			
			<select id="sel2" name="mlocation">
				<c:if test="#sel1==서울시">
					<option value="송파구">송파구</option>
					<option value="강남구">강남구</option>
					<option value="강동구">강동구</option>
					<option value="강북구">강북구</option>
				</c:if>
				
				<c:if test="#sel1==경기도">
					<option value="남양주시">남양주시</option>
					<option value="광명시">광명시</option>
					<option value="구리시">구리시</option>
					<option value="오산시">오산시</option>
					<option value="의정부시">의정부시</option>
				</c:if>
			</select>
<%-- 			<input type="text" name="mlocation" value="${member.mlocation}"/> --%>
			<br/>
			
			<input type="submit" value="가입"/> ${error2}<br/>
		</form>
		
<%-- 		
				<c:if test="${member.mresid==1}">
					<tr>
						<td class="list">보유 Restaurant </td>
						<td class="content">${member.mresid}</td>
					</tr>
				</c:if>
--%>			
				
	</body>
</html>