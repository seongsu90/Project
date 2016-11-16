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
			<tr>
				<!-- <td style="width:100px">매장</td> -->
				<td style="width:100px">테이블</td>
				<td style="width:100px;">메뉴</td>
				<td style="width:100px">수량</td>
				<%-- <td style="width:100px">가격</td> --%>
			</tr>
			
			<c:forEach var="pos" items="${infoList}">
				<tr>
					<%-- <td>${pos.presid}</td> --%>
					<td>${pos.ptableno}</td>
					<td>${pos.pmlname}</td>
					<td>${pos.pcount}</td>	
					<%-- <td>${menuPrice}</td> --%>				
				</tr>
			</c:forEach>
		</table>
		
		<br/>	
	 	
	 	<b>합계 : ${totalPrice}</b><br/>
		<a href="add?presid=${presid}&ptableno=${ptableno}"><input type="submit" value="주문"/></a>				
		<c:forEach var="pos" items="${infoList}">
			<a href="delete?presid=${pos.presid}&ptableno=${pos.ptableno}"><input type="submit" value="결제"/></a>		
			<a href="modify?presid=${pos.presid}&ptableno=${pos.ptableno}"><input type="submit" value="추가"/></a>			
		</c:forEach>
		
		
	</body>
</html>
