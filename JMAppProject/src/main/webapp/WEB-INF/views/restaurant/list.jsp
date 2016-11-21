<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"> 
		<style type="text/css">
			* {
				font-family: 굴림;
				font-size: 12px;
			}
			table {
  				width:100%;
			}
			table, th, td {
   				border: 2px solid black;
    			border-collapse: collapse;
			}
			th, td {
  				padding: 5px;
    			text-align: center;
			}
			
			th {
  				background-color: black;
    			color: white;
			}
		
		</style>
	</head>
	<body>
		<hr/>
		<p style="font-size:100%;"><b>식당 목록</b></p>
		<hr/>
		
		<br/>
		<table style="width: 1000px; border-collapse: collapse; border-style: solid; border-width: 3px; border-color: black;">
			<tr>
				<th> 식당 사진 </th>
				<th> 식당 이름</th>
				<th> 식당 위치</th>
				<th> 식당 정보 </th>
				<th> 식당 테이블 수 </th>
				<th> 식당 전화번호 </th>
				<th> 식당 오픈타임 </th>
				<th> 식당 클로즈타임 </th>
				<th> 식당 휴일 </th>
			
			</tr>
			<c:forEach var="restaurant" items="${list}">
				<tr>
					
					
					<td> <img src="showPhoto?ressavedfile=${restaurant.ressavedfile}" width="80px"/></td>
					
					<td style="border: 1px solid black;"><a href="info?resid=${restaurant.resid}">${restaurant.resname}</a></td>
					
					
					<td> ${restaurant.reslocation} </td>
					<td> ${restaurant.resinfo} </td>
					<td> ${restaurant.restotaltable} </td>
					<td> ${restaurant.restel} </td>
					<td> ${restaurant.resopen} </td>
					<td> ${restaurant.resclose} </td>
					<td> ${restaurant.rescloseday} </td>
				</tr>
			</c:forEach>
		</table>
		<br/>
 		
	
 		
		<div style="width: 600px">
			<c:if test="${pageNo!=1}">
			<a href="list?pageNo=1&find=${find}">[처음]</a>
			</c:if>
			
			<c:if test="${groupNo>1}">
				<a href="list?pageNo=${startPageNo-1}&find=${find}">[이전]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
				<a href="list?pageNo=${i}&find=${find}"
					<c:if test="${pageNo==i}">style="color:red" </c:if>
				>${i}</a>
			</c:forEach>
			
			<c:if test="${groupNo<totalGroupNo}">
				<a href="list?pageNo=${endPageNo+1}&find=${find}">[다음]</a>
			</c:if>
			
			<c:if test="${pageNo!=totalPageNo}">
			<a href="list?pageNo=${totalPageNo}&find=${find}">[맨끝]</a>
			</c:if>
		</div>
		
	</body>
</html>