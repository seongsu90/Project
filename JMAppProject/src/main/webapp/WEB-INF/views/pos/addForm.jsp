<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		Pos 추가
		<hr/>		
		
		<form method="post">
			매장 : <input type="text" name="pResid" value="${pos.presid}"/><br/>	
			테이블 : <input type="text" name="ptableno" value="${pos.ptableno}"/><br/>
			메뉴 : <input type="text" name="pMlname" value="${pos.pmlname}"/><br/>			
			수량 : <input type="number" name="pcount" value="${pos.pcount}"/><br/>			
			<input type="submit" value="주문"/><br/>		
		</form>
		
	</body>
</html>