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
				padding: 5px;
			}
			td {
				border-style: solid;
				border-width: 1px;
				text-align: center;
				padding: 2px 5px;
			}
		</style>
	</head>
	<body>
		<p style="font-size:150%;"><b>즐겨찾기 목록</b></p>
		<hr/>
		
		<br/>
		<table style="border-collapse: collapse; border-style: solid; border-width: 2px; border-color: black;">
			<tr>
				<th> Restaurant id </th>
				<th> Restaurant Name </th>
				<th> Restaurant Info </th>
				<th> &nbsp; </th>
			</tr>
			<c:forEach var="favorite" items="${list}">
				<tr>
					<td> ${favorite.mid} </td>
					<td> ${favorite.mname} </td>
					<td> ${favorite.mpassword} </td>
					<td> <a href="/ourapp/member/modifyInfoForManager?mid=${member.mid}"><input type="button" value="수정"/></a></td>
				</tr>
			</c:forEach>
		</table>
		<br/>
 		
		<form method="post" action="/ourapp/member/list?pageNo=1">
			검색 <input type="text" name="find" value="${find}"/>
			<input type="submit" value="찾기"/>
		</form><br/>
 		
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