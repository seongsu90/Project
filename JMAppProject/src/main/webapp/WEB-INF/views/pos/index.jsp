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
 		
<!-- 		1. <a href="/ourapp/pos/add">add</a><br/>
		2. <a href="/ourapp/pos/modify">modify</a><br/>
		3. <a href="/ourapp/pos/del">del</a><br/>
		4. <a href="/ourapp/pos/info">info</a><br/> -->

	<table>
			<tr>
				<td>
					<c:forEach var="pos" items="${list}">
						<a href="info?presid=${pos.presid};ptableno=${pos.ptableno}">
							<div>
								<table style="width:100%; height:30px; opacity: 0.7">
									<tr>																		
										<td style="background-color:orange; width:70px"> 매장 </td>
				 						<td><input type="text" name="presid" style="width:100px" value="${pos.presid}"></td>
				 						
										<td style="background-color:orange; width:70px"> 테이블 </td>
				 						<td><input type="text" name="ptableno" style="width:100px" value="${pos.ptableno}"></td>				 						
				 												
										<td style="background-color:orange; width:70px"> 메뉴 </td>
									 	<td><input type="text" name="pmlname" style="width:100px" value="${pos.pmlname}"></td>
									
										<td style="background-color:orange; width:70px"> 수량 </td>
									 	<td><input type="text" name="pcount" style="width:100px" value="${pos.pcount}"></td>
									</tr>	
								</table>
							</div>										
						</a>
					</c:forEach>
				</td>
			</tr>	
		</table> 
		
	</body>
</html>
