<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
	 주문 상세정보
	 <hr/>
	 
	 	<table  width="400" border="1">
	 		<h3>${ptableno} 번 테이블</h3>
			<tr>
				<td style="width:100px;">메뉴</td>
				<td style="width:100px">수량</td>
			</tr>
			
			<c:forEach var="pos" items="${infoList}">
				<tr>
					<td>${pos.pmlname}</td>
					<td>${pos.pcount}</td>	
				</tr>
			</c:forEach>
		</table>
		
		<br/>	
	 	
	 	<b>합계 : ${totalPrice}</b><br/>
	 	<br/>
		<a href="add?presid=${presid}&ptableno=${ptableno}"><input type="submit" value="주문"/></a>
		<a href="delete?presid=${presid}&ptableno=${ptableno}"><input type="submit" value="결제"/></a>		
					
		
		
		
	</body>
</html>
