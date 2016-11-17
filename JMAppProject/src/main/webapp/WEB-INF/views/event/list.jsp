<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				color: blue;
			}
			th {
				border-style: solid;
				border-width: 1px;
				border-bottom-width: 2px;
				text-align: center;
			}
			td {
				border-style: solid;
				border-width: 1px;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<hr/>
		<p style="font-size:150%;"><b>이벤트 목록</b></p>
		<hr/>
		
		<br/>
		<table style="width: 1000px;">
			<tr>
				<th> 이벤트 이름</th>
				<th> 식당명</th>
				<th> 이벤트 사진 </th>
				<th> 이벤트 정보 </th>
				<th> 이벤트 메뉴 이름 </th>
				<th> 이벤트 할인가격 </th>
				<th> 이벤트 시작기간 </th>
				<th> 이벤트 종료기간 </th>
			</tr>
			<c:forEach var="event" items="${list}">
				<tr>
					<td> ${event.ename} </td>			
					<td> ${event.eresid} </td>
					<td> ${event.esavedfile} </td>
					<td> ${event.einfo} </td>
					<td> ${event.emlname} </td>
					<td> ${event.eprice} </td>
					<td> ${event.estart} </td>
					<td> ${event.eend} </td>
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