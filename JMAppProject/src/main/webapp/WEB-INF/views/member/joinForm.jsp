<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript">
		
 			$(document).ready(function() {
 				console.log("ready 실행");
 				setCity();
 				
 				$("#selMetro").change(function () {
 					console.log("change");
 			        setProvince();
 			    });
			});
			
			function setCity() {
				console.log("setCity 실행");
				$.ajax({
					url: "getCity.jsp",
					success: function (data) {
						$("#selMetro").html(data);
					}
				});
			}
			
 			function setProvince() {
 				console.log("setProvince 실행");
 				var cityName = $("#selMetro").val();
 				$.ajax({
					url: "getProvince.jsp",
					data: {"cityName":cityName},
					success: function (data) {
						$("#selProvince").html(data);
					}
				});
			} 
		
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
			<select id="selMetro" name="selMerto">
			</select>
			
			<select id="selProvince" name="selProvince">
				<option value="">전체</option>
			</select>
<%-- 			<input type="text" name="mlocation" value="${member.mlocation}"/> --%>
			<br/>
			
			<input type="submit" value="가입"/> ${error2}<br/>
		</form>
			
	</body>
</html>