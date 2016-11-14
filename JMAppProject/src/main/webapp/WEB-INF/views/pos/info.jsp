<%@ page contentType="text/html;charset=UTF-8"%>

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
				<td style="background-color:orange; width:70px"> 매장 </td>
			 	<td>${pos.presid}</td>
			</tr>
		
			<tr>
				<td style="background-color:orange; width:70px"> 테이블 </td>
			 	<td>${pos.ptableno}</td>
			</tr>
			
			<tr>
				<td style="background-color:orange; width:70px"> 메뉴 </td>
			 	<td>${pos.pmlname}</td>
			</tr>
			
			<tr>
				<td style="background-color:orange; width:70px"> 수량 </td>
			 	<td>${pos.pcount}</td>
			</tr>
		</table>		 
	 
	</body>
</html>