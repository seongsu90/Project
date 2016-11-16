<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		
		<style type="text/css">
 			a {	
				text-decoration: none;
				color: black;
			}
			a:HOVER {				
				color: green;
			} 
						
		</style>
		
	</head>
	
	<body>
		Pos 메인화면
		<hr/>	
		
		<c:if test="${presid != 0}">
			<table width="400" border="1">
				<tr>
					<td style="width:200px; height:200px">
						<a href="info?presid=${presid}&ptableno=1">1							
							<c:forEach  var="pos" items="${posList}">	
									<br/>${pos.pmlname}		${pos.pcount}<br/>
							</c:forEach>									
						</a>										
					</td>
					<td style="width:200px; height:200px">
						<a href="info?presid=${presid}&ptableno=2">2</a>					
					</td>
				</tr>
				<tr>
					<td style="width:200px; height:200px">
						<a href="info?presid=${presid}&ptableno=3">3</a>					
					</td>
					<td style="width:200px; height:200px">
						<a href="info?presid=${presid}&ptableno=4">4</a>					
					</td>
				</tr>	
			</table>
		</c:if>	
		<c:if test="${presid == 0}">돌아가</c:if>
		
		 <%-- 
		<%for(int i=1; i<=6; i++) { %>	
			<table width="400" border="1">
				<tr>
					<td style="width:200px; height:200px">
						<a href="info?presid=1&ptableno=posList.get(i).getPtableno()">posList.get(i).getPtableno()</a>										
					</td>
				</tr>
			</table>	
		<%} %>
	 	 --%>		
		<%-- 
		<table width="400" border="1">			
			<tr>
				<td style="width:100px">매장</td>
				<td style="width:100px">테이블</td>
				<td style="width:100px">메뉴</td>
				<td style="width:100px">수량</td>
			</tr>
			
			<c:forEach var="pos" items="${posList}">
				<tr>
					<td>${pos.presid}</td>
					<td><a href="info?presid=${pos.presid}&ptableno=${pos.ptableno}">${pos.ptableno}</a></td>
					<td>${pos.pmlname}</td>
					<td>${pos.pcount}</td>
				</tr>
			</c:forEach>
		</table> 
		--%>
		
	</body>
</html>
