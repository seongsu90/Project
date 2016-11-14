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
	 	
	 	<table>			
			<tr>
				<td style="width:100px">매장</td>
				<td style="width:100px">테이블</td>
				<td style="width:100px">메뉴</td>
				<td style="width:100px">수량</td>
				<td style="width:100px">가격</td>
			</tr>
			
			<c:forEach var="pos" items="${list}">
				<tr>
					<td>${pos.presid}</td>
					<td>${pos.ptableno}</td>
					<td>${pos.pmlname}</td>
					<td>${pos.pcount}</td>	
					<td>${menuPrice}</td>				
				</tr>
			</c:forEach>
		</table>
		
		<c:forEach var="pos" items="${list}">
			<b>합계 : ${totalPrice}</b><br/>
			<a href="delete?presid=${pos.presid}&ptableno=${pos.ptableno}">결제(삭제)</a>
		</c:forEach>
		
	 
	</body>
</html>
