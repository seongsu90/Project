<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		
<!-- 		<style type="text/css">

 			a {	
				text-decoration: none;
				color: black;
			}
			a:HOVER {				
				color: green;
			} 
			
		</style>
		 -->
	</head>
	
	<body>
		Pos 메인화면
		<hr/>		
		
		<table width="400" border="1">			
			<tr>
				<td style="width:100px">매장</td>
				<td style="width:100px">테이블</td>
				<td style="width:100px">메뉴</td>
				<td style="width:100px">수량</td>
			</tr>
			
			<c:forEach var="pos" items="${list}">
				<tr>
					<td>${pos.presid}</td>
					<td><a href="info?presid=${pos.presid}&ptableno=${pos.ptableno}">${pos.ptableno}</a></td>
					<td>${pos.pmlname}</td>
					<td>${pos.pcount}</td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>
