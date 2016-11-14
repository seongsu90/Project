<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<style type="text/css">
			* {
				font-family: 돋움;
				font-size: 12px;		
			}
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
		
		<table>
			<tr>
				<td>
					<c:forEach var="pos" items="${list}">
						<a href="info?pResid=${pos.pResid}">							
								
							<div>
								<table style="width:100%; height:30px; background-color: black; opacity: 0.7">
									<tr>
										<td style="text-align:left; color:white;">${pos.ptableno}</td>
										<td style="text-align:right; color:aqua;">${pos.pMlname}</td>
										<td style="text-align:right; color:yellow;">${pos.pcount}</td>
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