<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	<body> 
	식당 정보 보기
	<hr/>

		<table style="width:570px">
	
		<tr>
		<td style="background-color:orange; width:70px">식당 ID</td>
		<td>${restaurant.resid}</td>
		</tr>
	
		<tr>
		<td style="background-color:orange; width:70px">식당 이름</td>
		<td>${restaurant.resname}</td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 위치</td>
		<td><pre>${restaurant.reslocation}</pre></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 전화번호</td>
		<td><pre>${restaurant.restel}</pre></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 전제 테이블 수</td>
		<td><pre>${restaurant.restotaltable}</pre></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 정보</td>
		<td><pre>${restaurant.resinfo}</pre></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 오픈타임</td>
		<td><pre>${restaurant.resopen}</pre></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 클로즈타임</td>
		<td><pre>${restaurant.resclose}</pre></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 휴일</td>
		<td><pre>${restaurant.rescloseday}</pre></td>
		</tr>
		
		<tr>
		<td style="background-color:orange; width:70px">식당 사진</td>
		<td><img src="showPhoto?savedfile=${restaurant.ressavedfile}" width="500px"/></td>
		</tr>
		
		</table>
		
		
		
		<div>
			<c:if test="${login!=member.mid}">
				<a href="modify?mid=${member.mid}">[수정]</a>

	
				<a href="remove?mid=${member.mid}">[삭제]</a>
			</c:if>
			<a href="list">[목록]</a>
		</div>
	</body>
</html>